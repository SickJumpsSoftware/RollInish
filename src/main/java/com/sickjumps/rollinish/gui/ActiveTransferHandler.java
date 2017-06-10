package com.sickjumps.rollinish.gui;

import com.sickjumps.rollinish.campaign.character.Participant;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;
import javax.activation.ActivationDataFlavor;
import javax.swing.JTable;
import javax.swing.TransferHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Nathan
 */

public class ActiveTransferHandler extends TransferHandler {

    private final DataFlavor localDataFlavor;
    private final static Logger logger = LoggerFactory.getLogger(ActiveTransferHandler.class);
    
    public ActiveTransferHandler() {
        localDataFlavor = new ActivationDataFlavor(Participant.class, DataFlavor.javaJVMLocalObjectMimeType, "Participant object");
    }
    
    @Override
    public boolean canImport(TransferHandler.TransferSupport info) {
        if (!info.isDrop()) return false;
        
        if (!(info.getComponent() instanceof JTable)) return false;
        
        return true;
    }
    
    @Override
    public boolean importData(TransferHandler.TransferSupport info) {
        if (!this.canImport(info)) return false;
        
        try {
            JTable table = (JTable) info.getComponent();
            PlayerTableModel model = (PlayerTableModel) table.getModel();
            
            Transferable t = info.getTransferable();
            List<Participant> players = (List<Participant>)t.getTransferData(localDataFlavor);
            
            players.stream().forEach((p) -> {
                model.addRow(p);
            });
            
            return true;
        } catch (UnsupportedFlavorException ufe) {
            logger.error("Unsupported DataFlavor for drop operation", ufe);
        } catch (IOException ioe) {
            logger.error("Data no longer available in requested flavor", ioe);
        }
        
        return false;
    }
}
