package org.jhpster.example.specification.domain;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.flowable.variable.service.impl.types.JsonType;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name = "staging_maker_approver")
@Data
public class Hello {
    @Id
    private Long id;
    @Column(columnDefinition = "json", name = "json_data")
    private String jsonInfo;
}