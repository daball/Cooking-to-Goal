package com.customfit.ctg.gui.manageusers;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.customfit.ctg.gui.GUIFormats;
import com.customfit.ctg.gui.GUIFrameMain;

public class GUIManageUsersPanel extends JPanel {
	private GUIFrameMain parentFrame;
	private String title;
	
	public GUIManageUsersPanel(GUIFrameMain pf){
		title = "Manage User(s)";
		
		parentFrame = pf;
		
		this.setLayout(new BorderLayout());
		this.add(titlePanel(), BorderLayout.NORTH);
		this.add(new GUICenterPanel(), BorderLayout.CENTER);
		this.add(new GUISouthPanel(parentFrame), BorderLayout.SOUTH);
		
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
		
		return panel;
	}
	
}
