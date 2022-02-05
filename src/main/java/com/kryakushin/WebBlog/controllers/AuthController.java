package com.kryakushin.WebBlog.controllers;

import com.kryakushin.WebBlog.models.Post;
import com.kryakushin.WebBlog.models.User;
import com.kryakushin.WebBlog.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/auth")
    public String reg(Model model) {
        model.addAttribute("title", "Авторизация");
        return "auth";
    }

    @PostMapping("/auth")
    public String authAdd(@RequestParam("floatingEmail") String floatingEmail, @RequestParam("floatingPassword") String floatingPassword, Model model) {
        List<User> users = userRepository.findAll();
        System.out.println(users.size());
        for (User une : users) {
            System.out.println(une.getEmail());
            if (Objects.equals(une.getEmail(), floatingEmail)) {
                System.out.println("User found");
                break;
            }

        }
        return "redirect:/";
    }


}
