package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.InstitutionServiceImpl;

import java.util.List;


@Controller
public class HomeController {

    private InstitutionServiceImpl institutionService;

    public HomeController(InstitutionServiceImpl institutionService) {
        this.institutionService = institutionService;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        return "index";
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionService.findAll();
    }
}
