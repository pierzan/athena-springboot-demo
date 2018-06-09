package com.tomtom.athena.sample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/index.html")
    public String index(
        Model model) {
        return "index";
    }

}
