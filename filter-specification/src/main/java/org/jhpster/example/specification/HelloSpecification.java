package org.jhpster.example.specification;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;
import com.vladmihalcea.hibernate.type.json.JsonNodeStringType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import liquibase.repackaged.net.sf.jsqlparser.expression.JsonFunctionExpression;
import org.flowable.variable.service.impl.types.JsonType;
import org.jhpster.example.specification.domain.Hello;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class HelloSpecification  {


    public static Specification<Hello> defaults(String name,String address) {
        List<Predicate> predicates = new ArrayList<>()  ;
        return (root, query, criteriaBuilder) -> {
            Expression<String> roomIdStr = root.get("jsonInfo");
            Expression<JsonType> roomIdInt = criteriaBuilder.function("cast", JsonType.class, roomIdStr);
            predicates.add(
                    criteriaBuilder.like(
                            criteriaBuilder.function("json_extract_path_text",
                                    String.class, roomIdInt,
                                    criteriaBuilder.literal("masterData")
                            ), "KEREN"
                    )
            );
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
