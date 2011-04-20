package com.customfit.ctg.model;

import java.util.*;

/**
 * This describes the User data model, including the user's name
 * and nutrition plans.
 * 
 * @author David
 */
public class User {
	/**
	 * The user's name.
	 */
	private String name;
	
	/**
	 * The list of nutrition plans for the user.
	 */
	private List<NutritionPlan> nutritionPlans = new ArrayList<NutritionPlan>();
	
	/**
	 * The active nutrition plan for the user.
	 */
	private NutritionPlan activeNutritionPlan = new NutritionPlan("Default Plan");
	
	/**
	 * Constructs a user with a single, active empty nutrition plan with
	 * the user name provided.
	 * 
	 * @param name The user's name.
	 */
	public User(String name){
		this.setName(name);
		this.nutritionPlans.add(this.activeNutritionPlan);
	}
	
	/**
	 * Constucts a user provided the information.
	 * 
	 * @param name The user's name.
	 * @param nutritionPlans The list of nutrition plans.
	 * @param activeNutritionPlan The active nutrition plan.
	 */
	public User(String name, List<NutritionPlan> nutritionPlans,
			NutritionPlan activeNutritionPlan) {
		super();
		this.name = name;
		this.nutritionPlans = nutritionPlans;
		this.activeNutritionPlan = activeNutritionPlan;
	}

	/**
	 * Gets the user's name
	 * 
	 * @return The user's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the user's name.
	 * 
	 * @param name The user's name.
	 */
	public void setName(String name) {
		this.name = name;
	}	
	
	/**
	 * Gets the List of NutritionPlans for the user.
	 * 
	 * @return The list of nutrition plans for the user.
	 */
	public List<NutritionPlan> getNutritionPlans() {
		return nutritionPlans;
	}

	/**
	 * Gets the active nutrition plan for the user.
	 * 
	 * @return The active nutrition plan for the user.
	 */
	public NutritionPlan getActiveNutritionPlan() {
		return activeNutritionPlan;
	}

	/**
	 * Sets the active nutrition plan for the user.
	 * 
	 * @param activeNutritionPlan The active nutrition plan for the user.
	 */
	public void setActiveNutritionPlan(NutritionPlan activeNutritionPlan) {
		this.activeNutritionPlan = activeNutritionPlan;
	}
}