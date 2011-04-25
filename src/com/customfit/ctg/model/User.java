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
     * The user's members.
     */
    private List<Member> members;
    
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
        this.members = new ArrayList<Member>();
        this.members.add(new Member(name));
    }

    /**
     * Constructs a user with the information provided.
     * 
     * @param name The user's name.
     * @param members The user's members.
     * @param meals The list of meals for the user.
     */
    public User(String name, List<Member> members, List<Meal> meals)
    {
        this.name = name;
        this.members = members;
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
    }
    
    /**
     * Gets the user's members.
     * 
     * @return The user's members.
     */
    public List<Member> getMembers()
    {
        return members;
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