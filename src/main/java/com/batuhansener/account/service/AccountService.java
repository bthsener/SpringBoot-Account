package com.batuhansener.account.service;

import com.batuhansener.account.dto.AccountDto;
import com.batuhansener.account.dto.CreateAccountRequest;
import com.batuhansener.account.dto.converter.AccountDtoConverter;
import com.batuhansener.account.exception.AccountNotFoundException;
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
//        account = accountRepository.save(account);
        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
//            Transaction transaction = transactionService.initiateMoney(account, createAccountRequest.getInitialCredit());
            Transaction transaction = new Transaction(
                    createAccountRequest.getInitialCredit(),
                    LocalDateTime.now(),
                    account
                    );
            account.getTransaction().add(transaction);
        }
        return converter.convert(accountRepository.save(account));
    }

    public Account findAccountById(String id){
        System.out.println("şimdi de burada");
        return accountRepository.findById(id).orElseThrow(()-> new AccountNotFoundException("Account could not find by id "+id));
    }

    public void deleteAccount(String id){
        Account account = findAccountById(id);
        transactionService.deleteAllAccountTransactions(account.getTransaction());
        accountRepository.delete(account);
    }
}
