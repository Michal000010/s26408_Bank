package com.example.s26408_bank.services;

import com.example.s26408_bank.models.Account;
import com.example.s26408_bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account getAccount(long accountId) {
        return accountRepository.getAccountById(accountId);
    }

    public Account registerAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(long accountId) {
        accountRepository.deleteById(accountId);
    }

    public List<Account> getAccountsBySaldoIsGreaterThan(Double saldo) {
        return accountRepository.getAccountsBySaldoIsGreaterThan(saldo);
    }
}
