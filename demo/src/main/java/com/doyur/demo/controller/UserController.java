package com.doyur.demo.controller;

import com.doyur.demo.dto.request.CreateUserRequest;
import com.doyur.demo.service.abstracts.UserService;
import com.doyur.demo.service.concretes.UserDetailsServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller // Eğer HTML gibi basic web kullanılacaksa Controller kullan @RestController angular, react gibi teknolojiler için
@RequestMapping
public class UserController {
    private UserDetailsService userDetailsService;
    private UserService userService;

    public UserController(UserDetailsService userDetailsService, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }


  /*  @GetMapping("/anasayfa")
    public String anasayfa() {
        return "anasayfa";
    }*/


    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") CreateUserRequest createUserRequest) {
        return "register";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") CreateUserRequest createUserRequest, Model model) {
        userService.save(createUserRequest);
        model.addAttribute("message", "Registered Successfuly!"); //Bunu service katmanında yapmalısın kullanıcı kayıt olursa dönmeli yoksa önceden kayıtlı old. bildir
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("user-page")
    public String userPage (Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "user";
    }

    @GetMapping("admin-page")
    public String adminPage (Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "admin";
    }


}
