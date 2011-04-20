package com.customfit.ctg;

import javax.swing.JPanel;

import com.customfit.ctg.gui.GUIFrameMain;
import com.customfit.ctg.model.NutritionPlan;
import com.customfit.ctg.model.Recipe;
import com.customfit.ctg.model.User;

/**
 * Links the view with the model.
 * @author S. D. Salyer
 *
 */
public class Controller {

	private MealPlanner model;
	private GUIFrameMain gui;
	
	/**
	 * Constructor for the Controller.  Needs references 
	 * to the model and the view.
	 * @param model
	 * @param gui
	 */
	public Controller(MealPlanner model){
		this.model = model;
		this.gui = new GUIFrameMain(model, this);	// View;
		
		// Go!
		gui.setVisible(true);
	}
	
	/**
	 * @param p Is the JPanel you would like to open.
	 */
	public void openPanel(JPanel panel) {
		model.registerObserver((Observer) panel);
		gui.openPanel(panel);
	}
	
	
	/**
	 * Creates a new Recipe with name only.
	 * @param name
	 * @return The created Recipe
	 */
	public Recipe createRecipe(String name){
		Recipe newRecipe = new Recipe(name);
		model.addRecipe(newRecipe);
		return newRecipe;
	}
	
	/**
	 * Creates a new user with name only and adds them to the list
	 * @param name
	 * @return The created user
	 */
	public User createUser(String name){
		User newUser = new User(name);
		model.addUser(newUser);
		return newUser;
	}
	
	/**
	 * Creates a new user with name and nutrition plan and adds them to the list
	 * @return The created user
	 */
	public User createUser(String name, NutritionPlan np){
		User newUser = createUser(name);
		newUser.setActiveNutritionPlan(np);
		return newUser;
	}
}
