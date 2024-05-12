package com.alura.conversorapp.Model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class History {
    private String currencyFrom;
    private String currencyTo;
    private double amount;
    private BigDecimal result;
    private String time;
    private LocalDate date;


    public History(String currencyFrom, String currencyTo, double amount, BigDecimal result, String time, LocalDate date) {
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

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = BigDecimal.valueOf(result);
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
