package com.example.s26408_bank.repository;


import com.example.s26408_bank.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account getAccountById(Long id);

    List<Account> getAccountsBySaldoIsGreaterThan(Double saldo);
}
