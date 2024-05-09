package com.alura.conversorapp.Controller;

import com.alura.conversorapp.Model.SceneSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class MainViewController {
    @FXML
    private Pane scene1Pane;

    public void onSwitch2Click(ActionEvent actionEvent) throws IOException {
        new SceneSwitch(scene1Pane, "History.fxml");
    }
}
