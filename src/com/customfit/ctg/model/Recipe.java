package com.customfit.ctg.model;

import java.util.*;
import com.customfit.ctg.controller.*;

/**
 * A Recipe holds all of the individual components of a recipe.
 * 
 * @author Drew, David
 */
public class Recipe {

    /**
     * The name of the recipe.
     */
    private String name = "New Recipe";

    /**
     * The instructions for the recipe.
     */
    private String instructions = "Insert your recipe here.";

    /**
     * The serving size for the recipe (for each of the number of servings).
     */
    private Measurement servingSize = new Measurement(1.0, "unit");

    /**
     * The number of servings the recipe makes.
     */
    private double servings = 1.0;

    /**
     * The recipe rating (voting system).
     */
    private double rating = 0.0;

    /**
     * The list of ingredients in the recipe.
     */
    private List<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();

    /**
     * The nutrition information for the recipe.
     */
    private NutritionFacts nutritionInformation = new NutritionFacts();

    /**
     * Constructs an empty Recipe with some default parameters.
     */
    public Recipe() {
    }

    /**
     * Constructs a recipe object with all parameters.
     * 
     * @param name The name of the recipe.
     * @param instructions The instructions for the recipe.
     * @param servingSize The serving size for the recipe (for each of the number of servings).
     * @param servings The number of servings the recipe makes.
     * @param rating The recipe rating (voting system).
     * @param ingredients The list of ingredients in the recipe.
     * @param nutrition The nutrition information for the recipe.
     */
    public Recipe(String name,
                              String instructions,
                              Measurement servingSize,
                              double servings,
                              double rating,
                              List<RecipeIngredient> ingredients,
                              NutritionFacts nutritionInformation
                              ){
        this.name = name;
        this.instructions = instructions;
        this.servingSize = servingSize;
        this.servings = servings;
        this.rating = rating;
        this.ingredients = ingredients;
        this.nutritionInformation = nutritionInformation;
    }

    /**
     * Sets the name of the recipe.
     * @param name The name of the recipe.
     */
    public void setName(String name) {
            this.name = name;
    }

    /**
     * Gets the name of the recipe.
     * 
     * @param name The name of the recipe.
     */
    public String getName() {
            return name;
    }
    
    /**
     * Sets the instructions for the recipe.
     * 
     * @param instructions The instructions for the recipe.
     */
    public void setInstructions(String instructions) {
            this.instructions = instructions;
    }

    /**
     * Gets the instructions for the recipe.
     * 
     * @return The instructions for the recipe.
     */
    public String getInstructions() {
            return instructions;
    }
    
    /**
     * Gets the serving size for the recipe (for each of the number of servings).
     * 
     * @return The serving size for the recipe (for each of the number of servings).
     */
    public Measurement getServingSize() {
            return servingSize;
    }

    /**
     * Sets the serving size for the recipe (for each of the number of servings).
     * 
     * @param servingSize The serving size for the recipe (for each of the number of servings).
     */
    public void setServingSize(Measurement servingSize) {
            this.servingSize = servingSize;
    }

    /**
     * Gets the number of servings the recipe makes.
     * 
     * @return The number of servings the recipe makes.
     */
    public double getServings() {
            return servings;
    }

    /**
     * Sets the number of servings the recipe makes.
     * 
     * @param servings The number of servings the recipe makes.
     */
    public void setServings(double servings) {
            this.servings = servings;
    }

    /**
     * Sets the recipe rating (voting system).
     * 
     * @param The recipe rating (voting system).
     */
    public void setRating(double rating) {
            this.rating = rating;
    }

    /**
     * Gets the recipe rating (voting system).
     * 
     * @return The recipe rating (voting system).
     */
    public double getRating() {
            return rating;
    }
	
    /**
     * Sets the list of ingredients in the recipe.
     * 
     * @param ingredients The list of ingredients in the recipe.
     */
    protected void setIngredients(List<RecipeIngredient> ingredients) {
            this.ingredients = ingredients;
    }

    /**
     * Gets the list of ingredients in the recipe.
     * 
     * @return The list of ingredients in the recipe.
     */
    public List<RecipeIngredient> getIngredients() {
            return ingredients;
    }

    /**
     * Sets the nutrition information for the recipe.
     * @param nutrition The nutrition information for the recipe.
     */
    public void setNutritionInformation(NutritionFacts nutritionInformation) {
            this.nutritionInformation = nutritionInformation;
    }

    /**
     * Gets the nutrition information for the recipe.
     * @return The nutrition information for the recipe.
     */
    public NutritionFacts getNutritionInformation() {
            return nutritionInformation;
    }

    /**
     * Prints the name of the Recipe.
     */
    @Override
    public String toString()
    {
            return this.getName();
    }

    /**
     * Scales a Recipe to a certain number of servings.
     * 
     * This method scales the Ingredient List amount and
     * the NutritionFacts nutrient fields' quantity to match
     * the new servings.
     * 
     * Serving size will be unaffected. The new servings amount
     * will be stored in the mutated object.
     * 
     * @param recipe The Recipe to scale.
     * @param toServings The number of servings to scale to.
     * 
     * @return A new Recipe that has been scaled.
     */
    public static Recipe scaleRecipeToServings(Recipe recipe, double toServings)
    {
        //get the scale factor, which is (fromServings / toServings)
        double scaleFactor = recipe.getServings() / toServings;
        //rebuild and scale ingredients
        ArrayList<RecipeIngredient> newIngredientsList = new ArrayList<RecipeIngredient>();
        for (RecipeIngredient ingredient: recipe.getIngredients())
        {
            if (ingredient.getAmount() == null)
                newIngredientsList.add(ingredient);
            else
                newIngredientsList.add(ingredient.scale(scaleFactor));
        }
        //build the new Recipe and return
        Recipe newRecipe = new Recipe(
                recipe.getName(),
                recipe.getInstructions(),
                recipe.getServingSize(),
                toServings,
                recipe.getRating(),
                newIngredientsList,
                recipe.getNutritionInformation().scale(scaleFactor));
        return newRecipe;
    }

    /**
     * Scales a Recipe to a certain number of servings.
     * @param recipe The Recipe to scale.
     * @param toServings The number of servings to scale to.
     * @return A new Recipe that has been scaled.
     */
    public Recipe scaleToServings(int toServings)
    {
        return Recipe.scaleRecipeToServings(this, toServings);
    }
    
    @Override
    public boolean equals(Object object)
    {
       Recipe recipe = (Recipe)object;
       if (this.name.equals(recipe.name)
               && this.instructions.equals(recipe.instructions)
               && this.servings == recipe.servings
               && this.servingSize.equals(recipe.servingSize)
               && this.rating == recipe.rating
               && this.ingredients.size() == recipe.ingredients.size()
               && this.nutritionInformation.equals(recipe.nutritionInformation))
       {
           for (int ingredient = 0; ingredient < this.ingredients.size(); ingredient++)
           {
               if (!this.ingredients.get(ingredient).equals(recipe.ingredients.get(ingredient)))
                   return false;
           }
           return true;
       }
       return false;
    }
   
}