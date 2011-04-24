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
     * The list of members that will be dining at the meal.
     */
    private List<Member> members = new ArrayList<Member>();

    /**
     * Gets the date/time the meal.
     * 
     * @return The date/time the meal.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the date/time the meal.
     * 
     * @param date The date/time the meal.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets the list of members that will be dining at the meal.
     * 
     * @return The list of members that will be dining at the meal.
     */
    public List<Member> getMembers() {
        return members;
    }

    /**
     * Sets the list of members that will be dining at the meal.
     * @param members The list of members that will be dining at the meal.
     */
    public void setMembers(List<Member> members) {
        this.members = members;
    }

    /**
     * Gets the name of the meal, e.g. breakfast.
     * 
     * @return The name of the meal.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the meal, e.g. breakfast.
     * 
     * @param name The name of the meal.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The list of recipes that constitutes a meal.
     * 
     * @return The list of recipes that constitutes a meal.
     */
    public List<Recipe> getRecipes() {
        return recipes;
    }

    /**
     * Sets the list of recipes that constitutes a meal.
     * 
     * @param recipes The list of recipes that constitutes a meal.
     */
    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    
}