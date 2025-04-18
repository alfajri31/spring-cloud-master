//package org.group.reactiveexample;
//
//import org.group.reactiveexample.controller.ExampleController;
//import org.group.reactiveexample.model.entity.MyStudent;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import reactor.core.publisher.Flux;
//
//@SpringBootTest
//class ReactiveExampleApplicationTests {
//
//    @Autowired
//    private ExampleController exampleController;
//
//    @Test
//    void contextLoads() {
//        exampleController.useServiceStudent();
//    }
//
//    @Test
//    void contextLoads1() {
//        exampleController.useSubscribeOnlyWhenSaveStudent();
//    }
//
//    @Test
//    void contextLoads2() {
//        exampleController.useSubscribeInSynchronousLine();
//    }
//
//
//    @Test
//    void contextLoads3() {
//        Flux<MyStudent> studentFlux = exampleController.useReturnForServiceStudent();
//        // To verify or inspect the result, you can block or subscribe.
//        studentFlux.doOnNext(student -> System.out.println("Student: " + student)).subscribe();
//    }
//}
