/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customfit.ctg.view;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import javax.swing.JPanel;

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

            this.paint(g);
            
            return Printable.PAGE_EXISTS;
    } 
}
