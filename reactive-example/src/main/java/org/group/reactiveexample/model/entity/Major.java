package org.group.reactiveexample.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table(name = "Major")
public class Major {
    @Id
    private String id;
    private String majorName;
    private String facultyId;
    private String studentId;

    public Major() {
        this.id = UUID.randomUUID().toString(); // Manually generate UUID
    }
}
