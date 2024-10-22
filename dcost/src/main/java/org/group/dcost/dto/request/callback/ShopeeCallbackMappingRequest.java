package org.group.dcost.dto.request.callback;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShopeeCallbackMappingRequest {
    private String userId;
    private String requestId;
    private String requestName;
    private Integer paidAmount;
    private String date;
    private String digitalPaymentId;
}
