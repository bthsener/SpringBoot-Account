package com.batuhansener.account;

import com.batuhansener.account.model.Customer;
import com.batuhansener.account.repository.CustomerRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

	private final CustomerRepository customerRepository;

	public AccountApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		customerRepository.save(new Customer("","Batuhan", "Sener", null));
		customerRepository.save(new Customer("","Ahmet", "Mehmet", null));
		customerRepository.save(new Customer("","Ayse", "Fatma", null));
		customerRepository.save(new Customer("","Hayriye", "Dursun", null));
	}
}
