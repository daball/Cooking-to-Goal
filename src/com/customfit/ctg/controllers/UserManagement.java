package com.customfit.ctg.controllers;

import com.customfit.ctg.model.*;
import com.customfit.ctg.view.users.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * The UserManagement Controller logic represents the actions that
 * directly involve user management, and are responsible for
 * establishing all the use cases for User Management. This class
 * must set up a function for each use.
 * 
 * @author David
 */
public class UserManagement {

    /**
     * Activates Register User application feature, which in this case
     * displays a Register User JPanel to prepare a new User object
     * for storage. If you already have a User object, use the
     * overloaded method.
     */
    public static void registerUser()
    {
        //create register panel
        RegisterPanel registerPanel = new RegisterPanel();
        //display panel in main frame
        Application.getMainFrame().setPanel(registerPanel);
    }

    /**
     * Activates Register User application feature, which in this case
     * sends the User object over to the Controller's default data driver
     * and then shows the Login User view again.
     * 
     * This method is also used as a callback from the Enroll User JPanel
     * upon saving the newly created User.
     * 
     * @param user The completed User object ready to store.
     * 
     * @return Boolean indicating the success of the operation. 
     */
    public static boolean registerUserAndPresentLogin(User user)
    {
        //send it over to the database
        boolean status = Application.getDataDriver().insertUser(user);
        //checek for errors
        if (!status)
            //if failed, tell user about the failure
            JOptionPane.showMessageDialog(Application.getMainFrame(), "There was a problem registering your user.");
        else
            //otherwise, assume success and present login
            UserManagement.presentLogin();
        //return status
        return status;
    }

    /**
     * Activates View Profile application feature, which displays
     * a View Profile JPanel to display the profile of the provided
     * User object.
     * 
     * @param user The user for which there is a profile to show in view.
     */
    public static void viewProfile(User user)
    {
        //create profile panel
        ProfilePanel profilePanel = new ProfilePanel();
        //load the user into the profile panel
        profilePanel.setUser(user);
        //display panel in main frame
        Application.getMainFrame().setPanel(profilePanel);
    }

    /**
     * Activates Edit Registration application feature, which displays
     * an Edit Registration JPanel to permit end user to edit the contents of the
     * provided User object.
     * 
     * @param user The user for which there is a profile to edit in view.
     */
    public static void editRegistration(User user)
    {
        //method stub:
        //	replace this CLI-code with GUI-initiation code
        System.err.println("editRegstration() hit: User " + "Name" + ": " + user.getName() + ". Feature not currently implemented.");
        /* 
         * example pseudocode:
         * 		instantiate JPanel for viewing User
         * 		pass recipe to a special function in JPanel for processing List<User>
         * 		Controller.getMainFrame().setPanel( list panel )
         * TODO: replace this with GUI initialization code for Create User
         */
    }

    /**
     * Activates Update User application feature, which updates the User
     * record in the database.
     * 
     * @param originalUserName The user's original name, used to locate the recipe in the database.
     * @param newUser The new user data.
     * 
     * @return Boolean indicating the success of the operation. 
     */
    public static boolean updateUser(String originalUserName, User newUser)
    {
        return Application.getDataDriver().updateUserByName(originalUserName, newUser);
    }

    /**
     * Activates Delete User application feature, which deletes the User
     * record in the database.
     * 
     * @param userName The user's name, used to locate the user in the database.
     * 
     * @return Boolean indicating the success of the operation. 
     */
    public static boolean deleteUser(String userName)
    {
        return Application.getDataDriver().deleteUserByName(userName);
    }

    /**
     * Activates Delete User application feature, which deletes the User
     * record in the database.
     * 
     * @param user The user to delete.
     * 
     * @return Boolean indicating the success of the operation. 
     */
    public static boolean deleteUser(User user)
    {
        return deleteUser(user.getName());
    }

    /**
     * Activates Login User application feature, which presents the user
     * with a login prompt in the current view.
     */
    public static void presentLogin()
    {
        //get list of users
        List<User> users = Application.getDataDriver().selectAllUsers();
        //create login panel
        LoginPanel loginPanel = new LoginPanel();
        //tell login panel about our user list
        loginPanel.setUserList(users);
        //display panel in main frame
        Application.getMainFrame().setPanel(loginPanel);
    }
}