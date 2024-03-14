package com.batuhansener.account.controller;

import com.batuhansener.account.dto.AccountCustomerDto;
import com.batuhansener.account.dto.CustomerAccountDto;
import com.batuhansener.account.dto.CustomerDto;
import com.batuhansener.account.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
