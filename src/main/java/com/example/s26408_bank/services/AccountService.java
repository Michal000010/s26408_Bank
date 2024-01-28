package com.example.s26408_bank.services;

import com.example.s26408_bank.models.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    public Account getAccount(long accountId) {
        return null;
    }

    public Account registerAccount(Account account) {
        return null;
    }

    public void deleteAccount(long accountId) {
        return;
    }

    public Account updateAccount(long accountId, Account account) {
        return null;
    }
}
