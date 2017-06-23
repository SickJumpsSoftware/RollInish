package com.sickjumps.rollinish.gui.table;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

/**
 *
 * @author Nathan
 */
public class CellClickHandler extends MouseAdapter {

    private final JTable table;

    public CellClickHandler(JTable table) {
        this.table = table;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Point p = e.getPoint();

        int column = table.columnAtPoint(p);
        int row = table.rowAtPoint(p);

        String columnName = table.getColumnName(column);

        if ((columnName.equalsIgnoreCase("initiative") || columnName.equalsIgnoreCase("dex mod")) && row > -1) {
            table.getCellEditor(row, column).getTableCellEditorComponent(table, "", true, row, column);
        }
    }
}
