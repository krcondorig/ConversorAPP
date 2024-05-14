package com.alura.conversorapp.Model;

import com.alura.conversorapp.Service.ConsumeAPI;
import com.alura.conversorapp.Service.ConvertData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Currency {

    public static ObservableList<String> getConversionRatesKeys() {
        var consumo = new ConsumeAPI();
        var json = consumo.getDataAPI("https://v6.exchangerate-api.com/v6/c5358bd3919aa084cba56330/latest/USD");
        var data = new ConvertData().getData(json, DataExchangeRateAPI.class);
        return FXCollections.observableArrayList(new ArrayList<>(data.conversionRates().keySet()));
    }

    public static BigDecimal convertCurrency(double amount, String currencyOne, String currencyTwo) {
        var consumo = new ConsumeAPI();
        var json = consumo.getDataAPI("https://v6.exchangerate-api.com/v6/c5358bd3919aa084cba56330/latest/" + currencyOne);
        var data = new ConvertData().getData(json, DataExchangeRateAPI.class);
        BigDecimal result = BigDecimal.valueOf(data.conversionRates().get(currencyTwo) * amount)
                .setScale(2, RoundingMode.HALF_UP);
        return result;
    }

}
