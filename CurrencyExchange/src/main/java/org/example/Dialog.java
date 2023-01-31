package org.example;

import javafx.scene.control.Alert;
import javafx.stage.Window;

/**
 * Class responsible for displaying the information window.
 * @author Marek Frańczak
 * @since 1.0.0
 */
public class Dialog {

    /**
     * Method responsible for displaying the information window.
     * @param window passes a Window object where the dialog box is displayed.
     * @see Window
     */
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
