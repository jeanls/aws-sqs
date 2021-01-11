package com.jean.awssqs.controllers;

import com.jean.awssqs.sqs.AwsSQSProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/sqs")
public class SqsController {

    private final AwsSQSProducer awsSQSProducer;

    @PostMapping
    public ResponseEntity<Object> produce() {

        awsSQSProducer.sendMessage("Hi");

        return ResponseEntity.ok().build();
    }
}
