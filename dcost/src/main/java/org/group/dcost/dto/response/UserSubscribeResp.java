package org.group.dcost.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSubscribeResp {
    private String digitalPaymentId;
    private String digitalPaymentName;
    private String totalAmountPerDay;
    private String totalAmountPerMonth;
    private String totalAmountPerYear;
}
