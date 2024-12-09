package org.group.reactiveexample.controller;

import org.group.reactiveexample.model.dto.request.TestRequest;
import org.group.reactiveexample.model.dto.response.TestResponse;
import org.group.reactiveexample.service.ExampleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("my-api")
public class ExampleController {

    private final ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }


    @PostMapping
    private ResponseEntity<Mono<TestResponse>> testRequest(@RequestBody TestRequest testRequest) {
        Mono<TestResponse> testResponse = exampleService.testService(testRequest);
        return ResponseEntity.ok(testResponse);
    }
}
