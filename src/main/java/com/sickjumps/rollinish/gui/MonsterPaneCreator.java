package com.sickjumps.rollinish.gui;

import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.gui.TableFormat;
import com.sickjumps.rollinish.campaign.character.Monster;
import com.sickjumps.rollinish.gui.table.MonsterTableModel;
import com.sickjumps.rollinish.gui.table.MouseOverAdapter;
import com.sickjumps.rollinish.gui.table.TableFormatGenerator;
import com.sickjumps.rollinish.gui.transfer.ExportTransferHandler;
import java.awt.Dimension;
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
class MonsterPaneCreator {

    static JTabbedPane createMonsterPane(List<Monster> monsterData) {
        Map<String, EventList<Monster>> monstersByCR = new LinkedHashMap<>();
        JTabbedPane monsterPane = new JTabbedPane();

        createMonsterMap(monsterData, monstersByCR);

        createTabbedPane(monstersByCR, monsterPane);

        return monsterPane;
    }

    private static void createTabbedPane(Map<String, EventList<Monster>> monstersByCR, JTabbedPane monsterPane) {
        monstersByCR.keySet().stream().forEach((String cr) -> {
            TableFormat<Monster> format = TableFormatGenerator.getMonsterTableFormat();
            JTable table = new JTable(new MonsterTableModel(monstersByCR.get(cr), format));

            table.setDragEnabled(true);
            table.setTransferHandler(new ExportTransferHandler());

            table.setRowHeight(35);
            table.setIntercellSpacing(new Dimension(10, 15));

            MouseOverAdapter adapter = new MouseOverAdapter(table);
            table.addMouseMotionListener(adapter);
            table.addMouseListener(adapter);

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
}
