package com.customfit.ctg;

import com.customfit.ctg.data.*;
import com.customfit.ctg.model.*;
import java.util.*;

public class RecipeManagement {

	public static void browseRecipes()
	{
		FlatFileDriver driver = DataManager.acquireFlatFileDriver();
		List<Recipe> recipes = driver.selectAllRecipes();
		
		System.out.println("Recipe list:");
		for (Recipe r : recipes)
			System.out.println(r.getName());
		
	}
}
