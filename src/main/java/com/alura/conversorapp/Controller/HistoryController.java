package com.alura.conversorapp.Controller;


import com.alura.conversorapp.Model.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class HistoryController {
    @FXML
    private Pane scene2Pane;

    public void onSwitch1Click(ActionEvent actionEvent) throws IOException {
        new SceneSwitch(scene2Pane, "MainView.fxml");
    }
}
