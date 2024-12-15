package org.group.dcost.controller.api;

import lombok.AllArgsConstructor;
import org.group.dcost.service.ILogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/log")
@AllArgsConstructor
@RestController
public class CheckLogController {

    private final ILogService iLogService;

    /**
     * Elasticsearch log service
     */
    @PostMapping(value = "/inquiry")
    private ResponseEntity<List<Object>> checkLog() {
        List<Object> response = iLogService.checkLog();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping(value = "/inquiry-date/{date}")
    private ResponseEntity<List<Object>> checkLogByDate(@PathVariable("date") String date) {
        List<Object> response = iLogService.checkLogByDate(date);
        return ResponseEntity.ok().body(response);
    }

//    @PostMapping(value = "/bunga")
//    private ResponseEntity<List<Object>> checkBunga(@Reques) {
//        List<Object> response = iLogService.checkLogByDate(date);
//        return ResponseEntity.ok().body(response);
//    }


}
