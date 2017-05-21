package com.sickjumps.rollinish.io;

import com.sickjumps.rollinish.campaign.Campaign;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mechanism for saving and loading .campaign files
 * @author Nathan
 */

public class CampaignSerializer {

    private final static Logger LOGGER = LoggerFactory.getLogger(CampaignSerializer.class);
    
    /**
     * Writes a campaign to an OutputStream.
     * 
     * @param campaign The campaign to be saved
     * @param os The stream to use to save the file
     */
    public void save(Campaign campaign, OutputStream os) {
        try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(campaign);
        } catch (IOException ioe) {
            LOGGER.error("Error saving campaign", ioe);
        }
    }
    
    /**
     * Reads a Campaign from an InputStream.
     * 
     * @param is The InputStream to read from
     * @return The loaded Campaign, or a default Campaign on error
     */
    public Campaign load(InputStream is) {
        Campaign c = new Campaign();
        
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            c = (Campaign) ois.readObject();
        } catch (ClassNotFoundException fnfe) {
            LOGGER.error("Unable to create Campaign object", fnfe);
        } catch (IOException ioe) {
            LOGGER.error("Unable to read campaign from stream", ioe);
        }
        
        return c;
    }
}
