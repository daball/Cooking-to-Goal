package com.customfit.ctg.model;

public class User {

	private String name;
	private NutritionFacts maxGoals;
	private NutritionFacts minGoals;
	
	/**
	 * Constructs a user.
	 * Add nutrition facts with setters.
	 * @param name
	 */
	public User(String name){
		this.setName(name);
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
	/**
	 * @return the maxGoals
	 */
	public NutritionFacts getMaxGoals() {
		return maxGoals;
	}
	/**
	 * @param maxGoals the maxGoals to set
	 */
	public void setMaxGoals(NutritionFacts maxGoals) {
		this.maxGoals = maxGoals;
	}
	/**
	 * @return the minGoals
	 */
	public NutritionFacts getMinGoals() {
		return minGoals;
	}
	/**
	 * @param minGoals the minGoals to set
	 */
	public void setMinGoals(NutritionFacts minGoals) {
		this.minGoals = minGoals;
	}
	
	
}
