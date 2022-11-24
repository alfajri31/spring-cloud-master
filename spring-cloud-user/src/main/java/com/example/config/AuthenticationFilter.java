package com.example.config;

import com.example.entity.UserEntity;
import com.example.model.internal.LoginModel;
import com.example.service.ILoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final ILoginService iLoginService;
    private final Environment environment;



    AuthenticationFilter(Environment environment,ILoginService iLoginService) {
        this.environment = environment;
        this.iLoginService = iLoginService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LoginModel creds = new ObjectMapper().readValue(request.getInputStream(),LoginModel.class);
            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(creds.getUsername(),creds.getPassword(),new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        LoginModel loginModel = new ModelMapper().map(authResult.getPrincipal(), LoginModel.class);
        //        String userName = ((SecurityProperties.User) authResult.getPrincipal()).getUsername();
        UserEntity userEntity = iLoginService.getUserDetailsByUsername(loginModel.getUsername());
        String token = Jwts.builder().setSubject(userEntity.getId()).setExpiration(new Date(System.currentTimeMillis() + Long.parseLong("864000000"))).signWith(SignatureAlgorithm.HS512, environment.getProperty("jwt-key")).compact();
        response.addHeader("token",token);
    }
}
