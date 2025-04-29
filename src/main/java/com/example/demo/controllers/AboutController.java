package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping("/about")
@Controller
public class AboutController {

    @GetMapping
    public String about() {
        return "about";
    }
}
