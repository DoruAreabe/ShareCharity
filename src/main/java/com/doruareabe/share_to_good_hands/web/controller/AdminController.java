package com.doruareabe.share_to_good_hands.web.controller;

import com.doruareabe.share_to_good_hands.entity.User;
import com.doruareabe.share_to_good_hands.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {
    UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    String getMainPage(){
        return "views/adminpart/index";
    }

    @ModelAttribute
    void addLoggedUser(Model model, Principal principal) {
        if (principal != null) {
            User user = userService.findUserByEmail(principal.getName());
            model.addAttribute("LoggedUser", user);
        }
    }

}
