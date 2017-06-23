/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sickjumps.rollinish.campaign.designer;

import com.sickjumps.rollinish.ApplicationConfiguration;
import com.sickjumps.rollinish.campaign.Campaign;
import com.sickjumps.rollinish.campaign.DefaultCampaign;
import com.sickjumps.rollinish.campaign.character.Participant;
import com.sickjumps.rollinish.campaign.io.CampaignSerializer;
import com.sickjumps.rollinish.gui.AddNewPlayerDialog;
import com.sickjumps.rollinish.gui.table.PlayerTableModel;
import com.sickjumps.rollinish.gui.table.RowObjectTableModel;
import com.sickjumps.rollinish.gui.table.TableFormatGenerator;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

/**
 *
 * @author Nathan
 */
public class CampaignDesigner extends javax.swing.JDialog {
    
    private Campaign campaign;
    private final ApplicationConfiguration config;

    /**
     * Creates new form CampaignDesigner
     */
    public CampaignDesigner(ApplicationConfiguration config) {
        super((Frame) null, true);
        this.campaign = new DefaultCampaign();
        this.config = config;
        
        initComponents();
    }
    
    public Campaign getResult() {
        this.setVisible(true);
        
        return this.campaign;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new JLabel();
        txtCampaignName = new JTextField();
        btnAdd = new JButton();
        btnRemove = new JButton();
        jScrollPane1 = new JScrollPane();
        tblPlayers = new JTable(new PlayerTableModel(campaign.getAvailable(), TableFormatGenerator.getPlayerTableFormat()));
        btnCancel = new JButton();
        btnSave = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Campaign Name");

        btnAdd.setText("Add Player");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove Player");
        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        tblPlayers.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(tblPlayers);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setText("Save and Play");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCampaignName))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCampaignName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Participant p = new AddNewPlayerDialog(null, true).getResult();
        
        this.campaign.addAvailablePlayer(p);
    }//GEN-LAST:event_btnAddActionPerformed
    
    private void btnRemoveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int index = tblPlayers.getSelectedRow();
        
        if (index == -1) {
            return;
        }
        
        RowObjectTableModel<Participant> model = (RowObjectTableModel<Participant>) tblPlayers.getModel();
        
        this.campaign.removeAvailablePlayer(model.getRow(index));
    }//GEN-LAST:event_btnRemoveActionPerformed
    
    private void btnCancelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed
    
    private void btnSaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        this.campaign.setCampaignName(txtCampaignName.getText());
        
        String saveDirectory = config.getLastCampaignSaveDirectory();
        if (saveDirectory.isEmpty()) {
            saveDirectory = config.getDefaultCampaignSaveDirectory();
        }
        
        final JFileChooser jfc = new JFileChooser();
        jfc.setCurrentDirectory(new File(saveDirectory));
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        int result = jfc.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File f = jfc.getSelectedFile();
            CampaignSerializer.save(campaign, f);
        }
        
        this.setVisible(false);
    }//GEN-LAST:event_btnSaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnAdd;
    private JButton btnCancel;
    private JButton btnRemove;
    private JButton btnSave;
    private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JTable tblPlayers;
    private JTextField txtCampaignName;
    // End of variables declaration//GEN-END:variables
}
