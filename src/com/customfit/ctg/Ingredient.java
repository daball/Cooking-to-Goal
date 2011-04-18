package com.customfit.ctg;

/**
 * The model of an ingredient
 * @author Drew
 */
public class Ingredient{

	private String name;


	/**
	 * Constructs an Ingredient
	 * @param name
	 */
	public Ingredient(String name){
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
