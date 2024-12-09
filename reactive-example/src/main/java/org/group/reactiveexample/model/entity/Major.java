package org.group.reactiveexample.model.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "Major")
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String majorName;
    private String facultyId;
}
