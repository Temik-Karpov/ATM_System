package ru.karpov.ATM.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {
    @Id
    private String id;
    private String bankAccountSenderId;
    private String bankAccountGetterId;
    private Boolean transferAmount;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getBankAccountSenderId() {
        return bankAccountSenderId;
    }

    public void setBankAccountSenderId(final String bankAccountSenderId) {
        this.bankAccountSenderId = bankAccountSenderId;
    }

    public String getBankAccountGetterId() {
        return bankAccountGetterId;
    }

    public void setBankAccountGetterId(final String bankAccountGetterId) {
        this.bankAccountGetterId = bankAccountGetterId;
    }

    public Boolean getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(final Boolean transferAmount) {
        this.transferAmount = transferAmount;
    }
}
