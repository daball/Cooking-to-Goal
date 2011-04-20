package com.customfit.ctg;

/**
 * The main entry point for the CTG application.
 * Creates the Model, the View, and the Controller.
 * @author S. D. Salyer
 *
 */
public class CTGMain {

	/**
	 * The main method creates the model, view, and controller.
	 * The controller takes over application control from there.
	 * @param args
	 */
	public static void main(String[] args){
		MealPlanner mp = new MealPlanner();			// Model
													// View created in controller
		new Controller(mp);							// Controller
	}
}
