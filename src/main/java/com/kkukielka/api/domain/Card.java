
package com.kkukielka.api.domain;

public class Card {

    private ExpirationDate expirationDate;
    private String iban;
    private String number;
    private String swift;
    private String type;

    public ExpirationDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(ExpirationDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
