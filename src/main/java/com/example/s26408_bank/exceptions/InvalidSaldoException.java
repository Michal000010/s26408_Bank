package com.example.s26408_bank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidSaldoException extends RuntimeException {

    public InvalidSaldoException() {
        super("Saldo nie moze byc ujemne");
    }
}
