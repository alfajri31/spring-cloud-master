package com.mapping.entity;

import com.mapping.entity.base.BaseEntityUUID;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "packet_price")
@Data
public class PacketPriceEntity extends BaseEntityUUID {
    private Double nominal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="packet_entity_id")
    private PacketEntity packetEntity;
}
