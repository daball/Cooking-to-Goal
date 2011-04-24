package com.customfit.ctg.model;

/**
 * An ingredient is anything with a name apparently.
 * 
 * It did have another field with GroceryCategory,
 * but I am curious about it's function. --David
 * 
 * @author Drew, David
 */
public class Ingredient{

    /**
     * The name of the Ingredient.
     */
    private String name;
    
    /**
     * Constructs an Ingredient with a name.
     * @param name The name of the Ingredient.
     */
    public Ingredient(String name){
            this.setName(name);
    }
	
    /**
     * Gets the name of the Ingredient.
     * @return The name of the Ingredient.
     */
    public String getName() {
            return name;
    }

    /**
     * Sets the name of the Ingredient.
     * @param name The name of the Ingredient.
     */
    public void setName(String name) {
            this.name = name;
    }
}