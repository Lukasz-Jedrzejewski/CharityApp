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

    public SuperAdminController(DonationServiceImpl donationService) {
        this.donationService = donationService;
    }

    @GetMapping("/panel")
    public String loginPage(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/panel";
    }

    @GetMapping("/donation-list")
    public String donationList(@AuthenticationPrincipal CurrentUser currentUser,Model model) {
        model.addAttribute("donationList", donationService.findAll());
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/donations";
    }
}
