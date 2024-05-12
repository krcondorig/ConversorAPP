package com.alura.conversorapp.Model;

import com.alura.conversorapp.Service.ConsumeAPI;
import com.alura.conversorapp.Service.ConvertData;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Currency {

    public static ObservableList<String> getConversionRatesKeys() {
        var consumo = new ConsumeAPI();
        var json = consumo.getDataAPI("https://v6.exchangerate-api.com/v6/c5358bd3919aa084cba56330/latest/USD");
        var data = new ConvertData().getData(json, DataExchangeRateAPI.class);
        return FXCollections.observableArrayList(new ArrayList<>(data.conversionRates().keySet()));
    }


    public static double convertCurrency(double amount, String currencyOne, String currencyTwo) {
        var consumo = new ConsumeAPI();
        var json = consumo.getDataAPI("https://v6.exchangerate-api.com/v6/c5358bd3919aa084cba56330/latest/" + currencyOne);
        var data = new ConvertData().getData(json, DataExchangeRateAPI.class);
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = time.format(formatter);

//        History history = new History(currencyOne, currencyTwo, amount, data.conversionRates().get(currencyTwo) * amount, formattedTime, date);
//        System.out.println(history);
        return data.conversionRates().get(currencyTwo) * amount;
    }

}
