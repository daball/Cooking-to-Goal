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
    public Recipe(Recipe recipe) {
        this.name = recipe.name;
        this.instructions = recipe.instructions;
        this.servingSize = recipe.servingSize;
        this.servings = recipe.servings;
        this.rating = recipe.rating;
        this.ingredients = recipe.ingredients;
        this.nutritionInformation = recipe.nutritionInformation;
    }
    
    /**
     * Constructs an exsting Recipe by copying fields.
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
     * Scales a Recipe's Ingredients, Serving Size, and Nutritional Information
     * to match the scaled factor.
     * 
     * @param recipe Recipe to scale.
     * @param scaleFactor The factor to scale it by.
     * 
     * @return A new Recipe object with scaled fields.
     */
    public static Recipe scaleRecipe(Recipe recipe, double scaleFactor)
    {
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
        return new Recipe(        
                recipe.getName(),
                recipe.getInstructions(),
                recipe.getServingSize().scale(scaleFactor),
                recipe.getServings(),
                recipe.getRating(),
                newIngredientsList,
                recipe.getNutritionInformation().scale(scaleFactor));
    }
    
    /**
     * Scales this Recipe's Ingredients, Serving Size, and Nutritional Information
     * to match the scaled factor.
     * 
     * @param scaleFactor The factor to scale the Recipe by.
     * 
     * @return A new Recipe object with scaled fields.
     */
    public Recipe scale(double scaleFactor)
    {
        return Recipe.scaleRecipe(this, scaleFactor);
    }
    
    /**
     * Scales a Recipe to a certain number of servings.
     * 
     * This method scales the Ingredient List amount and
     * the NutritionFacts nutrient fields' quantities to match
     * the new size of the Recipe.
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
        //scale it
        Recipe newRecipe = recipe.scale(scaleFactor);
        //then fix the serving size back, it was servings count that we were tampering
        newRecipe.servingSize = recipe.servingSize;
        newRecipe.servings = toServings;
        //return adjusted Recipe
        return newRecipe;
    }

    /**
     * Scales this Recipe to a certain number of servings.
     * 
     * @param recipe The Recipe to scale.
     * @param toServings The number of servings to scale to.
     * 
     * @return A new Recipe that has been scaled.
     */
    public Recipe scaleToServings(int toServings)
    {
        return Recipe.scaleRecipeToServings(this, toServings);
    }
    
    /**
     * Scales a Recipe to a nutritional target. This assumes that the member
     * will eat that one meal for the day, and that's it. 
     * 
     * If this is not the case and the member plans on eating more than one meal
     * for the day, then just call .scale(double factor) behind it with some fraction like
     * 1.0/3.0'rd of the day.
     * 
     * @param nutrientName The nutrient to scale to recipe to.
     * @param goal The member's nutritional target.
     * 
     * @return The ideal Recipe for the nutritional goal specified.
     */
    public static Recipe scaleToNutritionalTarget(Recipe recipe, String nutrientName, Measurement goal)
    {
        //get the nutrient from the recipe
        Measurement nutrient = recipe.nutritionInformation.getNutrient(nutrientName);
        //check for nutrient existance, it may not exist. if it doesn't, then there is nothing to scale toward
        if (nutrient != null)
        {
            //gather information
            double recipeNutrientQuantity = nutrient.getQuantity();
            double goalQuantity = goal.getQuantity();
            //calculate how many times you would have to make a recipe to reach your exact goal
            double scaleFactor = goalQuantity / recipeNutrientQuantity;
            //now scale the Recipe
            return recipe.scale(scaleFactor);
        }            
        else
            //nothing else to do here, make a copy of self and go on
            return new Recipe(recipe);
    }
    
     /**
     * Scales this Recipe to a nutritional target. This assumes that the member
     * will eat that one meal for the day, and that's it. 
     * 
     * If this is not the case and the member plans on eating more than one meal
     * for the day, then just call .scale(double factor) behind it with some fraction like
     * 1.0/3.0'rd of the day.
     * 
     * @param nutrientName The nutrient to scale to recipe to.
     * @param goal The member's nutritional target.
     * 
     * @return The ideal Recipe for the nutritional goal specified.
     */
    public Recipe scaleToNutritionalTarget(String nutrientName, Measurement goal)
    {
       return Recipe.scaleToNutritionalTarget(this, nutrientName, goal);
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
    
    /**
     * Adds two Recipe objects together into a new Recipe object.
     * 
     * It merges ingredients, summing them if they are on both sides.
     * It adds servings together into the output.
     * It also accumulates nutrition information for both Recipes.
     * 
     * @param recipeLeft A recipe object.
     * @param recipeRight Another recipe object.
     * 
     * @return A new Recipe object with the fields summed together.
     */
    public static Recipe addRecipes(Recipe recipeLeft, Recipe recipeRight)
    {
        //copy the left recipe to a new container object
        Recipe newRecipe = new Recipe(recipeLeft);
        //add servings from both
        newRecipe.servings += recipeRight.servings;
        //add nutrition info from both
        newRecipe.nutritionInformation.add(recipeRight.nutritionInformation);
        //assemble new ingredients
        newRecipe.ingredients = new ArrayList<RecipeIngredient>();
        //step one: add known ingredients together
        for (RecipeIngredient ingredientLeft: recipeLeft.ingredients)
            //get the ingredient on the right that matches the one on the left
            for (RecipeIngredient ingredientRight: recipeRight.ingredients)
                //if the two ingredients have matching names
                if (ingredientLeft.getName().equals(ingredientRight.getName()))
                    //then add them together on the newIngredients list
                    newRecipe.ingredients.add(ingredientLeft.add(ingredientRight));
        //step two: add unknown ingredients from right to left as is
        for (RecipeIngredient ingredientRight: recipeRight.ingredients)
            //if the ingredient is unknown
            if (!newRecipe.ingredients.contains(ingredientRight))
                //then add it
                newRecipe.ingredients.add(ingredientRight);
        //return new recipe
        return newRecipe;
    }
    
     /**
     * Adds a Recipe object to this one and returns a new Recipe object
     * to the output.
     * 
     * It merges ingredients, summing them if they are on both sides.
     * It adds servings together into the output.
     * It also accumulates nutrition information for both Recipes.
     * 
     * @param recipeLeft A recipe object to add with this one.
     * 
     * @return A new Recipe object with the fields summed together.
     */
    public Recipe add(Recipe recipe)
    {
        return Recipe.addRecipes(this, recipe);
    }
            
}