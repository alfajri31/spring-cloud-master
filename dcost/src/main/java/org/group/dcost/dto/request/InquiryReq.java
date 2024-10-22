package org.group.dcost.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InquiryReq {
    private String userId="";
    private Integer page=0;
    private Integer size=10;
}
