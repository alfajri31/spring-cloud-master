package org.group.myunittest.controller;

import org.group.myunittest.service.ICalcInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {

    private final ICalcInterface iCalcInterface;

    public CalcController(ICalcInterface iCalcInterface) {
        this.iCalcInterface = iCalcInterface;
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestParam int a, @RequestParam int b) {
        Integer result = iCalcInterface.add(a, b);
        return ResponseEntity.ok(result);
    }
}
