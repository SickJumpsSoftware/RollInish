package com.sickjumps.rollinish.campaign;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;


/**
 *
 * @author Nathan
 */

public class Campaign implements Serializable {
    private final ArrayList<Participant> players;
    private final String campaignName;
    
    public Campaign() {
        this("Default Campaign");
    }

    public Campaign(String campaignName) {
        this.campaignName = campaignName;
        players = new ArrayList<>();
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
