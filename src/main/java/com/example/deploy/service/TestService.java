package com.example.deploy.service;


import com.example.deploy.repositories.DRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    DRepository dynamoRepository;


}
