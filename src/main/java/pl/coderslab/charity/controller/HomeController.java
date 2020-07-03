package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.entity.VerificationToken;
import pl.coderslab.charity.model.UserModel;
import pl.coderslab.charity.service.*;

import javax.mail.MessagingException;
import java.util.List;


@Controller
public class HomeController {
//    private final InitData initData;
    private final InstitutionServiceImpl institutionService;
    private final DonationServiceImpl donationService;
    private final UserServiceImpl userService;
    private final VerificationTokenServiceImpl verificationTokenService;
    private final MailServiceImpl mailService;

    public HomeController(InstitutionServiceImpl institutionService,
                          DonationServiceImpl donationService, UserServiceImpl userService,
                          VerificationTokenServiceImpl verificationTokenService, MailServiceImpl mailService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.userService = userService;
        this.verificationTokenService = verificationTokenService;
        this.mailService = mailService;
    }

    @RequestMapping("/")
    public String homeAction(){
        return "index";
    }

    @GetMapping("/register")
    public String login(Model model) {
        model.addAttribute("userModel", new UserModel());
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute UserModel userModel) throws MessagingException {
        if (userModel.getPassword2().equals(userModel.getPassword())) {
            User user = new User();
            user.setEnabled(false);
            userService.saveUser(user, userModel);
            VerificationToken verificationToken = new VerificationToken(user);
            verificationTokenService.save(verificationToken);
            mailService.sendVerificationToken(user.getEmail(), verificationToken.getToken());
        } else {
            return "passInvalid";
        }
        return "register-verify";
    }

    @RequestMapping(value = "/confirm-register", method = {RequestMethod.GET, RequestMethod.POST})
    public String confirmRegister(@RequestParam("token") String verificationToken) {
        VerificationToken token = verificationTokenService.findToken(verificationToken);
        if (token != null) {
            User user = userService.findByMail(token.getUser().getEmail());
            user.setEnabled(true);
            userService.editUser(user);
            return "/register-successfully";
        } else {
            return "/register-failed";
        }
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
