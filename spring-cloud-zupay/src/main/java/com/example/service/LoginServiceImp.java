package com.example.service;

import com.example.entity.UserEntity;
import com.example.model.internal.GeneralResp;
import com.example.model.internal.LoginModel;
import com.example.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class LoginServiceImp implements ILoginService {

    @Autowired
    public UserEntity userEntity;

    @Autowired
    public UserRepository userRepository;

    @Override
    public ResponseEntity<Object> authentication(LoginModel loginModel)  {
        UserEntity userEntity = userRepository.findByUsername(loginModel.getUsername());
        if(userEntity==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(loginModel);
        }
        LoginModel resLoginModel = new LoginModel();
        String token = Jwts.builder().setSubject(userEntity.getId()).setExpiration(new Date(System.currentTimeMillis() + Long.parseLong("864000000"))).signWith(SignatureAlgorithm.HS512,"fajrifajri").compact();
        resLoginModel.setUsername(userEntity.getUsername());
        resLoginModel.setToken(token);
        GeneralResp generalResp = new GeneralResp();
        generalResp.setData(resLoginModel);
        generalResp.setStatusCode(HttpStatus.ACCEPTED.value());
        generalResp.setResult("success login");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(generalResp);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
