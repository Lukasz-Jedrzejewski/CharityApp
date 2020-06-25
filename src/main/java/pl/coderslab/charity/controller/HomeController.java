package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.fixture.InitData;
import pl.coderslab.charity.service.DonationServiceImpl;
import pl.coderslab.charity.service.InstitutionServiceImpl;
import pl.coderslab.charity.service.UserServiceImpl;

import java.util.List;


@Controller
public class HomeController {
    private InitData initData;
    private InstitutionServiceImpl institutionService;
    private DonationServiceImpl donationService;
    private UserServiceImpl userService;

    public HomeController(InitData initData, InstitutionServiceImpl institutionService, DonationServiceImpl donationService, UserServiceImpl userService) {
        this.initData = initData;
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.userService = userService;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        initData.initRoles();
        initData.initSuperAdmin();
        return "index";
    }

    @GetMapping("/register")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute User user) {
        if (user.getPassword2().equals(user.getPassword())) {
            userService.saveUser(user);
        } else {
            return "passInvalid";
        }
        return "redirect:/login";
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionService.findAll();
    }

    @ModelAttribute("bags")
    public Integer getBags() {
        return donationService.getBagQuantity();
    }

    @ModelAttribute("donations")
    public int getDonations() {
        return donationService.getDonationQuantity();
    }

    @GetMapping("/about")
    public String getLogin() {
        return "login";
    }

}
