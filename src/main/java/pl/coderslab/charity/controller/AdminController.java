package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.service.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImpl userService;
    private final InstitutionServiceImpl institutionService;
    private final RoleServiceImpl roleService;
    private final CategoryServiceImpl categoryService;
    private final DonationServiceImpl donationService;

    public AdminController(UserServiceImpl userService, InstitutionServiceImpl institutionService, RoleServiceImpl roleService, CategoryServiceImpl categoryService, DonationServiceImpl donationService) {
        this.userService = userService;
        this.institutionService = institutionService;
        this.roleService = roleService;
        this.categoryService = categoryService;
        this.donationService = donationService;
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

    @GetMapping("/category-list")
    public String categoryList(@AuthenticationPrincipal CurrentUser currentUser,Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/categories";
    }

    @GetMapping("/category-delete/{id}")
    public String categoryDelete(@PathVariable long id) {
        categoryService.delete(id);
        return "redirect:/admin/category-list";
    }

    @GetMapping("/category-add")
    public String categoryAdd(@AuthenticationPrincipal CurrentUser currentUser,Model model) {
        model.addAttribute("category", new Category());
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/category-form";
    }

    @GetMapping("/category-add/{id}")
    public String categoryEdit(@AuthenticationPrincipal CurrentUser currentUser, Model model, @PathVariable long id) {
        model.addAttribute("category", categoryService.getOne(id));
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/category-form";
    }

    @PostMapping("/category-add")
    public String saveCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/admin/category-list";
    }

    @GetMapping("/donation-list")
    public String donationList(@AuthenticationPrincipal CurrentUser currentUser,Model model) {
        model.addAttribute("donationList", donationService.findAll());
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/donations";
    }
}
