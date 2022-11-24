package com.mapping.repository;

import com.mapping.entity.PacketEntity;
import com.mapping.entity.PacketPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacketPriceRepository extends JpaRepository<PacketPriceEntity,String> {
}
