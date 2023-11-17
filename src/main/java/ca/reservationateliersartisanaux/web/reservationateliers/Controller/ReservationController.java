package ca.reservationateliersartisanaux.web.reservationateliers.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.reservationateliersartisanaux.web.reservationateliers.models.Reservation;
import ca.reservationateliersartisanaux.web.reservationateliers.service.ReservationService;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/liste")
    public String afficherListeReservations(Model model) {
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "listeReservations";
    }

    @GetMapping("/{id}")
    public String afficherReservation(@PathVariable Long id, Model model) {
        model.addAttribute("reservation", reservationService.getReservationById(id).orElse(null));
        return "detailReservation";
    }

    @PostMapping("/enregistrer")
    public String enregistrerReservation(Reservation reservation) {
        reservationService.saveReservation(reservation);
        return "redirect:/reservations/liste";
    }

    @PostMapping("/supprimer/{id}")
    public String supprimerReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return "redirect:/reservations/liste";
    }
}

