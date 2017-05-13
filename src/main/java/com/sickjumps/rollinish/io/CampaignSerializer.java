package com.sickjumps.rollinish.io;

import com.sickjumps.rollinish.beans.Campaign;
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

    private final static Logger LOGGER = LoggerFactory.getLogger(CampaignSerializer.class);
    
    public void save(Campaign campaign, FileOutputStream fos) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(campaign);
    }
    
    public Campaign load(FileInputStream fis) {
        Campaign c = new Campaign();
        
        return c;
    }
}
