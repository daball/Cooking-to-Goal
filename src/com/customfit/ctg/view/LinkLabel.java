package com.customfit.ctg.view;

//source from http://www.java2s.com/Code/Java/Swing-Components/LinkLabel.htm

/**
 * The utillib library.
 * More information is available at http://www.jinchess.com/.
 * Copyright (C) 2002 Alexander Maryanovsky.
 * All rights reserved.
 *
 * The utillib library is free software; you can redistribute
 * it and/or modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2 of the
 * License, or (at your option) any later version.
 *
 * The utillib library is distributed in the hope that it will
 * be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser
 * General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with utillib library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

import java.awt.Color;
import java.awt.Cursor;
import java.awt.KeyboardFocusManager;
import java.awt.event.*;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

/**
 * Special LinkLabel appears to be a link and acts like a link.
 * 
 * @author Alexander Maryanovsky, David Ball
 */
public class LinkLabel extends JLabel implements Serializable {

  /**
   * The normal text set by the user.
   */
  private String text;

  /**
   * Creates an empty LinkLabel.
   */
  public LinkLabel(){
    super();
    
    setText( "Link Label" );
    setVerticalAlignment( CENTER );
    setHorizontalAlignment( CENTER );
    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    enableEvents(MouseEvent.MOUSE_EVENT_MASK);
    addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent evt)
        {
            ((LinkLabel)evt.getSource()).setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        }
        @Override
        public void focusLost(FocusEvent evt)
        {
            ((LinkLabel)evt.getSource()).setBorder(BorderFactory.createEmptyBorder());
        }
    });
  }
  
  /**
   * Creates a new LinkLabel with the given text.
   */
  public LinkLabel(String text){
    super(text);
    
    setText( "Link Label" );
    setVerticalAlignment( CENTER );
    setHorizontalAlignment( CENTER );
    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    enableEvents(MouseEvent.MOUSE_EVENT_MASK);
    addFocusListener(new FocusAdapter() {
        @Override
        public void focusGained(FocusEvent evt)
        {
            System.out.print("focusgained");
            ((LinkLabel)evt.getSource()).setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        }
        @Override
        public void focusLost(FocusEvent evt)
        {
            ((LinkLabel)evt.getSource()).setBorder(BorderFactory.createEmptyBorder());
        }
    });
  }
  
  /**
   * Sets the text of the label.
   */
  @Override
  public void setText(String text){
    this.text = text;
    super.setText("<html><font color=\"#0000FF\"><u>"+this.text+"</u></font></html>");
  }

  /**
   * Returns the text set by the user.
   */
  public String getNormalText(){
    return text;
  }

  /**
   * Processes mouse events and responds to clicks.
   */
  @Override
  protected void processMouseEvent(MouseEvent evt){
    super.processMouseEvent(evt);
    if (evt.getID() == MouseEvent.MOUSE_CLICKED)
      fireActionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, getNormalText()));
    else if (evt.getID() == MouseEvent.MOUSE_ENTERED)
        super.setText("<html><font color=\"#CC0000\"><u>"+this.text+"</u></font></html>");
    else if (evt.getID() == MouseEvent.MOUSE_EXITED)
        this.setText(this.getNormalText());
  }
  
  /**
   * Adds an ActionListener to the list of listeners receiving notifications
   * when the label is clicked.
   */
  public void addActionListener(ActionListener listener){
    listenerList.add(ActionListener.class, listener);
  }

  /**
   * Removes the given ActionListener from the list of listeners receiving
   * notifications when the label is clicked.
   */
  public void removeActionListener(ActionListener listener){
    listenerList.remove(ActionListener.class, listener);
  }

  /**
   * Fires an ActionEvent to all interested listeners.
   */
  protected void fireActionPerformed(ActionEvent evt){
    Object [] listeners = listenerList.getListenerList();
    for (int i = 0; i < listeners.length; i += 2){
      if (listeners[i] == ActionListener.class){
        ActionListener listener = (ActionListener)listeners[i+1];
        listener.actionPerformed(evt);
      }
    }
  }
}