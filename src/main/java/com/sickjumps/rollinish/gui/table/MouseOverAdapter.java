package com.sickjumps.rollinish.gui.table;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

/**
 *
 * @author Nathan
 */
public class MouseOverAdapter extends MouseAdapter {

    private final JTable table;

    public MouseOverAdapter(JTable table) {
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
    public void mouseExited(MouseEvent e) {
        table.clearSelection();
    }
}
