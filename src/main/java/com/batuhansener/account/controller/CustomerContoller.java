package com.batuhansener.account.controller;

import com.batuhansener.account.dto.*;
import com.batuhansener.account.model.Customer;
import com.batuhansener.account.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
public class CustomerContoller {

    private final CustomerService customerService;

    public CustomerContoller(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customer_id}")
    public ResponseEntity<CustomerDto> getCustomerInfo(@PathVariable String customer_id){
        return ResponseEntity.ok(customerService.getCustomerById(customer_id));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PutMapping
    public ResponseEntity<CustomerDto> updateCustomerName(@RequestBody UpdateCustomerNameRequest request){
        customerService.updateCustomerName(request.getCustomer_id(), request.getCustomer_name());
        return ResponseEntity.ok(customerService.getCustomerById(request.getCustomer_id()));
    }

}
