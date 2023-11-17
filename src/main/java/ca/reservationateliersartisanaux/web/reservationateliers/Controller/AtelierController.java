package ca.reservationateliersartisanaux.web.reservationateliers.Controller;

import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;
import ca.reservationateliersartisanaux.web.reservationateliers.models.Atelier;
import ca.reservationateliersartisanaux.web.reservationateliers.models.Reservation;
import ca.reservationateliersartisanaux.web.reservationateliers.service.AtelierService;
import ca.reservationateliersartisanaux.web.reservationateliers.service.ReservationService;

@Controller
@RequestMapping("/ateliers")
public class AtelierController {

    private final AtelierService atelierService;
    private final ReservationService reservationService;

    public AtelierController(AtelierService atelierService, ReservationService reservationService) {
        this.atelierService = atelierService;
        this.reservationService = reservationService;
    }

    @GetMapping("/liste")
    public String afficherListeAteliers(Model model) {
        model.addAttribute("ateliers", atelierService.getAllAteliers());
        return "listeAteliers";
    }

    @GetMapping("/{id}")
    public String afficherAtelier(@PathVariable Long id, Model model) {
        Atelier atelier = atelierService.getAtelierById(id).orElse(null);

        if (atelier != null) {
            List<Reservation> reservations = reservationService.getReservationsByAtelier(atelier);
            model.addAttribute("atelier", atelier);
            model.addAttribute("reservations", reservations);
            model.addAttribute("reservation", new Reservation());
        } else {
            return "redirect:/erreur";
        }

        return "detailAtelier";
    }

   
    
    @PostMapping("/reserver")
    public String reserverCreneau(@ModelAttribute("reservation") Reservation reservation,
                                  @RequestParam("dateReservation") String dateReservationString,
                                  @RequestParam("atelierId") Long atelierId) {

        LocalDate dateReservation = LocalDate.parse(dateReservationString);
        reservation.setDateReservation(dateReservation);
        Atelier atelier = atelierService.getAtelierById(atelierId).orElse(null);

        if (atelier != null) {
            reservation.setAtelier(atelier);
            reservationService.saveReservation(reservation);
            return "redirect:/ateliers/liste";
        } else {
            return "redirect:/erreur";
        }
    }

    @GetMapping("/annuler/{id}")
    public String annulerReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return "redirect:/ateliers/liste";
    }
}
