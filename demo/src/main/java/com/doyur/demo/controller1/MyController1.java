package com.doyur.demo.controller1;

import com.doyur.demo.service.abstracts.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping
public class MyController1 {

    private UserService userService;

    public MyController1(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/anasayfa")
    public String anasayfa() {
        return "anasayfa";
    }

    @GetMapping("/bizeulasin")
    public String bizeulasin() {
        return "bizeulasin";
    }

    @GetMapping("/girisyap")
    public String girisyap() {
        return "girisyap";
    }

    @GetMapping("/kayitol")
    public String kayitol() {
        return "kayitol";
    }

    @GetMapping("/restornac")
    public String restornac() {
        return "restornac";
    }

    @GetMapping("/restoranlaricin")
    public String restoranlaricin() {
        return "restoranlaricin";
    }

    @GetMapping("/restorangiris")
    public String restorangiris(){
        return "restorangiris";
    }
}
