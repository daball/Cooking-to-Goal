/**
 * 
 */
package com.customfit.ctg.data;

import java.util.List;

import com.customfit.ctg.model.Recipe;

/**
 * The DerbyDataDriver class represents one of the DataDriverInterfaces
 * aimed at providing basic data operations for the application
 * for the local filesystem, as a data store.
 * 
 * @author David
 */
public class DerbyDataDriver implements DataDriverInterface {

	@Override
	public boolean connect(String connectionString) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Recipe> selectAllRecipes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Recipe> selectRecipesByName(String recipeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertRecipe(Recipe newRecipe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRecipeByName(String currentRecipeName,
			Recipe updatedRecipe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRecipe(String recipeName) {
		// TODO Auto-generated method stub
		return false;
	}

}
