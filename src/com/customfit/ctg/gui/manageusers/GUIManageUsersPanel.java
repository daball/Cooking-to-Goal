package com.customfit.ctg.gui.manageusers;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.customfit.ctg.Controller;
import com.customfit.ctg.Observer;
import com.customfit.ctg.gui.GUIFormats;
import com.customfit.ctg.gui.GUIFrameMain;

public class GUIManageUsersPanel extends JPanel implements Observer {
	private String title;
	private Controller controller;
	
	public GUIManageUsersPanel(Controller controller){
		this.controller = controller;
		title = "Manage User(s)";
				
		this.setLayout(new BorderLayout());
		this.add(titlePanel(), BorderLayout.NORTH);
		this.add(new GUICenterPanel(), BorderLayout.CENTER);
		this.add(new GUISouthPanel(controller), BorderLayout.SOUTH);
		
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

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.revalidate();
	}
		
}
