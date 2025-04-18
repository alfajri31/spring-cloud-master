package org.group.reactiveexample.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table(name = "Faculty")
public class Faculty {
    @Id
    private String id;
    private String majorId;
    private String majorName;

    public Faculty() {
        this.id = UUID.randomUUID().toString(); // Manually generate UUID
    }
}
