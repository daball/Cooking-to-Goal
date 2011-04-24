package com.customfit.ctg.model;

import java.util.*;

/**
 * This describes a User of the system, including the user's name
 * and managed Members.
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
     * Constructs a user with a single, active empty nutrition plan with
     * the user name provided.
     * 
     * @param name The user's name.
     */
    public User(String name){
        this.setName(name);
    }

    /**
     * Constructs a user with a single, active empty nutrition plan with
     * the user name provided.
     * 
     * @param name The user's name.
     */
    public User(String name, List<Member> members){
        this.setName(name);
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
}