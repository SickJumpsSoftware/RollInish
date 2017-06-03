package com.sickjumps.rollinish.campaign.log;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nathan
 */

public class CampaignLogManager {

    private static CampaignLogManager instance = null;
    
    private final List<CampaignLogEventListener> listeners;
    
    private CampaignLogManager() {
        this.listeners = new ArrayList<>();
    }
    
    public static CampaignLogManager instance() {
        if (instance == null) {
            instance = new CampaignLogManager();
        }
        
        return instance;
    }
    
    public void addTurnLogEventListener(CampaignLogEventListener listener) {
        listeners.add(listener);
    }
    
    public void publish(String message) {
        String formattedMessage = String.format("%s%n", message);
        CampaignLogEvent e = new CampaignLogEvent(this, formattedMessage);
        
        for (CampaignLogEventListener l : listeners) {
            l.onMessageLogged(e);
        }
    }
}
