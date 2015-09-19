/*
    QueryConnector - Attach a query to a Calc document
    Copyright (C) 2013 Enrico Giuseppe Messina

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package com.meserico.queryconnector;

import java.io.File;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;

/**
 *
 * @author Enrico Messina
 */
public class ODBCSelectorDialog extends JExtDialog {

    private static final String ODBC_FILE_DIR = "ODBC_FILE_DIR";
    
    private boolean approved;
    
    /**
     * Creates new form ODBCSelector
     */
    public ODBCSelectorDialog(java.awt.Dialog parent) {
        super(parent, true);
        initComponents();
        this.setSize(445, 300);
        this.setLocationRelativeTo(parent);
        this.approved = false;
        this.loadData();
    }
    
    private void loadData(){
        Preferences pref = Preferences.userNodeForPackage(this.getClass());
        String prefOdbcFile = pref.get(ODBC_FILE_DIR, null);
        if(prefOdbcFile == null)
            prefOdbcFile = System.getProperty("user.home");
        this.odbcFileDir.setText(prefOdbcFile);
        this.dsnFileList.loadDir(new File(prefOdbcFile), ".+(\\.dsn){1}");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainContainer = new javax.swing.JPanel();
        tabs = new javax.swing.JTabbedPane();
        userDSNPanel = new javax.swing.JPanel();
        userDSNScrollPane = new javax.swing.JScrollPane();
        userDSN = new com.meserico.queryconnector.ODBCList();
        systemDSNPanel = new javax.swing.JPanel();
        systemDSNScrollPane = new javax.swing.JScrollPane();
        systemDSN = new com.meserico.queryconnector.ODBCList();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dsnFileList = new com.meserico.queryconnector.DirList();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        odbcFileDir = new javax.swing.JTextField();
        changeODBCDir = new javax.swing.JButton();
        buttonPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        okButton = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        selectDSNLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/meserico/queryconnector/languages"); // NOI18N
        setTitle(bundle.getString("ODBC_SETTINGS")); // NOI18N
        setResizable(false);
        setUndecorated(true);

        mainContainer.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainContainer.setLayout(new java.awt.BorderLayout());

        tabs.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabsStateChanged(evt);
            }
        });

        userDSNPanel.setLayout(new java.awt.BorderLayout(20, 20));

        userDSNScrollPane.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10), javax.swing.BorderFactory.createEtchedBorder()));

        userDSN.setType(com.meserico.queryconnector.ODBCList.Type.User);
        userDSN.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                userDSNValueChanged(evt);
            }
        });
        userDSNScrollPane.setViewportView(userDSN);

        userDSNPanel.add(userDSNScrollPane, java.awt.BorderLayout.CENTER);

        tabs.addTab(bundle.getString("USER_DSN"), userDSNPanel); // NOI18N

        systemDSNPanel.setLayout(new java.awt.BorderLayout());

        systemDSNScrollPane.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10), javax.swing.BorderFactory.createEtchedBorder()));

        systemDSN.setType(com.meserico.queryconnector.ODBCList.Type.System);
        systemDSN.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                systemDSNValueChanged(evt);
            }
        });
        systemDSNScrollPane.setViewportView(systemDSN);

        systemDSNPanel.add(systemDSNScrollPane, java.awt.BorderLayout.CENTER);

        tabs.addTab(bundle.getString("SYSTEM_DSN"), systemDSNPanel); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jPanel3.setLayout(new java.awt.BorderLayout(0, 10));

        dsnFileList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                dsnFileListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(dsnFileList);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new java.awt.BorderLayout(8, 0));

        jLabel1.setText(bundle.getString("DSN_FILES_DIR")); // NOI18N
        jPanel4.add(jLabel1, java.awt.BorderLayout.WEST);

        odbcFileDir.setEnabled(false);
        jPanel4.add(odbcFileDir, java.awt.BorderLayout.CENTER);

        changeODBCDir.setText(bundle.getString("CHANGE_BUTTON")); // NOI18N
        changeODBCDir.setPreferredSize(new java.awt.Dimension(100, 25));
        changeODBCDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeODBCDirActionPerformed(evt);
            }
        });
        jPanel4.add(changeODBCDir, java.awt.BorderLayout.EAST);

        jPanel3.add(jPanel4, java.awt.BorderLayout.NORTH);

        tabs.addTab(bundle.getString("DSN_FILE_LABEL"), jPanel3); // NOI18N

        mainContainer.add(tabs, java.awt.BorderLayout.CENTER);

        buttonPanel.setPreferredSize(new java.awt.Dimension(580, 40));
        buttonPanel.setLayout(new java.awt.GridLayout(1, 2));

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        cancelButton.setText(bundle.getString("CANCEL_BUTTON")); // NOI18N
        cancelButton.setPreferredSize(new java.awt.Dimension(120, 25));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelButton);

        buttonPanel.add(jPanel1);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 5));

        okButton.setText(bundle.getString("OK_BUTTON")); // NOI18N
        okButton.setPreferredSize(new java.awt.Dimension(120, 25));
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });
        jPanel2.add(okButton);

        buttonPanel.add(jPanel2);

        mainContainer.add(buttonPanel, java.awt.BorderLayout.SOUTH);

        header.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        header.setPreferredSize(new java.awt.Dimension(436, 25));
        header.setLayout(new java.awt.BorderLayout());

        jLabel2.setText(bundle.getString("SELECTED_DSN_LABEL")); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 6, 1, 1));
        header.add(jLabel2, java.awt.BorderLayout.WEST);

        selectDSNLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        selectDSNLabel.setText(bundle.getString("NOTHING_SELECTED")); // NOI18N
        header.add(selectDSNLabel, java.awt.BorderLayout.CENTER);

        mainContainer.add(header, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(mainContainer, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void changeODBCDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeODBCDirActionPerformed
        this.changeODBCFileDir();
    }//GEN-LAST:event_changeODBCDirActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        this.approved = true;
        this.dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void userDSNValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_userDSNValueChanged
        if(this.userDSN.getSelectedIndex() != -1)
            this.selectDSNLabel.setText(tr("SELECTED_USER_DSN", this.userDSN.getSelectedValue().toString()));
        else this.selectDSNLabel.setText(tr("NOTHING_SELECTED"));
    }//GEN-LAST:event_userDSNValueChanged

    private void systemDSNValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_systemDSNValueChanged
        if(this.systemDSN.getSelectedIndex() != -1)
            this.selectDSNLabel.setText(tr("SELECTED_SYSTEM_DSN",this.systemDSN.getSelectedValue().toString()));
        else this.selectDSNLabel.setText(tr("NOTHING_SELECTED"));
    }//GEN-LAST:event_systemDSNValueChanged

    private void dsnFileListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_dsnFileListValueChanged
        if(this.dsnFileList.getSelectedIndex() != -1)
            this.selectDSNLabel.setText(tr("SELECTED_DSN_FILE",this.dsnFileList.getSelectedValue().toString()));
        else this.selectDSNLabel.setText(tr("NOTHING_SELECTED"));
    }//GEN-LAST:event_dsnFileListValueChanged

    private void tabsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabsStateChanged
        int idx = tabs.getSelectedIndex();
        if(idx == 0)
            this.userDSNValueChanged(null);
        else if(idx == 1)
            this.systemDSNValueChanged(null);
        else if(idx == 2)
            this.dsnFileListValueChanged(null);
    }//GEN-LAST:event_tabsStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton changeODBCDir;
    private com.meserico.queryconnector.DirList dsnFileList;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainContainer;
    private javax.swing.JTextField odbcFileDir;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel selectDSNLabel;
    private com.meserico.queryconnector.ODBCList systemDSN;
    private javax.swing.JPanel systemDSNPanel;
    private javax.swing.JScrollPane systemDSNScrollPane;
    private javax.swing.JTabbedPane tabs;
    private com.meserico.queryconnector.ODBCList userDSN;
    private javax.swing.JPanel userDSNPanel;
    private javax.swing.JScrollPane userDSNScrollPane;
    // End of variables declaration//GEN-END:variables

    public ODBCSource getSelectedDSN(){
        int tabIdx = tabs.getSelectedIndex();
        Object selectedSource;
        if(tabIdx == 0)
            selectedSource = userDSN.getSelectedValue();
        else if(tabIdx == 1)
            selectedSource = systemDSN.getSelectedValue();
        else
            selectedSource = dsnFileList.getSelectedFile();
        return new ODBCSource(selectedSource);
    }
    
    public boolean isApproved(){
        return this.approved;
    }
    
    private void changeODBCFileDir(){
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle(tr("SELECT_DSN_FILE_DIR_FILE_CHOOSER_TITLE"));
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            try{
                File file = chooser.getSelectedFile();
                Preferences pref = Preferences.userNodeForPackage(this.getClass());
                pref.put(ODBC_FILE_DIR, file.getAbsolutePath());
                pref.flush();   
                this.loadData();
            }catch(Exception ex){
                throw new RuntimeException(ex);
            }
        }
    }
}