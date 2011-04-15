/**
 * 
 */
package com.customfit.ctg.data;

import java.util.List;
import com.customfit.ctg.Recipe;
import java.io.*;

/**
 * @author David
 *
 */
public class RecipeFileAccess implements FileAccessDriverInterface<Recipe> {

	@Override
	public List<Recipe> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveObject(Recipe recipe) {
		FileWriter writer;
		try
		{
			writer = new FileWriter("./app_data/recipes/" + recipe.getName() + "-serialized.xml", false);
		}
		catch (Exception ex)
		{
			System.err.println("There was a problem creating file at " + "./app_data/recipes/" + recipe.getName() + "-serialized.xml. Message:");
			System.err.println(ex.getMessage());
			return false;
		}
			ObjectOutputStream outStream = new ObjectOutputStream();
		
		// TODO Auto-generated method stub
		
		return true;
	}


}
