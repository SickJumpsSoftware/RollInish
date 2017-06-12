package com.sickjumps.rollinish.campaign;

import com.sickjumps.rollinish.campaign.character.Participant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nathan
 */

public class Encounter implements Serializable {

    private List<Participant> available;
    private List<Participant> active;
    private String encounterName;

    public Encounter(String encounterName) {
        this.encounterName = encounterName;
        this.available = new ArrayList<>();
        this.active = new ArrayList<>();
    }
    
    public void addAvailablePlayer(Participant p) {
        this.available.add(p);
    }

    public List<Participant> getAvailable() {
        return available;
    }

    public void setAvailable(List<Participant> available) {
        this.available = available;
    }

    public void addActivePlayer(Participant p) {
        this.active.add(p);
    }
    
    public List<Participant> getActive() {
        return active;
    }

    public void setActive(List<Participant> active) {
        this.active = active;
    }

    public String getEncounterName() {
        return encounterName;
    }

    public void setEncounterName(String encounterName) {
        this.encounterName = encounterName;
    }
}
