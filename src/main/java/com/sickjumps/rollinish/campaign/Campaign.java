package com.sickjumps.rollinish.campaign;

import com.sickjumps.rollinish.campaign.character.Participant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Nathan
 */

public class Campaign implements Serializable {
    private final String campaignName;
    private final List<Encounter> encounters;
    private List<Participant> available;
    
    public Campaign(String campaignName) {
        this.campaignName = campaignName;
        this.available = new ArrayList<>();
        this.encounters = new ArrayList<>();
    }
    
    public void addListener() {
        
    }

    public String getCampaignName() {
        return campaignName;
    }

    public List<Encounter> getEncounters() {
        return encounters;
    }

    public void setAvailable(List<Participant> available) {
        this.available = available;
    }

    public List<Participant> getAvailable() {
        return available;
    }

    public void addAvailablePlayer(Participant p) {
        this.available.add(p);
    }
}
