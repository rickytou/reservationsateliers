package ca.reservationateliersartisanaux.web.reservationateliers.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.reservationateliersartisanaux.web.reservationateliers.models.Participant;
import ca.reservationateliersartisanaux.web.reservationateliers.service.ParticipantService;

@Controller
@RequestMapping("/participants")
public class ParticipantController {

    private final ParticipantService participantService;

    @Autowired
    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/liste")
    public String afficherListeParticipants(Model model) {
        model.addAttribute("participants", participantService.getAllParticipants());
        return "listeParticipants";
    }

    @GetMapping("/{id}")
    public String afficherParticipant(@PathVariable Long id, Model model) {
        model.addAttribute("participant", participantService.getParticipantById(id).orElse(null));
        return "detailParticipant";
    }

    @PostMapping("/enregistrer")
    public String enregistrerParticipant(Participant participant) {
        participantService.saveParticipant(participant);
        return "redirect:/participants/liste";
    }

    @PostMapping("/supprimer/{id}")
    public String supprimerParticipant(@PathVariable Long id) {
        participantService.deleteParticipant(id);
        return "redirect:/participants/liste";
    }
}

