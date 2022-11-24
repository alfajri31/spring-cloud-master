package com.example.manageroletableexistsample.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "rolesample")
@Data
public class RoleSampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "roleSampleEntity")
    private Collection<PrivilegesSampleEntity> privilegesSampleEntityList;
    @OneToMany(mappedBy = "roleSampleEntityUser")
    private Collection<UserSampleEntity> userSampleEntities;
}
