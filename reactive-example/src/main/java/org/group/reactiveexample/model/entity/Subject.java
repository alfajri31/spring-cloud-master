package org.group.reactiveexample.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table(name = "Subject")
public class Subject {
    @Id
    private String id;
    private String subjectName;
    private String facultyId;
    private String majorId;

    public Subject() {
        this.id = UUID.randomUUID().toString(); // Manually generate UUID
    }
}
