package org.example.nwright7;

import edu.missouriwestern.csc346.monsters.GameManager;
import edu.missouriwestern.csc346.monsters.Player;

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
        App.addToVBox(message);
        return message;
    }
}
