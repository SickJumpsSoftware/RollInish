package com.sickjumps.rollinish.gui.table;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

/**
 *
 * @author Nathan
 */
public class TableMouseEventHandler extends MouseAdapter {

    private final JTable table;

    public TableMouseEventHandler(JTable table) {
        this.table = table;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int row = table.rowAtPoint(e.getPoint());
        if (row > -1) {
            table.clearSelection();
            table.setRowSelectionInterval(row, row);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        int index = table.rowAtPoint(e.getPoint());
        
        if (index == -1) table.clearSelection();
    }
}
