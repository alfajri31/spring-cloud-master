package org.jhpster.example.repo;

import org.jhpster.example.specification.domain.Hello;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HelloRepository extends JpaRepository<Hello,Long> {

    List<Hello> findAll(Specification<Hello> helloSpecification);
}
