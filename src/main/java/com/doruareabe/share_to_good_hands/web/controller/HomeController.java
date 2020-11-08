package com.doruareabe.share_to_good_hands.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    String getHomePage(){
        return "views/userpart/index";
    }

}
