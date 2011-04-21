package com.customfit.ctg.view.users;

import com.customfit.ctg.controllers.*;
import com.customfit.ctg.model.User;
import com.customfit.ctg.view.SubPanel;

/**
 * Presents the user a way to manage account settings.
 * 
 * @author David
 */
public class EditAccountPanel extends SubPanel {

    /**
     * The user currently displayed on the panel.
     */
    private User user;
    
    private SubPanel previousPanel;
    
    /** Creates new form EditAccountPanel */
    public EditAccountPanel(SubPanel previousPanel) {
        initComponents();
        
        //save last panel in view
        this.previousPanel = previousPanel;
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
        jLabel1 = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JTextField();
        jButtonSave = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        linkLabelDelete = new com.customfit.ctg.view.LinkLabel();

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 3, 18));
        jLabelTitle.setText("Edit User Account");

        jLabel2.setText("Please make sure the following information is up to date for your user.");

        jLabel1.setText("Name:");

        jTextFieldUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldUserKeyReleased(evt);
            }
        });

        jButtonSave.setText("Save User");
        jButtonSave.setEnabled(false);
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        linkLabelDelete.setText("I want to delete my user account.");
        linkLabelDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkLabelDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTitle)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(linkLabelDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSave)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancel)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(linkLabelDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonCancel))
                .addContainerGap(157, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldUserKeyReleased
        //if user name is longer than two characters
        if (this.jTextFieldUser.getText().length() > 2)
        {
            //now check and see that the data is dirty
            if (this.jTextFieldUser.getText().equals(this.user.getName()))
                //disable sign up if it isn't
                this.jButtonSave.setEnabled(false);
            else
                //otherwise permit registration
                this.jButtonSave.setEnabled(true);
        }
        //otherwise
        else
            //disable sign up
            this.jButtonSave.setEnabled(false);
}//GEN-LAST:event_jTextFieldUserKeyReleased

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        //keep the previous user name
        String previousUserName = this.user.getName();
        //update the user
        this.user.setName(this.jTextFieldUser.getText());
        //update user and present previous panel
        UserManagement.updateRegistrationAndGoBack(previousUserName, this.user, this.previousPanel);
}//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        //user bailed out, go back to the last panel
        Application.getMainFrame().setPanel(this.previousPanel);
}//GEN-LAST:event_jButtonCancelActionPerformed

    private void linkLabelDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkLabelDeleteActionPerformed
        //tell controller to process delete request
        UserManagement.deleteUser(this.user.getName());
    }//GEN-LAST:event_linkLabelDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JTextField jTextFieldUser;
    private com.customfit.ctg.view.LinkLabel linkLabelDelete;
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
     * Sets the User for which the form will be laid out.
     * @param user 
     */
    public void setUser(User user) {
        //store user in here
        this.user = user;
        //fill out form with current user data
        this.jTextFieldUser.setText(user.getName());
    }
}
