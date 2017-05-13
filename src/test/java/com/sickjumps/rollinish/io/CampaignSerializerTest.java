package com.sickjumps.rollinish.io;

import com.sickjumps.rollinish.beans.Campaign;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Nathan
 */

public class CampaignSerializerTest {
    private final static Logger LOGGER = LoggerFactory.getLogger(CampaignSerializerTest.class);

    @Test
    public void saveWritesObjectToDisk() throws FileNotFoundException, IOException {
        Campaign testCampaign = new Campaign("Test name");
        CampaignSerializer test = new CampaignSerializer();
        
        String filename = "test.campaign";
        
        LOGGER.trace("create file output stream");
        FileOutputStream fos = new FileOutputStream(filename);
        
        LOGGER.trace("test save function");
        test.save(testCampaign, fos);
        
        LOGGER.trace("get file handle");
        File testFile = new File(filename);
        
        LOGGER.trace("assert file exists");
        assertTrue(testFile.exists());
        
        LOGGER.trace("close file output stream");
        fos.close();
        
        LOGGER.trace("delete file");
        Files.delete(testFile.toPath());
        
        
    }
    
    @Test
    public void loadReadsObjectFromDisk() throws FileNotFoundException, IOException {
        Campaign testCampaign = new Campaign("test");
        CampaignSerializer test = new CampaignSerializer();
        
        String filename = "test.campaign";
        FileOutputStream fos = new FileOutputStream(filename);
        test.save(testCampaign, fos);
        
        FileInputStream fis = new FileInputStream(filename);
        Campaign result = test.load(fis);
        
        assertTrue(testCampaign.equals(result));
        
        File testFile = new File(filename);
        Files.delete(testFile.toPath());
    }
}
