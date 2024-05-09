package com.alura.conversorapp.Model;

import com.alura.conversorapp.Service.ConsumeAPI;
import com.alura.conversorapp.Service.ConvertData;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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


}
