package com.customfit.ctg.model;

import com.customfit.ctg.controller.*;
import java.util.*;
        
/**
 * The Meal has a name, could be Breakfast, Lunch, Dinner,
 * Evening Date with Jenny, etc., and one or more recipes for
 * the meal.
 * 
 * @author David
 */
public class Meal {

    /**
     * The name of the meal, e.g. breakfast.
     */
    private String name = "";

    /**
     * The date/time the meal.
     */
    private Date date = null;
    
    /**
     * The list of recipes that constitutes a meal.
     */
    private List<Recipe> recipes = new ArrayList<Recipe>();
    
    /**
     * The list of members that constitutes a meal.
     */
    private List<Member> members = new ArrayList<Member>();

    /**
     * Gets the date/time the meal.
     * 
     * @return The date/time the meal.
     */
    public Date getDate()
    {
        return this.date;
    }

    /**
     * Sets the date/time the meal.
     * 
     * @param date The date/time the meal.
     */
    public void setDate(Date date)
    {
        this.date = date;
    }

    /**
     * Gets the name of the meal, e.g. breakfast.
     * 
     * @return The name of the meal.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Sets the name of the meal, e.g. breakfast.
     * 
     * @param name The name of the meal.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * The list of recipes that constitutes a meal.
     * 
     * @return The list of recipes that constitutes a meal.
     */
    public List<Recipe> getRecipes()
    {
        return recipes;
    }

    /**
     * Sets the list of recipes that constitutes a meal.
     * 
     * @param recipes The list of recipes that constitutes a meal.
     */
    public void setRecipes(List<Recipe> recipes)
    {
        this.recipes = recipes;
    }
    
    public void scaleAllRecipesToMemberNutritionalPlans() {

    }
    
    @Override
    public boolean equals(Object object)
    {
       Meal meal = (Meal)object;
       if (this.name.equals(meal.name)
               && this.date.equals(meal.date)
               && this.recipes.size() == meal.recipes.size()
               && this.members.size() == meal.members.size())
       {
           for (int recipe = 0; recipe < this.recipes.size(); recipe++)
           {
               if (!this.recipes.get(recipe).equals(meal.recipes.get(recipe)))
                   return false;
           }
           for (int member = 0; member < this.members.size(); member++)
           {
               if (!this.members.get(member).equals(meal.members.get(member)))
                   return false;
           }
           return true;
       }
       return false;
    }   
}