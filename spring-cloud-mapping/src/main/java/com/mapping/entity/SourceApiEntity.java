package com.mapping.entity;

import com.mapping.entity.base.BaseEntityAI;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "source_api")
@Data
public class SourceApiEntity extends BaseEntityAI {
    private String name;
    @OneToMany(mappedBy = "sourceApiEntity",fetch = FetchType.LAZY)
    private Set<OperatorEntity> operatorEntities;
}
