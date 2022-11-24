package com.mapping.repository;

import com.mapping.entity.GlobalTokenEntity;
import com.mapping.entity.SourceApiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceApiRepository extends JpaRepository<SourceApiEntity,Long> {
}
