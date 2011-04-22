package com.customfit.ctg.view.recipes;

import com.customfit.ctg.controller.*;
import com.customfit.ctg.model.*;
import com.customfit.ctg.view.*;
import javax.swing.table.DefaultTableModel;

/**
 * This is the main panel for managing the recipes that are available
 * to select from.
 *
 * @author Ryan Spoon
 */
public class EditRecipePanel extends SubPanel {
    /**
     * The Recipe List has two behaviors.
     */
    public static enum EditMode
    {
        EDIT_NEW,
        EDIT_EXISTING
    };
    
    /**
     * This determines the behavior of this list.
     */
    private EditMode editMode;

    /**
     * Holds the panel that was open right before this panel was instantiated.
     */
    private SubPanel previousPanel;

    /** Creates new form OldRecipeListPanel */
    public EditRecipePanel(EditMode editMode) {
        initComponents();
        //setup edit mode
        this.editMode = editMode;
        //customize form for edit mode
        if (this.editMode == EditMode.EDIT_NEW)
            this.jLabelTitle.setText("Create a New Recipe");
        else if (this.editMode == EditMode.EDIT_EXISTING)
            this.jLabelTitle.setText("Edit Recipe");
        //save last panel in view
        this.previousPanel = Application.getMainFrame().getPanel();
        //setup the me-menu in the right-top corner
        this.jComboBoxMeMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Account: " + UserManagement.getCurrentUser().getName(), "Edit User", "Logout" }));
        //clear out the built-in combo box for units
        this.jComboBoxServingSizeUnit.setModel(new javax.swing.DefaultComboBoxModel(new String[] {
            "", //empty for just one of something i guess, let em have it just in case
            MeasurementUnit.USAUnits.CUPS,
            MeasurementUnit.USAUnits.DRY_OUNCES,
            MeasurementUnit.USAUnits.GALLONS,
            MeasurementUnit.USAUnits.LIQUID_OUNCES,
            MeasurementUnit.USAUnits.PINTS,
            MeasurementUnit.USAUnits.POUNDS,
            MeasurementUnit.USAUnits.QUARTS,
            MeasurementUnit.USAUnits.TABLESPOONS,
            MeasurementUnit.USAUnits.TEASPOONS,
            MeasurementUnit.MetricUnits.GRAMS,
            MeasurementUnit.MetricUnits.MILLIGRAMS
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

        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        lblName1 = new javax.swing.JLabel();
        jTextName = new javax.swing.JTextField();
        scrollPaneNutrition = new javax.swing.JScrollPane();
        jTableNutritionFacts = new javax.swing.JTable();
        jLabelTitle = new javax.swing.JLabel();
        jComboBoxMeMenu = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        scrollPaneIngedients = new javax.swing.JScrollPane();
        jTableIngredients = new javax.swing.JTable();
        jButtonAddIngredient = new javax.swing.JButton();
        jButtonRemoveIngredient = new javax.swing.JButton();
        starVotingPanel = new com.customfit.ctg.view.StarVotingPanel();
        jSpinnerServes = new javax.swing.JSpinner();
        lblName2 = new javax.swing.JLabel();
        lblName3 = new javax.swing.JLabel();
        jTextFieldServingSize = new javax.swing.JTextField();
        jComboBoxServingSizeUnit = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaInstructions = new javax.swing.JTextArea();

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblName.setText("Name: ");

        lblName1.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblName1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblName1.setText("Rating: ");

        scrollPaneNutrition.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nutrition Facts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        scrollPaneNutrition.setFont(new java.awt.Font("Tahoma", 1, 11));

        jTableNutritionFacts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Calories", null},
                {"Total Fat (g)", null},
                {"     Saturated Fat (g)", null},
                {"     Trans Fat (g)", null},
                {"Cholesterol (mg)", null},
                {"Sodium (mg)", null},
                {"Total Carbohydrate (g)", null},
                {"     Dietary Fiber (g)", null},
                {"     Sugars (g)", null},
                {"Protein (g)", null}
            },
            new String [] {
                "Name", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableNutritionFacts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableNutritionFacts.getTableHeader().setReorderingAllowed(false);
        scrollPaneNutrition.setViewportView(jTableNutritionFacts);
        jTableNutritionFacts.getColumnModel().getColumn(0).setMinWidth(120);
        jTableNutritionFacts.getColumnModel().getColumn(0).setPreferredWidth(120);
        jTableNutritionFacts.getColumnModel().getColumn(0).setMaxWidth(120);

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 3, 18));
        jLabelTitle.setText("Edit Recipe");

        jComboBoxMeMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Me Menu", "Edit User", "Logout" }));
        jComboBoxMeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMeMenuActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingredients", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jTableIngredients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Amount", "Ingredient"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableIngredients.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableIngredients.getTableHeader().setReorderingAllowed(false);
        scrollPaneIngedients.setViewportView(jTableIngredients);
        jTableIngredients.getColumnModel().getColumn(0).setMinWidth(45);
        jTableIngredients.getColumnModel().getColumn(0).setPreferredWidth(55);
        jTableIngredients.getColumnModel().getColumn(0).setMaxWidth(60);

        jButtonAddIngredient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/art/export/add-item.png"))); // NOI18N
        jButtonAddIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddIngredientActionPerformed(evt);
            }
        });

        jButtonRemoveIngredient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/art/export/subtract-item.png"))); // NOI18N
        jButtonRemoveIngredient.setDefaultCapable(false);
        jButtonRemoveIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveIngredientActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jButtonAddIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRemoveIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(222, Short.MAX_VALUE))
            .addComponent(scrollPaneIngedients, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonRemoveIngredient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAddIngredient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneIngedients, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

        lblName2.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblName2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName2.setText("Serves:");

        lblName3.setFont(new java.awt.Font("Tahoma", 1, 11));
        lblName3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblName3.setText("Serving Size:");

        jTextFieldServingSize.setText("1.0");

        jComboBoxServingSizeUnit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Instructions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jTextAreaInstructions.setColumns(20);
        jTextAreaInstructions.setRows(5);
        jScrollPane1.setViewportView(jTextAreaInstructions);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(jComboBoxMeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblName3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldServingSize, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxServingSizeUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblName1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(starVotingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                .addComponent(lblName2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSpinnerServes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPaneNutrition, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTitle)
                            .addComponent(jComboBoxMeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblName1)
                                    .addComponent(starVotingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jSpinnerServes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblName2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxServingSizeUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblName3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldServingSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                                .addComponent(scrollPaneNutrition, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(245, 245, 245)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
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

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        //if its a new recipe
        if (this.editMode == EditMode.EDIT_NEW)
            //then save it and go back to the last panel
            RecipeManagement.createRecipeAndGoBack(this.getRecipe(), this.getPreviousPanel());
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        //go back to the last panel
        Application.getMainFrame().setPanel(this.previousPanel);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void jButtonRemoveIngredientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveIngredientActionPerformed
        removeIngredient();
    }//GEN-LAST:event_jButtonRemoveIngredientActionPerformed

    private void jButtonAddIngredientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddIngredientActionPerformed
        DefaultTableModel dtm = (DefaultTableModel)jTableIngredients.getModel();
        dtm.addRow(new Object [] {null, null, null});
        jTableIngredients.setModel(dtm);
    }//GEN-LAST:event_jButtonAddIngredientActionPerformed

    private void updateRecipeList() {
        DefaultTableModel dtm = (DefaultTableModel)jTableNutritionFacts.getModel();

        Object[] o = {"hey", 4};
        dtm.addRow(o);
        jTableNutritionFacts.setModel(dtm);
    }

    private void removeIngredient() {
        int currentRow = jTableIngredients.getSelectedRow();
        if (currentRow != -1) {
            DefaultTableModel dtm = (DefaultTableModel)jTableIngredients.getModel();
            dtm.removeRow(currentRow);

            jTableIngredients.setModel(dtm);
            if (currentRow < jTableIngredients.getRowCount())
                jTableIngredients.setRowSelectionInterval(currentRow, currentRow);
        }
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButtonAddIngredient;
    private javax.swing.JButton jButtonRemoveIngredient;
    private javax.swing.JComboBox jComboBoxMeMenu;
    private javax.swing.JComboBox jComboBoxServingSizeUnit;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerServes;
    private javax.swing.JTable jTableIngredients;
    private javax.swing.JTable jTableNutritionFacts;
    private javax.swing.JTextArea jTextAreaInstructions;
    private javax.swing.JTextField jTextFieldServingSize;
    private javax.swing.JTextField jTextName;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblName2;
    private javax.swing.JLabel lblName3;
    private javax.swing.JScrollPane scrollPaneIngedients;
    private javax.swing.JScrollPane scrollPaneNutrition;
    private com.customfit.ctg.view.StarVotingPanel starVotingPanel;
    // End of variables declaration//GEN-END:variables

    /**
     * Sets recipe to edit in view.
     * 
     * @param recipe Recipe to edit.
     */
    public void setRecipe(Recipe recipe)
    {
        this.jTextName.setText(recipe.getName());
        this.starVotingPanel.setRating(recipe.getRating());
        this.jSpinnerServes.setValue(recipe.getServings());
        this.jTextFieldServingSize.setText(Double.valueOf(recipe.getServingSize().getQuantity()).toString());
        this.jComboBoxServingSizeUnit.setSelectedItem(recipe.getServingSize().getUnit());
        for (RecipeIngredient ingredient: recipe.getIngredients())
        {
            DefaultTableModel dtm = (DefaultTableModel)this.jTableIngredients.getModel();
            Object[] objArray = new Object[]
                    {
                        ingredient.getAmount(),
                        ingredient.getName()
                    };
            dtm.addRow(objArray);
        }
        this.jTextAreaInstructions.setText(recipe.getInstructions());
        for (int nutritionRow = 0; nutritionRow < this.jTableNutritionFacts.getModel().getRowCount(); nutritionRow++)
        {
            String nutrient = (String)this.jTableNutritionFacts.getModel().getValueAt(nutritionRow, 0);
            if (nutrient.startsWith("Calories"))
                this.jTableNutritionFacts.getModel().setValueAt(recipe.getNutritionInformation().getCalories().getQuantity(), nutritionRow, 1);
            else if (nutrient.trim().startsWith("Total Fat"))
                this.jTableNutritionFacts.getModel().setValueAt(recipe.getNutritionInformation().getTotalFat().getQuantity(), nutritionRow, 1);
            else if (nutrient.trim().startsWith("Saturated Fat"))
                this.jTableNutritionFacts.getModel().setValueAt(recipe.getNutritionInformation().getSaturatedFat().getQuantity(), nutritionRow, 1);
            else if (nutrient.trim().startsWith("Trans Fat"))
                this.jTableNutritionFacts.getModel().setValueAt(recipe.getNutritionInformation().getTransFat().getQuantity(), nutritionRow, 1);
            else if (nutrient.startsWith("Cholesterol"))
                this.jTableNutritionFacts.getModel().setValueAt(recipe.getNutritionInformation().getCholesterol().getQuantity(), nutritionRow, 1);
            else if (nutrient.startsWith("Sodium"))
                this.jTableNutritionFacts.getModel().setValueAt(recipe.getNutritionInformation().getSodium().getQuantity(), nutritionRow, 1);
            else if (nutrient.startsWith("Total Carbohydrate"))
                this.jTableNutritionFacts.getModel().setValueAt(recipe.getNutritionInformation().getTotalCarbohydrate().getQuantity(), nutritionRow, 1);
            else if (nutrient.trim().startsWith("Dietary Fiber"))
                this.jTableNutritionFacts.getModel().setValueAt(recipe.getNutritionInformation().getDietaryFiber().getQuantity(), nutritionRow, 1);
            else if (nutrient.trim().startsWith("Sugars"))
                this.jTableNutritionFacts.getModel().setValueAt(recipe.getNutritionInformation().getSugars().getQuantity(), nutritionRow, 1);
            else if (nutrient.startsWith("Protein"))
                this.jTableNutritionFacts.getModel().setValueAt(recipe.getNutritionInformation().getProtein().getQuantity(), nutritionRow, 1);
        }
    }
    
    /**
     * Builds Recipe object from view inputs.
     */
    public Recipe getRecipe()
    {
        Recipe recipe = new Recipe();
        recipe.setName(this.jTextName.getText().trim());
        recipe.setRating(this.starVotingPanel.getRating());
        recipe.setServings(Double.longBitsToDouble((Integer)this.jSpinnerServes.getValue()));
        if (this.jTextFieldServingSize.getText().isEmpty()) this.jTextFieldServingSize.setText("1.0");
        recipe.getServingSize().setQuantity(Double.parseDouble(this.jTextFieldServingSize.getText()));
        recipe.getServingSize().setUnit((String)this.jComboBoxServingSizeUnit.getSelectedItem());
        for (int ingredientRow = 0; ingredientRow < this.jTableIngredients.getModel().getRowCount(); ingredientRow++)
        {
            String amount = (String)this.jTableIngredients.getModel().getValueAt(ingredientRow, 0);
            String ingredient = (String)this.jTableIngredients.getModel().getValueAt(ingredientRow, 1);
            //add ingredient to recipe
            recipe.getIngredients().add(new RecipeIngredient(ingredient, amount));
        }
        
        recipe.setInstructions(this.jTextAreaInstructions.getText());
        for (int nutritionRow = 0; nutritionRow < this.jTableNutritionFacts.getModel().getRowCount(); nutritionRow++)
        {
            String nutrient = (String)this.jTableNutritionFacts.getModel().getValueAt(nutritionRow, 0);
            Float amount = (Float)this.jTableNutritionFacts.getModel().getValueAt(nutritionRow, 1);
            if (amount != null && amount != 0)
            {
                if (nutrient.equals("Calories"))
                    recipe.getNutritionInformation().setCalories(amount);
                else if (nutrient.trim().startsWith("Total Fat"))
                    recipe.getNutritionInformation().setTotalFat(amount);
                else if (nutrient.trim().startsWith("Saturated Fat"))
                    recipe.getNutritionInformation().setSaturatedFat(amount);
                else if (nutrient.trim().startsWith("Trans Fat"))
                    recipe.getNutritionInformation().setTransFat(amount);
                else if (nutrient.startsWith("Cholesterol"))
                    recipe.getNutritionInformation().setCholesterol(amount);
                else if (nutrient.startsWith("Sodium"))
                    recipe.getNutritionInformation().setSodium(amount);
                else if (nutrient.startsWith("Total Carbohydrate"))
                    recipe.getNutritionInformation().setTotalCarbohydrate(amount);
                else if (nutrient.trim().startsWith("Dietary Fiber"))
                    recipe.getNutritionInformation().setDietaryFiber(amount);
                else if (nutrient.trim().startsWith("Sugars"))
                    recipe.getNutritionInformation().setSugars(amount);
                else if (nutrient.startsWith("Protein"))
                    recipe.getNutritionInformation().setProtein(amount);
            }
        }
        return recipe;
    }
    
    /**
     * Gets the last panel that was open before this one was opened.
     * @return 
     */
    public SubPanel getPreviousPanel() {
        return previousPanel;
    }
}
