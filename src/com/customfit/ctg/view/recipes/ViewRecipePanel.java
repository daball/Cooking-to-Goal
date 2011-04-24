package com.customfit.ctg.view.recipes;

import com.customfit.ctg.controller.*;

/**
 *
 * @author David
 */
public class ViewRecipePanel extends javax.swing.JPanel {

    /** Creates new form ViewRecipePanel */
    public ViewRecipePanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName3 = new javax.swing.JLabel();
        starVotingPanel = new com.customfit.ctg.view.StarVotingPanel();
        jLabelTitle = new javax.swing.JLabel();
        jComboBoxMeMenu = new javax.swing.JComboBox();

        lblName3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName3.setText("Serves #");

        starVotingPanel.setEditable(false);
        starVotingPanel.setScale(5);

        javax.swing.GroupLayout starVotingPanelLayout = new javax.swing.GroupLayout(starVotingPanel);
        starVotingPanel.setLayout(starVotingPanelLayout);
        starVotingPanelLayout.setHorizontalGroup(
            starVotingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        starVotingPanelLayout.setVerticalGroup(
            starVotingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 3, 18));
        jLabelTitle.setText("Recipe Name");

        jComboBoxMeMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Me Menu", "Edit User", "Logout" }));
        jComboBoxMeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMeMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(starVotingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxMeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblName3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(starVotingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelTitle)
                        .addComponent(jComboBoxMeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblName3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxMeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMeMenuActionPerformed
        // process me menu
        
        //if user hit Edit User
        if (((String)this.jComboBoxMeMenu.getSelectedItem()).equals("Edit User"))
            //then tell the controller about it
            UserManagement.editRegistration(UserManagement.getCurrentUser());
        //if user hit Edit User
        else if (((String)this.jComboBoxMeMenu.getSelectedItem()).equals("Logout"))
            //ask controller for logout
            UserManagement.logout();
        //and no matter what, be sure to reset this combo box back to index 0
        this.jComboBoxMeMenu.setSelectedIndex(0);
}//GEN-LAST:event_jComboBoxMeMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBoxMeMenu;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel lblName3;
    private com.customfit.ctg.view.StarVotingPanel starVotingPanel;
    // End of variables declaration//GEN-END:variables

}
