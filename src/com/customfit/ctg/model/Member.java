package com.customfit.ctg.model;

/**
 * This describes the Member data model, including the user's name
 * and nutrition plans.
 * 
 * @author David
 */
public class Member {

    /**
     * The member's name.
     */
    private String name;

    /**
     * The goal set out in the NutritionPlan.
     */
    private Measurement goal;

    /**
     * The direction of the nutritional goal. (Minimum or Maximum)
     */
    private GoalDirection goalDirection = GoalDirection.MAXIMUM_GOAL;

    /**
     * Constructs a Member with a single, active empty nutrition plan with
     * the member name provided.
     * 
     * @param name The member's name.
     */
    public Member(String name) {
        this.name = name;
    }
    
    /**
     * Constructs a Member with information provided.
     * 
     * @param name The member's name.
     * @param goal The nutritional goal for the Member.
     */
    public Member(String name, Measurement goal, GoalDirection goalDirection) {
        this.name = name;
        this.goal = goal;
        this.goalDirection = goalDirection;
    }
    
    /**
     * Gets the member's name.
     * 
     * @return The member's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the member's name.
     * 
     * @param name The member's name.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Get the goal for the Member.
     * 
     * @return The goal for the Member.
     */
    public Measurement getGoal() {
        return this.goal;
    }

    /**
     * Sets the goal for the Member.
     * 
     * @param goal The goal for the Member.
     */
    public void setGoal(Measurement goal) {
        this.goal = goal;
    }

    /**
     * Gets the direction of the nutritional goals.
     */
    public GoalDirection getGoalDirection() {
        return this.goalDirection;
    }

    /**
     * Sets the direction of the nutritional goals.
     */
    public void setGoalDirection(GoalDirection goalDirection) {
        this.goalDirection = goalDirection;
    }
}
