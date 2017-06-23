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

    private String campaignName;
    private EventList<Participant> available;
    private EventList<Participant> active;

    public Campaign(String campaignName) {
        this.campaignName = campaignName;

        this.active = GlazedLists.threadSafeList(new BasicEventList<>());
        this.available = GlazedLists.threadSafeList(new BasicEventList<>());
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getCampaignName() {
        return campaignName;
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

    public EventList<Participant> getActive() {
        return active;
    }

    public void setActive(EventList<Participant> active) {
        this.active = active;
    }

    public void removeActive(Participant p) {
        this.active.remove(p);
    }

    public void removeAllActive() {
        this.active.clear();
    }
}
