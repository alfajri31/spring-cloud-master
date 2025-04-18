package org.group.reactiveexample.repository;

import org.group.reactiveexample.model.entity.MyStudent;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMyStudentRepo extends ReactiveCrudRepository<MyStudent, Long> {

}
