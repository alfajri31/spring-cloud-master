package org.group.reactiveexample.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table(name = "Lecturer")
public class Lecturer {
    @Id
    private String id;
    private String name;

    public Lecturer() {
        this.id = UUID.randomUUID().toString(); // Manually generate UUID
    }
}
