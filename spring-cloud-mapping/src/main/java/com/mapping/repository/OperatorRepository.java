package com.mapping.repository;

import com.mapping.entity.OperatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepository extends JpaRepository<OperatorEntity,Long> {
    OperatorEntity findByOperatorSourceIdAndSourceApiEntityId(String operatorSourceI,Long sourceApiEntityId);
}
