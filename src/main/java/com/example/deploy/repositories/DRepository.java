package com.example.deploy.repositories;

import com.example.deploy.model.Dynamo;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@EnableScan
public interface DRepository extends CrudRepository<Dynamo, String> {
}
