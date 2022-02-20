package com.kryakushin.SchoolSite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministrationController {


    @GetMapping("/administration")
    public String home(Model model) {
        model.addAttribute("title", "Administration Page");
        return "administration";
    }

}
