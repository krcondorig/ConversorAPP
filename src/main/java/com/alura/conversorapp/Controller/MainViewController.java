package com.alura.conversorapp.Controller;

import com.alura.conversorapp.Model.Currency;
import com.alura.conversorapp.Model.SceneSwitch;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

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



    public void initialize() {


        ObservableList<String> conversionRatesKeys = Currency.getConversionRatesKeys();
        currencyOneBox.setItems(conversionRatesKeys);
        currencyTwoBox.setItems(conversionRatesKeys);

    }
    public void onSwitch2Click(ActionEvent actionEvent) throws IOException {
        new SceneSwitch(scene1Pane, "History.fxml");
    }



}
