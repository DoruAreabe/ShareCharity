package com.doruareabe.share_to_good_hands.web.controller;

import com.doruareabe.share_to_good_hands.entity.Donation;
import com.doruareabe.share_to_good_hands.service.CategoryService;
import com.doruareabe.share_to_good_hands.service.DonationService;
import com.doruareabe.share_to_good_hands.service.InstitutionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/donate")
public class DonationController {

    DonationService donationService;
    InstitutionService institutionService;
    CategoryService categoryService;

    public DonationController(DonationService donationService, InstitutionService institutionService, CategoryService categoryService) {
        this.donationService = donationService;
        this.institutionService = institutionService;
        this.categoryService = categoryService;
    }

    @GetMapping
    String donateForm(Model model) {
        model.addAttribute("donation", new Donation());
        model.addAttribute("categoriesFromServlet", categoryService.findAll());
        model.addAttribute("institutions", institutionService.findAll());
        return "views/userpart/donate";
    }

    @PostMapping
    String donateFormAction(@ModelAttribute Donation donation) {
        donationService.save(donation);
        return "views/userpart/donationConfimation";
    }


}
