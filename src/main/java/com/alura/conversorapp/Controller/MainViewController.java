package com.alura.conversorapp.Controller;

import com.alura.conversorapp.MainApplication;
import com.alura.conversorapp.Model.Currency;
import com.alura.conversorapp.Model.History;
import com.alura.conversorapp.Model.SceneSwitch;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    private static final List<History> historyList = new ArrayList<>();

    public void initialize() {

        ObservableList<String> conversionRatesKeys = Currency.getConversionRatesKeys();
        currencyOneBox.setItems(conversionRatesKeys);
        currencyTwoBox.setItems(conversionRatesKeys);
    }

    public void onSwitch2Click() throws IOException {
        new SceneSwitch(scene1Pane, "View/History.fxml");
    }


    public void onExchangeClick() {
        String temp = currencyOne;
        currencyOne = currencyTwo;
        currencyTwo = temp;

        currencyOneBox.setValue(currencyOne);
        currencyTwoBox.setValue(currencyTwo);
    }

    public void convertCurrency() {
        currencyOne = currencyOneBox.getValue();
        currencyTwo = currencyTwoBox.getValue();
        String amountEntered = enterAmountField.getText();

        if (amountEntered.isEmpty()) {
            showAlert("No hay un monto");
            return;
        }

        if (!amountEntered.matches("^\\d+(\\.\\d{0,4})?$")){
            showAlert("El monto no es valido, solo se aceptan cantidades hasta con 4 decimales");
            return;
        }

        if (currencyOne == null || currencyTwo == null) {
            showAlert("Ingrese un tipo de moneda de origen y de destino");
            return;
        }

        double amount = Double.parseDouble(amountEntered);

        try {
            BigDecimal result = Currency.convertCurrency(amount, currencyOne, currencyTwo);
            resultLabel.setText(result + " " + currencyTwo);

            History history = new History(currencyOne, currencyTwo, amount, result, LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")), LocalDate.now());
            historyList.add(history);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<History> getHistoryList() {
        return historyList;
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        final Image icon = new Image(Objects.requireNonNull(MainApplication.class.getResourceAsStream("images/icon-moneda.png")));
        Stage dialogStage = (Stage) alert.getDialogPane().getScene().getWindow();
        dialogStage.getIcons().add(icon);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
