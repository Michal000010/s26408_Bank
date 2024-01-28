package com.example.s26408_bank.controllers;

import com.example.s26408_bank.models.Account;
import com.example.s26408_bank.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Account>> getAllAccount() {
        return ResponseEntity.ok(accountService.getAccounts());
    }

    @GetMapping(value = "/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable long accountId) {
        return ResponseEntity.ok(accountService.getAccount(accountId));
    }

    @PostMapping()
    public ResponseEntity<Account> registerAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.registerAccount(account));
    }

    @DeleteMapping(value = "/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable long accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/greaterThan")
    public ResponseEntity<List<Account>> getAccountsBySaldoIsGreaterThan(@RequestParam Double saldo) {
        return ResponseEntity.ok(accountService.getAccountsBySaldoIsGreaterThan(saldo));
    }
}
