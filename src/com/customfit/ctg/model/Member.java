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

    public Member() {
        this.activeNutritionPlan = activeNutritionPlan;
        this.nutritionPlans.add(this.activeNutritionPlan);
    }
    
    public Member(List<NutritionPlan> nutritionPlans,
			NutritionPlan activeNutritionPlan) {
        this.nutritionPlans = nutritionPlans;
        this.activeNutritionPlan = activeNutritionPlan;
        this.nutritionPlans.add(this.activeNutritionPlan);
    }

    
    public void testMealRecipeAgainstActiveNutritionPlan(Recipe mealRecipe)
    {
        return testMealRecipeAgainstNutritionPlan(mealRecipe, this.activeNutritionPlan);
    }
    
    public void testMealRecipeAgainstNutritionPlan(Recipe mealRecipe, NutritionPlan activeNutritionPlan)
    {
        //compare
        mealRecipe.getNutritionInformation();
        activeNutritionPlan.get
    }
}
