package com.customfit.ctg.model;

import java.util.*;

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
     * The active nutrition plan for the user's member.
     */
    private NutritionPlan activeNutritionPlan = new NutritionPlan("Default Plan");

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
     * @param activeNutritionPlan The active nutrition plan for the user's member.
     */
    public Member(String name, NutritionPlan activeNutritionPlan) {
        this.name = name;
        this.activeNutritionPlan = activeNutritionPlan;
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
    
    public void calculateNutritionPlanEffectiveness() {}
    public void calculateActiveNutritionPlanEffectiveness() {}
//    public void testMealRecipeAgainstActiveNutritionPlan(Recipe mealRecipe)
//    {
//        return testMealRecipeAgainstNutritionPlan(mealRecipe, this.activeNutritionPlan);
//    }
//    
//    public void testMealRecipeAgainstNutritionPlan(Recipe mealRecipe, NutritionPlan activeNutritionPlan)
//    {
//        //compare
//        mealRecipe.getNutritionInformation();
//        activeNutritionPlan.get
//    }
}
