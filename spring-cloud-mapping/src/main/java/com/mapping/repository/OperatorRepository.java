package com.mapping.repository;

import com.mapping.entity.OperatorEntity;
import com.mapping.entity.partial.PartialOperatorBulkUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface OperatorRepository extends JpaRepository<OperatorEntity,Long> {
    OperatorEntity findByOperatorSourceIdAndSourceApiEntityId(String operatorSourceI,Long sourceApiEntityId);
}
