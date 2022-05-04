package org.example.nwright7;

import edu.missouriwestern.csc346.monsters.GameManager;
import edu.missouriwestern.csc346.monsters.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class GameManagerFX extends GameManager {

    @Override
    public void fightAnnouncement(Player p1, Player p2) {
        String message = String.format("\n----- %s (%1.0f%%) and %s (%1.0f%%) enter the game -----",
                p1, p1.getBody().getHealth() * 100.0D, p2, p2.getBody().getHealth() * 100.0D);
        //his.displayMessage(message);
        App.fightAnnouncement.setText(message);
    }
    @Override
    public String displayMessage(String message) {
        //App.addToVBox(message);
        //if(message.toLowerCase().contains("maximum rounds remaining")){
        if(message.contains("Maximum remaining rounds")){
            //clear the previous round announcement
            App.roundAnn.getChildren().clear();
            //new Button(message);
            /* The displayRoundStart message in the version of the game I ran displayed a lot more than just the round
             * and remaining rounds, it also displayed the current roster and some "=" as a border in front and behind
             * the text. Rather than edit the function in the game, create a new Monsters.jar and implement it, I just
             * did some simple string manipulation.
             */
            message = message.substring(10, 48);
            TextField roundAnnouncement = new TextField(message);
            //center the round announcement and change it to large text
            roundAnnouncement.setAlignment(Pos.CENTER);
            //this is my approach to changing the font size
            roundAnnouncement.setStyle("-fx-font-size: " + 20.0 + "px;");

            //right now, the round announcement is being added to the rosterBox
            //App.rosterBox.getChildren().add(roundAnnouncement);


            //changing it so that the round announcement is being added to the top of the borderPane
            App.roundAnn.getChildren().add(roundAnnouncement);
        }else{
            App.addToVBox(message);
        }//end of else
        return message;
    }
}
