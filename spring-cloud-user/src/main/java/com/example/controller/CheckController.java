package com.example.controller;

import com.example.model.internal.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class CheckController {

    @Autowired
    private Environment environment;

    @GetMapping("check")
    public String check() {
        return "Working on port "+ environment.getProperty("server.port") + ", my secret key" + environment.getProperty("jwt-key");
    }
}
