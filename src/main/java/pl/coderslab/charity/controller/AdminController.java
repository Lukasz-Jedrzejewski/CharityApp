package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.service.RoleServiceImpl;
import pl.coderslab.charity.service.UserServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    public AdminController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin-list")
    public String adminList(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("adminList", userService.findAllAdministrators());
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/admins";
    }

    @GetMapping("/admin-delete/{id}")
    public String adminDelete(@PathVariable long id) {
        roleService.deleteByUserId(id);
        userService.delete(id);
        return "redirect:/admin/admin-list";
    }

    @GetMapping("/admin-add")
    public String adminAdd(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("admin", new User());
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/admin-form";
    }

    @GetMapping("/admin-add/{id}")
    public String adminEdit(@AuthenticationPrincipal CurrentUser currentUser, Model model, @PathVariable long id) {
        model.addAttribute("admin", userService.getOne(id));
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/admin-form";
    }

    @PostMapping("/admin-add")
    public String saveAdmin(@ModelAttribute("admin") User admin) {
        userService.saveAdmin(admin);
        return "redirect:/admin/admin-list";
    }

    @GetMapping("/user-list")
    public String userList(@AuthenticationPrincipal CurrentUser currentUser,Model model) {
        model.addAttribute("userList", userService.findAllUsers());
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/users";
    }

    @GetMapping("/user-delete/{id}")
    public String userDelete(@PathVariable long id) {
        roleService.deleteByUserId(id);
        userService.delete(id);
        return "redirect:/admin/user-list";
    }

    @GetMapping("/user-add/{id}")
    public String userEdit(@AuthenticationPrincipal CurrentUser currentUser, Model model, @PathVariable long id) {
        model.addAttribute("userToEdit", userService.getOne(id));
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/user-form";
    }

    @PostMapping("/user-add")
    public String saveUser(@ModelAttribute("userToEdit") User user) {
        userService.save(user);
        return "redirect:/admin/user-list";
    }

    @GetMapping("/user-enabled/{id}")
    public String enableUser(@PathVariable long id) {
        User user = userService.getOne(id);
        userService.changeEnabled(user);
        return "redirect:/admin/user-list";
    }

    @GetMapping("/user-disabled/{id}")
    public String disableUser(@PathVariable long id) {
        User user = userService.getOne(id);
        userService.changeDisabled(user);
        return "redirect:/admin/user-list";
    }
}
