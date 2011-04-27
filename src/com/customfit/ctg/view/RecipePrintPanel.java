/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PrintPanel.java
 *
 * Created on Apr 25, 2011, 1:28:33 PM
 */
package com.customfit.ctg.view;

import com.customfit.ctg.model.Recipe;
import com.customfit.ctg.model.RecipeIngredient;
import java.util.List;

/**
 *
 * @author Drew
 */
public class RecipePrintPanel extends AbstractPrintPanel {

    /** Creates new form PrintPanel */
    public RecipePrintPanel() {
        initComponents();
    }
    
    public void setRecipe(Recipe recipe)
    {
        List<RecipeIngredient> ingredients = recipe.getIngredients();

        StringBuilder ingredientStringBuilder = new StringBuilder();
        for(RecipeIngredient recipeIngredient : ingredients){
            ingredientStringBuilder.append("     ");
            ingredientStringBuilder.append(recipeIngredient.getAmount());
            ingredientStringBuilder.append("\t");
            ingredientStringBuilder.append(recipeIngredient.getName());
            ingredientStringBuilder.append("\n");
        }

        this.jLabelName.setText(recipe.getName());
        this.jTextPaneIngredients.setText(ingredientStringBuilder.toString());
        this.starRatingPanel.setRating(recipe.getRating());
        this.jLabelMakes.setText("Makes " + recipe.getServings() + ", " + recipe.getServingSize().toString() + " servings.");
        this.jTextPaneInstructions.setText(recipe.getInstructions());
        this.jTextPaneNutritionFacts.setText(recipe.getNutritionInformation().toString());
    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        starRatingPanel = new com.customfit.ctg.view.StarRatingPanel();
        jLabelMakes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneIngredients = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneNutritionFacts = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPaneInstructions = new javax.swing.JTextPane();

        jLabelName.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabelName.setText("Recipe");

        starRatingPanel.setScale(5);

        javax.swing.GroupLayout starRatingPanelLayout = new javax.swing.GroupLayout(starRatingPanel);
        starRatingPanel.setLayout(starRatingPanelLayout);
        starRatingPanelLayout.setHorizontalGroup(
            starRatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        starRatingPanelLayout.setVerticalGroup(
            starRatingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jLabelMakes.setFont(new java.awt.Font("Times New Roman", 2, 11)); // NOI18N
        jLabelMakes.setText("Makes 5, 3.0 ounce servings.");

        jScrollPane1.setBorder(null);

        jTextPaneIngredients.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(jTextPaneIngredients);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setText("Ingredients");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel2.setText("Nutrition Facts");

        jScrollPane2.setBorder(null);

        jTextPaneNutritionFacts.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(jTextPaneNutritionFacts);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setText("Instructions");

        jScrollPane3.setBorder(null);

        jTextPaneInstructions.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jScrollPane3.setViewportView(jTextPaneInstructions);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelMakes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                            .addComponent(jLabelName, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(starRatingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(starRatingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelMakes)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelMakes;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane jTextPaneIngredients;
    private javax.swing.JTextPane jTextPaneInstructions;
    private javax.swing.JTextPane jTextPaneNutritionFacts;
    private com.customfit.ctg.view.StarRatingPanel starRatingPanel;
    // End of variables declaration//GEN-END:variables


}
