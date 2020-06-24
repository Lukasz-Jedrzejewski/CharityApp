package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
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
}
