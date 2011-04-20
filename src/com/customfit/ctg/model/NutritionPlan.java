/**
 * 
 */
package com.customfit.ctg.model;

/**
 * The NutritionPlan belongs to User,
 * and provides a way to have multiple
 * NutritionPlans.
 * 
 * @author David
 */
public class NutritionPlan {

	/**
	 * The name of the NutritionPlan.
	 */
	private String name;
	
	/**
	 * The minimum goals set out
	 * in the NutritionPlan.
	 */
	private NutritionFacts minimumGoals = new NutritionFacts();
	
	/**
	 * The maximum goals set out
	 * in the NutritionPlan.
	 */
	private NutritionFacts maximumGoals = new NutritionFacts();

	/**
	 * Creates a new NutritionPlan for a User with empty goals.
	 * 
	 * @param name The name of the NutritionPlan.
	 */
	public NutritionPlan(String name) {
		super();
		this.name = name;
	}

	/**
	 * Creates a new NutritionPlan for a User with the specified goals.
	 * 
	 * @param name The name of the NutritionPlan.
	 * @param minimumGoals The minimum goals set out in the NutritionPlan.
	 * @param maximumGoals The maximum goals set out in the NutritionPlan.
	 */
	public NutritionPlan(String name, NutritionFacts minimumGoals,
			NutritionFacts maximumGoals) {
		super();
		this.name = name;
		this.minimumGoals = minimumGoals;
		this.maximumGoals = maximumGoals;
	}

	/**
	 * Gets the name of this NutritionPlan.
	 * 
	 * @return The name of the NutritionPlan.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of this NutritionPlan.
	 * 
	 * @param name The name of the NutritionPlan.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the maximum goals set out
	 * in the NutritionPlan.
	 * 
	 * @return The NutritionPlan maximum goals.
	 */
	public NutritionFacts getMaximumGoals() {
		return maximumGoals;
	}
	
	/**
	 * Sets the maximum goals set out
	 * in the NutritionPlan.
	 * 
	 * @param maxGoals The NutritionPlan maximum goals.
	 */
	public void setMaximumGoals(NutritionFacts maximumGoals) {
		this.maximumGoals = maximumGoals;
	}

	/**
	 * Gets the minimum goals set out
	 * in the NutritionPlan.
	 * 
	 * @return The NutritionPlan minimum goals.
	 */
	public NutritionFacts getMinimumGoals() {
		return minimumGoals;
	}

	/**
	 * Sets the minimum goals set out
	 * in the NutritionPlan.
	 * 
	 * @param minGoals the minGoals to set
	 */
	public void setMinimumGoals(NutritionFacts minimumGoals) {
		this.minimumGoals = minimumGoals;
	}
}
