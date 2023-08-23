package com.cantimapp.adm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CantikappAdmApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CantikappAdmApplication.class, args);
    }

}
