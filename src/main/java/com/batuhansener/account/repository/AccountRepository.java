package com.batuhansener.account.repository;

import com.batuhansener.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

}
