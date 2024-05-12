package com.alura.conversorapp.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class History {
    private String currencyFrom;
    private String currencyTo;
    private double amount;
    private double result;
    private String time;
    private LocalDate date;


    public History(String currencyFrom, String currencyTo, double amount, double result, String time, LocalDate date) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.amount = amount;
        this.result = result;
        this.time = time;
        this.date = date;
    }

    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "History{" +
                "currencyFrom='" + currencyFrom + '\'' +
                ", currencyTo='" + currencyTo + '\'' +
                ", amount=" + amount +
                ", result=" + result +
                ", time=" + time +
                ", date=" + date +
                '}';
    }


}
