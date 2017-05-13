package com.sickjumps.rollinish.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


/**
 *
 * @author Nathan
 */

public class Campaign implements Serializable {
    private ArrayList<Participant> players;
    private String campaignName;
    
    public Campaign() {
        this.campaignName = "Default Campaign";
    }

    public Campaign(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getCampaignName() {
        return campaignName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.players);
        hash = 17 * hash + Objects.hashCode(this.campaignName);
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
        final Campaign other = (Campaign) obj;
        if (!Objects.equals(this.campaignName, other.campaignName)) {
            return false;
        }
        if (!Objects.equals(this.players, other.players)) {
            return false;
        }
        return true;
    }
}
