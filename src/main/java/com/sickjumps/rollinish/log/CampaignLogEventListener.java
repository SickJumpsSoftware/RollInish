package com.sickjumps.rollinish.log;

/**
 *
 * @author Nathan
 */

public interface CampaignLogEventListener {
    public void onMessageLogged(CampaignLogEvent e);
}
