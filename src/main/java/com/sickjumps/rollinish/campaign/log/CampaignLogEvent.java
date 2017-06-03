package com.sickjumps.rollinish.campaign.log;

import java.util.EventObject;

/**
 *
 * @author Nathan
 */

public class CampaignLogEvent extends EventObject {

    private final String message;
    
    public CampaignLogEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
