/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sickjumps.rollinish.gui;

import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.swing.TableComparatorChooser;
import com.sickjumps.rollinish.campaign.Campaign;
import com.sickjumps.rollinish.campaign.character.Monster;
import com.sickjumps.rollinish.campaign.character.Participant;
import com.sickjumps.rollinish.campaign.character.comparator.InitiativeComparator;
import com.sickjumps.rollinish.gui.table.CellClickHandler;
import com.sickjumps.rollinish.gui.table.TableMouseEventHandler;
import com.sickjumps.rollinish.gui.table.PlayerTableModel;
import com.sickjumps.rollinish.gui.table.RowObjectTableModel;
import com.sickjumps.rollinish.gui.table.TableFormatGenerator;
import com.sickjumps.rollinish.gui.transfer.ExportTransferHandler;
import com.sickjumps.rollinish.gui.transfer.ImportTransferHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author Nathan
 */
public final class CampaignViewerFrame extends JFrame {

    private final List<Monster> monsterData;
    private final Campaign campaign;
    private final SortedList<Participant> sortedPlayers;

    /**
     * Creates new form CampaignViewerFrame
     */
    public CampaignViewerFrame(Campaign c, List<Monster> monsterData) {
        this.monsterData = monsterData;
        this.campaign = c;

        initComponents();
        
        this.sortedPlayers = new SortedList<>(campaign.getActive(), new InitiativeComparator());

        configureAvailableTable();
        configureActiveTable();

        this.paneTables.setResizeWeight(0.5d);
        this.paneTables.setEnabled(false);
        this.pack();
    }

    private void configureAvailableTable() {
        tblAvailable.setTransferHandler(new ExportTransferHandler());
        tblAvailable.setDragEnabled(true);

        tblAvailable.setRowHeight(50);
        tblAvailable.setIntercellSpacing(new Dimension(10, 15));

        tblAvailable.setModel(new PlayerTableModel(campaign.getAvailable(),
                TableFormatGenerator.getPlayerTableFormat()));

        TableMouseEventHandler handler = new TableMouseEventHandler(tblAvailable);
        tblAvailable.addMouseMotionListener(handler);
        tblAvailable.addMouseListener(handler);
    }

    private void configureActiveTable() {
        TableComparatorChooser.install(
                tblActive,
                this.sortedPlayers,
                TableComparatorChooser.SINGLE_COLUMN
        );

        tblActive.setModel(
                new PlayerTableModel(
                        this.sortedPlayers,
                        TableFormatGenerator.getActivePlayerTableFormat()));

        tblActive.setTransferHandler(new ImportTransferHandler());
        tblActive.setDragEnabled(false);

        tblActive.setRowHeight(50);
        tblActive.setIntercellSpacing(new Dimension(10, 15));

        TableMouseEventHandler handler = new TableMouseEventHandler(tblActive);
        tblActive.addMouseMotionListener(handler);
        tblActive.addMouseListener(handler);
        tblActive.addMouseListener(new CellClickHandler(tblActive));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        leftButtonPanel = new JPanel();
        btnAddNewPlayer = new JButton();
        btnRemoveAvailable = new JButton();
        rightButtonPanel = new JPanel();
        btnRemoveActive = new JButton();
        btnClearTable = new JButton();
        tabMonsterTable = MonsterPaneCreator.createMonsterPane(monsterData);
        paneTables = new JSplitPane();
        jScrollPane1 = new JScrollPane();
        tblAvailable = new JTable();
        jScrollPane2 = new JScrollPane();
        tblActive = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(Frame.MAXIMIZED_BOTH);

        jPanel1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

        leftButtonPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

        btnAddNewPlayer.setText("Add New Player");
        btnAddNewPlayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAddNewPlayerActionPerformed(evt);
            }
        });

        btnRemoveAvailable.setText("Remove Player");
        btnRemoveAvailable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnRemoveAvailableActionPerformed(evt);
            }
        });

        GroupLayout leftButtonPanelLayout = new GroupLayout(leftButtonPanel);
        leftButtonPanel.setLayout(leftButtonPanelLayout);
        leftButtonPanelLayout.setHorizontalGroup(leftButtonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, leftButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftButtonPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRemoveAvailable, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddNewPlayer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        leftButtonPanelLayout.setVerticalGroup(leftButtonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(leftButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddNewPlayer, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemoveAvailable, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rightButtonPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

        btnRemoveActive.setText("Remove Player");
        btnRemoveActive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnRemoveActiveActionPerformed(evt);
            }
        });

        btnClearTable.setText("Clear Encounter");
        btnClearTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnClearTableActionPerformed(evt);
            }
        });

        GroupLayout rightButtonPanelLayout = new GroupLayout(rightButtonPanel);
        rightButtonPanel.setLayout(rightButtonPanelLayout);
        rightButtonPanelLayout.setHorizontalGroup(rightButtonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(rightButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightButtonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btnRemoveActive, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(btnClearTable, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                .addContainerGap())
        );
        rightButtonPanelLayout.setVerticalGroup(rightButtonPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(rightButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRemoveActive, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearTable, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblAvailable.setModel(new PlayerTableModel(campaign.getAvailable(),
            TableFormatGenerator.getPlayerTableFormat()));
    tblAvailable.setFillsViewportHeight(true);
    jScrollPane1.setViewportView(tblAvailable);

    paneTables.setLeftComponent(jScrollPane1);

    tblActive.setModel(new PlayerTableModel(campaign.getActive(),
        TableFormatGenerator.getActivePlayerTableFormat()));
tblActive.setFillsViewportHeight(true);
jScrollPane2.setViewportView(tblActive);

paneTables.setRightComponent(jScrollPane2);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
jPanel1.setLayout(jPanel1Layout);
jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
    .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(leftButtonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(tabMonsterTable, GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
            .addComponent(paneTables))
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(rightButtonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(leftButtonPanel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rightButtonPanel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                    .addComponent(paneTables, GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(tabMonsterTable, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
    );

        GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewPlayerActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnAddNewPlayerActionPerformed
        Participant p = new AddNewPlayerDialog(this, true).getResult();

        if (p != null) {
            this.campaign.addAvailablePlayer(p);
        }
    }//GEN-LAST:event_btnAddNewPlayerActionPerformed

    private void btnRemoveAvailableActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnRemoveAvailableActionPerformed
        int index = this.tblAvailable.getSelectedRow();

        if (index < 0) {
            return;
        }

        RowObjectTableModel<Participant> model = (RowObjectTableModel<Participant>) this.tblAvailable.getModel();
        Participant p = model.getRow(index);

        this.campaign.removeAvailablePlayer(p);
    }//GEN-LAST:event_btnRemoveAvailableActionPerformed

    private void btnClearTableActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnClearTableActionPerformed
        this.campaign.removeAllActive();
        
        // force repaint as clearing the underlying model does not remove all
        // rows from the view
        this.tblActive.revalidate();
        this.tblActive.repaint();
    }//GEN-LAST:event_btnClearTableActionPerformed

    private void btnRemoveActiveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnRemoveActiveActionPerformed
        int index = this.tblActive.getSelectedRow();

        if (index < 0) {
            return;
        }

        RowObjectTableModel<Participant> model = (RowObjectTableModel<Participant>) this.tblActive.getModel();
        Participant p = model.getRow(index);

        this.campaign.removeActive(p);
    }//GEN-LAST:event_btnRemoveActiveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnAddNewPlayer;
    private JButton btnClearTable;
    private JButton btnRemoveActive;
    private JButton btnRemoveAvailable;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JPanel leftButtonPanel;
    private JSplitPane paneTables;
    private JPanel rightButtonPanel;
    private JTabbedPane tabMonsterTable;
    private JTable tblActive;
    private JTable tblAvailable;
    // End of variables declaration//GEN-END:variables
}
