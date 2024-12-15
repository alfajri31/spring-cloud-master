package com.mapping.entity;

import com.mapping.entity.base.BaseEntityUUID;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "packet")
@Data
public class PacketEntity extends BaseEntityUUID {
    private String name;
    @Column(nullable = false,columnDefinition = "boolean default true")
    private Boolean status;
    @OneToMany(mappedBy = "packetEntity",fetch = FetchType.LAZY)
    private Set<PacketPriceEntity> packetPriceEntities;
    @Column(nullable = false,columnDefinition = "integer default 0")
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operator_entity_id")
    private OperatorEntity operatorEntity;
}
