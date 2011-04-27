/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customfit.ctg.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import javax.swing.JPanel;
import javax.swing.RepaintManager;

/**
 * Extend this abstract class to create a 
 * printable JPanel.  Pass it to the PrintPreviewPanel 
 * class or invoke its print() method to print.
 * 
 * @author Drew
 */
abstract class AbstractPrintPanel extends JPanel implements Printable {
   
	
    @Override
    public int print(Graphics g, PageFormat pf, int pageIndex)
                    throws PrinterException {
            if(pageIndex > 0)
                return Printable.NO_SUCH_PAGE;

            // Get the Graphics2D context for the component
            Graphics2D g2 = (Graphics2D) g;
            // Move to 0,0 in printer
            g2.translate(pf.getImageableX(), pf.getImageableY());
            
//            // Get the bounds of the printable size
//            Rectangle page =  new Rectangle((int)pf.getImageableWidth(), (int)pf.getImageableHeight());
//            
//            
//            // Translate the component to the printable size
//            g2.translate(-page.x, -page.y);
//            g2.setClip(page.x, page.y, page.width, page.height);
            
            // Change the background to white to save ink
            Color oldBg = this.getBackground();
            this.setBackground(Color.WHITE);
            
            // Disable double buffering or it prints black
            disableDoubleBuffering(this);
            
            // Paint the component for the printer
            this.paint(g2);
            
            // Reset buffing and the background
            enableDoubleBuffering(this);
            this.setBackground(oldBg);

            // Done
            return Printable.PAGE_EXISTS;
    } 
    
    /**
     * Borrowed from:
     * @author http://www.apl.jhu.edu/~hall/java/Swing-Tutorial/Swing-Tutorial-Printing.html
     * @param c
     */
    public static void disableDoubleBuffering(Component c) {
        RepaintManager currentManager = RepaintManager.currentManager(c);
        currentManager.setDoubleBufferingEnabled(false);
      }

    /**
     * Borrowed from:
     * @author http://www.apl.jhu.edu/~hall/java/Swing-Tutorial/Swing-Tutorial-Printing.html
     * @param c
     */
      public static void enableDoubleBuffering(Component c) {
        RepaintManager currentManager = RepaintManager.currentManager(c);
        currentManager.setDoubleBufferingEnabled(true);
      }

}
