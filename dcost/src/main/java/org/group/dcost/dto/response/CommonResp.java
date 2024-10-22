package org.group.dcost.dto.response;

import lombok.Data;

@Data
public class CommonResp {
    private Integer status;
    private boolean success;
    private String message;
}
