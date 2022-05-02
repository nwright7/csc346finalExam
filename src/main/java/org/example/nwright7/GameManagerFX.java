package org.example.nwright7;

import edu.missouriwestern.csc346.monsters.GameManager;

public class GameManagerFX extends GameManager {
    @Override
    public String displayMessage(String message) {
        App.addToVBox(message);
        return message;
    }
}
