package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServlet;

@Controller
public class TestController {
    @RequestMapping(value = "/", method = RequestMethod.GET )
    public String get(ModelMap model) {
        model.addAttribute("message", "Hello, World!");
        return "index";
    }
}
