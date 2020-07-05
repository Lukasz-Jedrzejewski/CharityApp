package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.service.*;

@Controller
@RequestMapping("/admin")
public class SuperAdminController {

    private final DonationServiceImpl donationService;
    private final UserServiceImpl userService;

    public SuperAdminController(DonationServiceImpl donationService, UserServiceImpl userService) {
        this.donationService = donationService;
        this.userService = userService;
    }

    @GetMapping("/panel")
    public String loginPage(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/panel";
    }

    @GetMapping("/donation-list")
    public String donationList(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("donationList", donationService.findAll());
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/donations";
    }

    @GetMapping("/edit-mail/{id}")
    public String editMail(@AuthenticationPrincipal CurrentUser currentUser, Model model, @PathVariable long id){
        model.addAttribute("admin", userService.getOne(id));
        User user = currentUser.getUser();
        model.addAttribute("user",user);
        return"/admin/edit-mail-form";
    }

    @PostMapping("/edit-mail")
    public String updateMail(@ModelAttribute("admin") User admin) {
        userService.changeSuperAdminMail(admin);
        return "redirect:/admin/admin-list";
    }

    @GetMapping("/edit-password/{id}")
    public String editPassword(@AuthenticationPrincipal CurrentUser currentUser, Model model, @PathVariable long id) {
        model.addAttribute("admin", userService.getOne(id));
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/change-password";
    }

    @PostMapping("/edit-password")
    public String updatePassword(@ModelAttribute("admin") User admin) {
        userService.changePass(admin);
        return "redirect:/admin/admin-list";
    }
}
