package com.customfit.ctg;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.customfit.ctg.gui.GUIFrameMain;

/**
 * Links the view with the model.
 * @author S. D. Salyer
 *
 */
public class Controller implements ActionListener{

	private MealPlanner model;
	private GUIFrameMain gui;
	
	/**
	 * Constructor for the Controller.  Needs references 
	 * to the model and the view.
	 * @param model
	 * @param gui
	 */
	public Controller(MealPlanner model, GUIFrameMain gui){
		this.model = model;
		this.gui = gui;
		
		// Go!
		gui.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
	}
}
