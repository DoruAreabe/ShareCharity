package com.doruareabe.share_to_good_hands.web.controller;

import com.doruareabe.share_to_good_hands.entity.Donation;
import com.doruareabe.share_to_good_hands.entity.User;
import com.doruareabe.share_to_good_hands.service.CategoryService;
import com.doruareabe.share_to_good_hands.service.DonationService;
import com.doruareabe.share_to_good_hands.service.InstitutionService;
import com.doruareabe.share_to_good_hands.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;


@Controller
@RequestMapping("/donate")
public class DonationController {

    DonationService donationService;
    InstitutionService institutionService;
    CategoryService categoryService;
    UserService userService;

    public DonationController(DonationService donationService, InstitutionService institutionService, CategoryService categoryService, UserService userService) {
        this.donationService = donationService;
        this.institutionService = institutionService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @GetMapping
    String donateForm(Model model) {
        model.addAttribute("donation", new Donation());
        model.addAttribute("categoriesFromServlet", categoryService.findAll());
        model.addAttribute("institutions", institutionService.findAll());
        return "views/userpart/donate";
    }

    @PostMapping
    String donateFormAction(@Valid @ModelAttribute Donation donation, BindingResult bindingResult, Principal principal) {
        if(bindingResult.hasErrors()) return "views/userpart/donate";
        donation.setUser(userService.findUserByEmail(principal.getName()));
        donationService.save(donation);
        return "views/userpart/donationConfimation";
    }

    @ModelAttribute
    void addLoggedUser(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.findUserByEmail(principal.getName());
            model.addAttribute("LoggedUser", user);
        }
    }

}
