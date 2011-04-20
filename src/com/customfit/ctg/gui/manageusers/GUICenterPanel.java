package com.customfit.ctg.gui.manageusers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;

import com.customfit.ctg.model.*;

/**
 * Central panel for the manage users interface.
 * 
 * @author Ryan Spoon
 *
 */
public class GUICenterPanel extends JPanel  {
	private JList listUsers;
	private JTextField txtName;
	private JTextField txtGoal1;
	private JTextField txtGoal2;
	
	ArrayList<User> userList = new ArrayList<User>();
	
	String[] defaultList = { "test1", "test2", "test3", "test4",
	"test5" };
	
	GUICenterPanel() {
//TODO: David needs to implement Users onto the data package.
//TODO: Outsource this to the Controller and have the Controller send the data over 
		//userList = parentFrame.getMealPlanner().getUserList();
		
		this.setLayout(new BorderLayout());
		
		this.add(addGoalsPanel(), BorderLayout.NORTH);
		this.add(addUserListPanel(), BorderLayout.CENTER);
		this.add(addUserPanel(), BorderLayout.SOUTH);
	}
	
	/**
	 * Create a panel for the list of users.
	 * 
	 * TODO: Update the list with actual users.
	 * 
	 * @return
	 */
	private JPanel addUserListPanel(){
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Users"));
		
		listUsers = new JList();
		listUsers.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listUsers.setLayoutOrientation(JList.VERTICAL);
		listUsers.setVisibleRowCount(-1);
		
		updateUserList();
		
		JScrollPane scrollPane = new JScrollPane(listUsers,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		panel.setLayout(new GridLayout(1, 1));
		panel.add(scrollPane);
		
		return panel;
	}
	
	/**
	 * Create a panel for setting the what nutritional goals to use.
	 * 
	 * TODO: Update the goals based on known nutrition types.
	 * 
	 * @return
	 */
	private JPanel addGoalsPanel(){
		JPanel panel = new JPanel();
		
		panel.setBorder(BorderFactory.createTitledBorder("Nutritional goal types"));
		
		JComboBox listGoal1 = new JComboBox(defaultList);
		JComboBox listGoal2 = new JComboBox(defaultList);
		JLabel lblG1 = new JLabel("Goal 1: ", JLabel.RIGHT);
		JLabel lblG2 = new JLabel("Goal 2: ", JLabel.RIGHT);
		
		JButton btnSaveTypes = new JButton("Save Nutrition Types");
		btnSaveTypes.addActionListener(new ButtonListener("savetypes"));
		
		panel.setLayout(new GridLayout(2, 3));
		
		panel.add(lblG1);
		panel.add(listGoal1); 
		panel.add(btnSaveTypes);
		panel.add(lblG2); 
		panel.add(listGoal2);
		
		return panel;
	}
	
	/**
	 * Create a panel for working with individual users.
	 * 
	 * TODO: Configure the users list to update this panel on selection (or double click?)
	 * 
	 * @return
	 */
	private JPanel addUserPanel(){
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("Update User"));
		
		txtName = new JTextField("");
		txtGoal1 = new JTextField("");
		txtGoal2 = new JTextField("");
		JLabel lblName = new JLabel("Name:");
		JLabel lblGoal1 = new JLabel("Goal 1:");
		JLabel lblGoal2 = new JLabel("Goal 2:");
		
		JButton btnAdd = new JButton("Add User");
		btnAdd.addActionListener(new ButtonListener("add"));
		JButton btnUpdate = new JButton("Update User");
		btnUpdate.addActionListener(new ButtonListener("update"));
		JButton btnRemove = new JButton("Remove User");
		btnAdd.addActionListener(new ButtonListener("remove"));
		
		//txtName.setPreferredSize(new Dimension(100,30));
		//txtGoal1.setPreferredSize(txtName.getPreferredSize());
		//txtGoal2.setPreferredSize(txtName.getPreferredSize());
		
		//panel.setLayout(new FlowLayout());
		panel.setLayout(new GridLayout(3, 3));
		
		panel.add(lblName);
		panel.add(lblGoal1);
		panel.add(lblGoal2);
		panel.add(txtName);
		panel.add(txtGoal1);
		panel.add(txtGoal2);
		panel.add(btnAdd);
		panel.add(btnUpdate);
		panel.add(btnRemove);
		
		return panel;
	}
	
	public void updateUserList() {
		DefaultListModel model = new DefaultListModel();
		
		
		for (User u : userList) {
			model.addElement(u.getName());
			System.out.println(model.getSize() + u.getName());
		}
		listUsers = new JList(model);
		//this.revalidate();
		
	}
	//===============================================
	/**
	 * Controls the actions of the buttons
	 * 
	 * @author Ryan Spoon
	 *
	 */
	private class ButtonListener implements ActionListener {
		private String whichButton; 
		
		/**
		 * Create a new buttonlistener with a given button ID, b.
		 * 
		 * @param b
		 */
		ButtonListener(String b){
			whichButton = b; 
		}
		
		/**
		 * Perform that action for the button specified.
		 * 
		 * TODO: Make it do things!
		 * 
		 */
		public void actionPerformed(ActionEvent e) {
			if(whichButton.equalsIgnoreCase("add")) {
				if (!txtName.getText().isEmpty()) {
					userList.add(new User(txtName.getText()));
					updateUserList();
				}
			}
			if(whichButton.equalsIgnoreCase("remove")) {
				
			}
			if(whichButton.equalsIgnoreCase("update")) {
				
			}
			if(whichButton.equalsIgnoreCase("savetypes")) {
				
			}
		}//end actionPerformed
	}//end class ButtonListener
	
}//end class GUICenterPanel
