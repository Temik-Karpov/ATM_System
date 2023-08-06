package ru.karpov.ATM.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankAccountOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String passportId;
    private String account;
    private String card;

    public BankAccountOwner(final String id, final String passportId,
                            final String account, final String card) {
        this.id = id;
        this.passportId = passportId;
        this.account = account;
        this.card = card;
    }

    public BankAccountOwner() {

    }

    public String getPassportId() {
        return passportId;
    }

    public String getAccount() {
        return account;
    }

    public String getCard() {
        return card;
    }

    public void setPassportId(final String passportId) {
        this.passportId = passportId;
    }

    public void setAccount(final String account) {
        this.account = account;
    }

    public void setCard(final String card) {
        this.card = card;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
