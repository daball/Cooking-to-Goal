package com.customfit.ctg.model;

import java.util.*;

/**
 * This describes a User of the system, including the user's name,
 * managed Members, and nutrition plans.
 * 
 * @author David
 */
public class User {

    /**
     * The user's name.
     */
    private String name;

    /**
     * The user's members.
     */
    private List<Member> members;

    /**
     * The list of nutrition plans for the user.
     */
    private List<NutritionPlan> nutritionPlans = new ArrayList<NutritionPlan>();
    
    /**
     * Constructs a user with the name provided.
     * 
     * @param name The user's name.
     */
    public User(String name){
        this.name = name;
    }

    /**
     * Constructs a user with the information provided.
     * 
     * @param name The user's name.
     * @param members The user's members.
     * @param nutritionPlans The list of nutrition plans for the user's member.
     */
    public User(String name, List<Member> members, List<NutritionPlan> nutritionPlans){
        this.name = name;
        this.members = members;
        this.nutritionPlans = nutritionPlans;
    }

    /**
     * Gets the user's name.
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
    
}