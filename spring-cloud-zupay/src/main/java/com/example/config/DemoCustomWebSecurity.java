package com.example.config;

import com.example.service.ILoginService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class DemoCustomWebSecurity extends WebSecurityConfigurerAdapter {


    private final ILoginService iLoginService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public DemoCustomWebSecurity(ILoginService iLoginService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.iLoginService = iLoginService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(iLoginService).passwordEncoder(bCryptPasswordEncoder);
    }
}
