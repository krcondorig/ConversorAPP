package com.alura.conversorapp.Model;

import com.alura.conversorapp.Controller.HistoryController;
import com.alura.conversorapp.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;


import java.io.IOException;
import java.util.Objects;

public class SceneSwitch {
    public SceneSwitch(Pane currentPane, String fxmlPath) throws IOException {
        Pane newPane = FXMLLoader.load(Objects.requireNonNull(MainApplication.class.getResource(fxmlPath)));
        currentPane.getChildren().removeAll();
        currentPane.getChildren().setAll(newPane);
    }
}
