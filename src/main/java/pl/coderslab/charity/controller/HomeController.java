package pl.coderslab.charity.controller;

import com.byteowls.jopencage.model.JOpenCageLatLng;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.PasswordResetToken;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.entity.VerificationToken;
import pl.coderslab.charity.model.ContactMessage;
import pl.coderslab.charity.model.UserModel;
import pl.coderslab.charity.service.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;


@Controller
public class HomeController {
    private final InstitutionServiceImpl institutionService;
    private final DonationServiceImpl donationService;
    private final UserServiceImpl userService;
    private final VerificationTokenServiceImpl verificationTokenService;
    private final MailServiceImpl mailService;
    private final PasswordResetTokenServiceImpl passwordResetTokenService;
    private final CoordinatesServiceImpl coordinatesService;

    public HomeController(InstitutionServiceImpl institutionService,
                          DonationServiceImpl donationService, UserServiceImpl userService,
                          VerificationTokenServiceImpl verificationTokenService, MailServiceImpl mailService, PasswordResetTokenServiceImpl passwordResetTokenService, CoordinatesServiceImpl coordinatesService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
        this.userService = userService;
        this.verificationTokenService = verificationTokenService;
        this.mailService = mailService;
        this.passwordResetTokenService = passwordResetTokenService;
        this.coordinatesService = coordinatesService;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("contactMessage", new ContactMessage());
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

    @PostMapping("/send-contact-message")
    public String sendContactMessage(@ModelAttribute ContactMessage contactMessage) throws MessagingException {
        String adminMail = userService.getOne(1).getEmail();
        mailService.sendMsg(adminMail, "Skontaktuj się ze mną!", contactMessage.toHtml());
        return "index";
    }

    @GetMapping("/institution-details/{id}")
    public String getInstitutionDetails(@PathVariable Long id, Model model) throws IOException {
        model.addAttribute("currentInstitution", institutionService.getOne(id));
        String street = institutionService.getOne(id).getStreet();
        String city = institutionService.getOne(id).getCity();
        JOpenCageLatLng data = coordinatesService.getData(street, city);
        model.addAttribute("cords", data);
        return "institution-details";
    }

    @GetMapping("/reset-pass")
    public String resetPassword (Model model) {
        model.addAttribute("userModel", new UserModel());
        return "reset";
    }

    @PostMapping("/reset-pass")
    public String postReset (@ModelAttribute UserModel userModel) throws MessagingException {
        String email = userModel.getEmail();
        PasswordResetToken passwordResetToken = new PasswordResetToken(userService.findByMail(email));
        passwordResetTokenService.save(passwordResetToken);
        mailService.sendPasswordResetToken(userModel.getEmail(), passwordResetToken.getToken());
        return "reset-info";
    }

    @RequestMapping(value = "/reset-confirmation", method = {RequestMethod.GET, RequestMethod.POST})
    public String confirmReset(@RequestParam("token") String passwordResetToken, Model model) {
        PasswordResetToken token = passwordResetTokenService.findToken(passwordResetToken);
        if (token != null) {
            UserModel userModel = new UserModel();
            userModel.setEmail(token.getUser().getEmail());
            model.addAttribute("userModel", userModel);
            return "/set-password";
        } else {
            return "/set-password-failed";
        }
    }

    @PostMapping("/set-pass")
    public String setPassword(@ModelAttribute UserModel userModel) {
        if (userModel.getPassword2().equals(userModel.getPassword())) {
            String email = userModel.getEmail();
            userService.resetPass(email, userModel.getPassword());
        }
        return "password-changed-successfully";
    }

    @GetMapping("/steps")
    public String getStepsView () {
        return "index";
    }

}
