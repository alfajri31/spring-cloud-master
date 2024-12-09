package org.group.reactiveexample.service;

import lombok.AllArgsConstructor;
import org.group.reactiveexample.model.dto.request.TestRequest;
import org.group.reactiveexample.model.dto.response.TestResponse;
import org.group.reactiveexample.model.entity.Student;
import org.group.reactiveexample.repository.IStudentRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class ExampleService {

    private final IStudentRepo studentRepo;

    public Mono<TestResponse> getSingleStudent(TestRequest testRequest) {
        return studentRepo.findById(testRequest.getStudentId())
                .map(student -> new TestResponse());
    }

    public Flux<TestResponse> getMultipleStudents(TestRequest testRequest) {
        return studentRepo.findAllByStudentId(testRequest.getStudentId())
                .map(student -> new TestResponse());
    }

    public Mono<TestResponse> getSingleStudentWithSync(TestRequest testRequest) {
        Student student = fetchStudentFromDatabase(testRequest.getStudentId());
        return Mono.just(new TestResponse());
    }

    private Student fetchStudentFromDatabase(String studentId) {
        return new Student();
    }
}
