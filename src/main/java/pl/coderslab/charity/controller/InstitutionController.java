package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.service.serviceImpl.DonationServiceImpl;
import pl.coderslab.charity.service.serviceImpl.InstitutionServiceImpl;

@Controller
@RequestMapping("/admin")
public class InstitutionController {

    private final InstitutionServiceImpl institutionService;
    private final DonationServiceImpl donationService;

    public InstitutionController(InstitutionServiceImpl institutionService, DonationServiceImpl donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @GetMapping("/institution-list")
    public String institutionList(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("institutionList", institutionService.findAll());
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/institutions";
    }

    @GetMapping("/institution-delete/{id}")
    public String institutionDelete(@PathVariable long id) {
        donationService.changeIdToNull(id);
        institutionService.delete(id);
        return "redirect:/admin/institution-list";
    }

    @GetMapping("/institution-add")
    public String institutionAdd(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("institution", new Institution());
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/institution-form";
    }

    @GetMapping("/institution-add/{id}")
    public String institutionEdit(@AuthenticationPrincipal CurrentUser currentUser, Model model, @PathVariable long id) {
        model.addAttribute("institution", institutionService.getOne(id));
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/institution-form";
    }

    @PostMapping("/institution-add")
    public String saveInstitution(@ModelAttribute Institution institution) {
        institutionService.save(institution);
        return "redirect:/admin/institution-list";
    }
}
