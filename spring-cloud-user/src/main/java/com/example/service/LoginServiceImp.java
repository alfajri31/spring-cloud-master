package com.example.service;

import com.example.entity.UserEntity;
import com.example.model.internal.LoginModel;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LoginServiceImp implements ILoginService {

    @Autowired
    public UserEntity userEntity;

    @Autowired
    public UserRepository userRepository;

    @Override
    public UserEntity authentication(LoginModel loginModel)  {
        return userRepository.findByUsername(loginModel.getUsername());
    }

    @Override
    public UserEntity getUserDetailsByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity==null) throw new UsernameNotFoundException(username);
        return userEntity;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if(user==null) {
            throw new UsernameNotFoundException(username);
        }
        else {
            return new User(user.getUsername(),user.getPassword(),true,true,true,true,new ArrayList<>());
        }
    }
}
