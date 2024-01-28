package com.example.s26408_bank.services;

import com.example.s26408_bank.exceptions.InvalidPeselException;
import com.example.s26408_bank.exceptions.InvalidSaldoException;
import com.example.s26408_bank.models.Account;
import com.example.s26408_bank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account getAccount(long accountId) {
        return accountRepository.getAccountById(accountId);
    }

    public Account registerAccount(Account account) {
        checkPeselIsValid(account.getPesel());
        checkSaldo(account.getSaldo());
        return accountRepository.save(account);
    }

    public void deleteAccount(long accountId) {
        accountRepository.deleteById(accountId);
    }

    public List<Account> getAccountsBySaldoIsGreaterThan(Double saldo) {
        return accountRepository.getAccountsBySaldoIsGreaterThan(saldo);
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    protected void checkPeselIsValid(String pesel) {
        if (Objects.isNull(pesel) || pesel.length() != 11) {
            throw new InvalidPeselException(pesel);
        }
        try {
            Double.parseDouble(pesel);
        } catch (NumberFormatException nfe) {
            throw new InvalidPeselException(pesel);
        }
    }

    protected void checkSaldo(Double saldo) {
        if (saldo < 0) {
            throw new InvalidSaldoException();
        }
    }
}
