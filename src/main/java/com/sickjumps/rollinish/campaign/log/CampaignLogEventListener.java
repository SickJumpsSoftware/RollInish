package com.sickjumps.rollinish.campaign.log;

/**
 *
 * @author Nathan
 */

public interface CampaignLogEventListener {
    public void onMessageLogged(CampaignLogEvent e);
}
