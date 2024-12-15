package com.mapping.entity.partial;

import lombok.Data;

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
