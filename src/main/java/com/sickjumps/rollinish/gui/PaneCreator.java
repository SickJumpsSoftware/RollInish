package com.sickjumps.rollinish.gui;

import com.sickjumps.rollinish.campaign.character.Monster;
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

public class PaneCreator {

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
            table.setTransferHandler(new MonsterTransferHandler());
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

}
