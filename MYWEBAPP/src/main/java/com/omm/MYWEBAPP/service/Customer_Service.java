package com.omm.MYWEBAPP.service;

import com.omm.MYWEBAPP.DTO.InputDTO.customerinputdto;
import com.omm.MYWEBAPP.DTO.MAPPER.CustoemrcumFeedbackMAp;
import com.omm.MYWEBAPP.DTO.OUTPUTDTO.CustomerDto;
import com.omm.MYWEBAPP.Entity.Customer_entity;
import com.omm.MYWEBAPP.repo.Customerrepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Service
public class Customer_Service {
    private final Customerrepo customerrepo;
    private final CustoemrcumFeedbackMAp custoemrcumFeedbackMAp;
    private final MongoTemplate mongoTemplate;



    public String addCustomers(List<customerinputdto>customerinputdtos){
       List<Customer_entity>entities=customerinputdtos.stream().map(custoemrcumFeedbackMAp::toCustomerEntity).toList();
       customerrepo.saveAll(entities);
        return "Customers added successfully";
    }
    public List<CustomerDto> GetAllCustomers(){
        return customerrepo.findAll().stream().map(custoemrcumFeedbackMAp::toCustomerOutputDto).toList();
    }
    public CustomerDto getCustomerById(String id){
        return custoemrcumFeedbackMAp.toCustomerOutputDto(customerrepo.findById(id).orElse(null));
    }
    public String deleteAll(){
        mongoTemplate.dropCollection("customers");
        return "All customers deleted successfully";
    }


}
