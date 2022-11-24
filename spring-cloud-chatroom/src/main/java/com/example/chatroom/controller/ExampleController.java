package com.example.chatroom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ExampleController {

    @GetMapping("/")
    public String viewIndex(Model model) {
        return "index";
    }
}
