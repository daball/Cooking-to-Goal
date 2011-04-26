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
     * The nutritional goal set for the Member.
     */
    private Measurement goal;

    /**
     * The direction of the nutritional goal. (Minimum or Maximum)
     */
    private GoalDirection goalDirection = GoalDirection.MAXIMUM_GOAL;

    /**
     * The nutrient to track.
     */
    private String trackedNutrient = "";
    
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
     * @param trackedNutrient The nutrient to track.
     * @param goal The nutritional goal for the Member.
     * @param goalDirection The direction of the goal.
     */
    public Member(String name, String trackedNutrient, Measurement goal, GoalDirection goalDirection) {
        this.name = name;
        this.trackedNutrient = trackedNutrient;
        this.goal = goal;
        this.goalDirection = goalDirection;
    }
    
    /**
     * Gets the member's name.
     * 
     * @return The member's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the member's name.
     * 
     * @param name The member's name.
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Get the goal for the Member.
     * 
     * @return The goal for the Member.
     */
    public Measurement getGoal()
    {
        return this.goal;
    }

    /**
     * Sets the goal for the Member.
     * 
     * @param goal The goal for the Member.
     */
    public void setGoal(Measurement goal)
    {
        this.goal = goal;
    }

    /**
     * Gets the direction of the nutritional goals.
     */
    public GoalDirection getGoalDirection()
    {
        return this.goalDirection;
    }

    /**
     * Sets the direction of the nutritional goals.
     */
    public void setGoalDirection(GoalDirection goalDirection)
    {
        this.goalDirection = goalDirection;
    }

   /**
     * Gets the nutrient to track.
     * 
     * @return The nutrient to track.
     */
    public String getTrackedNutrient()
    {
        return trackedNutrient;
    }

    /**
     * Sets the nutrient to track.
     * 
     * @param trackedNutrient The nutrient to track.
     */
    public void setTrackedNutrient(String trackedNutrient)
    {
        this.trackedNutrient = trackedNutrient;
    }
 
    @Override
    public boolean equals(Object object)
    {
       Member member = (Member)object;
       if (this.name.equals(member.name)
               && this.trackedNutrient.equals(member.trackedNutrient)
               && this.goal.equals(member.goal)
               && this.goalDirection == member.goalDirection)
           return true;
       return false;
    }
}
