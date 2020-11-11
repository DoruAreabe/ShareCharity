package com.doruareabe.share_to_good_hands.web.controller;

import com.doruareabe.share_to_good_hands.entity.Donation;
import com.doruareabe.share_to_good_hands.entity.Institution;
import com.doruareabe.share_to_good_hands.entity.User;
import com.doruareabe.share_to_good_hands.service.DonationService;
import com.doruareabe.share_to_good_hands.service.InstitutionService;
import com.doruareabe.share_to_good_hands.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    UserService userService;
    InstitutionService institutionService;
    DonationService donationService;

    public HomeController(UserService userService, InstitutionService institutionService, DonationService donationService) {
        this.userService = userService;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @GetMapping("/")
    String getHomePage(Model model, Principal principal) {
        System.out.println();
        return "views/userpart/index";
    }

    @ModelAttribute
    void addInstitution(Model model) {
        List<Institution> institutions = institutionService.findAll();
        List<List<Institution>> pairs = new ArrayList<>();
        for (int i = 0; i < institutions.size(); i += 2) {
            List<Institution> pair = new ArrayList<>();
            pair.add(institutions.get(i));
            if ((i + 1) < institutions.size()) pair.add(institutions.get(i + 1));
            pairs.add(pair);
        }
        model.addAttribute("pairsInstitution", pairs);
    }

    @ModelAttribute
    void addDonations(Model model) {
        List<Donation> donations = donationService.findAll();
        int generalQuantity = donations.stream().mapToInt(Donation::getQuantity).sum();
        model.addAttribute("quantityOfDonation", donations.size());
        model.addAttribute("quantityOfPacks", generalQuantity);
    }

    @ModelAttribute
    void addLoggedUser(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.findUserByEmail(principal.getName());
            model.addAttribute("LoggedUser", user);
        }
    }

//    @GetMapping("details")ad w
qqqqq


}
