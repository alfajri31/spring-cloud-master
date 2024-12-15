package org.group.myunittest.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.group.myunittest.service.ICalcInterface;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CalcImplService implements ICalcInterface {

    @Override
    public Integer add(int a, int b) {
        return a + b;
    }
}
