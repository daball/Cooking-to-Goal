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
	    
	    File destDir = new File ("." + File.separator + "app_data" + File.separator + "recipes"); //recipes data directory
	    
	    if (!destDir.exists()) destDir.mkdirs();
	    
		try	{
			//open file
			fOut = new FileOutputStream(destDir.getCanonicalPath() + File.separator + recipe.getName() + "-serialized.dat", false);
		}
		catch (IOException ex) {
			try {
				System.err.println("There was a problem creating file at " + destDir.getCanonicalPath() + File.separator + recipe.getName() + "-serialized.dat" + ". Message:");
			} catch (IOException e) {
				System.err.println("There was a problem creating file at " + "." + File.separator + "app_data" + File.separator + "recipes" + File.separator + recipe.getName() + "-serialized.dat" + ". Message:");
			}
			System.err.print(ex.getMessage());
			System.err.println("Stack trace:");
			System.err.print(ex.getStackTrace());
			return false;
		}
		
		ObjectOutputStream oStream;
		try {
			//open object stream at file
			oStream = new ObjectOutputStream(fOut);
		}
		catch (IOException ex) {
			System.err.println("There was creating a serializable recipe object stream named after " + recipe.getName() + ". Message:");
			System.err.print(ex.getMessage());
			System.err.println("Stack trace:");
			System.err.print(ex.getStackTrace());
			return false;
		}
		
		try	{
			//write object
			oStream.writeObject(recipe);
		}
		catch (IOException ex) {
			System.err.println("There was writing a serializable recipe object named " + recipe.getName() + " to a file stream. Message:");
			System.err.print(ex.getMessage());
			System.err.println("Stack trace:");
			System.err.print(ex.getStackTrace());
			return false;
		}
		
		try {
			//close file
			fOut.close();
		}
		catch (IOException ex) {
			try {
				System.err.println("There was a problem closing file at " + destDir.getCanonicalPath() + File.separator + recipe.getName() + "-serialized.dat" + ". Message:");
			} catch (IOException e) {
				System.err.println("There was a problem closing file at " + "." + File.separator + "app_data" + File.separator + "recipes" + File.separator + recipe.getName() + "-serialized.dat" + ". Message:");
			}
			System.err.print(ex.getMessage());
			System.err.println("Stack trace:");
			System.err.print(ex.getStackTrace());
			return false;
		}
				
		return true;
	}
}