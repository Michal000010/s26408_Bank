package com.example.s26408_bank.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @JsonProperty(required = true)
    private long id;

    @JsonProperty(required = true)
    private String name;

    @JsonProperty(required = true)
    private String surname;

    @JsonProperty(required = true)
    private String pesel;

    @JsonProperty(required = true)
    private Double saldo;

    @JsonProperty(required = true)
    private Waluta waluta;
}
