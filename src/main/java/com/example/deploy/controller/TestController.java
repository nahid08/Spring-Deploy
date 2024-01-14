package com.example.deploy.controller;

import com.example.deploy.model.Dynamo;
import com.example.deploy.repositories.DRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RestController
public class TestController {


    @Autowired(required = false)
    DRepository dynamoRepository;

    @GetMapping("/test")
    public String testApi() {
        return "Hello World";
    }

    @GetMapping("/save")
    public ResponseEntity<String> saveDynamo(@RequestBody  Dynamo data) {
        System.out.println("Calling Dynamo DB");
        String msg = new String("All is Ok");
        try {
            dynamoRepository.save(data);
            System.out.println("Data is saved correctly");
        } catch (Exception e) {
            msg = "Something is wrong";
        }
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Dynamo>> dynamoList() {
        System.out.println("Calling List Api");
        List<Dynamo> dynamos = new ArrayList<>();
        try {
             dynamoRepository.findAll().forEach(data -> {
                 dynamos.add(data);
             });

        } catch (Exception e) {

        }

        return ResponseEntity.ok(dynamos);
    }
}
