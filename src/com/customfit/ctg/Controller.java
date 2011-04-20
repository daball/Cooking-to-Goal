package com.customfit.ctg;

import com.customfit.ctg.data.DataDriverInterface;
import com.customfit.ctg.data.DataManager;
import com.customfit.ctg.data.FlatFileDriver;
import com.customfit.ctg.gui.GUIFrameMain;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.customfit.ctg.gui.manageusers.*;

/**
 * The Controller class for the 
 * Cooking to Goal application.
 * @author Drew, David
 */
public class Controller {
	private static GUIFrameMain guiMain;
	private static DataDriverInterface dataDriver;
	
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
                
		guiMain = new GUIFrameMain();
		guiMain.setVisible(true);

		//connect with filesystem data driver
		dataDriver = DataManager.acquireFlatFileDriver();
		
        //I recommend all GUI designers switch to NetBeans
        //for extremely easy coding. -David
    }
    
	/**
	 * @return the dataDriver
	 */
	public static DataDriverInterface getDataDriver() {
		return dataDriver;
	}

	/**
	 * @return the gui
	 */
	public static GUIFrameMain getMainFrame() {
		return guiMain;
	}
  
 }