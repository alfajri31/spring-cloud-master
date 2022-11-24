package com.mapping.repository;

import com.mapping.entity.PacketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacketRepository extends JpaRepository<PacketEntity,String> {
    PacketEntity findByName(String name);
}
