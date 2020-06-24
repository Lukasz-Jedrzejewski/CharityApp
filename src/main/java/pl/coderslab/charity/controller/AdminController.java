package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.service.InstitutionServiceImpl;
import pl.coderslab.charity.service.RoleServiceImpl;
import pl.coderslab.charity.service.UserServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserServiceImpl userService;
    private InstitutionServiceImpl institutionService;
    private RoleServiceImpl roleService;

    public AdminController(UserServiceImpl userService, InstitutionServiceImpl institutionService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.institutionService = institutionService;
        this.roleService = roleService;
    }

    @GetMapping("/panel")
    public String loginPage(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/panel";
    }

    @GetMapping("/institution-list")
    public String institutionList(@AuthenticationPrincipal CurrentUser currentUser,Model model) {
        model.addAttribute("institutionList", institutionService.findAll());
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/institutions";
    }

    @GetMapping("/institution-delete/{id}")
    public String institutionDelete(@PathVariable long id) {
        institutionService.delete(id);
        return "redirect:/admin/institution-list";
    }

    @GetMapping("/institution-add")
    public String institutionAdd(@AuthenticationPrincipal CurrentUser currentUser,Model model) {
        model.addAttribute("institution", new Institution());
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/institution-form";
    }

    @GetMapping("/institution-add/{id}")
    public String institutionEdit(@AuthenticationPrincipal CurrentUser currentUser, Model model, @PathVariable long id) {
        model.addAttribute("institution", institutionService.getOne(id));
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/institution-form";
    }

    @PostMapping("/institution-add")
    public String saveInstitution(@ModelAttribute Institution institution) {
        institutionService.save(institution);
        return "redirect:/admin/institution-list";
    }

    @GetMapping("/admin-list")
    public String adminList(@AuthenticationPrincipal CurrentUser currentUser,Model model) {
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
    public String adminAdd(@AuthenticationPrincipal CurrentUser currentUser,Model model) {
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
}
