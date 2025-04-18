package org.group.reactiveexample.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "mystudent")
public class MyStudent {
    @Id
    private Long id; // Keep as Long if your DB uses auto-increment
    @Column("student_name")
    private String studentName;
    @Column("major_name")
    private String majorName;
    private String studentid;
    private String majorid;

}
