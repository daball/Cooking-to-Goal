package com.customfit.ctg.controller;

import com.customfit.ctg.model.Recipe;
import com.customfit.ctg.view.meal.MealMenuPanel;
import java.util.List;


/**
 * The composite model of our data.
 * 
 * @author Drew, David
 */
public class MealPlanner { // implements Observable

    //needs restructuring
    //particularly, the model for Meal needs to be developed first

    /**
     * Activates Browse Recipes application feature, which displays
     * a Browse Recipes JPanel in the main JFrame from the list
     * of all known recipes in the Controller's default database.
     */
    public static void browseMenu()
    {
        //recipes not provided, so go get them
        List<Recipe> recipes = Application.getDataDriver().selectAllRecipes();

        //now pass them to the overloaded method
        browseMenu(recipes);
    }

    /**
     * Activates Browse Recipes application feature, which displays
     * a Browse Recipes JPanel in the main JFrame with the recipes
     * you have provided.
     *
     * @param recipes The list of recipes to browse through.
     */
    public static void browseMenu(List<Recipe> recipes)
    {
        //create panel
        MealMenuPanel mealMenuPanel = new MealMenuPanel(MealMenuPanel.ListMode.LIST_BROWSE);
        //tell panel about our recipes
        mealMenuPanel.setRecipeList(recipes);
        //display panel in main frame
        Application.getMainFrame().setPanel(mealMenuPanel);
    }
}
