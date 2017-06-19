package com.sickjumps.rollinish.gui.table;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.gui.TableFormat;
import ca.odell.glazedlists.swing.DefaultEventTableModel;
import com.sickjumps.rollinish.campaign.character.Participant;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nathan
 */

public class PlayerTableModel extends DefaultEventTableModel implements RowObjectTableModel<Participant> {
    
    private final List<Participant> players;
    
    public PlayerTableModel(EventList<Participant> players, TableFormat<Participant> tableFormat) {
        super(players, tableFormat);
        this.players = players;
    }

    @Override
    public Participant getRow(int rowIndex) {
        return this.players.get(rowIndex);
    }

    @Override
    public List<Participant> getRows(int... rows) {
        List<Participant> playerList = new ArrayList<>();
        
        for (int row : rows) playerList.add(this.players.get(row));
        
        return playerList;
    }

    @Override
    public void addRow(Participant t) {
        this.players.add(t);
        super.fireTableDataChanged();
    }

    @Override
    public void insertRow(Participant t, int rowIndex) {
        this.players.add(rowIndex, t);
        super.fireTableDataChanged();
    }

    @Override
    public void removeRow(int rowIndex) {
        this.players.remove(rowIndex);
    }

}
