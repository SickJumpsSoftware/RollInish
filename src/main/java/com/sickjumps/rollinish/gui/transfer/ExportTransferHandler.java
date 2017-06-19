package com.sickjumps.rollinish.gui.transfer;

import com.sickjumps.rollinish.campaign.character.Participant;
import com.sickjumps.rollinish.gui.table.MonsterTableModel;
import com.sickjumps.rollinish.gui.table.PlayerTableModel;
import com.sickjumps.rollinish.gui.table.RowObjectTableModel;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import javax.activation.ActivationDataFlavor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.TransferHandler;
import javax.swing.table.TableModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Nathan
 */

public class ExportTransferHandler extends TransferHandler {

    private final static Logger logger = LoggerFactory.getLogger(ExportTransferHandler.class);
    private final DataFlavor localDataFlavor;
    
    public ExportTransferHandler() {
        localDataFlavor = new ActivationDataFlavor(Participant.class, DataFlavor.javaJVMLocalObjectMimeType, "Participant");
    }
    
    @Override
    public int getSourceActions(JComponent c) {
        return COPY;
    }
    
    @Override
    protected Transferable createTransferable(JComponent c) {
        JTable source = (JTable) c;
        
        TableModel model = source.getModel();
        
        return ((RowObjectTableModel<Participant>) model).getRow(source.getSelectedRow());
    }
}
