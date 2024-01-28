package com.example.s26408_bank.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Account {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
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
