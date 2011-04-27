/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.customfit.ctg.view.print;

import java.awt.*;
import java.awt.print.*;
import javax.swing.*;
import javax.swing.border.*;

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
//            System.out.print("imageable X:" + pf.getImageableX() + ", ");
//            System.out.print("Y:" + pf.getImageableY() + ", ");
//            System.out.print("W:" + pf.getImageableWidth() + ", ");
//            System.out.print("H:" + pf.getImageableHeight());
            //this.setSize(new Double(pf.getImageableWidth()).intValue(), new Double(pf.getImageableHeight()).intValue());
            // Move to 0,0 in printer
            g2.translate(pf.getImageableX(), pf.getImageableY());
//            for (Component component : this.getComponents())
//                if (component.getWidth() > pf.getImageableWidth())
//                {
//                    component.setSize(new Double(pf.getImageableWidth()).intValue()-50, component.getHeight());
//                    if (component.getClass().isAssignableFrom(JComponent.class))
//                    {
//                        JComponent jComponent = (JComponent)component;
//                        jComponent.setBorder(BorderFactory.createEmptyBorder());
//                        for (Component subComponent: jComponent.getComponents())
//                            if (component.getClass().isAssignableFrom(JComponent.class))
//                            {
//                                JComponent subJComponent = (JComponent)subJomponent;
//                                subJComponent.setBorder(BorderFactory.createEmptyBorder());
//                            }
//                    }
//                }
//                    //component.setSize(100, component.getHeight());
//            
//            // Get the bounds of the printable size
            Rectangle page =  new Rectangle((int)pf.getImageableWidth(), (int)pf.getImageableHeight());
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

      @Override
      public void setSize(int width, int height)
      {
          int newHeight = new Double(new Integer(width).doubleValue() / 8.5 * 11.0).intValue();
          super.setSize(width, newHeight);
      }
      
      @Override
      public void setSize(Dimension dimension)
      {
          setSize(dimension.width, dimension.height);
      }
}
