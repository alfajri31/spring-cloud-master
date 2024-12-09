package org.group.reactiveexample.repository;

import org.group.reactiveexample.model.entity.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IStudentRepo extends ReactiveCrudRepository<Student, String> {
    Flux<List<Student>> findAllByStudentId(String studentId);
}
