package com.customfit.ctg;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * @author Steven T
 * 
 */
public class GUIMainButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton viewGoals;
	private JButton manageUsers;
	private JButton manageRecipes;
	private JButton printList;

	// JButton buttonExit;

	public GUIMainButtonPanel() {
		this.setLayout(new BorderLayout());
		
		this.setPreferredSize(new Dimension(350, 100)); //sets the size for the JPanel
		this.viewGoals = new JButton("View Goals"); //creates an instance of the buttons
		this.manageUsers = new JButton("Manage Users");
		this.manageRecipes = new JButton("Manage Recipes");
		this.printList = new JButton("Print List");
//		this.buttonExit = new JButton("Exit");
		viewGoals.setPreferredSize(new Dimension(120, 30)); //sets the buttons sizes
		manageUsers.setPreferredSize(new Dimension(120, 30));
		manageRecipes.setPreferredSize(new Dimension(120, 30));
		printList.setPreferredSize(new Dimension(120, 30));
//		buttonExit.setPreferredSize(new Dimension(120, 30));
		ViewGoalsListener viewGoalsListener = new ViewGoalsListener(); //creates listeners
		ManageUsersListener manageUsersListener = new ManageUsersListener();
		ManageRecipesListener manageRecipesListener = new ManageRecipesListener();
		PrintListListener printListListener = new PrintListListener();
		viewGoals.addActionListener(viewGoalsListener); //adds listeners to the buttons
		manageUsers.addActionListener(manageUsersListener);
		manageRecipes.addActionListener(manageRecipesListener);
		printList.addActionListener(printListListener);
//		buttonExit.addActionListener(exitListener);
		this.setLayout(new FlowLayout()); //sets the layout for the buttons
		this.add(viewGoals); //adds buttons to the subpanel
		this.add(manageUsers);
		this.add(manageRecipes);
		this.add(printList);
//		buttonSubpanel.add(buttonExit);

	}
	
	private class ViewGoalsListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			
			
		}
		
	}
	
	
	private class ManageUsersListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			
			
		}
		
	}
	
	private class ManageRecipesListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			
			
		}
		
	}
	
	private class PrintListListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			
			
		}
		
	}
	
}
