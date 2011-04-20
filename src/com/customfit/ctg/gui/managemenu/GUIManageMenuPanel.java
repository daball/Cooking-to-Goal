package com.customfit.ctg.gui.managemenu;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.customfit.ctg.Controller;
import com.customfit.ctg.gui.GUIFormats;
import com.customfit.ctg.gui.GUIFrameMain;

public class GUIManageMenuPanel extends JPanel {
	private String title;
	
	private Controller controller;
	
	public GUIManageMenuPanel(Controller controller){
		this.controller = controller;		
		this.title = "Weekly Menu";
		
		this.setLayout(new BorderLayout());
		this.add(titlePanel(), BorderLayout.NORTH);
		this.add(centerPanel(), BorderLayout.CENTER);
		this.add(new GUIMainButtonPanel(controller), BorderLayout.SOUTH);
	}
	
	private JPanel titlePanel(){
		JPanel panel = new JPanel();
		JLabel lblTitle = new JLabel(title, JLabel.CENTER);
		lblTitle.setFont(GUIFormats.getTitleFont());
		panel.add(lblTitle);
		return panel;
	}
	
	private JPanel centerPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));

		
		panel.add(new GUIMainMenuRecipes());
		panel.add(new GUIMainMenuMealMenu());
		
		return panel;
	}
	
	//public JFrame getParentFrame() {
	//	return parentFrame;
	//}
}