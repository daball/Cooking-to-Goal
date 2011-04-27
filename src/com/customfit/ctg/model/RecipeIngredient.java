package com.customfit.ctg.model;

import com.customfit.ctg.controller.*;

/**
 * The RecipeIngredient extends the functionality
 * of an Ingredient by adding an amount.
 * 
 * @author David
 */
public class RecipeIngredient extends Ingredient{

    /**
     * The amount of the RecipeIngredient.
     */
    private Measurement amount;

    /**
     * Creates a default RecipeIngredient with only a name.
     * 
     * @param name The name of the Ingredient.
     */
    public RecipeIngredient(String name) {
        super(name);
    }

    /**
     * Creates a RecipeIngredient with name and amount.
     * 
     * @param name The name of the Ingredient.
     * @param amount The amount of the RecipeIngredient.
     */
    public RecipeIngredient(String name, Measurement amount) {
        super(name);
        this.amount = amount;
    }

    /**
     * Creates a RecipeIngredient with name and amount. The amount
     * will be converted to a Measurement out of the quantity and unit.
     * 
     * @param name Ingredient name.
     * @param quantity Quantity.
     * @param unit Measurement unit.
     */
    public RecipeIngredient(String name, double quantity, String unit) {
        super(name);
        this.amount = new Measurement(quantity, unit);
    }

    /**
     * Creates a RecipeIngredient with name and amount. The amount
     * will be converted to a Measurement out of the String.
     * 
     * @param name Ingredient name.
     * @param measureableUnitString Measurement string.
     */
    public RecipeIngredient(String name, String measureableUnitString) {
        super(name);
        this.amount = new Measurement(measureableUnitString);
    }

    /**
     * Gets the amount of the RecipeIngredient.
     * 
     * @return The amount of the RecipeIngredient.
     */
    public Measurement getAmount() {
        return this.amount;
    }

    /**
     * Sets the amount of the RecipeIngredient.
     * 
     * @param amount The amount of the RecipeIngredient.
     */
    public void setAmount(Measurement amount) {
        this.amount = amount;
    }

    /**
     * Gets the amount and the name of the RecipeIngredient.
     * 
     * Example: 1.0 teaspoons sugar
     * 
     * @return The amount and the name of the RecipeIngredient.
     */
    public String toString()
    {
        if (this.getName() != null && this.getAmount() != null)
            return this.getAmount() + " " + this.getName();
        else if (this.getName() != null)
            return this.getAmount().toString();
        else if (this.getAmount() != null)
            return this.getName();
        else
            return "";
    }
    
    /**
     * Scales a RecipeIngredient's amount field.
     * 
     * @param recipeIngredient A RecipeIngredient instance
     * @param scaleFactor The scale factor, e.g. 0.5, 2.0, 5.0, ...
     * 
     * @return The new RecipeIngredient with the scaled field.
     */
    public static RecipeIngredient scaleRecipeIngredient(RecipeIngredient recipeIngredient, double scaleFactor)
    {
        if (recipeIngredient.getAmount() == null)
            return recipeIngredient;
        else
            return new RecipeIngredient(recipeIngredient.getName(), recipeIngredient.getAmount().scale(scaleFactor));
    }

    /**
     * Scales amount field into a new RecipeIngredient.
     * 
     * @param scaleFactor The scale factor, e.g. 0.5, 2.0, 5.0, ...
     * 
     * @return The new RecipeIngredient with the scaled field.
     */
    public RecipeIngredient scale(double scaleFactor)
    {
        return RecipeIngredient.scaleRecipeIngredient(this, scaleFactor);
    }
    
    @Override
    public boolean equals(Object object)
    {
       RecipeIngredient recipeIngredient = (RecipeIngredient)object;
       if (super.equals(object)
               && this.amount.equals(recipeIngredient.amount))
           return true;
       return false;
    }
    
    /**
     * Creates a new RecipeIngredient object with the sum of the two amounts and the unit
     * and ingredient name from the RecipeIngredient on the left.
     * 
     * @param recipeIngredientLeft A RecipeIngredient object. (This one must have the amount.unit and name specified.)
     * @param recipeIngredientRight A RecipeIngredient object. (The amount.unit and name will be ignored.)
     * 
     * @return A new RecipeIngredient object with the sum of the two amounts.
     */
    public static RecipeIngredient addRecipeIngredients(RecipeIngredient recipeIngredientLeft, RecipeIngredient recipeIngredientRight)
    {
        return new RecipeIngredient(recipeIngredientLeft.getName(), recipeIngredientLeft.amount.add(recipeIngredientRight.amount));
    }

    /**
     * Creates a new RecipeIngredient object with the sum of the quantities of this RecipeIngredient
     * and the one you specified. The input measurement's unit will be ignored and only
     * the quantities will be merged into the new Measurement object. The unit from this
     * instance will be passed into the new Measurement object.
     * 
     * @param recipeIngredient The RecipeIngredient object you would like to add into this one.
     * 
     * @return A new Measurement object with the sum of the two quantities.
     */
    public RecipeIngredient add(RecipeIngredient recipeIngredient)
    {
        //put this on the left
        return RecipeIngredient.addRecipeIngredients(this, recipeIngredient);
    }
    
}