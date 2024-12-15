package org.jhpster.example.specification.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "staging_maker_approver")
@Data
public class Hello {
    @Id
    private Long id;
    @Column(columnDefinition = "json", name = "json_data")
    private String jsonInfo;
}
