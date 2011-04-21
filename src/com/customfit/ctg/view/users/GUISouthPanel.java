package com.customfit.ctg.view.users;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.customfit.ctg.controllers.Application;
import com.customfit.ctg.view.MainFrame;
import com.customfit.ctg.view.meal.GUIManageMenuPanel;

/**
 * 
 * @author Ryan Spoon
 * 
 */
public class GUISouthPanel extends JPanel {
	private JButton btnDone;
	private Application controller;
	
	public GUISouthPanel(Application controller) {
		this.controller = controller;
		this.setPreferredSize(new Dimension(350, 100)); //sets the size for the JPanel
		this.btnDone = new JButton("OK");
		btnDone.setPreferredSize(new Dimension(160, 30));
		btnDone.addActionListener(new ButtonListener("done"));
		
		this.setLayout(new FlowLayout()); //sets the layout for the buttons
		this.add(btnDone);
	}
	
	private class ButtonListener implements ActionListener {
		private String whichButton; 
		
		ButtonListener(String b){
			whichButton = b; 
		}
		
		public void actionPerformed(ActionEvent e) {
			if(whichButton.equalsIgnoreCase("done")) {		
				controller.openPanel(new GUIManageMenuPanel(controller));
			}
		}//end actionPerformed
	}//end class ButtonListener
	
}
