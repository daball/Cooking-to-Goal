package com.customfit.ctg;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class GUIMainMenuMealMenu extends JPanel  {
	private JLabel lblRecipe;
	private JButton btnRemove;
	private JList listRecipes;
	
	String[] defaultList = { "test1", "test2", "test3", "test4",
	"test5" };
	
	GUIMainMenuMealMenu() {
		lblRecipe = new JLabel("Weekly Menu");
		
		btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ButtonListener("remove"));
		
		listRecipes = new JList(defaultList);
		listRecipes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listRecipes.setLayoutOrientation(JList.VERTICAL);
		listRecipes.setVisibleRowCount(-1);
		
		JScrollPane scrollPane = new JScrollPane(listRecipes,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		JPanel simplePanel = new JPanel();
		simplePanel.setLayout(new GridLayout(1, 1));
		simplePanel.add(scrollPane);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(lblRecipe);
		this.add(simplePanel);
		this.add(btnRemove);
		
	}
	
	private class ButtonListener implements ActionListener {
		private String whichButton; 
		
		ButtonListener(String b){
			whichButton = b; 
			
		}
		public void actionPerformed(ActionEvent e) {
			if(whichButton.equalsIgnoreCase("remove")) {
				if (listRecipes.isSelectionEmpty()) {
					System.out.println("You didn't select anything!");
				}
				else {
					System.out.println("You have selected the recipe: " + listRecipes.getSelectedValue());
				}
			}
		} 
	}
	
}
