package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.fixture.InitData;
import pl.coderslab.charity.service.DonationServiceImpl;
import pl.coderslab.charity.service.InstitutionServiceImpl;

import java.util.List;


@Controller
public class HomeController {
    private InitData initData;
    private InstitutionServiceImpl institutionService;
    private DonationServiceImpl donationService;

    public HomeController(InitData initData, InstitutionServiceImpl institutionService, DonationServiceImpl donationService) {
        this.initData = initData;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @RequestMapping("/")
    public String homeAction(Model model){
        initData.initRoles();
        initData.initSuperAdmin();
        return "index";
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
}
