package com.customfit.ctg.model;

import java.util.*;

/**
 * This describes a User of the system, including the user's name,
 * managed Members, and nutrition plans.
 * 
 * @author David
 */
public class User
{

    /**
     * The user's name.
     */
    private String name;

    /**
     * The plans for the members.
     */
    private NutritionPlan nutritionPlan;
    
    /**
     * The list of meals for the user.
     */
    private List<Meal> meals = new LinkedList<Meal>();
    
    /**
     * Constructs a user with the name provided.
     * 
     * @param name The user's name.
     */
    public User(String name)
    {
        this.name = name;
        this.nutritionPlan = new NutritionPlan(name);
    }

    /**
     * Constructs a user with the information provided.
     * 
     * @param name The user's name.
     * @param nutritionPlan The nutrition plan for the user.
     * @param meals The list of meals for the user.
     */
    public User(String name, NutritionPlan nutritionPlan, List<Meal> meals)
    {
        this.name = name;
        this.nutritionPlan = nutritionPlan;
        this.meals = meals;
    }

    /**
     * Gets the user's name.
     * 
     * @return The user's name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the user's name.
     * 
     * @param name The user's name.
     */
    public void setName(String name)
    {
        this.name = name; 
        if (this.nutritionPlan == null)
            this.nutritionPlan = new NutritionPlan(name);
        else
            this.nutritionPlan.setName(name);
    }
    
    /**
     * Gets the List of NutritionPlans for the user.
     * 
     * @return The list of nutrition plans for the user.
     */
    public NutritionPlan getNutritionPlan()
    {
            return nutritionPlan;
    }
        
    /**
     * Gets the list of meals for the user.
     * 
     * @return The list of meals for the user.
     */
    public List<Meal> getMeals()
    {
        return meals;
    }
   
}