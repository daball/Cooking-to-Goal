/**
 * 
 */
package com.customfit.ctg.data;

import java.util.List;
import com.customfit.ctg.Recipe;

/**
 * The DataDriverInterface describes the required functionality
 * for any data storage mechanism for the Cooking to Goal application.  
 * @author David
 */
public interface DataDriverInterface {
	/**
	 * Set up connection to database. 
	 * @param connectionString Most data connections use a JDBC connection string,
	 * but could be implemented in any manner needed. Each driver will have it's own
	 * way of handling this function.
	 * @return Boolean indicating connection success, true if connected, false if not connected.
	 */
	public boolean connect(String connectionString);
	
	/**
	 * Close database connection.
	 */
	public void close();

	/**
	 * Tests connection to database. 
	 * @return Boolean indicating connection status, true if connected, false if not connected.
	 */
	public boolean isConnected();
	
	/**
	 * Returns a list of all Recipes.
	 * 
	 * Hint: Try using the getRecipe() function if you only need one Recipe
	 * object. There is an overhead for repeated round-trips to the database
	 * for exporting the whole table.
	 * 
	 * @return A list of all Recipe objects, or an empty list if none.
	 */
	public List<Recipe> selectAllRecipes();
	
	/**
	 * Returns a list of Recipes, by matching the name.
	 * @param String Recipe name.
	 * @return Recipe object, or null if non-existant.
	 */
	public List<Recipe> selectRecipesByName(String recipeName);
	
	/**
	 * Saves a new Recipe object.
	 * @param Recipe A Recipe object.
	 * @return Boolean indicating the success of the operation.
	 */
	public boolean insertRecipe(Recipe newRecipe);
	
	/**
	 * Updates a saved Recipe object.
	 * @param String The prior name for the recipe, which may or may not
	 * be the same as the one in updatedRecipe.
	 * @param Recipe The updated Recipe object. 
	 * @return Boolean indicating the success of the operation.
	 */
	public boolean updateRecipeByName(String currentRecipeName, Recipe updatedRecipe);
	
	/**
	 * Removes a Recipe object from the database.
	 * @param recipeName The recipe's name.
	 * @return Boolean indicating the success of the operation.
	 */
	public boolean deleteRecipe(String recipeName);
}
