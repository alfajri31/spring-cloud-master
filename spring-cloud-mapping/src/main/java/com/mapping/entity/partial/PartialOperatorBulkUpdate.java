package com.mapping.entity.partial;

import com.mapping.entity.SourceApiEntity;
import lombok.Data;
import org.hibernate.type.BigIntegerType;

@Data
public class PartialOperatorBulkUpdate {
    String name;
    Long sourceApiEntityId;
    String operatorSourceId;


    public PartialOperatorBulkUpdate(String name,Long sourceApiEntityId,String operatorSourceId){
        // set fields;
        this.name = name;
        this.sourceApiEntityId = sourceApiEntityId;
        this.operatorSourceId = operatorSourceId;
    }
}
