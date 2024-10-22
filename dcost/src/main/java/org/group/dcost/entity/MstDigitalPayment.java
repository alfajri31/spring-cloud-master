package org.group.dcost.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "mst_digital_payment")
public class MstDigitalPayment {
    @Id
    private String id;
    private String mstDigitalPaymentId;
    private String mstDigitalPaymentName;
}
