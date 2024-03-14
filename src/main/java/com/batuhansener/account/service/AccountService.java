package com.batuhansener.account.service;

import com.batuhansener.account.dto.AccountDto;
import com.batuhansener.account.dto.CreateAccountRequest;
import com.batuhansener.account.dto.converter.AccountDtoConverter;
import com.batuhansener.account.model.Account;
import com.batuhansener.account.model.Customer;
import com.batuhansener.account.model.Transaction;
import com.batuhansener.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final TransactionService transactionService;
    private final AccountDtoConverter converter;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService, TransactionService transactionService,
                          AccountDtoConverter converter){
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.transactionService = transactionService;
        this.converter = converter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomer_id());
        Account account = new Account(customer, createAccountRequest.getInitialCredit(), LocalDateTime.now());
        account = accountRepository.save(account);
        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = transactionService.initiateMoney(account, createAccountRequest.getInitialCredit());
            account.getTransaction().add(transaction);
        }
        return converter.convert(account);
    }

}
