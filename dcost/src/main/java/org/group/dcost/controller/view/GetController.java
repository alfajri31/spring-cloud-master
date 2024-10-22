package org.group.dcost.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GetController {


    @GetMapping("/")
    public String index() {
        return "index";
    }
}
