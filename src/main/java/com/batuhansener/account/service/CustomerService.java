package com.batuhansener.account.service;

import com.batuhansener.account.dto.AccountCustomerDto;
import com.batuhansener.account.dto.CustomerDto;
import com.batuhansener.account.dto.converter.CustomerDtoConverter;
import com.batuhansener.account.exception.CustomerNotFoundException;
import com.batuhansener.account.model.Customer;
import com.batuhansener.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter){
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    protected Customer findCustomerById(String id){
        System.out.println("buradayım");
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer could not find by id: "+id));
    }

    public List<CustomerDto> getAllCustomers(){
        return customerRepository.findAll()
                .stream()
                .map(converter::convertToCustomerDto)
                .collect(Collectors.toList());
    }

    public CustomerDto getCustomerById(String customer_id){
        Customer customer = findCustomerById(customer_id);
        return converter.convertToCustomerDto(customer);
    }

    public void updateCustomerName(String customer_id, String customer_name){
        Customer customer = findCustomerById(customer_id);
        customer.setName(customer_name);
        customerRepository.saveAndFlush(customer);
    }
}
