package com.sickjumps.rollinish.campaign;

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
    
    public Campaign(String campaignName) {
        this.campaignName = campaignName;
        this.encounters = new ArrayList<>();
    }

    public String getCampaignName() {
        return campaignName;
    }

    public List<Encounter> getEncounters() {
        return encounters;
    }
}
