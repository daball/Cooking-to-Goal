package com.customfit.ctg;

import com.customfit.ctg.gui.GUIFrameMain;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * The Controller class for the 
 * Cooking to Goal application.
 * @author Drew
 */
public class Controller {
	
	/**
	 * The main entry point for the 
	 * Cooking to Goal application.
	 * @param args
	 */
	public static void main(String args[]) {
		//make this look more like Windows, Linux, or whatever
		//besides that junky metal look
        try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//create main window
        GUIFrameMain gui = new GUIFrameMain();
        
        //display main window
        gui.setVisible(true);
        
        //I recommend all GUI designers switch to NetBeans
        //for extremely easy coding. -David
	}

}