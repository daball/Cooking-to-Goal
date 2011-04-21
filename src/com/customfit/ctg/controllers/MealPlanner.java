package com.customfit.ctg.controllers;

import com.customfit.ctg.model.*;
import java.util.ArrayList;
import java.util.Iterator;



/**
 * The composite model of our data.
 * 
 * @author Drew
 */
public class MealPlanner { // implements Observable
	
	private static ArrayList<Recipe> menuList = new ArrayList<Recipe>();		// Stores Recipe objects for weekly menu

	/**
	 * Adds a user to the list
	 * @param u A User object
	 */
	public void addUser(User u){
		userList.add(u);
		notifyObservers();
	}
	
	/**
	 * Removes a User from the list
	 * @param u A user object
	 */
	public void removeUser(User u){
		userList.remove(u);
		notifyObservers();
	}
	
	/**
	 * Adds a Recipe to the list
	 * @param u A Recipe object
	 */
	public void addRecipe(Recipe r){
		recipeList.add(r);
		notifyObservers();
	}
	
	/**
	 * Removes a Recipe from the list
	 * @param u A Recipe object
	 */
	public void removeRecipe(Recipe r){
		recipeList.remove(r);
		notifyObservers();
	}
	
	/**
	 * Adds a Recipe to the Menu list
	 * @param u A Recipe object
	 */
	public void addRecipeToMenu(Recipe r){
		menuList.add(r);
		notifyObservers();
	}
	
	/**
	 * Removes a Recipe from the Menu list
	 * @param u A Recipe object
	 */
	public void removeRecipeFromMenu(Recipe r){
		menuList.remove(r);
		notifyObservers();
	}
	
	/**
	 * Retrieves the entire list of users.
	 * @return Array List of User objects
	 */
	public ArrayList<User> getUserList(){
		return this.userList;
	}
	
	/**
	 * Retrieves the entire list of recipes.
	 * @return Array List of Recipe objects
	 */
	public ArrayList<Recipe> getRecipeList(){
		return this.recipeList;
	}
	
	/**
	 * Retrieves the entire list of recipes from the Menu.
	 * @return Array List of Recipe objects
	 */
	public ArrayList<Recipe> getMenuList(){
		return this.menuList;
	}
	
	/**
	 * Add an observer to this model
	 * @param o
	 */
	public void registerObserver(Observer o){
		observers.add(o);
	}
	
}
