package org.group.reactiveexample.controller;

import org.group.reactiveexample.model.entity.MyStudent;
import org.group.reactiveexample.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("my-api")
public class ExampleController {

    /**
     * NOTE : USE API FOR TEST
     * all the service result are stored in 'MyStudent' table
     * you want test this clean the table of 'MyStudent' first
     * you can see the between service and controller to see the differences that saved in that table
     */

    @Autowired
    private ExampleService iExampleService;

    @PostMapping("test0")
    public void useSynchronousLine() {
        iExampleService.useSynchronousLine();
    }

    @PostMapping("test1")
    public Flux<MyStudent> useReturnInSynchronousLine() {
        //the return will error because can't return the 1 million data than the limit size response itself
        return iExampleService.useReturnInSynchronousLine();
    }

    @PostMapping("test2")
    public Mono<MyStudent> useReturnInSynchronousLineTake1ForResponse() {
        return iExampleService.useReturnInSynchronousLineTake1ForResponse();
    }



    @PostMapping("test3")
    public void useSubscribeInSynchronousLine() {
        iExampleService.useSubscribeInSynchronousLineService();
    }

    @PostMapping("test4")
    public Mono<String> useThenInSynchronousLine() {
        return iExampleService.useThenInSynchronousLine();
    }

    @PostMapping("test5")
    public Flux<MyStudent>  saveConcurrentWithBatch() {
        return iExampleService.saveConcurrentWithBatchService();
    }
}
