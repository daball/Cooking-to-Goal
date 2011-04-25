package com.customfit.ctg.view;

import com.customfit.ctg.controller.*;
import java.awt.Color;
import java.util.*;
import javax.swing.*;

/**
 * The main JFrame which will be used throughout the application's lifecycle,
 * which is constructed so that you can set the current panel in view.
 * 
 * @author Drew, Ryan, and David
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Holds the current SubPanel the main frame is displaying.
     */
    private SubPanel panel;
    
    /**
     * Holds the panel history.
     */
    private Stack<SubPanel> panelHistory = new Stack<SubPanel>();

    /**
     * Holds the panel future history.
     */
    private Queue<SubPanel> panelFutureHistory = new LinkedList<SubPanel>();
    
    /**
     * Holds the original title bar when object was created.
     * Used for updating title bar upon creation.
     */
    private String initalTitle;

    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
        
        //save a copy of title bar
        this.initalTitle = this.getTitle();
        
        //tell it to exit the app when you hit the program's X button
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //tell the JVM to use operating system's look and feel 
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
        	Application.dumpException("Error setting look and feel.", e);
        } catch (InstantiationException e) {
        	Application.dumpException("Error setting look and feel.", e);
        } catch (IllegalAccessException e) {
        	Application.dumpException("Error setting look and feel.", e);
        } catch (UnsupportedLookAndFeelException e) {
        	Application.dumpException("Error setting look and feel.", e);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cooking to Goal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        //shut down the application
        Application.exit(0);
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    /**
     * Returns the current SubPanel the main frame is displaying.
     * 
     * @return The current SubPanel the main frame is displaying.
     */
    public SubPanel getPanel() {
        //get current panel
        return this.panel;
    }

    /**
     * Sets the SubPanel that the main frame will display.
     * 
     * @param p The SubPanel you would like the main frame to display.
     */
    public void setPanel(SubPanel panel) {
        //if there is any panel loaded
        if (this.panel != null)
        {
            //add old panel to history
            this.panelHistory.push(this.panel);
            //then remove prior panel from component model
            this.jScrollPane1.remove(this.panel);
        }
        //update panel reference
        this.panel = panel;
        //add new panel to component model
        this.jScrollPane1.setViewportView(this.panel);
        //update title bar
        this.setTitle(this.panel.getTitle() + " - " + this.initalTitle);
    }
    
    /**
     * Pops the first panel off the stack and loads it into view.
     */
    public void goBack(){
        //add old panel to future history
        this.panelFutureHistory.add(this.panel);
        //grab the last panel loaded
        SubPanel panel = this.panelHistory.pop();
        //if there is any panel loaded
        if (this.panel != null)
            //then remove prior panel from component model
            this.jScrollPane1.remove(this.panel);
        //update panel reference
        this.panel = panel;
        //add new panel to component model
        this.jScrollPane1.setViewportView(this.panel);
        //update title bar
        this.setTitle(this.panel.getTitle() + " - " + this.initalTitle);
    }
}
