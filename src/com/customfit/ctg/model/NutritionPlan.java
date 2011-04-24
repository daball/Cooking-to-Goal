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
	 * The goals set out in the NutritionPlan.
	 */
	private NutritionFacts goals = new NutritionFacts();
        
        /**
         * The direction of the nutritional goals.
         */
        public static enum NutritionGoalDirection
        {
            MINIMUM_GOAL,
            MAXIMUM_GOAL
        };
        
        /**
         * The direction of the nutritional goals. (Minimum or Maximum)
         */
        private NutritionGoalDirection goalDirection = NutritionGoalDirection.MAXIMUM_GOAL;
	
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
	 * @param goals The goals set out in the NutritionPlan.
	 */
	public NutritionPlan(String name, NutritionFacts goals) {
		super();
		this.name = name;
		this.goals = goals;
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
	 * Gets the goals set out in the NutritionPlan.
	 * 
	 * @return The NutritionPlan maximum goals.
	 */
	public NutritionFacts getGoals() {
		return this.goals;
	}
	
	/**
	 * Sets the goals set out in the NutritionPlan.
	 * 
	 * @param maxGoals The NutritionPlan maximum goals.
	 */
	public void setGoals(NutritionFacts goals) {
		this.goals = goals;
	}

        /**
         * Gets the direction of the nutritional goals.
         */
        public NutritionGoalDirection getGoalDirection() {
            return this.goalDirection;
        }

        /**
         * Sets the direction of the nutritional goals.
         */
        public void setGoalDirection(NutritionGoalDirection goalDirection) {
            this.goalDirection = goalDirection;
        }
        
}
