package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX's application startup class for checking currency value after exchange.
 * The conversion factor is updated when you run the converter.
 * @author Marek Frańczak
 * @since 1.0.0
 * @see Application
 */
public class App extends Application {

    /**
     * Field responsible for creating the scene where the graphic layer of the program will be displayed.
     */
    private static Scene scene;

    /**
     * Method responsible for initializing the graphic layer of the application.
     * @see Application
     * @param stage Providing a scene that will be responsible for displaying the graphic layer.
     * @throws IOException Exception thrown when .fxml file could not be found.
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("mainwindow"), 600, 200);
        stage.setScene(scene);
        stage.setTitle("Oblicz walutę");
        stage.show();
    }

    /**
     *
     * @param fxml The name of .fxml file that contains information about the appearance of the application.
     * @return Loads a hierarchy of objects from an XML document.
     * @throws IOException Exception thrown when .fxml file could not be found.
     * @see Parent
     * @see FXMLLoader
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * Main method in app.
     * @see Application
     */
    public static void main(String[] args) {
        launch();
    }

}