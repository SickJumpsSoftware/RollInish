package com.sickjumps.rollinish.gui;

import com.sickjumps.rollinish.campaign.character.Participant;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataHandler;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.TransferHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Nathan
 */

public class MonsterTransferHandler extends TransferHandler {
    
    private final DataFlavor localDataFlavor;
    private final static Logger logger = LoggerFactory.getLogger(MonsterTransferHandler.class);
    
    public MonsterTransferHandler() {
        localDataFlavor = new ActivationDataFlavor(Participant.class, DataFlavor.javaJVMLocalObjectMimeType, "List of Monster objects");
    }

    @Override
    public int getSourceActions(JComponent c) {
        return COPY;
    }
    
    @Override
    protected Transferable createTransferable(JComponent c) {
        JTable source = (JTable) c;
        MonsterTableModel model = (MonsterTableModel) source.getModel();
        
        Participant monster = model.getRow(source.getSelectedRow());
        
        return new DataHandler(monster, localDataFlavor.getMimeType());
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
            
            Participant player = (Participant) info.getTransferable().getTransferData(localDataFlavor);
            
            model.addRow(player);
            
            return true;
        } catch (UnsupportedFlavorException ufe) {
            logger.error("Unsupported DataFlavor for drop operation", ufe);
        } catch (IOException ioe) {
            logger.error("Data no longer available in requested flavor", ioe);
        }
        
        return false;
    }
}
