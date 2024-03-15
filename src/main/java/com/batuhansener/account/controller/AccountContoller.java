package com.batuhansener.account.controller;

import com.batuhansener.account.dto.AccountDto;
import com.batuhansener.account.dto.CreateAccountRequest;
import com.batuhansener.account.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/account")
public class AccountContoller {
    private final AccountService accountService;


    public AccountContoller(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody CreateAccountRequest request){
        return ResponseEntity.ok(accountService.createAccount(request));
    }

    @GetMapping
    public String getMessage(){
        return "selam";
    }

    @DeleteMapping("/{account_id}")
    public void deleteAccount(@PathVariable String account_id){
        System.out.println("selam");
        accountService.deleteAccount(account_id);
    }

}
