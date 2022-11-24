package com.example.manageroletableexistsample.repository;

import com.example.manageroletableexistsample.entity.UserSampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserSampleRepo extends JpaRepository<UserSampleEntity,Integer> {
}
