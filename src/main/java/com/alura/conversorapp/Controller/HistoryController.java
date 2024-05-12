package com.alura.conversorapp.Controller;


import com.alura.conversorapp.Model.History;
import com.alura.conversorapp.Model.SceneSwitch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.List;

public class HistoryController {
    public TableColumn<History, String> colFecha;
    public TableColumn<History, String> colHora;
    public TableColumn<History, String> colMonedaOrigen;
    public TableColumn<History, String> colMonedaDestino;
    public TableColumn<History, String> colMonto;
    public TableColumn<History, String> colConvertido;
    public TableView<History> tablaHistorial;
    @FXML
    private Pane scene2Pane;

    public void initialize() {
        List<History> historyList = MainViewController.getHistoryList();
        // Configurar las celdas de la tabla para mostrar los historiales
        colFecha.setCellValueFactory(new PropertyValueFactory<>("date"));
        colHora.setCellValueFactory(new PropertyValueFactory<>("time"));
        colMonedaOrigen.setCellValueFactory(new PropertyValueFactory<>("currencyFrom"));
        colMonedaDestino.setCellValueFactory(new PropertyValueFactory<>("currencyTo"));
        colMonto.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colConvertido.setCellValueFactory(new PropertyValueFactory<>("result"));

        // Configurar la tabla con la lista de historias
        ObservableList<History> observableList = FXCollections.observableArrayList(historyList);
        tablaHistorial.setItems(observableList);
    }

    public void onSwitch1Click() throws IOException {
        new SceneSwitch(scene2Pane, "View/MainView.fxml");
    }

}
