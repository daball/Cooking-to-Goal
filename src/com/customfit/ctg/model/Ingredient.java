package com.customfit.ctg.model;

/**
 * The model of an ingredient
 * @author Drew
 */
public class Ingredient{

	private String name;
	private GroceryCategory category;


	/**
	 * Constructs an Ingredient
	 * @param name
	 */
	public Ingredient(String name){
		this.setName(name);
	}
	
	/**
	 * Constructs an Ingredient
	 * @param name
	 */
	public Ingredient(String name, GroceryCategory category){
		this.setName(name);
		this.setCategory(category);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the category
	 */
	public GroceryCategory getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(GroceryCategory category) {
		this.category = category;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
