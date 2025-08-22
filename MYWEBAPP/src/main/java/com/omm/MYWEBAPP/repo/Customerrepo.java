package com.omm.MYWEBAPP.repo;

import com.omm.MYWEBAPP.Entity.Customer_entity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Customerrepo extends MongoRepository <Customer_entity,String>{
}
