package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.service.CategoryServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/donate")
public class DonationController {

    private CategoryServiceImpl categoryService;

    public DonationController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @ModelAttribute("categories")
    public List<Category> categoryList() {
        return categoryService.findAll();
    }

    @GetMapping("/get")
    public String getDonation(Model model) {
        model.addAttribute("donation", new Donation());
        return "donationForm";
    }


}
