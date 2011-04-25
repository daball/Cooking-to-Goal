package com.customfit.ctg.controller;

import com.customfit.ctg.model.Meal;
import com.customfit.ctg.model.Recipe;
import com.customfit.ctg.model.User;
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
        List<Meal> meals = UserManagement.getCurrentUser().getMeals();

        //now pass them to the overloaded method
        browseMenu(recipes, meals);
    }

    /**
     * Activates Browse Recipes application feature, which displays
     * a Browse Recipes JPanel in the main JFrame with the recipes
     * you have provided.
     *
     * @param recipes The list of recipes to browse through.
     */
    public static void browseMenu(List<Recipe> recipes, List<Meal> meals)
    {
        //create panel
        MealMenuPanel mealMenuPanel = new MealMenuPanel(MealMenuPanel.ListMode.LIST_BROWSE);
        //tell panel about our recipes
        mealMenuPanel.setRecipeList(recipes);
        mealMenuPanel.setMenuList(meals);
        //display panel in main frame
        Application.getMainFrame().setPanel(mealMenuPanel);
    }

    /**
     * Add the recipe to the meal.
     *
     * @param recipe
     * @param meal
     */
    public static void addRecipeToMenu(Recipe recipe, Meal meal) {
        User cUser = UserManagement.getCurrentUser();
        List<Meal> meals = cUser.getMeals();
        //for each m in meals
            //if (m.equals(meal)) {
                //m.addRecipe(recipe);
            //}
    }
}
