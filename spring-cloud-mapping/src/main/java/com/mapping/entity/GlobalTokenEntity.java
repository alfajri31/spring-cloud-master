package com.mapping.entity;

import com.mapping.entity.base.BaseEntityAI;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "global_token")
@Data
public class GlobalTokenEntity extends BaseEntityAI {
    @Column(name = "access_token",columnDefinition = "TEXT")
    private String accessToken;
}
