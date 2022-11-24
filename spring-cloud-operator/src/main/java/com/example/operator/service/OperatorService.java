package com.example.operator.service;

import com.example.operator.repository.IOperatorRepository;
import com.mapping.entity.OperatorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableEurekaClient
public class OperatorService {

    @Autowired
    private IOperatorRepository operatorRepository;

    public List<OperatorEntity> getOperator() {
        List<OperatorEntity> operatorEntities = operatorRepository.findAll();
        return ResponseEntity.ok().body(operatorEntities).getBody();
    }
}
