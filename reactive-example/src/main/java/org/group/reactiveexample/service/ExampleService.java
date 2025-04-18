package org.group.reactiveexample.service;

import lombok.extern.slf4j.Slf4j;
import org.group.reactiveexample.model.entity.MyStudent;
import org.group.reactiveexample.model.entity.Student;
import org.group.reactiveexample.repository.IMyStudentRepo;
import org.group.reactiveexample.repository.IStudentRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ExampleService  {
    /**
     * Estimation Example
     * If using flatMap() with 8 parallel threads → Each batch of 10,000 rows needs 1 connection.
     * So, 8 threads x 1 connection per batch = ~8 PostgresSQL connections active at once.
     * Since there are 100 batches in total, each thread will process 100/8 = 12.5 batches per thread.
     */

    private final IStudentRepo studentRepo;
    private final IMyStudentRepo myStudentRepo;

    public ExampleService(IStudentRepo studentRepo,IMyStudentRepo myStudentRepo) {
        this.studentRepo = studentRepo;
        this.myStudentRepo = myStudentRepo;
    }


    public void useSynchronousLine() {
        //try to fetch all 1 million user student and iterate save it and log the saved student
       studentRepo.findAll().flatMap(this::setName).flatMap(this::saveStudent);
    }

    public Flux<MyStudent> useReturnInSynchronousLine() {
        //try to fetch all 1 million user student and iterate save it and log the saved student
        return studentRepo.findAll().flatMap(this::setName).flatMap(this::saveStudent);
    }

    public Mono<MyStudent> useReturnInSynchronousLineTake1ForResponse() {
        //try to fetch all 1 million user student and iterate save it and log the saved student
        return studentRepo.findAll().flatMap(this::setName).flatMap(this::saveStudent).collectList().flatMap(students -> Mono.just(students.get(0)));
    }


    public void useSubscribeInSynchronousLineService() {
        //try to fetch all 1 million user student and save it and log the saved student
        studentRepo.findAll().flatMap(this::setName).flatMap(this::saveStudent).subscribe();
        // looked like this 'void result = studentRepo.findAll().flatMap(this::setName).flatMap(this::saveStudent).subscribe();'
    }

    public Mono<String> useThenInSynchronousLine() {
        //try to fetch all 1 million user student and save it and log the saved student
        Mono<Void> result = studentRepo.findAll().flatMap(this::setName).flatMap(this::saveStudent).then();
        return result.flatMap(data -> Mono.just("Success ✅"));
    }


    public Flux<MyStudent> saveConcurrentWithBatchService() {
        //try to fetch all 1 million user student and save it with batch
        return studentRepo.findAll()
                .flatMap(this::setName)
                .buffer(10000)
                .flatMap(this::saveStudentInBulk);
    }

    private Mono<MyStudent> setName(Student student) {
        MyStudent myStudent = new MyStudent();
        myStudent.setStudentName("test");
        myStudent.setMajorName("test");
        return Mono.just(myStudent);
    }


    private Mono<MyStudent> saveStudent(MyStudent student) {
        log.info("triggered saved student: " + student);
        return myStudentRepo.save(student);
    }

    private Flux<List<MyStudent>> setNameInBulk(List<Student> students) {
        List<MyStudent> myStudentsList = new ArrayList<>();
        students.forEach(student -> {
            MyStudent myStudent = new MyStudent();
            myStudent.setStudentName("test");
            myStudent.setMajorName("test");
            myStudentsList.add(myStudent);
        });
        return Flux.just(myStudentsList);
    }

    private Flux<MyStudent> saveStudentInBulk(List<MyStudent> myStudents) {
        List<MyStudent> myStudentList = new ArrayList<>(myStudents);
        return myStudentRepo.saveAll(myStudentList);
    }
}
