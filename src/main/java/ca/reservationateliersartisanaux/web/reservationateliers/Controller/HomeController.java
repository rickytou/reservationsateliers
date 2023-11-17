package ca.reservationateliersartisanaux.web.reservationateliers.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/ateliers")
    public String listeAteliers() {
        return "redirect:/ateliers/liste";
    }
}
