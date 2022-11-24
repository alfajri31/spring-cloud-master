package com.mapping.entity;

import com.mapping.entity.base.BaseEntityAI;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "source_api")
@Data
public class SourceApiEntity extends BaseEntityAI {
    private String name;
    @OneToMany(mappedBy = "sourceApiEntity",fetch = FetchType.LAZY)
    private Set<OperatorEntity> operatorEntities;
}
