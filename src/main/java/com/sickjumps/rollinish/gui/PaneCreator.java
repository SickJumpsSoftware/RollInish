package com.sickjumps.rollinish.gui;

import com.sickjumps.rollinish.campaign.Encounter;
import com.sickjumps.rollinish.campaign.character.Monster;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.TransferHandler;

/**
 *
 * @author Nathan
 */

class PaneCreator {

    static JTabbedPane createMonsterPane(List<Monster> monsterData) {
        Map<String, List<Monster>> monstersByCR = new LinkedHashMap<>();
        JTabbedPane monsterPane = new JTabbedPane();
        
        createMonsterMap(monsterData, monstersByCR);
        
        createTabbedPane(monstersByCR, monsterPane);
        
        return monsterPane;
    }

    private static void createTabbedPane(Map<String, List<Monster>> monstersByCR, JTabbedPane monsterPane) {
        monstersByCR.keySet().stream().forEach((String cr) -> {
            JTable table = new JTable(new MonsterTableModel(monstersByCR.get(cr)));
            table.setDragEnabled(true);
            table.setTransferHandler(new ActiveTransferHandler());
            monsterPane.addTab(cr, new JScrollPane(table));
        });
    }

    private static void createMonsterMap(List<Monster> monsterData, Map<String, List<Monster>> monstersByCR) {
        monsterData.stream().forEach((Monster m) -> {
            List<Monster> subList = monstersByCR.getOrDefault(m.getChallenge(), new ArrayList<>());
            subList.add(m);
            monstersByCR.put(m.getChallenge(), subList);
        });
    }

    static JTabbedPane createEncounterPane(List<Encounter> encounters) {
        JTabbedPane encounterPane = new JTabbedPane();
        
        encounters.stream().forEach((e) -> {
            JPanel panel = new JPanel();
            JScrollPane leftScrollPane = new JScrollPane();
            JScrollPane rightScrollPane = new JScrollPane();
            
            JTable availableTable = new JTable(new PlayerTableModel(e.getAvailable()));
            JTable activeTable = new JTable(new PlayerTableModel(e.getActive()));
            
            availableTable.setFillsViewportHeight(true);
            activeTable.setFillsViewportHeight(true);
            
            leftScrollPane.setViewportView(availableTable);
            rightScrollPane.setViewportView(activeTable);
            
            availableTable.setTransferHandler(new ActiveTransferHandler());
            activeTable.setTransferHandler(new ActiveTransferHandler());
            
            availableTable.setDragEnabled(true);
            activeTable.setDragEnabled(true);
            
            panel.setLayout(new FlowLayout());
            panel.add(leftScrollPane);
            panel.add(rightScrollPane);
            
            encounterPane.addTab(e.getEncounterName(), panel);
        });
        
        return encounterPane;
    }
}
