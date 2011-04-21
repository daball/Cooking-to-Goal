package com.customfit.ctg.data;

import java.util.List;
import com.customfit.ctg.model.*;

/**
 * The DataDriverInterface describes the required functionality
 * for any data storage mechanism for the Cooking to Goal application.
 *   
 * @author David
 */
public interface DataDriver {
	/**
	 * Set up connection to database.
	 *  
	 * @param connectionString Most data connections use a JDBC connection string,
	 * but could be implemented in any manner needed. Each driver will have it's own
	 * way of handling this function.
	 * 
	 * @return Boolean indicating connection success, true if connected, false if not connected.
	 */
	public boolean connect(String connectionString);

	/**
	 * Close database connection.
	 */
	public void close();

	/**
	 * Tests connection to database.
	 *  
	 * @return Boolean indicating connection status, true if connected, false if not connected.
	 */
	public boolean isConnected();

	/**
	 * Returns a list of all Recipes.
	 * 
	 * @return A list of all Recipe objects, or an empty list if none.
	 */
	public List<Recipe> selectAllRecipes();

	/**
	 * Returns a list of Recipes, by matching the name.
	 * 
	 * @param recipeName Recipe name.
	 * 
	 * @return List of Recipe objects, or an empty list if none.
	 */
	public List<Recipe> selectRecipesByName(String recipeName);

	/**
	 * Saves a new Recipe object.
	 * 
	 * @param newRecipe A Recipe object.
	 * 
	 * @return Boolean indicating the success of the operation.
	 */
	public boolean insertRecipe(Recipe newRecipe);

	/**
	 * Updates a saved Recipe object.
	 * 
	 * @param currentRecipeName The prior name for the recipe, which may or may not
	 * be the same as the one in updatedRecipe.
	 * @param updatedRecipe The updated Recipe object.
	 *  
	 * @return Boolean indicating the success of the operation.
	 */
	public boolean updateRecipeByName(String currentRecipeName, Recipe updatedRecipe);

	/**
	 * Removes a Recipe object from the database.
	 * 
	 * @param recipeName The recipe's name.
	 * 
	 * @return Boolean indicating the success of the operation.
	 */
	public boolean deleteRecipeByName(String recipeName);
	
	/**
	 * Returns a list of all Users.
	 * 
	 * @return A list of all User objects, or an empty list if none.
	 */
	public List<User> selectAllUsers();
	
	/**
	 * Returns a list of all Users, by matching the name.
	 * 
	 * @param userName User name.
	 * 
	 * @return List of User objects, or an empty list if none.
	 */
	public List<User> selectUsersByName(String userName);
	
	/**
	 * Saves a new User object.
	 * 
	 * @param newUser A User object.
	 * 
	 * @return Boolean indicating the success of the operation.
	 */
	public boolean insertUser(User newUser);

	/**
	 * Updates a saved User object.
	 * 
	 * @param currentUserName The prior name for the user, which may or may not
	 * be the same as the one in updatedUser.
	 * @param updatedUser The updated User object.
	 *  
	 * @return Boolean indicating the success of the operation.
	 */
	public boolean updateUserByName(String currentUserName, User updatedUser);

	/**
	 * Removes a User object from the database.
	 * 
	 * @param userName The user's name.
	 * 
	 * @return Boolean indicating the success of the operation.
	 */
	public boolean deleteUserByName(String userName);
}