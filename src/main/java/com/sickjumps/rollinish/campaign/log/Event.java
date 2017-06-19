package com.sickjumps.rollinish.campaign.log;

import java.util.EventObject;

/**
 *
 * @author Nathan
 */

public class Event extends EventObject {

    private final String message;
    
    public Event(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
