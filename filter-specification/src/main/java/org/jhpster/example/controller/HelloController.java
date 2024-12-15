package org.jhpster.example.controller;

import org.jhpster.example.service.HelloService;
import org.jhpster.example.specification.domain.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {


    @Autowired
    private HelloService helloService;

    @GetMapping("/hello")
    public List<Hello> getTasks(@RequestParam String name,
                            @RequestParam String address) {
       return helloService.getAll(name,address);
    }
}
