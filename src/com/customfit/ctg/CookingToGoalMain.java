package com.customfit.ctg;

import com.customfit.ctg.controllers.Application;

/**
 * The main entry point for the CTG application.
 * Hands control of the application over to the
 * Application controller.
 * 
 * @author S. D. Salyer, Drew
 *
 */
public class CookingToGoalMain {

	/**
	 * The main entry point for the CTG application.
	 * Hands control of the application over to the
	 * Application controller.
	 * 
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args){
		//Tell Application controller to launch the application
		Application.launch(args);
	}
}