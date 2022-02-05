package com.kryakushin.WebBlog.controllers;

import com.kryakushin.WebBlog.models.User;
import com.kryakushin.WebBlog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class RegController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/reg")
    public String reg(Model model) {
        model.addAttribute("title", "Регистрация");
        return "reg";
    }

    @PostMapping("/reg")
    public String regAdd(@RequestParam("floatingName") String floatingName, @RequestParam("floatingEmail") String floatingEmail, @RequestParam("floatingPassword") String floatingPassword, Model model) {
        Date current = new Date();
        String str = String.format("%s %te %<tB","", current);
        User user = new User(floatingName, floatingEmail, floatingPassword, str);
        System.out.print(user);
        userRepository.save(user);
        return "redirect:/";
    }

}
