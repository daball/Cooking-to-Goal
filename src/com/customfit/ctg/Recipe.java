package com.customfit.ctg;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The model of a recipe.
 * 
 * @author Drew
 */
public class Recipe implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name = "New Recipe";
	private String description = "Your recipe description goes here.";
	private String instructions = "Insert your recipe here.";

	private int servingSize = 0;
	private int servings = 0;
	
	private double rating = 0.0;
	
	private ArrayList<RecipeIngredient> ingredients;
	
	private NutritionFacts nutrition;

	/**
	 * Constructs a basic Recipe object with just a name.
	 * Fields must be set with setters.
	 */
	public Recipe(String name) {
		this.setName(name);
	}
	
	/**
	 * Constructs a recipe object with all parameters.
	 * 
	 * @param name
	 * @param description
	 * @param instructions
	 * @param servingSize
	 * @param servings
	 * @param rating
	 * @param ingredients
	 * @param nutrition
	 */
	public Recipe(String name,
				  String description,
				  String instructions,
				  int servingSize,
				  int servings,
				  double rating,
				  ArrayList<RecipeIngredient> ingredients,
				  NutritionFacts nutrition
				  ){
		this.setName(name);
		this.setDescription(description);
		this.setInstructions(instructions);
		this.setServingSize(servingSize);
		this.setServings(servings);
		this.setRating(rating);
		this.setIngredients(ingredients);
		this.setNutrition(nutrition);
	}

	/**
	 * @return the servingSize
	 */
	public int getServingSize() {
		return servingSize;
	}

	/**
	 * @param servingSize the servingSize to set
	 */
	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}

	/**
	 * @return the servings
	 */
	public int getServings() {
		return servings;
	}

	/**
	 * @param servings the servings to set
	 */
	public void setServings(int servings) {
		this.servings = servings;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param instructions the instructions to set
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
	public void setIngredients(ArrayList<RecipeIngredient> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * @return the ingredients
	 */
	public ArrayList<RecipeIngredient> getIngredients() {
		return ingredients;
	}

	/**
	 * @param nutrition the nutrition to set
	 */
	public void setNutrition(NutritionFacts nutrition) {
		this.nutrition = nutrition;
	}

	/**
	 * @return the nutrition
	 */
	public NutritionFacts getNutrition() {
		return nutrition;
	}
}
