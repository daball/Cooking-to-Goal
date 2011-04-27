/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EditMealPanel.java
 *
 * Created on Apr 26, 2011, 3:23:26 PM
 */

package com.customfit.ctg.view.meal;

import com.customfit.ctg.controller.*;
import com.customfit.ctg.model.*;
import com.customfit.ctg.view.*;

/**
 *
 * @author David
 */
public class EditMealPanel extends CreateEditPanel {

    private CreateEditMode createEditMode = CreateEditMode.EDIT;
    
    private Meal meal;
    
    /** Creates new form EditMealPanel */
    public EditMealPanel(CreateEditMode createEditMode) {
        initComponents();
        
        //customize form for edit mode
        this.setCreateEditMode(createEditMode);
        if (this.getCreateEditMode() == CreateEditMode.CREATE)
            this.jLabelTitle.setText("Create a Meal Plan");
        else if (this.getCreateEditMode() == CreateEditMode.EDIT)
            this.jLabelTitle.setText("Edit Meal Plan");
        
        //setup the me-menu in the right-top corner
        jComboBoxMeMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"User: " + UserManagement.getCurrentUser().getName(), "Profile Home", "Edit Profile", "Logout" }));
        
        //setup pre-canned meal names
        this.jXComboBoxMeal.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
            //meals
            "Breakfast", "Lunch", "Dinner",
            //snacks
            "Morning Snack", "Afternoon Snack", "Evening Snack",
            "Late Night Snack"
            //and whatever other canned meals you can imagine
            //the user can specify their own meal name anyways
        }));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePickerAddon1 = new org.jdesktop.swingx.plaf.DatePickerAddon();
        jLabelTitle = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jComboBoxMeMenu = new javax.swing.JComboBox();
        jXDatePickerDate = new org.jdesktop.swingx.JXDatePicker();
        jXComboBoxMeal = new org.jdesktop.swingx.JXComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonOK = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 3, 18));
        jLabelTitle.setText("Edit Meal");

        jScrollPane2.setBorder(null);

        jTextPane1.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jTextPane1.setBorder(null);
        jTextPane1.setEditable(false);
        jTextPane1.setText("For what event do you want to plan this meal?");
        jTextPane1.setFocusable(false);
        jTextPane1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jTextPane1.setOpaque(false);
        jTextPane1.setVerifyInputWhenFocusTarget(false);
        jScrollPane2.setViewportView(jTextPane1);

        jComboBoxMeMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Me Menu", "Edit User", "Logout" }));
        jComboBoxMeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMeMenuActionPerformed(evt);
            }
        });

        jXComboBoxMeal.setEditable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Date:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Meal:");

        jButtonOK.setText("OK");
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jComboBoxMeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jXComboBoxMeal, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jXDatePickerDate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitle)
                    .addComponent(jComboBoxMeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jXDatePickerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jXComboBoxMeal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOK)
                    .addComponent(jButtonCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxMeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMeMenuActionPerformed
        // process me menu
        
        //if user hit Profile Home
        if (((String)this.jComboBoxMeMenu.getSelectedItem()).equals("Profile Home"))
            //then tell the controller about it
            UserManagement.viewHome();
        //if user hit Edit User
        else if (((String)this.jComboBoxMeMenu.getSelectedItem()).equals("Edit Profile"))
            //then tell the controller about it
            UserManagement.editRegistration(UserManagement.getCurrentUser());
        //if user hit Logout
        else if (((String)this.jComboBoxMeMenu.getSelectedItem()).equals("Logout"))
            //ask controller for logout
            UserManagement.logout();
        //and no matter what, be sure to reset this combo box back to index 0
        this.jComboBoxMeMenu.setSelectedIndex(0);
}//GEN-LAST:event_jComboBoxMeMenuActionPerformed

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOKActionPerformed
        //tell controller about OK button
        MealPlanner.insertMealPlan(this.getMeal());
    }//GEN-LAST:event_jButtonOKActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        //tell main window to go back
        Application.getMainFrame().goBack();
    }//GEN-LAST:event_jButtonCancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.plaf.DatePickerAddon datePickerAddon1;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JComboBox jComboBoxMeMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private org.jdesktop.swingx.JXComboBox jXComboBoxMeal;
    private org.jdesktop.swingx.JXDatePicker jXDatePickerDate;
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
     * Sets Meal into the panel and updates the GUI to match.
     * 
     * @param meal Meal to load.
     */
    public void setMeal(Meal meal)
    {
        //set all the parameters from meal
        //set name
        this.jXComboBoxMeal.setSelectedItem(meal.getName());
        //set date
        this.jXDatePickerDate.setDate(meal.getDate());
        //save meal for later
        this.meal = meal;
    }
    
    /**
     * Gets a new Meal based on the information in the form.
     * 
     * @returns Meal based on the user input.
     */
    public Meal getMeal()
    {
        //build a Meal object from the old one
        Meal newMeal = new Meal(meal);
        //update the fields
        newMeal.setName((String)this.jXComboBoxMeal.getSelectedItem());
        newMeal.setDate(jXDatePickerDate.getDate());
        //return the new Meal
        return newMeal;
    }
}
