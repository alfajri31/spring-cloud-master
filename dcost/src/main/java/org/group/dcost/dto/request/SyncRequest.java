package org.group.dcost.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SyncRequest {
    private String userId;
    private List<String> digitalPaymentIds;
}
