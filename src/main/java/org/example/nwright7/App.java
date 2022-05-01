package org.example.nwright7;

import edu.missouriwestern.csc346.monsters.Cook;
import edu.missouriwestern.csc346.monsters.GiantRat;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        String s = "Hello. Prepare to be amazed.";
        //var javaVersion = SystemInfo.javaVersion();
        //var javafxVersion = SystemInfo.javafxVersion();
        Cook cook = new Cook();
        GiantRat ricky = new GiantRat();
        s = cook.toString();

        var label = new Label(s);
        var scene = new Scene(new StackPane(label), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}