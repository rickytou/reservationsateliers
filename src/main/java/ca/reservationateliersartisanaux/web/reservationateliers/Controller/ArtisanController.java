package ca.reservationateliersartisanaux.web.reservationateliers.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.reservationateliersartisanaux.web.reservationateliers.models.Artisan;
import ca.reservationateliersartisanaux.web.reservationateliers.service.ArtisanService;

@Controller
@RequestMapping("/artisans")
public class ArtisanController {

    private final ArtisanService artisanService;

    @Autowired
    public ArtisanController(ArtisanService artisanService) {
        this.artisanService = artisanService;
    }

    @GetMapping("/liste")
    public String afficherListeArtisans(Model model) {
        model.addAttribute("artisans", artisanService.getAllArtisans());
        return "listeArtisans";
    }

    @GetMapping("/{id}")
    public String afficherArtisan(@PathVariable Long id, Model model) {
        model.addAttribute("artisan", artisanService.getArtisanById(id).orElse(null));
        return "detailArtisan";
    }

    @PostMapping("/enregistrer")
    public String enregistrerArtisan(Artisan artisan) {
        artisanService.saveArtisan(artisan);
        return "redirect:/artisans/liste";
    }

    @PostMapping("/supprimer/{id}")
    public String supprimerArtisan(@PathVariable Long id) {
        artisanService.deleteArtisan(id);
        return "redirect:/artisans/liste";
    }
}


