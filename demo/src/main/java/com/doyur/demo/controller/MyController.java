package com.doyur.demo.controller;

import com.doyur.demo.service.concretes.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MyController {

 /*   MyService myService;

    @Autowired
    MyController(MyService myService){
        this.myService = myService;
    }


    public String deneme(Principal principal){

        principal.getName();
        return null;
    }


   @GetMapping("/kullanici")
    public String kullaniciNoktasi(Principal principal) {
        // Varsayılan olarak principal.getName() kullanıcı adını döndürüyorsa
        String kullaniciAdi = principal.getName();

        // Kullanıcı rollerini kullanıcı deposundan veya servisinden alın
        Set<UserRole> kullaniciRolleri = // kullanıcı adına göre rolleri al

        if (myService.kullaniciRoluneSahipMi(kullaniciRolleri, UserRole.USER)) {
            return "Hoş geldiniz, Kullanıcı!";
        } else {
            return "Erişim reddedildi!";
        }
    } */
}
