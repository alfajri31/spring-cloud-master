package com.example.model.internal;

import lombok.Data;

import java.util.List;

@Data
public class GeneralResp {
    private String result;
    private Integer statusCode;
    private List<String> message;
    private Object data;
}
