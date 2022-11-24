package com.example.manageroletableexistsample.repository;

import com.example.manageroletableexistsample.entity.RoleSampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleSampleRepo extends JpaRepository<RoleSampleEntity,Integer> {
}
