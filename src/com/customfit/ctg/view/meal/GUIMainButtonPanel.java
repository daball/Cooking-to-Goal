package com.customfit.ctg.view.meal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.customfit.ctg.controllers.Application;
import com.customfit.ctg.view.recipes.GUIManageRecipesPanel;
import com.customfit.ctg.view.users.GUIManageUsersPanel;


/**
 * 
 * @author Steven T
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

		GUIListener gl = new GUIListener();
		viewGoals.addActionListener(gl); //adds listeners to the buttons
		manageUsers.addActionListener(gl);
		manageRecipes.addActionListener(gl);
		printList.addActionListener(gl);
		
		this.setLayout(new FlowLayout()); //sets the layout for the buttons
		this.add(viewGoals); //adds buttons to the subpanel
		this.add(manageUsers);
		this.add(manageRecipes);
		this.add(printList);
		this.add(exit);

	}
	
	/**
	 * Listener for this button panel.
	 * Commands should be sent to the Controller
	 * @author S. D. Salyer
	 *
	 */
	private class GUIListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource().equals(viewGoals)){
				// do something
			}
			else if(ae.getSource().equals(manageUsers)){
				Application.openPanel(new GUIManageUsersPanel());
			}
			else if(ae.getSource().equals(manageRecipes)){
				Application.openPanel(new GUIManageRecipesPanel());
			}
			else if(ae.getSource().equals(printList)){
				// do something
			}
			else if(ae.getSource().equals(manageUsers)){
				System.exit(0);
			}
			else{
				// Shouldn't be here
			}
		}
	} // end private inner class

}
