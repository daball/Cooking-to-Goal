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
		FileOutputStream fOut;
		try	{
			//open file
			fOut = new FileOutputStream("./app_data/recipes/" + recipe.getName() + "-serialized.xml", false);
		}
		catch (IOException ex) {
			System.err.println("There was a problem creating file at " + "./app_data/recipes/" + recipe.getName() + "-serialized.xml. Message:");
			System.err.println(ex.getMessage());
			System.err.println("Stack trace:");
			System.err.println(ex.getStackTrace());
			return false;
		}
		
		ObjectOutputStream oStream;
		try {
			//open object stream at file
			oStream = new ObjectOutputStream(fOut);
		}
		catch (IOException ex) {
			System.err.println("There was creating a serializablre recipe object stream named after " + recipe.getName() + ". Message:");
			System.err.println(ex.getMessage());
			System.err.println("Stack trace:");
			System.err.println(ex.getStackTrace());
			return false;
		}
		
		try	{
			//write object
			oStream.writeObject(recipe);
		}
		catch (IOException ex) {
			System.err.println("There was writing a serializablre recipe object named " + recipe.getName() + " to a file stream. Message:");
			System.err.println(ex.getMessage());
			System.err.println("Stack trace:");
			System.err.println(ex.getStackTrace());
			return false;
		}
		
		try {
			//close file
			fOut.close();
		}
		catch (IOException ex) {
			System.err.println("There was a problem closing file at " + "./app_data/recipes/" + recipe.getName() + "-serialized.xml. Message:");
			System.err.println(ex.getMessage());
			System.err.println("Stack trace:");
			System.err.println(ex.getStackTrace());
			return false;
		}
				
		return true;
	}
}