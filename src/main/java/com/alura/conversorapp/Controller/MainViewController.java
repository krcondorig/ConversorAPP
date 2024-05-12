package com.alura.conversorapp.Controller;

import com.alura.conversorapp.Model.Currency;
import com.alura.conversorapp.Model.History;
import com.alura.conversorapp.Model.SceneSwitch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MainViewController {
    @FXML
    public TextField enterAmountField;
    @FXML
    public ComboBox<String> currencyOneBox;
    @FXML
    public ComboBox<String> currencyTwoBox;
    @FXML
    public Button btnExchange;
    @FXML
    public Button btnConvert;
    @FXML
    public Label resultLabel;
    @FXML
    public Button btnHistorial;
    @FXML
    private Pane scene1Pane;
    private String currencyOne, currencyTwo;
    static List<History> historyList = new ArrayList<>();

    public void initialize() {

        ObservableList<String> conversionRatesKeys = Currency.getConversionRatesKeys();
        currencyOneBox.setItems(conversionRatesKeys);
        currencyTwoBox.setItems(conversionRatesKeys);


    }
    public void onSwitch2Click(ActionEvent actionEvent) throws IOException {
        new SceneSwitch(scene1Pane, "History.fxml");
    }


    public void onExchangeClick(ActionEvent actionEvent) {


        String temp = currencyOne;
        currencyOne = currencyTwo;
        currencyTwo = temp;

        currencyOneBox.setValue(currencyOne);
        currencyTwoBox.setValue(currencyTwo);
    }

    public void convertCurrency(ActionEvent actionEvent) {
        currencyOne = currencyOneBox.getValue();
        currencyTwo = currencyTwoBox.getValue();

        if (enterAmountField.getText().isEmpty() || enterAmountField.getText() == null) {
            System.out.println("No hay monto");
            return;
        }
        if (currencyOne == null || currencyTwo == null) {
            System.out.println("No hay monedas");
            return;
        }
        System.out.println("entro" + currencyTwo);
        double amount = Double.parseDouble(enterAmountField.getText());
        System.out.println("amount" + amount);

        try {
            double result = Currency.convertCurrency(amount, currencyOne, currencyTwo);
            resultLabel.setText(String.format("%.2f %s", result, currencyTwo));

            History history = new History(currencyOne, currencyTwo, amount, result, LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), LocalDate.now());
            historyList.add(history);
//            for(History h: historyList){
//                System.out.println(h);
//            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public static List<History> getHistoryList() {
        return historyList;
    }



}
