package org.example.nwright7;

import edu.missouriwestern.csc346.monsters.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * JavaFX App which implements homework 6 (the game)
 *
 * @author Nick Wright
 * @since May 2022
 */
public class App extends Application {

    //VBox vBox from video 4
    static VBox centerPane = new VBox();
    //adding a new border pane
    BorderPane borderPane = new BorderPane();
    static VBox rosterBox = new VBox();
    //change this to a setter?
    public static TextField fightAnnouncement = new TextField("No Fights to Announce. Please stand by.");
    //creating another VBox to hold the round announcement
    static VBox roundAnn = new VBox();

    @Override
    public void start(Stage stage) {
        //adding a title
        stage.setTitle("Nick Wright Battle Royale");
        String s = "Hello. Prepare to be amazed.";

        //creating a scroll pane
        //the scroll pane will not show unless there is enough in the pane for it to run out of space
        ScrollPane scrollPane = new ScrollPane(centerPane);
        //setting the scrollPane to the center of the borderPane
        borderPane.setCenter(scrollPane);

        //changing the alignment and the color of the fightAnnouncement
        fightAnnouncement.setAlignment(Pos.CENTER);
        //setting the background color
        fightAnnouncement.setBackground(new Background(new BackgroundFill(Color.SLATEGREY, null, null)));
        //changing the text to white
        fightAnnouncement.setStyle("-fx-text-fill: white;");

        //setting the bottom pane to fightAnnouncement
        borderPane.setBottom(fightAnnouncement);

        //setting the width of the rosterBox
        rosterBox.setMinWidth(250);
        //adding the roster to the right
        borderPane.setRight(rosterBox);

        //adding the round announcement to the top of the borderPane
        borderPane.setTop(roundAnn);


        //you can add stuff after the next three lines of uncommented code, and it will still show in the window
        var scene = new Scene(borderPane, 1024, 768);   //v = width, v1 = height
        //as of right now, the scene is composed of the borderPane which holds the scrollPane which holds the
        //vbox which holds all the labels consisting of each line
        stage.setScene(scene);
        stage.show();
        mainApp();
    }//end of start

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
        //every time the rosterBox gets called, it will clear the previous rosterBox
        rosterBox.getChildren().clear();
        //creating a title for the rosterBox
        TextField title = new TextField("The Roster");
        //setting the alignment of the title
        title.setAlignment(Pos.CENTER);
        //setting the background color
        title.setBackground(new Background(new BackgroundFill(Color.SLATEGREY, null, null)));
        title.setStyle("-fx-text-fill: white;");
        //adding the title to the rosterBox
        rosterBox.getChildren().add(title);

        //loop for adding each player
        for(Player p : roster){
            //addToVBox(p.toString());
            rosterBox.getChildren().add(new TextField(p.toString()));

        }
        blankLine();
    }//end of displayRoster
}