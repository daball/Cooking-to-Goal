package com.customfit.ctg.view.users;

import com.customfit.ctg.controller.*;
import com.customfit.ctg.model.*;
import com.customfit.ctg.view.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 * Presents the user with his personalized profile home.
 * 
 * @author David
 */
public class HomePanel extends SubPanel {
    
    /**
     * The user currently displayed in the panel.
     */
    private User user;
    
    /**
     * The list of recipes currently displayed in the panel.
     */
    private List<Recipe> recipes;
    
    /** Creates new form HomePanel */
    public HomePanel() {
        initComponents();
        fillPageInfo();
        //setup the me-menu in the right-top corner
        jComboBoxMeMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"User: " + UserManagement.getCurrentUser().getName(), "Profile Home", "Edit Profile", "Logout" }));
    }

    private void fillPageInfo() {
        //String x = "";
        //System.out.println("field: " + x);

        List<Member> allMembers = UserManagement.getCurrentUser().getAllMembers();
        
        StringBuilder userStatusMessage = new StringBuilder();
        userStatusMessage.append("You are currently tracking ");
        userStatusMessage.append(allMembers.size());
        userStatusMessage.append("member");
        if (allMembers.size() != 1) userStatusMessage.append("s");
        userStatusMessage.append(" in addition to yourself. Your menu will scale based the weekly target of you and your other tracked members, which is a ");
        if (UserManagement.getCurrentUser().getOwnMember().getGoalDirection() == GoalDirection.MAXIMUM_GOAL)
            userStatusMessage.append("maximum");
        else if (UserManagement.getCurrentUser().getOwnMember().getGoalDirection() == GoalDirection.MINIMUM_GOAL)
            userStatusMessage.append("minimum");
        userStatusMessage.append(" allowance ");
        userStatusMessage.append(UserManagement.getCurrentUser().getTotalGoal().toString());
        userStatusMessage.append(" of ");
        userStatusMessage.append(UserManagement.getCurrentUser().getOwnMember().getTrackedNutrient());
        userStatusMessage.append(" each day.");
        this.jTextUserSettings.setText(userStatusMessage.toString());
        
        StringBuilder recipeStatusMessage = new StringBuilder();
        recipeStatusMessage.append("You currently have ");
        recipeStatusMessage.append(RecipeManagement.getAllRecipes().size());
        recipeStatusMessage.append(" recipes in your inventory.");
        this.jTextRecipes.setText(recipeStatusMessage.toString());
        
        StringBuilder mealStatusMessage = new StringBuilder();
        mealStatusMessage.append("You currently have ");
        mealStatusMessage.append("____");
        mealStatusMessage.append(" meals planned for the next seven days.");
        this.jTextMealPlanning.setText(mealStatusMessage.toString());
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jComboBoxMeMenu = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        linkLabelManageRecipes = new com.customfit.ctg.view.LinkLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextMealPlanning = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextRecipes = new javax.swing.JTextPane();
        linkLabelEditWeeklyMenu = new com.customfit.ctg.view.LinkLabel();
        linkLabelPrintShoppingList = new com.customfit.ctg.view.LinkLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextUserSettings = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        linkLabelEditUserSettings = new com.customfit.ctg.view.LinkLabel();
        linkLabelAddNewRecipe = new com.customfit.ctg.view.LinkLabel();

        setPreferredSize(new java.awt.Dimension(700, 388));

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 3, 18));
        jLabelTitle.setText("Profile Home");

        jScrollPane2.setBorder(null);

        jTextPane1.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jTextPane1.setBorder(null);
        jTextPane1.setEditable(false);
        jTextPane1.setText("Welcome to the Cooking to Goal nutritional planner. This application is designed to help you try to reach the nutritional goals that you plan for yourself and other members you wish to manage.\n\nWelcome to your personalized home. Establish meal plans by creating a menu for you, your family, or friends.");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Recipes");

        linkLabelManageRecipes.setText("Manage Available Recipes");
        linkLabelManageRecipes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkLabelManageRecipesActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Weekly Meal Planning");

        jScrollPane5.setBorder(null);

        jTextMealPlanning.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jTextMealPlanning.setBorder(null);
        jTextMealPlanning.setEditable(false);
        jTextMealPlanning.setText("You have %COUNT% meals planned for the next seven days.");
        jTextMealPlanning.setFocusable(false);
        jTextMealPlanning.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jTextMealPlanning.setOpaque(false);
        jTextMealPlanning.setVerifyInputWhenFocusTarget(false);
        jScrollPane5.setViewportView(jTextMealPlanning);

        jScrollPane6.setBorder(null);

        jTextRecipes.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jTextRecipes.setBorder(null);
        jTextRecipes.setEditable(false);
        jTextRecipes.setText("You currently have %NumOfRecipes% available to choose from for your menu.");
        jTextRecipes.setFocusable(false);
        jTextRecipes.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jTextRecipes.setOpaque(false);
        jTextRecipes.setVerifyInputWhenFocusTarget(false);
        jScrollPane6.setViewportView(jTextRecipes);

        linkLabelEditWeeklyMenu.setText("Edit Weekly Menu");
        linkLabelEditWeeklyMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkLabelEditWeeklyMenuActionPerformed(evt);
            }
        });

        linkLabelPrintShoppingList.setText("Print Shopping List");
        linkLabelPrintShoppingList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkLabelPrintShoppingListActionPerformed(evt);
            }
        });

        jScrollPane7.setBorder(null);

        jTextUserSettings.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jTextUserSettings.setBorder(null);
        jTextUserSettings.setEditable(false);
        jTextUserSettings.setText("You are currently tracking %NumOfMembers+user% of people to plan meals for.  The weekly menu will scale based on the given weekly target of %TotalWeeklyTarget% %TargetNutrition%.");
        jTextUserSettings.setFocusable(false);
        jTextUserSettings.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jTextUserSettings.setOpaque(false);
        jTextUserSettings.setVerifyInputWhenFocusTarget(false);
        jScrollPane7.setViewportView(jTextUserSettings);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("User Settings");

        linkLabelEditUserSettings.setText("Edit User Settings");
        linkLabelEditUserSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkLabelEditUserSettingsActionPerformed(evt);
            }
        });

        linkLabelAddNewRecipe.setText("Add a New Recipe");
        linkLabelAddNewRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkLabelAddNewRecipeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(linkLabelEditUserSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 427, Short.MAX_VALUE)
                                        .addComponent(jComboBoxMeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                                    .addComponent(jLabel1))
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                                .addGap(188, 188, 188))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addContainerGap(558, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(linkLabelAddNewRecipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(linkLabelManageRecipes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(556, 556, 556))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(linkLabelPrintShoppingList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(linkLabelEditWeeklyMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(592, 592, 592))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitle)
                    .addComponent(jComboBoxMeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linkLabelEditUserSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linkLabelManageRecipes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linkLabelAddNewRecipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(linkLabelEditWeeklyMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linkLabelPrintShoppingList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
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

    private void linkLabelManageRecipesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkLabelManageRecipesActionPerformed
        //tell controller to create a new recipe
        RecipeManagement.browseRecipes();
}//GEN-LAST:event_linkLabelManageRecipesActionPerformed

    private void linkLabelEditWeeklyMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkLabelEditWeeklyMenuActionPerformed
        MealPlanner.browseMenu();
    }//GEN-LAST:event_linkLabelEditWeeklyMenuActionPerformed

    private void linkLabelPrintShoppingListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkLabelPrintShoppingListActionPerformed
        RecipeManagement.printShoppingList();
    }//GEN-LAST:event_linkLabelPrintShoppingListActionPerformed

    private void linkLabelEditUserSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkLabelEditUserSettingsActionPerformed
        UserManagement.editRegistration(UserManagement.getCurrentUser());
    }//GEN-LAST:event_linkLabelEditUserSettingsActionPerformed

    private void linkLabelAddNewRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkLabelAddNewRecipeActionPerformed
        RecipeManagement.createRecipe();
    }//GEN-LAST:event_linkLabelAddNewRecipeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBoxMeMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextPane jTextMealPlanning;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextRecipes;
    private javax.swing.JTextPane jTextUserSettings;
    private com.customfit.ctg.view.LinkLabel linkLabelAddNewRecipe;
    private com.customfit.ctg.view.LinkLabel linkLabelEditUserSettings;
    private com.customfit.ctg.view.LinkLabel linkLabelEditWeeklyMenu;
    private com.customfit.ctg.view.LinkLabel linkLabelManageRecipes;
    private com.customfit.ctg.view.LinkLabel linkLabelPrintShoppingList;
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
        //set title label
        this.jLabelTitle.setText(user.getName() + " Home");
    }

    @Override
    public void refresh()
    {
        //refresh data
    }
    
}
