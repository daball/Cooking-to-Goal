package com.customfit.ctg.controller;

import com.customfit.ctg.data.*;
import com.customfit.ctg.view.*;

/**
 * The Application class exists as the part of the Controller logic
 * that interfaces mainly with the application.
 * 
 * @author S. D. Salyer, David
 */
public class Application {

    /**
     * Holds the MainFrame used throughout the application
     * execution lifecycle.
     */
    private static MainFrame mainFrame;

    /**
     * Holds the data driver used throughout the application
     * execution lifecycle.
     */
    private static DataDriver dataDriver;

    /**
     * Holds the flat file driver used throughout the application
     * execution lifecycle.
     */
    private static FlatFileDriver flatFileDriver;

    /**
     * Launches the application. Our implementation ignores args.
     * @param args Command-line arguments.
     */
    public static void launch(String[] args)
    {		
        //setup filesystem data connection
        flatFileDriver = DataManager.acquireFlatFileDriver();

        //establish data connection
        //for now it will repeat a connection to the filesystem but may later use a db
        //TODO:Set this to use database driver once it is ready to go.
        try {
                dataDriver = DataManager.acquireDriver("com.customfit.ctg.data.FlatFileDriver");
        } catch (ClassNotFoundException e) {
                Application.dumpException("Error occurred while trying to load data driver.", e);
        } catch (InstantiationException e) {
                Application.dumpException("Error occurred while trying to load data driver.", e);
        } catch (IllegalAccessException e) {
                Application.dumpException("Error occurred while trying to load data driver.", e);
        }

        //create window
        mainFrame = new MainFrame();

        //tell UserManagement controller to present login screen
        UserManagement.presentLogin();

        //make the main frame visible (after it has been prepared)
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainFrame.setVisible(true);
            }
        });
    }

    /**
     * Gracefully shuts down the application.
     * @param exitCode Exit code to return to the operation system.
     */
    public static void exit(int exitCode)
    {
        //hide the main window
        Application.getMainFrame().setVisible(false);
        
        //close database connection
        Application.getDataDriver().close();
        
        //exit with exit code
        System.exit(exitCode);
    }

    /**
     * Gets the MainFrame used throughout the application
     * execution lifecycle.
     * 
     * @return The only MainFrame you should ever need.
     */
    public static MainFrame getMainFrame()
    {
        return mainFrame;
    }

    /**
     * Gets the DataDriver used throughout the application
     * execution lifecycle.
     * 
     * @return The only DataDriver you should ever need.
     */
    public static DataDriver getDataDriver()
    {
        return dataDriver;
    }

    /**
     * Gets the FlatFileDriver used throughout the application
     * execution lifecycle.
     * 
     * @return The only FlatFileDriver you should ever need.
     */
    public static FlatFileDriver getFlatFileDriver()
    {
        return flatFileDriver;
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