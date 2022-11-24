package com.example.mybatissample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health")
public class CheckController {

    @GetMapping("check")
    public String check() {
        return "Success";
    }
}
