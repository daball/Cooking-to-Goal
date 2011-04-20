package com.customfit.ctg;

import com.customfit.ctg.gui.GUIFrameMain;

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
		GUIFrameMain gui = new GUIFrameMain(mp);	// View
		new Controller(mp, gui);					// Controller
	}
}
