package org.group.dcost.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InquiryResp {
    private Integer page;
    private Integer size;
    private Integer totalPages;
    private Integer totalSize;
    private List<Object> data;
}
