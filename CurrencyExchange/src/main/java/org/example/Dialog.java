package org.example;

import javafx.scene.control.Alert;
import javafx.stage.Window;

public class Dialog {

    public void aboutDialog(Window window){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(window);
        alert.setTitle("O programie");
        alert.setHeaderText(null);
        alert.setContentText("Program do przeliczania walut v.1.0.0. \nInformacje o kursie pobiera ze strony: www.alphavantage.co\n" +
                "autor: Marek Frańczak");
        alert.showAndWait();
    }
}
