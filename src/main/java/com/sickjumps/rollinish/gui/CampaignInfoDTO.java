package com.sickjumps.rollinish.gui;

import com.sickjumps.rollinish.beans.Campaign;
import java.io.FileOutputStream;

/**
 *
 * @author Nathan
 */

public class CampaignInfoDTO {

    private String campaignName;
    private String saveDirectory;

    public CampaignInfoDTO() {
        campaignName = saveDirectory = "default";
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public void setSaveDirectory(String saveDirectory) {
        this.saveDirectory = saveDirectory;
    }
    
    public String getCampaignName() {
        return campaignName;
    }
    
    public String getSaveDirectory() {
        return this.saveDirectory;
    }
}
