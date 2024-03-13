package com.batuhansener.account.repository;

import com.batuhansener.account.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
