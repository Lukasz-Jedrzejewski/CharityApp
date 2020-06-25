package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.service.CategoryServiceImpl;
import pl.coderslab.charity.service.DonationServiceImpl;
import pl.coderslab.charity.service.InstitutionServiceImpl;
import pl.coderslab.charity.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/donate")
public class DonationController {

    private CategoryServiceImpl categoryService;
    private DonationServiceImpl donationService;
    private InstitutionServiceImpl institutionService;
    private UserServiceImpl userService;

    public DonationController(CategoryServiceImpl categoryService, DonationServiceImpl donationService, InstitutionServiceImpl institutionService, UserServiceImpl userService) {
        this.categoryService = categoryService;
        this.donationService = donationService;
        this.institutionService = institutionService;
        this.userService = userService;
    }

    @ModelAttribute("categories")
    public List<Category> categoryList() {
        return categoryService.findAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutionList() {
        return institutionService.findAll();
    }

    @GetMapping("/get")
    public String getDonation(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        model.addAttribute("donation", new Donation());
        return "donationForm";
    }

    @PostMapping("/form-confirmation")
    public String saveDonation(@ModelAttribute Donation donation) {
        donationService.save(donation);
        return "form-confirmation";
    }


}
