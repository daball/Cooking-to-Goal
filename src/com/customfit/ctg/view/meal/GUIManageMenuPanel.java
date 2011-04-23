package com.customfit.ctg.view.meal;

import com.customfit.ctg.view.*;

import javax.swing.*;
import java.awt.*;

public class GUIManageMenuPanel extends SubPanel {
	
	public GUIManageMenuPanel(){
		//set sub-panel title
		this.title = "Weekly Menu";
		
		this.setLayout(new BorderLayout());
		this.add(titlePanel(), BorderLayout.NORTH);
		this.add(centerPanel(), BorderLayout.CENTER);
		this.add(new GUIMainButtonPanel(), BorderLayout.SOUTH);
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
}