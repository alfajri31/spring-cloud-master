package com.example.operator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OperatorModel {
    @JsonProperty("operator_name")
    public String operatorName;
}
