package com.customfit.ctg;

import java.io.Serializable;
import java.util.Map;

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
	/**
	 * Store rating as a percentage. So, if we use a 5-point scale, you may use Round(rating * 5.0) to get any scale. Change the scale to 10, Round(rating * 10.0).
	 * The data is still the same. You may remove this comment or adjust it. --David 
	 */
	private double rating = 0.0;
	
	private Map<Ingredient, Integer> ingredients; // K = Ingredient, V = Quantity
	
	private NutritionFacts nutrition;

	/**
	 * Constructs an empty object.
	 * Fields must be set with setters.
	 */
	public Recipe() {}
	
	public Recipe(String name,
				  String description,
				  String instructions,
				  int servingSize,
				  double rating,
				  Map<Ingredient, Integer> ingredients,
				  NutritionFacts nutrition
				  ){
		this.setName(name);
		this.setDescription(description);
		this.setInstructions(instructions);
		this.setServingSize(servingSize);
		this.setRating(rating);
		this.setIngredients(ingredients);
		this.setNutrition(nutrition);
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
	 * @param servingSize the servingSize to set
	 */
	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}

	/**
	 * @return the servingSize
	 */
	public int getServingSize() {
		return servingSize;
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
	public void setIngredients(Map<Ingredient, Integer> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * @return the ingredients
	 */
	public Map<Ingredient, Integer> getIngredients() {
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
