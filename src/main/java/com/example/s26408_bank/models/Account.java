package com.example.s26408_bank.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {

    private long id;
    private String name;
    private String surname;
    private String pesel;
}
