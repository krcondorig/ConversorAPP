module com.alura.conversorapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.alura.conversorapp to javafx.fxml;
    exports com.alura.conversorapp;
    exports com.alura.conversorapp.Controller;
    exports com.alura.conversorapp.Model;
    opens com.alura.conversorapp.Controller to javafx.fxml;
}