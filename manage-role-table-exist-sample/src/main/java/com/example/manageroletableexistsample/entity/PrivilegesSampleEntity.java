package com.example.manageroletableexistsample.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Table(name = "privilegessample")
@Data
public class PrivilegesSampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @Column(name = "role_id")
    private String roleId;
    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id",insertable = false,updatable = false)
    private RoleSampleEntity roleSampleEntity;
}
