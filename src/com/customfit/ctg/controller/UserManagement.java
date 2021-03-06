package com.customfit.ctg.controller;

import com.customfit.ctg.model.*;
import com.customfit.ctg.view.*;
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
     * Once user login has succeeded, then keep track of it for
     * later.
     */
    private static User currentUser;
    
    /**
     * Gets currently logged in user.
     * @return Currently logged in user.
     */
    public static User getCurrentUser()
    {
        return currentUser;
    }
    
    /**
     * Activates Register User application feature, which in this case
     * displays a Register User JPanel to prepare a new User object
     * for storage. If you already have a User object, use the
     * overloaded method.
     */
    public static void registerUser()
    {
        //create panel
        EditProfilePanel newUserPanel = new EditProfilePanel(CreateEditMode.CREATE);
        //display panel in main frame
        Application.getMainFrame().setPanel(newUserPanel);
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
        //save it here
        UserManagement.currentUser = user;
        //send it over to the database
        boolean status = Application.getDataDriver().insertUser(user);
        //check for errors
        if (!status)
            //if failed, tell user about the failure
            JOptionPane.showMessageDialog(Application.getMainFrame(), "There was a problem registering your user.", "Error", JOptionPane.ERROR_MESSAGE);
        else
            //otherwise, assume success and present home
            UserManagement.viewHome(user);
        //return status
        return status;
    }

    /**
     * Activates View Home application feature, which displays
     * a View Profile JPanel to display the profile of the provided
     * User object.
     * 
     * @param user The user for which there is a profile to show in view.
     */
    public static void viewHome(User user)
    {
        //create profile panel
        HomePanel profilePanel = new HomePanel();
        //load the user data into the profile panel
        profilePanel.setUser(user);
        //display panel in main frame
        Application.getMainFrame().setPanel(profilePanel);
    }
    
    /**
     * Activates View Home application feature, which displays
     * a View Profile JPanel to display the profile of the provided
     * User object, for the currently logged in user.
     */
    public static void viewHome()
    {
        //call overload
        viewHome(currentUser);
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
        //get currently loaded frame
        SubPanel currentPanel = Application.getMainFrame().getPanel();
        //create panel
        EditProfilePanel editProfilePanel = new EditProfilePanel(CreateEditMode.CREATE.EDIT);
        //load the user into the profile panel
        editProfilePanel.setUser(user);
        //display panel in main frame
        Application.getMainFrame().setPanel(editProfilePanel);
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
    public static boolean updateRegistrationAndGoBack(String originalUserName, User newUser)
    {
        boolean status = Application.getDataDriver().updateUserByName(originalUserName, newUser);
        UserManagement.currentUser = newUser;
         //check for errors
        if (!status)
            //if failed, tell user about the failure
            JOptionPane.showMessageDialog(Application.getMainFrame(), "There was a problem updating your user registration.", "Error", JOptionPane.ERROR_MESSAGE);
        else
        {
            //now login user
            UserManagement.finishLogin(newUser);
        }
       return status;
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
        boolean status = false;
        //be sure to ask for a confirmation first, if they click OK
        if (JOptionPane.showConfirmDialog(Application.getMainFrame(), "Are you sure you want to delete the profile for " + userName + "? All profile data will be deleted. This cannot be reversed.", "Delete Profile Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
        {
            //then do the delete
            status = Application.getDataDriver().deleteUserByName(userName);
             //check for errors
            if (!status)
                //if failed, tell user about the failure
                JOptionPane.showMessageDialog(Application.getMainFrame(), "There was a problem deleting your profile.", "Error", JOptionPane.ERROR_MESSAGE);
            else
                //if all went well go back to login screen, since the user is now dead
                UserManagement.presentLogin();
        }
        //turn the status back over
        return status;
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
        //call overloaded
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
        //check to see if this is the first go around
        if (users.size() > 0)
        {
            //and if not, then create login panel
            LoginPanel loginPanel = new LoginPanel();
            //tell login panel about our user list
            loginPanel.setUserList(users);
            //display panel in main frame
            Application.getMainFrame().setPanel(loginPanel);
        }
        else
        {
            //if it is, then welcome guest to new application
            FirstTimeUserPanel firstTimePanel = new FirstTimeUserPanel();
            //display panel in main frame
            Application.getMainFrame().setPanel(firstTimePanel);
       }
    }
    
    /**
     * Finishes login and presents user with profile home.
     * 
     * @param user User that was just logged in.
     */
    public static void finishLogin(User user)
    {
        //save login
        currentUser = user;
        //show user profile home
        UserManagement.viewHome();
    }
    
    /**
     * Logs current user out and presents user with login screen.
     */
    public static void logout()
    {
        //erase current login
        currentUser = null;
        //present login screen
        UserManagement.presentLogin();
    }
    
}