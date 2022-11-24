package com.example.manageroletableexistsample.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "usersample")
@Data
public class UserSampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    @Column(name="role_id")
    private Integer roleId;
    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id",insertable = false,updatable = false)
    private RoleSampleEntity roleSampleEntityUser;

}
