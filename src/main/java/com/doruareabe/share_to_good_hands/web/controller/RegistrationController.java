package com.doruareabe.share_to_good_hands.web.controller;

import com.doruareabe.share_to_good_hands.service.UserService;
import com.doruareabe.share_to_good_hands.web.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("registration")
public class RegistrationController {

    UserService userService;


    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    String registerForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "views/userpart/registration";
    }

    @PostMapping
    String registrationAction(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            if (!userDto.getPassword1().equals(userDto.getPassword2())) model.addAttribute("msg", true);
            return "views/userpart/registration";
        }
        if (!userDto.getPassword1().equals(userDto.getPassword2())) {
            model.addAttribute("msg", true);
            return "views/userpart/registration";
        }
            userService.save(userDto);
            return "redirect:/login";
        }
    }
