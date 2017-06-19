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

    private List<Participant> active;
    private String encounterName;

    public Encounter(String encounterName) {
        this.encounterName = encounterName;
        this.active = new ArrayList<>();
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
