package com.sickjumps.rollinish.campaign;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.GlazedLists;
import com.sickjumps.rollinish.campaign.character.Participant;
import java.io.Serializable;


/**
 *
 * @author Nathan
 */

public class Campaign implements Serializable {
    private final String campaignName;
    private EventList<Encounter> encounters;
    private EventList<Participant> available;
    
    public Campaign(String campaignName) {
        this.campaignName = campaignName;
        
        this.encounters = GlazedLists.threadSafeList(new BasicEventList<>());
        
        this.available = GlazedLists.threadSafeList(new BasicEventList<>());
    }

    public String getCampaignName() {
        return campaignName;
    }

    public EventList<Encounter> getEncounters() {
        return encounters;
    }
    
    public void setEncounters(EventList<Encounter> encounters) {
        this.encounters = encounters;
    }
    
    public void addEncounter(Encounter e) {
        this.encounters.add(e);
    }

    public void setAvailable(EventList<Participant> available) {
        this.available = available;
    }

    public EventList<Participant> getAvailable() {
        return available;
    }

    public void addAvailablePlayer(Participant p) {
        this.available.add(p);
    }
    
    public void removeAvailablePlayer(Participant p) {
        this.available.remove(p);
    }
}
