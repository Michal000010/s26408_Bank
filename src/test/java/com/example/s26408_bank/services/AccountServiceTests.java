package com.example.s26408_bank.services;

import com.example.s26408_bank.exceptions.InvalidPeselException;
import com.example.s26408_bank.models.Account;
import com.example.s26408_bank.models.Waluta;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountServiceTests {

    @Autowired
    AccountService accountService;

    @Test
    void tryDeleteAccount() {
        accountService.deleteAccount(1);
    }

    @Test
    void tryRegisterAccountWithWrongPesel() {
        accountService.registerAccount(Account.builder().pesel("999999999999").name("XYZ").surname("ZZZ").saldo(10.0).waluta(Waluta.EUR).build());
    }

    @Test
    void tryRegisterAccoun() {
        accountService.registerAccount(Account.builder().pesel("99999999999").name("XYZ").surname("ZZZ").saldo(10.0).waluta(Waluta.EUR).build());
    }
}
