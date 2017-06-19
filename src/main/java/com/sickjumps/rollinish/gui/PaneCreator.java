package com.sickjumps.rollinish.gui;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.gui.TableFormat;
import com.sickjumps.rollinish.gui.table.PlayerTableModel;
import com.sickjumps.rollinish.campaign.Campaign;
import com.sickjumps.rollinish.gui.transfer.ImportTransferHandler;
import com.sickjumps.rollinish.campaign.character.Monster;
import com.sickjumps.rollinish.campaign.character.Participant;
import com.sickjumps.rollinish.gui.table.MonsterTableFormat;
import com.sickjumps.rollinish.gui.table.MonsterTableModel;
import com.sickjumps.rollinish.gui.transfer.ExportTransferHandler;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

/**
 *
 * @author Nathan
 */

class PaneCreator {

    static JTabbedPane createMonsterPane(List<Monster> monsterData) {
        Map<String, EventList<Monster>> monstersByCR = new LinkedHashMap<>();
        JTabbedPane monsterPane = new JTabbedPane();
        
        createMonsterMap(monsterData, monstersByCR);
        
        createTabbedPane(monstersByCR, monsterPane);
        
        return monsterPane;
    }

    private static void createTabbedPane(Map<String, EventList<Monster>> monstersByCR, JTabbedPane monsterPane) {
        monstersByCR.keySet().stream().forEach((String cr) -> {
            JTable table = new JTable(new MonsterTableModel(monstersByCR.get(cr), new MonsterTableFormat()));
            
            table.setDragEnabled(true);
            table.setTransferHandler(new ExportTransferHandler());
            
            monsterPane.addTab(cr, new JScrollPane(table));
        });
    }

    private static void createMonsterMap(List<Monster> monsterData, Map<String, EventList<Monster>> monstersByCR) {
        monsterData.stream().forEach((Monster m) -> {
            EventList<Monster> subList = monstersByCR.getOrDefault(m.getChallenge(), GlazedLists.eventList(new ArrayList<>()));
            subList.add(m);
            monstersByCR.put(m.getChallenge(), subList);
        });
    }

    static JTabbedPane createEncounterTabbedPane(Campaign c) {
        JTabbedPane tabbedPane = new JTabbedPane();
        TableFormat<Participant> format = GlazedLists.tableFormat(Participant.class, 
                                                                  new String[] { "characterName", "playerName", "initiative" },
                                                                  new String[] { "Character Name", "Player Name", "Initiative" }, 
                                                                  new boolean[] { false, false, true });
        
        c.getEncounters().stream().forEach((e) -> {
            EventList<Participant> activePlayers = GlazedLists.eventList(e.getActive());
            JTable activeTable = new JTable(new PlayerTableModel(activePlayers, format));
            JScrollPane scrollPane = new JScrollPane(activeTable);
            
            activeTable.setFillsViewportHeight(true);
            activeTable.setTransferHandler(new ImportTransferHandler());
            activeTable.setDragEnabled(false);
            activeTable.setAutoCreateRowSorter(true);
            activeTable.setName(e.getEncounterName() + "active table");
            
            tabbedPane.addTab(e.getEncounterName(), scrollPane);
        });
        
        return tabbedPane;
    }
}
