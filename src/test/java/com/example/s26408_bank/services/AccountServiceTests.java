package com.example.s26408_bank.services;

import com.example.s26408_bank.exceptions.InvalidPeselException;
import com.example.s26408_bank.exceptions.InvalidSaldoException;
import com.example.s26408_bank.models.Account;
import com.example.s26408_bank.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.s26408_bank.models.Waluta.EUR;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceTests {

    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    AccountService accountService;

    @Test
    void getAccountTests() {
        //when
        Account account = accountService.getAccount(1);

        //then
        assertNull(account);

        //given
        when(accountRepository.getAccountById(1L)).thenReturn(createTestAccount());

        //when
        account = accountService.getAccount(1);

        //then
        assertEquals("Jan", account.getName());
        assertEquals("Kowalcki", account.getSurname());
        assertEquals(EUR, account.getWaluta());
        assertEquals("99999999999", account.getPesel());
        assertEquals(1000.0, account.getSaldo());
    }

    @Test
    void registerAccountWHenPeselIsNull() {
        //given
        Account testAccount = createTestAccount();
        testAccount.setPesel(null);
        //when
        Exception exception = assertThrows(InvalidPeselException.class, () -> {
            accountService.registerAccount(testAccount);
        });
        //then
        assertTrue(exception.getMessage().contains("Pesel: 'null' jest nieprawidlowy"));
    }

    @Test
    void registerAccountWhenPeselIsNotNumber() {
        //given
        Account testAccount = createTestAccount();
        testAccount.setPesel("Incorrect");
        //when
        Exception exception = assertThrows(InvalidPeselException.class, () -> {
            accountService.registerAccount(testAccount);
        });
        //then
        assertTrue(exception.getMessage().contains("Pesel: 'Incorrect' jest nieprawidlowy"));
    }

    @Test
    void registerAccountWhenPeselHasBadLength() {
        //given
        Account testAccount = createTestAccount();
        testAccount.setPesel("99999999999999999999");
        //when
        Exception exception = assertThrows(InvalidPeselException.class, () -> {
            accountService.registerAccount(testAccount);
        });
        //then
        assertTrue(exception.getMessage().contains("Pesel: '99999999999999999999' jest nieprawidlowy"));
    }

    @Test
    void registerAccount() {
        //given
        Account testAccount = createTestAccount();
        when(accountRepository.save(testAccount)).thenReturn(createTestAccount());
        //when
        Account account = accountService.registerAccount(testAccount);
        //then
        assertEquals("Jan", account.getName());
        assertEquals("Kowalcki", account.getSurname());
        assertEquals(EUR, account.getWaluta());
        assertEquals("99999999999", account.getPesel());
        assertEquals(1000.0, account.getSaldo());
    }

    @Test
    void registerAccountWithBadSaldo() {
        //given
        Account testAccount = createTestAccount();
        testAccount.setSaldo(-10.0);
        //when
        Exception exception = assertThrows(InvalidSaldoException.class, () -> {
            accountService.registerAccount(testAccount);
        });
        //then
        assertTrue(exception.getMessage().contains("Saldo nie moze byc ujemne"));
    }

    private Account createTestAccount() {
        return Account.builder()
                .id(1)
                .name("Jan")
                .surname("Kowalcki")
                .waluta(EUR)
                .saldo(1000.0)
                .pesel("99999999999")
                .build();
    }
}
