package com.example.service;

import com.example.entity.UserEntity;
import com.example.model.internal.LoginModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ILoginService extends UserDetailsService {
    ResponseEntity<Object> authentication(LoginModel loginModel) throws Exception;
}
