package com.example.manageroletableexistsample.repository;

import com.example.manageroletableexistsample.entity.PrivilegesSampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPrivilegesSampleRepo extends JpaRepository<PrivilegesSampleEntity,Integer> {
}
