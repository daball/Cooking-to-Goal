package com.customfit.ctg.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The model of a recipe.
 * 
 * @author Drew
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
     * Sets the serving size for the recipe (for each of the number of servings).
     */
    private MeasurableUnit servingSize = new MeasurableUnit(1.0, "unit");

    /**
     * Sets the number of servings the recipe makes.
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
     * Constructs an empty Recipe object.
     * Fields must be set with setters.
     */
    public Recipe() {
        super();
    }

    /**
     * Constructs a recipe object with all parameters.
     * 
     * @param name The name of the recipe.
     * @param description The instructions for the recipe.
     * @param instructions Sets the serving size for the recipe (for each of the number of servings).
     * @param servingSize
     * @param servings
     * @param rating
     * @param ingredients
     * @param nutrition
     */
    public Recipe(String name,
                              //String description,
                              String instructions,
                              MeasurableUnit servingSize,
                              double servings,
                              double rating,
                              List<RecipeIngredient> ingredients,
                              NutritionFacts nutritionInformation
                              ){
        super();
        this.setName(name);
        this.setInstructions(instructions);
        this.setServingSize(servingSize);
        this.setServings(servings);
        this.setRating(rating);
        this.setIngredients(ingredients);
        this.setNutritionInformation(nutritionInformation);
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
            this.name = name;
    }

    /**
     * Gets the name of the recipe.
     */
    public String getName() {
            return name;
    }
    
    /**
     * The instructions for the recipe.
     */
    public void setInstructions(String instructions) {
            this.instructions = instructions;
    }

    /**
     * @return the instructions
     */
    public String getInstructions() {
            return instructions;
    }
    
	/**
	 * @return the servingSize
	 */
	public MeasurableUnit getServingSize() {
		return servingSize;
	}

	/**
	 * @param servingSize the servingSize to set
	 */
	public void setServingSize(MeasurableUnit servingSize) {
		this.servingSize = servingSize;
	}

	/**
	 * @return the servings
	 */
	public double getServings() {
		return servings;
	}

    /**
     * Sets the name of the recipe.
     */
    public void setServings(double servings) {
            this.servings = servings;
    }

	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}
	
	/**
	 * @param ingredients the ingredients to set
	 */
	protected void setIngredients(List<RecipeIngredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	/**
	 * @return the ingredients
	 */
	public List<RecipeIngredient> getIngredients() {
		return ingredients;
	}
	
	/**
	 * @param nutrition the nutrition information to set
	 */
	public void setNutritionInformation(NutritionFacts nutritionInformation) {
		this.nutritionInformation = nutritionInformation;
	}

	/**
	 * @return the nutrition information
	 */
	public NutritionFacts getNutritionInformation() {
		return nutritionInformation;
	}
	
	@Override
	public String toString()
	{
		return this.getName();
	}        
}
