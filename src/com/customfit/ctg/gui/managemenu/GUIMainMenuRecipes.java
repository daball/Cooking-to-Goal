package com.customfit.ctg.gui.managemenu;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.customfit.ctg.model.*;

public class GUIMainMenuRecipes extends JPanel  {
	private static final long serialVersionUID = 1L;
	
	private JLabel lblRecipe;
	private JButton btnAdd;
	private JList listRecipes;
	
	GUIMainMenuRecipes() {
		lblRecipe = new JLabel("Recipes");
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ButtonListener("add"));
		
		listRecipes = new JList();
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
		this.add(btnAdd);
	}
	
	/**
	 * This updates the GUI list with the Recipe list.
	 * 
	 * It usually gets called by the controller.
	 * 
	 * @param recipes List of recipes.
	 */
	public void updateRecipeList(List<Recipe> recipes)
	{
		DefaultListModel model = new DefaultListModel();
		for (Recipe recipe : recipes) {
			model.add(model.getSize(),recipe.getName());
		}
	}
	
	private class ButtonListener implements ActionListener {
		private String whichButton; 
		
		ButtonListener(String b){
			whichButton = b; 
			
		}
		public void actionPerformed(ActionEvent e) {
			if(whichButton.equalsIgnoreCase("add")) {
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