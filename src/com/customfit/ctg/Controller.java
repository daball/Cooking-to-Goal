package com.customfit.ctg;

import com.customfit.ctg.data.DataDriverInterface;
import com.customfit.ctg.data.DataManager;
import com.customfit.ctg.data.FlatFileDriver;
import com.customfit.ctg.gui.GUIFrameMain;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.customfit.ctg.gui.manageusers.*;

/**
 * The Controller class for the 
 * Cooking to Goal application.
 * @author Drew, David
 */
public class Controller {
	/**
	 * Holds the reference to the GUIFrameMain that
	 * draws the main window throughout the application
	 * execution.
	 * 
	 * It is created by main() as the JVM executes the app. 
	 */
	static GUIFrameMain guiMain;
	
	/**
	 * Holds the reference to the data driver used throughout
	 * the Controller(s).
	 * 
	 * This may be null if no driver is loaded.
	 * Be sure to make sure your driver is
	 * connected when using it. Otherwise use
	 * connect().
	 */
	static DataDriverInterface dataDriver;
	
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
		guiMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiMain.setVisible(true);

		//connect with filesystem data driver
		dataDriver = DataManager.acquireFlatFileDriver();
    }
    
	/**
	 * Gets the reference to the data driver used througout
	 * the Controller(s).
	 * 
	 * @return The data driver instance (or null otherwise).
	 */
	public static DataDriverInterface getDataDriver() {
		return dataDriver;
	}

	/**
	 * Gets the global GUIFrameMain instance.
	 * 
	 * @return The reference to the GUIFrameMain that
	 * draws the main window throughout the application
	 * execution.
	 */
	public static GUIFrameMain getMainFrame() {
		return guiMain;
	}
  
	/**
	 * This is used anywhere in the program in order to dump 
	 * as much info about the error as possible to stderr, while
	 * shortening implementation code by 5 lines per exception.
	 * There are lots of exceptions, so this was needed to shorten
	 * the code.
	 * 
	 * You can use this inside your try {} catch {} blocks to
	 * provide stderr listeners with lots of debug information.
	 * 
	 * @param message Message to dump.
	 * @param exception Exception.
	 */
	public static void dumpException(String message, Exception exception)
	{
		System.err.println("ERROR: An exception has been handled. Message:");
		System.err.println(message);
		System.err.println("Exception message:");
		System.err.print(exception.getMessage());
		System.err.println("Stack trace:");
		System.err.print(exception.getStackTrace());	
	}
}