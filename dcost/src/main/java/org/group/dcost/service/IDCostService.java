package org.group.dcost.service;

import org.group.dcost.dto.request.InquiryReq;
import org.group.dcost.dto.request.SyncRequest;
import org.group.dcost.dto.response.CommonResp;
import org.group.dcost.dto.response.InquiryResp;

import java.io.IOException;

public interface IDCostService {
    CommonResp syncService(SyncRequest syncRequest) throws IOException;
    InquiryResp inquirySubscribe(InquiryReq inquiryReq);

    CommonResp resetSync(SyncRequest syncRequest) throws IOException;
}
