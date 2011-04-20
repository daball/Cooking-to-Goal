package com.customfit.ctg.gui.managemenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.customfit.ctg.Controller;
import com.customfit.ctg.gui.GUIFrameMain;
import com.customfit.ctg.gui.manageusers.GUIManageUsersPanel;

/**
 * 
 * @author Steven T
 * 
 */
public class GUIMainButtonPanel extends JPanel {
	JButton viewGoals;
	JButton manageUsers;
	JButton manageRecipes;
	JButton printList;
	JButton exit;

	// JButton buttonExit;

	public GUIMainButtonPanel() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(350, 100)); //sets the size for the JPanel
		this.viewGoals = new JButton("View Goals"); //creates an instance of the buttons
		this.manageUsers = new JButton("Manage Users");
		this.manageRecipes = new JButton("Manage Recipes");
		this.printList = new JButton("Print List");
		this.exit = new JButton("Exit");
		viewGoals.setPreferredSize(new Dimension(160, 30)); //sets the buttons sizes
		manageUsers.setPreferredSize(new Dimension(160, 30));
		manageRecipes.setPreferredSize(new Dimension(160, 30));
		printList.setPreferredSize(new Dimension(160, 30));
		exit.setPreferredSize(new Dimension(160, 30));
		ViewGoalsListener viewGoalsListener = new ViewGoalsListener(); //creates listeners
		ManageUsersListener manageUsersListener = new ManageUsersListener();
		ManageRecipesListener manageRecipesListener = new ManageRecipesListener();
		PrintListListener printListListener = new PrintListListener();
		viewGoals.addActionListener(viewGoalsListener); //adds listeners to the buttons
		manageUsers.addActionListener(manageUsersListener);
		manageRecipes.addActionListener(manageRecipesListener);
		printList.addActionListener(printListListener);
		this.setLayout(new FlowLayout()); //sets the layout for the buttons
		this.add(viewGoals); //adds buttons to the subpanel
		this.add(manageUsers);
		this.add(manageRecipes);
		this.add(printList);
		this.add(exit);

	}
	
	private class ViewGoalsListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			
			
		}
		
	}
	
	
	private class ManageUsersListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
//TODO: Outsource this to a Controller and call the Controller up from here
			Controller.getMainFrame().openPanel(new GUIManageUsersPanel());
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
	
	public class ExitListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			System.exit(0);
		}// end actionPerformed
	}
	
}
