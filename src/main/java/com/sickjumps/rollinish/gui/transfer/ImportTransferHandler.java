package com.sickjumps.rollinish.gui.transfer;

import com.sickjumps.rollinish.campaign.Dice;
import com.sickjumps.rollinish.campaign.character.Monster;
import com.sickjumps.rollinish.campaign.character.Participant;
import com.sickjumps.rollinish.gui.table.PlayerTableModel;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import javax.activation.ActivationDataFlavor;
import javax.swing.JTable;
import javax.swing.TransferHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Nathan
 */
public class ImportTransferHandler extends TransferHandler {

    private final DataFlavor localDataFlavor;
    private final static Logger logger = LoggerFactory.getLogger(ImportTransferHandler.class);

    public ImportTransferHandler() {
        localDataFlavor = new ActivationDataFlavor(Participant.class, DataFlavor.javaJVMLocalObjectMimeType, "Participant object");
    }

    @Override
    public boolean canImport(TransferHandler.TransferSupport info) {
        if (!info.isDrop()) {
            return false;
        }

        return info.getComponent() instanceof JTable;
    }

    @Override
    public boolean importData(TransferHandler.TransferSupport info) {
        if (!this.canImport(info)) {
            return false;
        }

        try {
            JTable table = (JTable) info.getComponent();
            PlayerTableModel model = (PlayerTableModel) table.getModel();
            
            Participant toCopy = (Participant) info.getTransferable().getTransferData(localDataFlavor);
            if (toCopy instanceof Monster) {
                toCopy.setInitiative(Dice.rollD20(toCopy.getDexMod()));
            }
            
            model.addRow(new Participant(toCopy));

            return true;
        } catch (UnsupportedFlavorException ufe) {
            logger.error("Unsupported DataFlavor for drop operation", ufe);
        } catch (IOException ioe) {
            logger.error("Data no longer available in requested flavor", ioe);
        }

        return false;
    }
}
