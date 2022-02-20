package com.kryakushin.SchoolSite.controllers;

import com.kryakushin.SchoolSite.models.User;
import com.kryakushin.SchoolSite.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/auth")
    public String reg(Model model) {
        model.addAttribute("title", "Authorization");
        return "auth";
    }

    @PostMapping("/auth")
    public String authAdd(@RequestParam("floatingEmail") String floatingEmail, @RequestParam("floatingPassword") String floatingPassword, Model model) {
        /*List<User> users = userRepository.findAll(); // старая версия
        System.out.println(users.size());
        for (User une : users) {
            System.out.println(une.getEmail());
            if (Objects.equals(une.getEmail(), floatingEmail)) {
                System.out.println("User found");
                break;
            }
        } */
        User userByName = userRepository.findUserByName(floatingEmail);

        if (userByName != null) {
            if(userRepository.existsById(userByName.getId())) {
                System.out.println(userByName.getEmail());
                System.out.println(userByName.getName());
                System.out.println("User found");
                return "redirect:/";
            }
            else {
                return "redirect:/auth";
            }
        }
        else {
            return "redirect:/auth";
        }
    }



}
