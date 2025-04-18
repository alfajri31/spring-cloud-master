package org.group.reactiveexample.repository;

import org.group.reactiveexample.model.entity.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IStudentRepo extends ReactiveCrudRepository<Student, Long> {
    Mono<Student> findByName(String name);
}
