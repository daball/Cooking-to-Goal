package com.customfit.ctg;

import javax.swing.JPanel;

import com.customfit.ctg.gui.GUIFrameMain;

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
}
