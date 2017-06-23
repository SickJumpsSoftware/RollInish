package com.sickjumps.rollinish.campaign.io;

import com.sickjumps.rollinish.campaign.Campaign;
import com.sickjumps.rollinish.campaign.DefaultCampaign;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Nathan
 */
public class CampaignSerializer {
    
    private final static Logger logger = LoggerFactory.getLogger(CampaignSerializer.class);
    
    public static Campaign load(File file) {
        Campaign c = new DefaultCampaign();
        
        try (FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            c = (Campaign) ois.readObject();
        } catch (IOException ex) {
            logger.error("Unable to load campaign from file", ex);
        } catch (ClassNotFoundException ex) {
            logger.error("Loaded object was not an instance of type Campaign", ex);
        }
        
        return c;
    }
    
    public static void save(Campaign c, File file) {
        try (FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(c);
        } catch (IOException ex) {
            logger.error("Unable to persist Campaign object to disk", ex);
        }
    }
}
