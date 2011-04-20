package com.customfit.ctg.gui.managemenu;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.customfit.ctg.Recipe;
import com.customfit.ctg.User;
import com.customfit.ctg.gui.GUIFrameMain;

public class GUIMainMenuRecipes extends JPanel  {
	private JLabel lblRecipe;
	private JButton btnAdd;
	private JList listRecipes;
	
	private GUIFrameMain parentFrame;
	
	ArrayList<Recipe> recipeList;
	String[] defaultList = { "test1", "test2", "test3", "test4",
	"test5" };
	
	GUIMainMenuRecipes(GUIFrameMain pf) {
		parentFrame = pf;
		
		lblRecipe = new JLabel("Recipes");
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ButtonListener("add"));
		
		listRecipes = new JList();
		listRecipes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listRecipes.setLayoutOrientation(JList.VERTICAL);
		listRecipes.setVisibleRowCount(-1);
		
		updateRecipeList();
		
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
	
	public void updateRecipeList() {
		DefaultListModel model = new DefaultListModel();
		listRecipes = new JList(model);
		recipeList = parentFrame.getMealPlanner().getRecipeList();
		//int i = 0;
		for (Recipe r : recipeList) {
			model.add(model.getSize(),r.getName());
			//i++;
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
