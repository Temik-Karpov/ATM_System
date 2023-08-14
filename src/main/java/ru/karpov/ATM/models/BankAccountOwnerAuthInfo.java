package ru.karpov.ATM.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class BankAccountOwnerAuthInfo {
    @Id
    private String id;
    private String bankAccountOwnerCode;

    @NotEmpty(message = "login is mandatory")
    private String bankAccountOwnerLogin;

    @NotEmpty(message = "password is mandatory")
    private String bankAccountOwnerPassword;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getBankAccountOwnerCode() {
        return bankAccountOwnerCode;
    }

    public void setBankAccountOwnerCode(final String bankAccountOwnerCode) {
        this.bankAccountOwnerCode = bankAccountOwnerCode;
    }

    public String getBankAccountOwnerLogin() {
        return bankAccountOwnerLogin;
    }

    public void setBankAccountOwnerLogin(final String bankAccountOwnerLogin) {
        this.bankAccountOwnerLogin = bankAccountOwnerLogin;
    }

    public String getBankAccountOwnerPassword() {
        return bankAccountOwnerPassword;
    }

    public void setBankAccountOwnerPassword(final String bankAccountOwnerPassword) {
        this.bankAccountOwnerPassword = bankAccountOwnerPassword;
    }
}
