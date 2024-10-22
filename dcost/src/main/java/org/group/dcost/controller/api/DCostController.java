package org.group.dcost.controller.api;

import lombok.AllArgsConstructor;
import org.group.dcost.dto.request.InquiryReq;
import org.group.dcost.dto.request.SyncRequest;
import org.group.dcost.dto.response.CommonResp;
import org.group.dcost.dto.response.InquiryResp;
import org.group.dcost.service.IDCostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RequestMapping("/subscribe")
@AllArgsConstructor
@RestController
public class DCostController {

    private final IDCostService idcostService;

    /**
     * Hanya untuk mentrigger api dari third party
     */
    @PostMapping(value = "/sync")
    private ResponseEntity<CommonResp> sync(@RequestBody SyncRequest syncRequest) throws IOException {
        CommonResp response = idcostService.syncService(syncRequest);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping(value = "inquiry")
    private ResponseEntity<InquiryResp> inquirySubscribe(@RequestBody InquiryReq inquiryReq) {
        InquiryResp response = idcostService.inquirySubscribe(inquiryReq);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping(value = "reset")
    private ResponseEntity<CommonResp> reset(@RequestBody SyncRequest syncRequest) throws IOException {
        CommonResp response = idcostService.resetSync(syncRequest);
        return ResponseEntity.ok().body(response);
    }
}
