package com.sickjumps.rollinish.beans;

/**
 *
 * @author Nathan
 */

public class Participant {
    private String characterName;
    private int initiative;

    public Participant(String characterName) {
        this.characterName = characterName;
        this.initiative = 0;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }
}
