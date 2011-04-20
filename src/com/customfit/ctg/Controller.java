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
	 * openPanel is used by any panel that needs to open a different panel
	 * inside of this frame.  To use this method, pass this frame to
	 * the panel (via the constructor is the easiest).
	 * 
	 * Caution: This will destroy the current panel, so make sure you save
	 * all critical data before hand. (we could us a stack or list to make it
	 * a bit smarter, but for now this should do the trick.)
	 * 
	 * @param p Is the JPanel you would like to open.
	 */
	public void openPanel(JPanel panel) {
		gui.remove(gui.getComponentAt(0, 0));
		gui.add(panel);
		gui.setContentPane(panel);
	}
}
