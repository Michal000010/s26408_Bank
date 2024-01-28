package com.example.s26408_bank.services;

import com.example.s26408_bank.models.Account;
import com.example.s26408_bank.models.Waluta;
import com.example.s26408_bank.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AccountServiceTests {

    @Mock
    AccountRepository accountRepository;

    @InjectMocks
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
