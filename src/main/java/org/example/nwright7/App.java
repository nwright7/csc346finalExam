package org.example.nwright7;

import edu.missouriwestern.csc346.monsters.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * JavaFX App
 */
public class App extends Application {

    //VBox vBox from video 4
    static VBox centerPane = new VBox();

    @Override
    public void start(Stage stage) {

        String s = "Hello. Prepare to be amazed.";
        //var javaVersion = SystemInfo.javaVersion();
        //var javafxVersion = SystemInfo.javafxVersion();
        //Cook cook = new Cook();
        //GiantRat ricky = new GiantRat();
        //s = cook.toString();

        //centerPane.getChildren().add(new Button("Hello."));
        //var label = new Label(s);
        //centerPane.getChildren().add(label);
        //centerPane.getChildren().add(new TextField("some text"));
        //addToVBox("Added with addToVBox Method");

        //String [] words = cook.toString().split("\\s+");
        //addToVBox(words);
        //addToVBox(words);
        //addToVBox(words);




        //creating a scroll pane
        //the scroll pane will not show unless there is enough in the pane for it to run out of space
        ScrollPane scrollPane = new ScrollPane(centerPane);
        //you can add stuff after the next three lines, and it will still show in the window
        var scene = new Scene(scrollPane, 1024, 768);   //v = width, v1 = height
        stage.setScene(scene);
        stage.show();
        mainApp();
    }

    public static void main(String[] args) {
        launch();
    }


    //method for single messages
    public static void addToVBox(String message){
        centerPane.getChildren().add(new Label(message));
    }//end of addToVBox
    //method for an array of messages
    public static void addToVBox(String[] messages){
        for(int i = 0; i < messages.length; i++){
            addToVBox(messages[i]);
        }
    }//end of addToVBox
    //method for an arrayList of messages
    public static void addToVBox(ArrayList<String> messages){
        for(String s : messages){
            addToVBox(s);
        }
    }//end of addToVBox

    public static void mainApp(){
//        //creating players
//        //creating cooks
//        Player cook1 = new Player ("Ptomain Tony", new Cook());
//        Player cook2 = new Player("Broccoli Spears", new Cook());
//        //creating rats
//        Player rat1 = new Player("Ricky", new GiantRat());
//        Player rat2 = new Player("Randy", new GiantRat());
//        //creating slimes
//        Player slime1 = new Player("Peter", new Slime());
//        Player slime2 = new Player("Paul", new Slime());
//        //creating hydras
//        Player hydra1 = new Player("Draco", new Hydra());
//        Player hydra2 = new Player("Seviper", new Hydra());
//        //creating wyverns
//        Player wyvern1 = new Player("Azure", new Wyvern());
//        Player wyvern2 = new Player("Cerulean", new Wyvern());
//
//        //adding all players to roster
//        ArrayList<Player> roster = new ArrayList<>();
//        roster.add(cook1);
//        roster.add(cook2);
//        roster.add(rat1);
//        roster.add(rat2);
//        roster.add(slime1);
//        roster.add(slime2);
//        roster.add(hydra1);
//        roster.add(hydra2);
//        roster.add(wyvern1);
//        roster.add(wyvern2);


        ArrayList<Player> roster = new ArrayList<>();
        //creating players and adding them to the roster
        //creating cooks
        roster.add(new Player ("Ptomain Tony", new Cook()));
        roster.add(new Player("Broccoli Spears", new Cook()));
        //creating rats
        roster.add(new Player("Ricky", new GiantRat()));
        roster.add(new Player("Randy", new GiantRat()));
        //creating slimes
        roster.add(new Player("Peter", new Slime()));
        roster.add(new Player("Paul", new Slime()));
        //creating hydras
        roster.add(new Player("Draco", new Hydra()));
        roster.add(new Player("Seviper", new Hydra()));
        //creating wyverns
        roster.add(new Player("Azure", new Wyvern()));
        roster.add(new Player("Cerulean", new Wyvern()));

        displayRoster(roster);
        GameManagerFX gm = new GameManagerFX();
        gm.contest(roster);


        //display roster
        displayRoster(roster);
    }//end of mainApp

    public static void blankLine(){addToVBox(" ");}//end of blankLine
    private static void displayRoster(ArrayList<Player> roster){
        blankLine();
        addToVBox("====== The Roster ======");
        for(Player p : roster){
            addToVBox(p.toString());
        }
        blankLine();
    }//end of displayRoster
}