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

	private String name,
				   description,
				   instructions;
	
	private int servingSize,
				rating;
	
	private Map<Ingredient, Integer> ingredients; // K = Ingredient, V = Quantity
	
	private NutritionFacts nutrition;

	/**
	 * Constructs an empty object.
	 * Fields must be set with setters.
	 */
	public Recipe() {}
	
//	public Recipe(String name,
//				  String description,
//				  String instructions,
//				  int servingSize,
//				  int rating,
//				  Map<Ingredient, Integer> ingredients,
//				  NutritionFacts nutrition
//				  ){
//		this.name = name;
//		this.description = description;
//		this.instructions = instructions;
//		this.servingSize = servingSize;
//		this.rating = rating;
//		this.ingredients = ingredients;
//		this.nutrition = nutrition;
//	}
}
