package com.example.manageroletableexistsample.controller;

import com.example.manageroletableexistsample.entity.RoleSampleEntity;
import com.example.manageroletableexistsample.entity.UserSampleEntity;
import com.example.manageroletableexistsample.repository.IRoleSampleRepo;
import com.example.manageroletableexistsample.repository.IUserSampleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserSampleRepo iUserSampleRepo;

    @Autowired
    private IRoleSampleRepo iRoleSampleRepo;

    @GetMapping("all")
    public List<RoleSampleEntity> getAll() {
        Optional<UserSampleEntity> userSampleEntityOptional = iUserSampleRepo.findById(1);
        if(userSampleEntityOptional.isPresent()) {
           List<RoleSampleEntity> roleSampleEntities = iRoleSampleRepo.findAllById(Collections.singleton(userSampleEntityOptional.get().getRoleId()));
           return roleSampleEntities;
        }
        return null;
    }
}
