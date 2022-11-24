package com.example.operator.repository;

import com.mapping.entity.OperatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOperatorRepository extends JpaRepository<OperatorEntity,Long> {
}
