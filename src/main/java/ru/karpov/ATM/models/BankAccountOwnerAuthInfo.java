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

    @NotEmpty(message = "login is mandatory")
    private String bankAccountOwnerLogin;

    @NotEmpty(message = "password is mandatory")
    private String bankAccountOwnerPassword;

    public BankAccountOwnerAuthInfo() {

    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public BankAccountOwnerAuthInfo(@NotEmpty(message = "login is mandatory") final String bankAccountOwnerLogin,
                                    @NotEmpty(message = "password is mandatory") final String bankAccountOwnerPassword) {
        this.bankAccountOwnerLogin = bankAccountOwnerLogin;
        this.bankAccountOwnerPassword = bankAccountOwnerPassword;
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
