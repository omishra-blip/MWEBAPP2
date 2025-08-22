package com.omm.MYWEBAPP.controller;

import com.omm.MYWEBAPP.DTO.InputDTO.customerinputdto;
import com.omm.MYWEBAPP.DTO.OUTPUTDTO.CustomerDto;
import com.omm.MYWEBAPP.Entity.Customer_entity;
import com.omm.MYWEBAPP.service.Customer_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class Customercontroller {
    private final Customer_Service customer_Service;
    @PostMapping("/customer/add")
    public ResponseEntity<String> addCustomers(@RequestBody List<customerinputdto> customerinputdtos){
        return ResponseEntity.ok(customer_Service.addCustomers(customerinputdtos));

    }
    @GetMapping("/customer")
    public ResponseEntity<List<CustomerDto>> GetAllCustomers(){
        return ResponseEntity.ok(customer_Service.GetAllCustomers());
    }
    @DeleteMapping("/customer/deleteall")
    public ResponseEntity<String>deleteAll(){
        return ResponseEntity.ok(customer_Service.deleteAll());
    }
}
