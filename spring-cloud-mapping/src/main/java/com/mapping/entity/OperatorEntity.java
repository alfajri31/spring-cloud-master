package com.mapping.entity;

import com.mapping.entity.base.BaseEntityAI;
import com.mapping.entity.base.BaseEntityUUID;
import com.mapping.entity.partial.PartialOperatorBulkUpdate;
import lombok.Data;
import lombok.ToString;
import org.hibernate.type.BigIntegerType;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "operator")
@Data
@SqlResultSetMapping(
        name="partialOperatorBulkUpdate", classes = {
            @ConstructorResult(targetClass = PartialOperatorBulkUpdate.class, columns = {
                    @ColumnResult(name="name",type = String.class),
                    @ColumnResult(name="source_api_entity_id",type = Long.class),
                    @ColumnResult(name="operator_source_id",type = String.class)
            })
        })
public class OperatorEntity extends BaseEntityUUID {
    private String name;
    @Column(name = "operator_source_id")
    private String operatorSourceId;
    @OneToMany(mappedBy = "operatorEntity",fetch = FetchType.LAZY)
    private Set<PacketEntity> packetEntities;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_api_entity_id")
    private SourceApiEntity sourceApiEntity;
}
