package com.example.operator.controller;

import com.example.operator.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("operator")
public class OperatorController {

    @Autowired
    private OperatorService operatorService;

    @GetMapping("list")
    public EntityResponse<?> getOperator() {
        operatorService.getOperator();
        return null;
    }
}
