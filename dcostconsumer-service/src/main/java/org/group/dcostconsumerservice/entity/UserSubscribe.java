package org.group.dcostconsumerservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user_subscribe")
@Builder
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
}

