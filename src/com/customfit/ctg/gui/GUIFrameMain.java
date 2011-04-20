package com.customfit.ctg.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.customfit.ctg.MealPlanner;
import com.customfit.ctg.gui.managemenu.GUIManageMenuPanel;

/**
 * The main GUI file
 * @author Drew and Ryan
 */
public class GUIFrameMain extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static final String APPLICATION_TITLE = "Cooking to Goal 1.0";
	private static final int WINDOW_WIDTH = 800,
							 WINDOW_HEIGHT = 600,
							 WINDOW_X = 100,
							 WINDOW_Y = 75;
	
	private JPanel panel;
	
	private MealPlanner model;		// The model the view displays
	
	/**
	 * Constructs the CTG GUI
	 */
	public GUIFrameMain(MealPlanner model){
		this.model = model;
		
		this.panel = new GUIManageMenuPanel();
		this.add(panel);
		
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setLocation(WINDOW_X, WINDOW_Y);
		this.setTitle(APPLICATION_TITLE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
	public void openPanel(JPanel p) {
		this.remove(panel);
		panel = p;
		this.add(panel);
		panel.revalidate();
	}
}
