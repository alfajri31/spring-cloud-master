package org.group.reactiveexample.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

;

@Data
@Table(name = "Student")
@AllArgsConstructor
public class Student {
    @Id
    private String id;
    private String name;
    private String major;

    public Student() {
        this.id = UUID.randomUUID().toString(); // Manually generate UUID
    }
}
