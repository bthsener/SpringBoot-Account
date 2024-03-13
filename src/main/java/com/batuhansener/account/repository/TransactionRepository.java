package com.batuhansener.account.repository;

import com.batuhansener.account.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, String > {

}

