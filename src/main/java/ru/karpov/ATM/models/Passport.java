package ru.karpov.ATM.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String lastName;
    private Date dateOfBirth;
    private Date dateOfIssue;
    private String divisionCode;
    private String cityOfBirth;

    public Passport(final String name, final String lastName,
                    final Date dateOfBirth, final Date dateOfIssue,
                    final String divisionCode, final String cityOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfIssue = dateOfIssue;
        this.divisionCode = divisionCode;
        this.cityOfBirth = cityOfBirth;
    }

    public Passport() {

    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public String getDivisionCode() {
        return divisionCode;
    }

    public String getCityOfBirth() {
        return cityOfBirth;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(final Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfIssue(final Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public void setDivisionCode(final String divisionCode) {
        this.divisionCode = divisionCode;
    }

    public void setCityOfBirth(final String cityOfBirth) {
        this.cityOfBirth = cityOfBirth;
    }
}
