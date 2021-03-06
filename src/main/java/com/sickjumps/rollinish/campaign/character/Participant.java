package com.sickjumps.rollinish.campaign.character;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Nathan
 */
public class Participant implements Serializable, Transferable {

    private String characterName;
    private String playerName;
    private int dexMod;
    private int initiative;
    private int hp;

    public Participant(String characterName, String playerName, int dexMod) {
        this(characterName, playerName, dexMod, 0);
    }
    
    public Participant(String characterName, String playerName, int dexMod, int hp) {
        this.characterName = characterName;
        this.playerName = playerName;
        this.dexMod = dexMod;
        this.hp = hp;
        this.initiative = 0;
    }
    
    public Participant(Participant copy) {
        this(copy.characterName, copy.playerName, copy.dexMod, copy.hp);
        this.initiative = copy.initiative;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
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

    public int getDexMod() {
        return dexMod;
    }

    public void setDexMod(int dexMod) {
        this.dexMod = dexMod;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.characterName);
        hash = 79 * hash + Objects.hashCode(this.playerName);
        hash = 79 * hash + this.dexMod;
        hash = 79 * hash + this.initiative;
        hash = 79 * hash + this.hp;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Participant other = (Participant) obj;
        if (this.dexMod != other.dexMod) {
            return false;
        }
        if (this.initiative != other.initiative) {
            return false;
        }
        if (this.hp != other.hp) {
            return false;
        }
        if (!Objects.equals(this.characterName, other.characterName)) {
            return false;
        }
        if (!Objects.equals(this.playerName, other.playerName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Participant{" + "characterName=" + characterName + ", playerName=" + playerName + ", dexMod=" + dexMod + ", hp=" + hp + ", initiative=" + initiative + '}';
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{new DataFlavor(Participant.class, "Participant")};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return true;
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        return this;
    }
}
