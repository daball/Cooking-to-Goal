package com.customfit.ctg.view.meal;

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
public class MealMenuPanel extends SubPanel {

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
    public MealMenuPanel(ListMode listMode) {
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
        linkLabelHome = new com.customfit.ctg.view.LinkLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonRemoveRecipe = new javax.swing.JButton();
        scrollPaneTable1 = new javax.swing.JScrollPane();
        jTableMenu = new javax.swing.JTable();
        listDate = new javax.swing.JComboBox();
        jButtonAddRecipe = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        scrollPaneTable2 = new javax.swing.JScrollPane();
        jTableRecipes = new javax.swing.JTable();
        linkLabelAddNew = new com.customfit.ctg.view.LinkLabel();

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 3, 18));
        jLabelTitle.setText("Meal Menu");

        jScrollPane2.setBorder(null);

        jTextPane1.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jTextPane1.setBorder(null);
        jTextPane1.setEditable(false);
        jTextPane1.setText("To add a recipe to the menu, select the desired recipe under available recipes, select the day of the week, and click add.  If you would like to remove a recipe from the menu, select the recipe under menu, and click remove.");
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

        linkLabelHome.setText("Return to home");
        linkLabelHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkLabelHomeActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Current Menu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jButtonRemoveRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/art/export/subtract-item.png"))); // NOI18N
        jButtonRemoveRecipe.setDefaultCapable(false);
        jButtonRemoveRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveRecipeActionPerformed(evt);
            }
        });

        jTableMenu.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableMenu.getTableHeader().setReorderingAllowed(false);
        jTableMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMenuMouseClicked(evt);
            }
        });
        scrollPaneTable1.setViewportView(jTableMenu);

        listDate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));

        jButtonAddRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/art/export/add-item.png"))); // NOI18N
        jButtonAddRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddRecipeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(listDate, 0, 199, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAddRecipe, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jButtonRemoveRecipe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(scrollPaneTable1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonAddRecipe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRemoveRecipe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(listDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Available Recipes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

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
        jTableRecipes.getTableHeader().setReorderingAllowed(false);
        jTableRecipes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRecipesMouseClicked(evt);
            }
        });
        scrollPaneTable2.setViewportView(jTableRecipes);

        linkLabelAddNew.setText("(Add a new recipe)");
        linkLabelAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkLabelAddNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(linkLabelAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(scrollPaneTable2, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(linkLabelAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneTable2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(linkLabelHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 389, Short.MAX_VALUE)
                        .addComponent(jComboBoxMeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linkLabelHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void jTableMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMenuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableMenuMouseClicked

    private void jButtonRemoveRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveRecipeActionPerformed
        
}//GEN-LAST:event_jButtonRemoveRecipeActionPerformed

    private void jTableRecipesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRecipesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableRecipesMouseClicked

    private void jButtonAddRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddRecipeActionPerformed
        
}//GEN-LAST:event_jButtonAddRecipeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddRecipe;
    private javax.swing.JButton jButtonRemoveRecipe;
    private javax.swing.JComboBox jComboBoxMeMenu;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMenu;
    private javax.swing.JTable jTableRecipes;
    private javax.swing.JTextPane jTextPane1;
    private com.customfit.ctg.view.LinkLabel linkLabelAddNew;
    private com.customfit.ctg.view.LinkLabel linkLabelHome;
    private javax.swing.JComboBox listDate;
    private javax.swing.JScrollPane scrollPaneTable1;
    private javax.swing.JScrollPane scrollPaneTable2;
    // End of variables declaration//GEN-END:variables

    private void jTableRecipesValueChanged(javax.swing.event.ListSelectionEvent evt) {                                       
        
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