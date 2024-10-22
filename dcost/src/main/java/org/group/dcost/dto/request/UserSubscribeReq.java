package org.group.dcost.dto.request;

import lombok.Data;

@Data
public class UserSubscribeReq {
   private String userId;
   private Boolean active;
}
