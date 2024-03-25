package org.example.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

@Service
public class SendMailService implements JavaDelegate {


    public void execute(DelegateExecution execution) {
        execution.setVariable("statusState","GAGAL");
    }
}