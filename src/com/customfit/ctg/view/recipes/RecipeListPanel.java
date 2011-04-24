package com.customfit.ctg.view.recipes;

import com.customfit.ctg.controller.*;
import com.customfit.ctg.model.*;
import com.customfit.ctg.view.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing.event.*;

/**
 * This is the panel that lists recipes and provides options to interact
 * with the list. This can be used for either browsing or searching.
 *
 * @author Ryan Spoon, David
 */
public class RecipeListPanel extends SubPanel {

    /**
     * This gets stored whenever the controller passes it this way.
     */
    private List<Recipe> recipes;
    
    /**
     * The Recipe List has two behaviors.
     */
    public static enum ListMode
    {
        LIST_BROWSE,
        LIST_SEARCH
    };
    
    /**
     * This determines the behavior of this list.
     */
    private ListMode listMode;
    
    /** Creates new form RecipeListPanel */
    public RecipeListPanel(ListMode listMode) {
        initComponents();
        
        //setup list mode
        this.listMode = listMode;
        
        //customize form for list mode
        if (this.listMode == ListMode.LIST_BROWSE)
            this.jLabelTitle.setText("Browse Recipes");
        else if (this.listMode == ListMode.LIST_SEARCH)
            this.jLabelTitle.setText("Search Recipes");
        
        //setup the me-menu in the right-top corner
        jComboBoxMeMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Account: " + UserManagement.getCurrentUser().getName(), "Edit User", "Logout" }));

        //manually coded (netbeans issue?) on-select event
        jTableRecipes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                jTableRecipesValueChanged(evt);
            }
        }
        );
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
        scrollPaneTable = new javax.swing.JScrollPane();
        jTableRecipes = new javax.swing.JTable();
        linkLabelAddNew = new com.customfit.ctg.view.LinkLabel();
        jButtonViewRecipe = new javax.swing.JButton();
        linkLabelHome = new com.customfit.ctg.view.LinkLabel();

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 3, 18));
        jLabelTitle.setText("Recipe Listing");

        jScrollPane2.setBorder(null);

        jTextPane1.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jTextPane1.setBorder(null);
        jTextPane1.setEditable(false);
        jTextPane1.setText("Select a recipe from the list to view the recipe. You may also filter the list by category or ratings.");
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

        jTableRecipes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Rating"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRecipes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableRecipes.getTableHeader().setReorderingAllowed(false);
        jTableRecipes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRecipesMouseClicked(evt);
            }
        });
        scrollPaneTable.setViewportView(jTableRecipes);

        linkLabelAddNew.setText("Add a new recipe");
        linkLabelAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkLabelAddNewActionPerformed(evt);
            }
        });

        jButtonViewRecipe.setText("View Recipe");
        jButtonViewRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewRecipeActionPerformed(evt);
            }
        });

        linkLabelHome.setText("Return to home");
        linkLabelHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkLabelHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(jComboBoxMeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(linkLabelAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonViewRecipe)
                        .addGap(18, 18, 18)
                        .addComponent(linkLabelHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitle)
                    .addComponent(jComboBoxMeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(linkLabelAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(linkLabelHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonViewRecipe))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void linkLabelHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkLabelHomeActionPerformed
        //tell controller to go home
        UserManagement.viewProfile();
    }//GEN-LAST:event_linkLabelHomeActionPerformed

    private void linkLabelAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkLabelAddNewActionPerformed
        //tell controller to create a new recipe
        RecipeManagement.createRecipe();
    }//GEN-LAST:event_linkLabelAddNewActionPerformed

    private void jTableRecipesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRecipesMouseClicked
        //if double-clicked
        if (evt.getClickCount() == 2)
            //same as view recipe
            jButtonViewRecipeActionPerformed(null);
    }//GEN-LAST:event_jTableRecipesMouseClicked

    private void jButtonViewRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewRecipeActionPerformed
        //if a row is selected
        if (this.jTableRecipes.getSelectedRowCount() > 0)
        {
            //grab Recipe
            Recipe recipe = this.recipes.get(this.jTableRecipes.getSelectedRow());
            //tell RecipeManagement to view recipe
            RecipeManagement.viewRecipe(recipe);
        }
    }//GEN-LAST:event_jButtonViewRecipeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonViewRecipe;
    private javax.swing.JComboBox jComboBoxMeMenu;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableRecipes;
    private javax.swing.JTextPane jTextPane1;
    private com.customfit.ctg.view.LinkLabel linkLabelAddNew;
    private com.customfit.ctg.view.LinkLabel linkLabelHome;
    private javax.swing.JScrollPane scrollPaneTable;
    // End of variables declaration//GEN-END:variables

    private void jTableRecipesValueChanged(javax.swing.event.ListSelectionEvent evt) {                                       
        //check for selected value
        if (this.jTableRecipes.getSelectedRowCount() == 0)
            //if none then disable login button
            this.jButtonViewRecipe.setEnabled(false);
        //otherwise
        else
            //if valid then enable login button
            this.jButtonViewRecipe.setEnabled(true);
    } 
    
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
     * Sets the initial list of recipes passed into the view.
     * 
     * @param recipes List of recipes.
     */
    public void setRecipeList(List<Recipe> recipes) {
        this.recipes = recipes;
        
        DefaultTableModel tableModel = (DefaultTableModel)jTableRecipes.getModel();
        
        //clear old results
        while (tableModel.getRowCount() > 0)
        {
            tableModel.removeRow(0);
        }

        //add recipes to list
        for (Recipe recipe : recipes)
        {
            Object[] row = {recipe.getName(), new Long(Math.round(recipe.getRating() * 5.0)).toString()};
            tableModel.addRow(row);
        }
        
        jTableRecipes.setModel(tableModel);
    }
    
    @Override
    public void refresh()
    {
        //refresh data
        if (this.listMode == ListMode.LIST_BROWSE)
            this.setRecipeList(Application.getDataDriver().selectAllRecipes());
    }

}