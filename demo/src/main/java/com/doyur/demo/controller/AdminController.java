package com.doyur.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
// Eğer HTML gibi basic web kullanılacaksa Controller kullan @RestController angular, react gibi teknolojiler için
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/profile")
    public String adminProfile(Model model) {
        // Admin profili için gerekli verileri model üzerinden ekleyebilirsiniz
        return "admin/profile";
    }

    @GetMapping("/reports")
    public String viewReports(Model model) {
        // Raporları model üzerinden ekleyebilirsiniz
        return "admin/reports";
    }

    @GetMapping("/add-restaurant")
    public String addRestaurantForm() {
        // Restoran ekleme formu şablonunu döndür
        return "admin/add-restaurant";
    }

    @GetMapping("/list-restaurants")
    public String listRestaurants(Model model) {
        // Var olan restoranları model üzerinden ekleyebilirsiniz
        return "admin/list-restaurants";
    }
}
