package com.twistoff.dmhelper.beans;

import java.util.List;


/**
 *
 * @author Nathan
 */

public class Campaign {
    private List<Participant> players;
    private String campaignName;

    public Campaign(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getCampaignName() {
        return campaignName;
    }
    
}
