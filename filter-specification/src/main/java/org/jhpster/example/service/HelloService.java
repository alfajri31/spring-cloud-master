package org.jhpster.example.service;

import org.jhpster.example.repo.HelloRepository;
import org.jhpster.example.specification.HelloSpecification;
import org.jhpster.example.specification.domain.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloService {
    @Autowired
    private HelloRepository helloRepository;

    public List<Hello> getAll(String name,String address) {
        Specification<Hello> spec = HelloSpecification.defaults(name,address);
        return helloRepository.findAll(
                Specification.where(spec)
        );
    }
}
