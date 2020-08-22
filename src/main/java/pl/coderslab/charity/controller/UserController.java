package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.service.serviceImpl.CategoryServiceImpl;
import pl.coderslab.charity.service.serviceImpl.DonationServiceImpl;
import pl.coderslab.charity.service.serviceImpl.InstitutionServiceImpl;
import pl.coderslab.charity.service.serviceImpl.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;
    private final DonationServiceImpl donationService;
    private final CategoryServiceImpl categoryService;
    private final InstitutionServiceImpl institutionService;

    public UserController(UserServiceImpl userService, DonationServiceImpl donationService, CategoryServiceImpl categoryService, InstitutionServiceImpl institutionService) {
        this.userService = userService;
        this.donationService = donationService;
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }

    @GetMapping("/panel")
    public String loginPage(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/user/panel";
    }

    @GetMapping("/user-edit/{id}")
    public String editProfile(@AuthenticationPrincipal CurrentUser currentUser, @PathVariable Long id, Model model){
        model.addAttribute("userToEdit", userService.getOne(id));
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/user/user-form";
    }

    @PostMapping("/user-edit")
    public String editProfile(@ModelAttribute("userToEdit") User user){
        userService.editUser(user);
        return "redirect:/user/panel";
    }

    @GetMapping("/edit-pass/{id}")
    public String changePassword(@AuthenticationPrincipal CurrentUser currentUser, @PathVariable Long id,Model model){
        model.addAttribute("userPass", userService.getOne(id));
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/user/pass-change";
    }

    @PostMapping("/edit-pass")
    public String changePassword(@ModelAttribute User user){
        userService.changePass(user);
        return "redirect:/user/panel";
    }

    @GetMapping("my-donations")
    public String readUserDonations(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("user", currentUser.getUser());
        return "/user/my-donations";
    }

    @ModelAttribute("myDonations")
    public List<Donation> userDonations(@AuthenticationPrincipal CurrentUser currentUser){
        return donationService.findUserDonations(currentUser.getUser().getId());
    }

    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryService.findAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions(){
        return institutionService.findAll();
    }

    @GetMapping("/set-status/{id}")
    public String setPicked(@PathVariable long id) {
        Donation donation = donationService.getOne(id);
        donation.setPicked(true);
        donationService.save(donation);
        return "redirect:/user/my-donations";
    }
}

