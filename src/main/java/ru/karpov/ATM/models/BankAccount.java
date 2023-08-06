package ru.karpov.ATM.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BankAccount {
    @Id
    private String id;
    private String typeOfBankAccountCode;
    private String activityOfBankAccountOwnerCode;
    private String currencyOfBankAccountCode;
    private String controlNumber;
    private String bankOfficeCode;
    private String BankAccountOwnerCode;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getTypeOfBankAccountCode() {
        return typeOfBankAccountCode;
    }

    public void setTypeOfBankAccountCode(final String typeOfBankAccountCode) {
        this.typeOfBankAccountCode = typeOfBankAccountCode;
    }

    public String getActivityOfBankAccountOwnerCode() {
        return activityOfBankAccountOwnerCode;
    }

    public void setActivityOfBankAccountOwnerCode(final String activityOfBankAccountOwnerCode) {
        this.activityOfBankAccountOwnerCode = activityOfBankAccountOwnerCode;
    }

    public String getCurrencyOfBankAccountCode() {
        return currencyOfBankAccountCode;
    }

    public void setCurrencyOfBankAccountCode(final String currencyOfBankAccountCode) {
        this.currencyOfBankAccountCode = currencyOfBankAccountCode;
    }

    public String getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(final String controlNumber) {
        this.controlNumber = controlNumber;
    }

    public String getBankOfficeCode() {
        return bankOfficeCode;
    }

    public void setBankOfficeCode(final String bankOfficeCode) {
        this.bankOfficeCode = bankOfficeCode;
    }

    public String getBankAccountOwnerCode() {
        return BankAccountOwnerCode;
    }

    public void setBankAccountOwnerCode(final String bankAccountOwnerCode) {
        BankAccountOwnerCode = bankAccountOwnerCode;
    }
}
