package com.example.service;

import com.example.entity.UserEntity;
import com.example.model.internal.LoginModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface ILoginService extends UserDetailsService {
    UserEntity authentication(LoginModel loginModel);
    UserEntity getUserDetailsByUsername(String username);
}
