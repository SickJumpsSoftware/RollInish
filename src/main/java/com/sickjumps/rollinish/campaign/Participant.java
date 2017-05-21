package com.sickjumps.rollinish.campaign;

/**
 *
 * @author Nathan
 */

public class Participant {
    private String characterName;
    private String playerName;
    private int initiative;

    public Participant(String characterName, String playerName) {
        this.characterName = characterName;
        this.playerName = playerName;
        this.initiative = 0;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }
}
