package com.batuhansener.account.service;

import com.batuhansener.account.model.Account;
import com.batuhansener.account.model.Transaction;
import com.batuhansener.account.repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    protected Transaction initiateMoney(final Account account, BigDecimal amount){
        return transactionRepository.save(
                //JpaRepo verdiğim nesneyi alacak ve id ekleyip tekrar bana dönecek
                new Transaction(amount, account)
        );
    }
}
