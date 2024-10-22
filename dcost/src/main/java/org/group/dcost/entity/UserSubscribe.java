package org.group.dcost.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user_subscribe")
public class UserSubscribe {
    @Id
    private String id;
    private String userId;
    private String digitalPaymentId;
    private String digitalPaymentName;
    private Integer dailyAmount;
    private Integer monthlyAmount;
    private Integer yearlyAmount;
    private String currentDate;
    private Boolean active;
    private String dailyAmountId;
    private String monthlyAmountId;
    private String yearlyAmountId;
}
