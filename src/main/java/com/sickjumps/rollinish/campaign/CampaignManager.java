package com.sickjumps.rollinish.campaign;

import com.sickjumps.rollinish.ApplicationConfiguration;
import com.sickjumps.rollinish.io.CampaignSerializer;
import com.sickjumps.rollinish.io.NamingStrategy;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Nathan
 */

public class CampaignManager {
    
    private final static Logger logger = LoggerFactory.getLogger(CampaignManager.class);

    private final ApplicationConfiguration config;
    private final CampaignSerializer cs;
    private final NamingStrategy strategy;
    
    public CampaignManager(ApplicationConfiguration config, CampaignSerializer cs, NamingStrategy strategy) {
        this.config = config;
        this.cs = cs;
        this.strategy = strategy;
    }
    
    public Campaign createNewCampaign() {
        CampaignInfoDTO dto = new NewCampaignDialog(null, true, config).getResult();
        
        updateMostRecentCampaignSettings(dto);
        
        Campaign c = new Campaign(dto.getCampaignName());
        
        Path path = generateFileNameFromDTO(dto);
        
        try (FileOutputStream fos = new FileOutputStream(path.toFile())) {
            cs.save(c, fos);
        } catch (IOException ioe) {
            logger.error("Error saving new campaign", ioe);
        }
        
        return c;
    }   
        
    public Campaign loadExistingCampaign() {
        return new Campaign();
    }
    
    public Campaign loadMostRecentCampaign() {
        return new Campaign();
    }
    
    private void updateMostRecentCampaignSettings(CampaignInfoDTO dto) {
        Path mostRecent = Paths.get(dto.getSaveDirectory());
        
        config.setLastCampaignName(dto.getCampaignName());
        config.setLastCampaignSaveDirectory(mostRecent);
    }
    
    private Path generateFileNameFromDTO(CampaignInfoDTO dto) {
        String directory = dto.getSaveDirectory();
        String name = this.strategy.getName(dto.getCampaignName(), "campaign");
        
        return Paths.get(directory, name).toAbsolutePath();
    }
}
