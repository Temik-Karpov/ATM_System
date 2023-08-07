package ru.karpov.ATM.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bank {
    @Id
    private String bankCode;
    private String name;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(final String bankCode) {
        this.bankCode = bankCode;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
