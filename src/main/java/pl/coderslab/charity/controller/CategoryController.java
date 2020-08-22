package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.service.serviceImpl.CategoryServiceImpl;

@Controller
@RequestMapping("/admin")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/category-list")
    public String categoryList(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        User user = currentUser.getUser();
        model.addAttribute("user", user);
        return "/admin/categories";
    }

    @GetMapping("/category-delete/{id}")
    public String categoryDelete(@PathVariable long id) {
        categoryService.changeCategoryId(id);
        categoryService.delete(id);
        return "redirect:/admin/category-list";
    }

    @GetMapping("/category-add")
    public String categoryAdd(@AuthenticationPrincipal CurrentUser currentUser, Model model) {
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
}

