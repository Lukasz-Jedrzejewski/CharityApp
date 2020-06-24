package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.service.InstitutionServiceImpl;
import pl.coderslab.charity.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserServiceImpl userService;
    private InstitutionServiceImpl institutionService;

    public AdminController(UserServiceImpl userService, InstitutionServiceImpl institutionService) {
        this.userService = userService;
        this.institutionService = institutionService;
    }

    @GetMapping("/panel")
    public String loginPage(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/panel";
    }

    @GetMapping("/institution-list")
    public String institutionList(@AuthenticationPrincipal CurrentUser currentUser,Model model) {
        model.addAttribute("institutionList", institutionService.findAll());
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/institutions";
    }

    @GetMapping("/institution-delete/{id}")
    public String institutionDelete(@PathVariable long id) {
        institutionService.delete(id);
        return "redirect:/admin/institution-list";
    }

    @GetMapping("/institution-add")
    public String institutionAdd(@AuthenticationPrincipal CurrentUser currentUser,Model model) {
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
