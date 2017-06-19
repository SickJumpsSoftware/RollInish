package com.sickjumps.rollinish.campaign.log;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nathan
 */

public class Manager {

    private static Manager instance = null;
    
    private final List<EventListener> listeners;
    
    private Manager() {
        this.listeners = new ArrayList<>();
    }
    
    public static Manager instance() {
        if (instance == null) {
            instance = new Manager();
        }
        
        return instance;
    }
    
    public void addTurnLogEventListener(EventListener listener) {
        listeners.add(listener);
    }
    
    public void publish(String message) {
        String formattedMessage = String.format("%s%n", message);
        Event e = new Event(this, formattedMessage);
        
        for (EventListener l : listeners) {
            l.onMessageLogged(e);
        }
    }
}
