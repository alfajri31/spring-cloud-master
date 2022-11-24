package com.example.manageroletableexistsample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("check")
public class CheckController {

    @GetMapping("health")
    public String getCheck() {
        return "yes its health";
    }
}
