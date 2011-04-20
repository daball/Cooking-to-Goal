package com.customfit.ctg.gui.manageusers;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.customfit.ctg.Controller;
import com.customfit.ctg.gui.GUIFrameMain;
import com.customfit.ctg.gui.managemenu.GUIManageMenuPanel;

/**
 * 
 * @author Ryan Spoon
 * 
 */
public class GUISouthPanel extends JPanel {
	private JButton btnDone;
	
	public GUISouthPanel() {
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
//TODO: Outsource this to a Controller and call the Controller up from here				
				Controller.getMainFrame().openPanel(new GUIManageMenuPanel());
			}
		}//end actionPerformed
	}//end class ButtonListener
	
}
