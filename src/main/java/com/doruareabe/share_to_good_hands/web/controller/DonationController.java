package com.doruareabe.share_to_good_hands.web.controller;

import com.doruareabe.share_to_good_hands.entity.Category;
import com.doruareabe.share_to_good_hands.entity.Donation;
import com.doruareabe.share_to_good_hands.service.CategoryService;
import com.doruareabe.share_to_good_hands.service.DonationService;
import com.doruareabe.share_to_good_hands.service.InstitutionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("institutions", institutionService.findAll());
        return "views/userpart/donate";
    }

    @PostMapping
    String donateFormAction(@RequestParam Long[] categories_id, @ModelAttribute Donation donation) {
        List<Category> allCategories = categoryService.findAll();
        List<Category> selectedCategories = new ArrayList<>();
        for (Long aLong : categories_id) {
            for (Category allCategory : allCategories) {
                if (allCategory.getId().equals(aLong)) selectedCategories.add(allCategory);
            }
        }
        donation.setCategories(selectedCategories);
        donationService.save(donation);
        return "views/userpart/donationConfimation";
    }


}
