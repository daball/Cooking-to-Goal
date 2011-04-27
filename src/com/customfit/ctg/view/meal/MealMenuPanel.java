package com.customfit.ctg.view.meal;

import com.customfit.ctg.controller.*;
import com.customfit.ctg.model.*;
import com.customfit.ctg.view.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

/**
 * This is the panel that lists recipes and provides options to interact
 * with the list. This can be used for either browsing or searching.
 *
 * @author Ryan Spoon, David
 */
public class MealMenuPanel extends SubPanel {
    public static final int WEEKS_TO_SHOW = 52;

    /**
     * This gets stored whenever the controller passes it this way.
     */
    private List<Recipe> recipes;

    /** Creates new form RecipeListPanel */
    public MealMenuPanel() {
        initComponents();

        //temp default configuration for meals
        if (MealPlanner.getAllMeals().isEmpty()) {
            MealPlanner.createDefaultMeals();
        }

        //setup the me-menu in the right-top corner
        jComboBoxMeMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"User: " + UserManagement.getCurrentUser().getName(), "Profile Home", "Edit Profile", "Logout" }));

        //manually coded (netbeans issue?) on-select event
        jTableRecipes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                jTableRecipesValueChanged(evt);
            }
        });
        
        //figure out which weeks to display
        makeMenuColInvisible();
        
        //setup combo box for weeks
        calculateWeeksForComboBox();
    }

    private void calculateWeeksForComboBox()
    {
        //first remove all the old combo box data
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel)this.jComboBoxWeeks.getModel();
        
        //clear old results
        comboBoxModel.removeAllElements();
        
        //get a Calendar
        Calendar calendarToday = Calendar.getInstance();
        Calendar calendarStart = Calendar.getInstance();
        Calendar calendarEnd = Calendar.getInstance();
        
        //go to the first day of the week
        if (calendarStart.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY)
        {
            switch (calendarStart.get(Calendar.DAY_OF_WEEK))
            {
                case Calendar.SUNDAY:
                    calendarStart.add(Calendar.DATE, -1);
                    calendarEnd.add(Calendar.DATE, -1);
                case Calendar.SATURDAY:
                    calendarStart.add(Calendar.DATE, -1);
                    calendarEnd.add(Calendar.DATE, -1);
                case Calendar.FRIDAY:
                    calendarStart.add(Calendar.DATE, -1);
                    calendarEnd.add(Calendar.DATE, -1);
                case Calendar.THURSDAY:
                    calendarStart.add(Calendar.DATE, -1);
                    calendarEnd.add(Calendar.DATE, -1);
                case Calendar.WEDNESDAY:
                    calendarStart.add(Calendar.DATE, -1);
                    calendarEnd.add(Calendar.DATE, -1);
                case Calendar.TUESDAY:
                    calendarStart.add(Calendar.DATE, -1);
                    calendarEnd.add(Calendar.DATE, -1);
            }
        }
        //rewind 4 weeks
        calendarStart.add(Calendar.DATE, 7*WEEKS_TO_SHOW/2*-1);
        calendarEnd.add(Calendar.DATE, 7*WEEKS_TO_SHOW/2*-1);
        //then add 6 days to end date
        calendarEnd.add(Calendar.DATE, 6);

        //loop through weeks to display the comboBoxText
        int selectedWeek = 0;
        for (int week = 0; week < WEEKS_TO_SHOW; week++)
        {
            StringBuilder dateString = new StringBuilder();
            dateString.append((calendarStart.get(Calendar.MONTH)+1));
            dateString.append("/");
            dateString.append(calendarStart.get(Calendar.DATE));
            dateString.append("/");
            dateString.append(calendarStart.get(Calendar.YEAR));
            dateString.append(" - ");
            dateString.append((calendarEnd.get(Calendar.MONTH)+1));
            dateString.append("/");
            dateString.append(calendarEnd.get(Calendar.DATE));
            dateString.append("/");
            dateString.append(calendarEnd.get(Calendar.YEAR));
            //insert dateString
            comboBoxModel.addElement(dateString.toString());
            //check selected week
            if (calendarToday.after(calendarStart) && calendarToday.before(calendarEnd))
                selectedWeek = week;
            //add 7 days, lather, rinse, repeat
            calendarStart.add(Calendar.DATE, 7);
            calendarEnd.add(Calendar.DATE, 7);
        }
        
        //then set the selected one
        this.jComboBoxWeeks.setSelectedIndex(selectedWeek);
    }
    
    public Date getStartDate()
    {
        String dateString = (String)this.jComboBoxWeeks.getSelectedItem();
        if (dateString == null)
            return null;
        String[] dateStrings = dateString.split(" - ");
        dateString = dateStrings[0];
        dateStrings = dateString.split("/");
        int month = Integer.parseInt(dateStrings[0]) - 1;
        int date = Integer.parseInt(dateStrings[1]);
        int year = Integer.parseInt(dateStrings[2]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);
        return calendar.getTime();
    }
    
    public Date getEndDate()
    {
        String dateString = (String)this.jComboBoxWeeks.getSelectedItem();
        if (dateString == null)
            return null;
        String[] dateStrings = dateString.split(" - ");
        dateString = dateStrings[1];
        dateStrings = dateString.split("/");
        int month = Integer.parseInt(dateStrings[0]) - 1;
        int date = Integer.parseInt(dateStrings[1]);
        int year = Integer.parseInt(dateStrings[2]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);
        return calendar.getTime();
    }
    
    private void makeMenuColInvisible() {
        jTableMenu.removeColumn(jTableMenu.getColumnModel().getColumn(2));
        jTableMenu.removeColumn(jTableMenu.getColumnModel().getColumn(1));
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
        jButtonRemoveMealOrRecipe = new javax.swing.JButton();
        scrollPaneTable1 = new javax.swing.JScrollPane();
        jTableMenu = new javax.swing.JTable();
        jButtonAddMealOrRecipe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxWeeks = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        scrollPaneTable2 = new javax.swing.JScrollPane();
        jTableRecipes = new javax.swing.JTable();
        linkLabelAddNew = new com.customfit.ctg.view.LinkLabel();

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 3, 18));
        jLabelTitle.setText("Plan Weekly Menu");

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Adjust your meal plans", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jButtonRemoveMealOrRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/art/export/subtract-item.png"))); // NOI18N
        jButtonRemoveMealOrRecipe.setDefaultCapable(false);
        jButtonRemoveMealOrRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveMealOrRecipeActionPerformed(evt);
            }
        });

        jTableMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Meal", "MealObject", "RecipeObject"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMenu.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableMenu.getTableHeader().setReorderingAllowed(false);
        jTableMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMenuMouseClicked(evt);
            }
        });
        scrollPaneTable1.setViewportView(jTableMenu);

        jButtonAddMealOrRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/art/export/add-item.png"))); // NOI18N
        jButtonAddMealOrRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddMealOrRecipeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Week:");

        jComboBoxWeeks.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxWeeks.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxWeeksItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneTable1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxWeeks, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAddMealOrRecipe, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRemoveMealOrRecipe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jComboBoxWeeks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonAddMealOrRecipe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRemoveMealOrRecipe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Select a recipe to add to your meal", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jTableRecipes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Recipe", "Rating"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
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
        jTableRecipes.setColumnSelectionAllowed(true);
        jTableRecipes.getTableHeader().setReorderingAllowed(false);
        jTableRecipes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRecipesMouseClicked(evt);
            }
        });
        scrollPaneTable2.setViewportView(jTableRecipes);
        jTableRecipes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableRecipes.getColumnModel().getColumn(1).setCellRenderer(new StarRatingTableCellRenderer());

        linkLabelAddNew.setText("Create a new recipe");
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
            .addComponent(scrollPaneTable2, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(linkLabelAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneTable2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(linkLabelHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
                        .addComponent(jComboBoxMeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(linkLabelHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void linkLabelHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkLabelHomeActionPerformed
        //tell controller to go home
        UserManagement.viewHome();
    }//GEN-LAST:event_linkLabelHomeActionPerformed

    private void linkLabelAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkLabelAddNewActionPerformed
        //tell controller to create a new recipe
        RecipeManagement.createRecipe();
    }//GEN-LAST:event_linkLabelAddNewActionPerformed

    private void jTableMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMenuMouseClicked
        //same as recipes clicked
        jTableRecipesMouseClicked(evt);
        if (this.jTableMenu.getSelectedRowCount() > 0)
            this.jButtonRemoveMealOrRecipe.setEnabled(true);
        else if (this.jTableMenu.getSelectedRowCount() == 0)
            this.jButtonRemoveMealOrRecipe.setEnabled(false);
    }//GEN-LAST:event_jTableMenuMouseClicked

    private void jButtonRemoveMealOrRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveMealOrRecipeActionPerformed
        //if a row is selected
        if (this.jTableMenu.getSelectedRowCount() > 0) {
            Object mealObject = jTableMenu.getModel().getValueAt(jTableMenu.getSelectedRow(), 1);
            Object recipeObject = jTableMenu.getModel().getValueAt(jTableMenu.getSelectedRow(), 2);
            
            //if a mealName exists (so not selecting a meal name
            if (mealObject != null) {
                Meal meal = (Meal)mealObject;
                if (recipeObject != null && meal.getRecipes().size() > 1)
                {
                    for (Meal allMealsMeal: UserManagement.getCurrentUser().getAllMeals())
                        if (allMealsMeal.equals(meal))
                        {
                            allMealsMeal.getRecipes().remove((Recipe)recipeObject);
                            break;
                        }
                }
                else
                {
                    for (Meal allMealsMeal: UserManagement.getCurrentUser().getAllMeals())
                        if (allMealsMeal.equals(meal))
                        {
                            UserManagement.getCurrentUser().getAllMeals().remove(allMealsMeal);
                            break;
                        }
                }
                Application.getDataDriver().updateUserByName(UserManagement.getCurrentUser().getName(), UserManagement.getCurrentUser());
                this.refresh();
            }

        }
}//GEN-LAST:event_jButtonRemoveMealOrRecipeActionPerformed

    private void jTableRecipesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRecipesMouseClicked
        //toggle add button state
        if (this.jTableRecipes.getSelectedRowCount() > 0 && this.jTableMenu.getSelectedRowCount() > 0)
            this.jButtonAddMealOrRecipe.setEnabled(true);
        else if (this.jTableRecipes.getSelectedRowCount() == 0 || this.jTableMenu.getSelectedRowCount() == 0)
            this.jButtonAddMealOrRecipe.setEnabled(false);
    }//GEN-LAST:event_jTableRecipesMouseClicked

    private void jButtonAddMealOrRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddMealOrRecipeActionPerformed
        //build a list of recipes
        List<Recipe> recipes = new ArrayList<Recipe>();
        for (int recipeRow: this.jTableRecipes.getSelectedRows())
            for (Recipe recipe: this.recipes)
                if (recipe.getName().equals((String)this.jTableRecipes.getModel().getValueAt(recipeRow, 0)))
                    recipes.add(recipe);

        int selectedMenuRow = this.jTableMenu.getSelectedRow();
        if (this.jTableMenu.getSelectedRowCount() > 0) {
            Object mealObject = jTableMenu.getModel().getValueAt(jTableMenu.getSelectedRow(), 1);
            Calendar calendarToday = Calendar.getInstance();
            Calendar calendarStart = Calendar.getInstance();
            calendarStart.setTime(this.getStartDate());
            while (calendarToday.get(Calendar.DAY_OF_WEEK) > calendarStart.get(Calendar.DAY_OF_WEEK))
                calendarStart.add(Calendar.DATE, 1);
            if (mealObject == null)
            {
                //tell controller to create a new meal
                MealPlanner.insertMealPlan(calendarStart.getTime(), recipes);
                //and refresh data
                this.refresh();
            }
            else
            {
                //add these recipes to the selected meal
                for (int recipeRow: this.jTableRecipes.getSelectedRows())
                    for (Recipe recipe: this.recipes)
                        if (recipe.getName().equals((String)this.jTableRecipes.getModel().getValueAt(recipeRow, 0)))
                            UserManagement.getCurrentUser().addRecipeToMeal((Meal)mealObject, recipe);

                //and refresh data
                this.refresh();
            }
        }

}//GEN-LAST:event_jButtonAddMealOrRecipeActionPerformed

    private void jComboBoxWeeksItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxWeeksItemStateChanged
        this.refresh();
    }//GEN-LAST:event_jComboBoxWeeksItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddMealOrRecipe;
    private javax.swing.JButton jButtonRemoveMealOrRecipe;
    private javax.swing.JComboBox jComboBoxMeMenu;
    private javax.swing.JComboBox jComboBoxWeeks;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMenu;
    private javax.swing.JTable jTableRecipes;
    private javax.swing.JTextPane jTextPane1;
    private com.customfit.ctg.view.LinkLabel linkLabelAddNew;
    private com.customfit.ctg.view.LinkLabel linkLabelHome;
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
    public String getTitle() {
        //grab title from on the panel
        return this.jLabelTitle.getText();
    }

    /**
     * Sets the initial list of recipes passed into the view.
     * 
     * @param recipes List of recipes.
     */
    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;

        DefaultTableModel tableModel = (DefaultTableModel) jTableRecipes.getModel();

        //clear old results
        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
        }

        //add recipes to list
        for (Recipe recipe : recipes) {
            Object[] row = {recipe.getName(), recipe.getRating()};
            tableModel.addRow(row);
        }

        jTableRecipes.setModel(tableModel);
        
        if (this.jTableRecipes.getSelectedRowCount() > 0)
            this.jButtonAddMealOrRecipe.setEnabled(true);
        else if (this.jTableRecipes.getSelectedRowCount() == 0)
            this.jButtonAddMealOrRecipe.setEnabled(false);
    }

    /**
     * Sets the initial list of meals passed into the view.
     *
     * @param meals List of meals.
     */
    public void setMeals(List<Meal> meals) {
        if (meals == null) { this.refresh(); return; }
        
        DefaultTableModel tableModel = (DefaultTableModel) jTableMenu.getModel();

        //clear old results
        while (tableModel.getRowCount() > 0) {
            tableModel.removeRow(0);
        }

        //add recipes to list
        for (Meal meal : meals) {
            Object[] row = {"<html><b>" + meal.toString() + "</b></html>", meal, null};
            tableModel.addRow(row);
            for (Recipe recipe : meal.getRecipes()) {
                Object[] rrow = {"       " + recipe.getName(), meal, recipe };
                tableModel.addRow(rrow);
            }

        }
        Object[] row = {"<html><b>" + "Create a new meal plan..." + "</b></html>", null, null};
        tableModel.addRow(row);

        jTableMenu.setModel(tableModel);
        
        if (this.jTableMenu.getSelectedRowCount() > 0)
            this.jButtonRemoveMealOrRecipe.setEnabled(true);
        else if (this.jTableMenu.getSelectedRowCount() == 0)
            this.jButtonRemoveMealOrRecipe.setEnabled(false);
    }

    @Override
    public void refresh() {
        if (this.getStartDate() != null && this.getEndDate() != null)
        {
            this.setMeals(UserManagement.getCurrentUser().getMealsByDateRange(this.getStartDate(), this.getEndDate()));
        }
        this.setRecipes(RecipeManagement.getAllRecipes());
    }
}
