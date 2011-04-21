package com.customfit.ctg.view.users;

import com.customfit.ctg.controller.*;
import com.customfit.ctg.model.*;
import com.customfit.ctg.view.SubPanel;
import java.util.*;
import javax.swing.*;

/**
 * Presents the guest with a login screen.
 * 
 * @author David
 */
public class LoginPanel extends SubPanel {

    /** Creates new form LoginPanel */
    public LoginPanel() {
        initComponents();

        jListUser.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {  };
            public int getSize() { return 0; }
            public Object getElementAt(int i) { return strings[i]; }
        });

        //get list model
        AbstractListModel listModel = (AbstractListModel)jListUser.getModel();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListUser = new javax.swing.JList();
        linkLabelRegister = new com.customfit.ctg.view.LinkLabel();
        jButtonLogin = new javax.swing.JButton();

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 3, 18));
        jLabelTitle.setText("Welcome");

        jLabel2.setText("Please select your user name to login.");

        jListUser.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListUser.setFocusCycleRoot(true);
        jListUser.setName("jListUser"); // NOI18N
        jListUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListUserMouseClicked(evt);
            }
        });
        jListUser.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListUserValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListUser);

        linkLabelRegister.setDisplayedMnemonic('R');
        linkLabelRegister.setText("Register a new user");
        linkLabelRegister.setDisplayedMnemonicIndex(0);
        linkLabelRegister.setFocusCycleRoot(true);
        linkLabelRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkLabelRegisterActionPerformed(evt);
            }
        });

        jButtonLogin.setMnemonic('L');
        jButtonLogin.setText("Login");
        jButtonLogin.setEnabled(false);
        jButtonLogin.setFocusCycleRoot(true);
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(jLabelTitle, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButtonLogin)
                        .addGap(18, 18, 18)
                        .addComponent(linkLabelRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLogin)
                    .addComponent(linkLabelRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void linkLabelRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkLabelRegisterActionPerformed
        //tell UserManagement that to display user registration screen
        UserManagement.registerUser();
    }//GEN-LAST:event_linkLabelRegisterActionPerformed

    private void jListUserValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListUserValueChanged
        //check for selected value
        if (this.jListUser.getSelectedValue() == null)
            //if none then disable login button
            this.jButtonLogin.setEnabled(false);
        //otherwise
        else
            //if valid then enable login button
            this.jButtonLogin.setEnabled(true);
    }//GEN-LAST:event_jListUserValueChanged

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        //grab user name
        String userName = (String)this.jListUser.getSelectedValue();
        //get User back out of data driver
        List<User> users = Application.getDataDriver().selectUsersByName(userName);
        User user = users.get(0);
        //tell UserManagement to complete login process and goto profile home
        UserManagement.finishLogin(user);
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jListUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListUserMouseClicked
        //if double click and there is a selected user
        if (evt.getClickCount() == 2 && this.jListUser.getSelectedValue() != null)
            //then do same as login 
            this.jButtonLoginActionPerformed(null);
    }//GEN-LAST:event_jListUserMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JList jListUser;
    private javax.swing.JScrollPane jScrollPane1;
    private com.customfit.ctg.view.LinkLabel linkLabelRegister;
    // End of variables declaration//GEN-END:variables

    /**
     * Extends SubPanel functionality by returning the title as being the
     * same as on the panel itself.
     * @return The title in the panel.
     */
    @Override
    public String getTitle()
    {
        //grab title from on the panel
        return this.jLabelTitle.getText();
    }
    
    /**
     * Sets list of users to list inside panel.
     * 
     * @param users List of User objects .
     */
    public void setUserList(List<User> users)
    {
        //create list model
        DefaultListModel listModel = new DefaultListModel();

        //insert user names into array
        for (User user : users)
            listModel.addElement(user.getName());
        
        //replace model
        jListUser.setModel(listModel);
        
        //focus on user list
        jListUser.requestFocusInWindow();
    }
}
