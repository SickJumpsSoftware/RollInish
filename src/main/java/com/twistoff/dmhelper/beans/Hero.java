package com.twistoff.dmhelper.beans;

/**
 *
 * @author Nathan
 */

public class Hero extends Participant {

    private String playerName;

    public Hero(String playerName, String characterName) {
        super(characterName);
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
