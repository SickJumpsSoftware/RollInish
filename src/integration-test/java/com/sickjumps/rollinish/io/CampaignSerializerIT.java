package com.sickjumps.rollinish.io;

import com.sickjumps.rollinish.campaign.Campaign;
import com.sickjumps.rollinish.io.CampaignSerializer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author Nathan
 */

public class CampaignSerializerIT {
    private final static Logger LOGGER = LoggerFactory.getLogger(CampaignSerializerIT.class);

    @Test
    public void saveWritesObjectToDisk() throws FileNotFoundException, IOException {
        Campaign testCampaign = new Campaign("Test name");
        CampaignSerializer test = new CampaignSerializer();
        
        String filename = "test-write.campaign";
        
        LOGGER.trace("create file output stream");
        File testFile;
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            LOGGER.trace("test save function");
            test.save(testCampaign, fos);
            
            LOGGER.trace("get file handle");
            testFile = new File(filename);
            
            LOGGER.trace("assert file exists");
            assertTrue(testFile.exists());
        }
        
        LOGGER.trace("delete file");
        Files.delete(testFile.toPath());
        
        
    }
    
    @Test
    public void loadReadsObjectFromDisk() throws FileNotFoundException, IOException, ClassNotFoundException {
        LOGGER.trace("create test objects");
        Campaign testCampaign = new Campaign("test");
        CampaignSerializer test = new CampaignSerializer();
        
        LOGGER.trace("write test campaign to disk");
        String filename = "test-read.campaign";
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            test.save(testCampaign, fos);
        }
        
        LOGGER.trace("read test campaign from disk");
        Campaign result;
        
        try (FileInputStream fis = new FileInputStream(filename)) {
            result = test.load(fis);
        }
        
        LOGGER.trace("assert objects are equal");
        assertTrue(testCampaign.equals(result));
        
        LOGGER.trace("clean up test");
        File testFile = new File(filename);
        Files.delete(testFile.toPath());
    }
    
    @Test
    public void testLocalDateTimeFormattingWithStringFormat() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh.mm.ss a");
        String filename = String.format("%s - %s.campaign", "test", formatter.format(now));
        System.out.println(filename);
    }
}
