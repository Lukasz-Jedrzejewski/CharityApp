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
import pl.coderslab.charity.service.*;

import javax.mail.MessagingException;
import java.util.List;

@Controller
@RequestMapping("/donate")
public class DonationController {

    private final CategoryServiceImpl categoryService;
    private final DonationServiceImpl donationService;
    private final InstitutionServiceImpl institutionService;
    private final UserServiceImpl userService;
    private final MailServiceImpl mailService;

    public DonationController(CategoryServiceImpl categoryService, DonationServiceImpl donationService, InstitutionServiceImpl institutionService, UserServiceImpl userService, MailServiceImpl mailService) {
        this.categoryService = categoryService;
        this.donationService = donationService;
        this.institutionService = institutionService;
        this.userService = userService;
        this.mailService = mailService;
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
    public String saveDonation(Model model, @ModelAttribute Donation donation,
                               @AuthenticationPrincipal CurrentUser currentUser) throws MessagingException {
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        donation.setUser(currentUser.getUser());
        donation.setPicked(false);
        donationService.save(donation);
        mailService.sendMsg(user.getEmail(), "Twoja donacja", donation.toHtml() + " Kurier skontaktuje się z Tobą w dniu odbioru.");
        return "form-confirmation";
    }


}
