package com.customfit.ctg;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The main GUI file
 * @author Drew
 */
public class GUIFrameMain extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private static final String APPLICATION_TITLE = "Cooking to Goal";
	private static final int WINDOW_WIDTH = 800,
							 WINDOW_HEIGHT = 600,
							 WINDOW_X = 100,
							 WINDOW_Y = 75;
	
	/**
	 * Constructs the CTG GUI
	 */
	public GUIFrameMain(){
		JPanel panel = new JPanel();
		
		panel.add(new JLabel("Hello World!"), JLabel.CENTER);
		
		this.add(panel);
		
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setLocation(WINDOW_X, WINDOW_Y);
		this.setTitle(APPLICATION_TITLE);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
