package com.example.controller.admin;

import com.example.entity.UserEntity;
import com.example.model.internal.LoginModel;
import com.example.repository.UserRepository;
import com.example.service.ILoginService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

@Controller
@RequestMapping("admin")
public class AdminLoginController extends HttpServlet {

    @Autowired
    public ILoginService iLoginService;

    @Autowired
    public UserRepository userRepository;

    @ModelAttribute
    LoginModel loginModel () {
        return new LoginModel();
    }

    @GetMapping("login")
    public String viewLogin(Model model) {
        return "admin/login";
    }

    @PostMapping("login")
    public RedirectView postLogin(@Validated @ModelAttribute("loginModel") LoginModel loginModel, BindingResult bindingResult, HttpServletResponse response, RedirectAttributes redirectAttributes) throws Exception {
        ResponseEntity<Object> result = iLoginService.authentication(loginModel);
        if(result.getStatusCode()== HttpStatus.ACCEPTED) {
           // new user
           redirectAttributes.addFlashAttribute("savedUser", result.getBody());
           redirectAttributes.addFlashAttribute("successLogin", true);
           return new RedirectView("homepage", true);
       }
        else if(result.getStatusCode()==HttpStatus.NOT_FOUND) {
            redirectAttributes.addFlashAttribute("savedUser", result.getBody());
            redirectAttributes.addFlashAttribute("notFoundLogin", true);
            return new RedirectView("login", true);
        }
        return new RedirectView("login", true);
    }

    @GetMapping("homepage")
    public String viewHomepage(Model model) {
        return "admin/homepage";
    }

    @GetMapping("404")
    public String view404(Model model) {
        return "404";
    }

    @GetMapping("check")
    public ResponseEntity<LoginModel> check() {
        LoginModel loginModel = new LoginModel();
        return ResponseEntity.ok().body(loginModel);
    }
}
