package com.customfit.ctg.view;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.beans.*;
import java.io.*;
import javax.swing.*;

/**
 * StarRatingPanel is a rating voting JPanel that displays a number of
 * stars for scoring something.
 * 
 * @author David
 */
public class StarRatingPanel extends JPanel implements Icon, Serializable
{
    
    /**
     * Number of stars to use.
     */
    private int scale = 1;
    public static final String PROP_SCALE = "scale";
    
    /**
     * Number of stars to score.
     */
    private int score = 0;
    public static final String PROP_SCORE = "score";
    
    /**
     * Boolean that indicates whether or not the star panel is editable.
     * 
     * When true, the panel will let the user click to change the rating
     * or right click to remove the rating.
     * 
     * When false, no changes are permitted by the user.
     */
    private boolean editable = true;
    public static final String PROP_EDITABLE = "editable";

    /**
     * Holds the star-off.png icon.
     */
    private ImageIcon imageIconStarOff;
    
    /**
     * Holds the star-on.png icon.
     */
    private ImageIcon imageIconStarOn;

    /**
     * Creates a new StarRatingPanel, which displays a number of
     * stars for scoring something.
     */
    public StarRatingPanel()
    {
        super();
        initComponents();
        this.imageIconStarOff = new ImageIcon(getClass().getResource("/art/export/star-off.png"));
        this.imageIconStarOn = new ImageIcon(getClass().getResource("/art/export/star-on.png"));
        this.setPreferredSize(new Dimension(this.imageIconStarOff.getIconWidth()*this.score, this.imageIconStarOff.getIconHeight()));
        this.setMinimumSize(new Dimension(this.imageIconStarOff.getIconWidth()*this.score, this.imageIconStarOff.getIconHeight()));
        this.setMaximumSize(new Dimension(this.imageIconStarOff.getIconWidth()*this.score, this.imageIconStarOff.getIconHeight()));
        this.enableEvents(AWTEvent.COMPONENT_EVENT_MASK);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 17, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Returns the score value for a given mouse polling position.
     * 
     * @param evt MouseEvent
     * 
     * @return The score value for a given mouse polling position.
     */
    private int mousePositionToScoreValue(java.awt.event.MouseEvent evt)
    {
        return new Double(Math.ceil(new Integer(evt.getX()).doubleValue() / new Integer(this.imageIconStarOff.getIconWidth()).doubleValue())).intValue();
    }
    
    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        if (this.editable)
            this.paintScore(this, this.getGraphics(), 0, 0, mousePositionToScoreValue(evt));
    }//GEN-LAST:event_formMouseEntered

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        if (this.editable)
            this.paintScore(this, this.getGraphics(), 0, 0, mousePositionToScoreValue(evt));
    }//GEN-LAST:event_formMouseMoved

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if (this.editable)
        {
            //if right click, erase the score
            if (evt.getButton() != MouseEvent.BUTTON1)
            {
                this.score = 0;
                this.repaint();
            }
            //otherwise set the score
            else this.score = mousePositionToScoreValue(evt);
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        //make sure we are on the right star
        if (this.editable) this.repaint();
    }//GEN-LAST:event_formMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    /**
     * Gets the scale currently in use. (The number of stars displayed.)
     * @return The scale.
     */
    public int getScale() {
        return this.scale;
    }

    /**
     * Sets the scale to use. (The number of stars to display.)
     * 
     * @param scale The scale.
     */
    public void setScale(int scale) {
        int oldScale = scale;
        this.scale = scale;
        this.setPreferredSize(new Dimension(this.imageIconStarOff.getIconWidth()*this.scale, this.imageIconStarOff.getIconHeight()));
        this.setMinimumSize(new Dimension(this.imageIconStarOff.getIconWidth()*this.scale, this.imageIconStarOff.getIconHeight()));
        this.setMaximumSize(new Dimension(this.imageIconStarOff.getIconWidth()*this.scale, this.imageIconStarOff.getIconHeight()));
        this.repaint();
        this.firePropertyChange(PROP_SCALE, oldScale, scale);
    }
    
    /**
     * Gets the current score. (Number of stars checked.)
     * 
     * @return The score.
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Sets the current score. (Number of stars checked.)
     * 
     * @param score The score.
     */
    public void setScore(int score) {
        int oldScore = score;
        this.score = score;
        this.repaint();
        this.firePropertyChange(PROP_SCORE, oldScore, this.score);
    }
    
    /**
     * Sets the current score by rating.
     * 
     * @param percentage Percentage of checked stars.
     */
    public void setRating(double percentage) {
        this.setScore(new Double(Math.ceil(this.scale * percentage)).intValue());
    }
    
    /**
     * Gets the rating by dividing score / scale.
     * 
     * @param percentage Percentage of checked stars.
     */
    public double getRating()
    {
        return new Integer(this.score).doubleValue() / new Integer(this.scale).doubleValue();
    }

    /**
     * Gets Boolean that indicates whether or not the star panel is editable.
     * 
     * When true, the panel will let the user click to change the rating
     * or right click to remove the rating.
     * 
     * @return Boolean that indicates whether or not the star panel is editable.
     */
    public boolean isEditable()
    {
        return editable;
    }

    /**
     * Sets Boolean that indicates whether or not the star panel is editable.
     * 
     * When true, the panel will let the user click to change the rating
     * or right click to remove the rating.
     * 
     * @param editable Boolean that indicates whether or not the star panel is editable.
     */
    public void setEditable(boolean editable)
    {
        boolean oldEditable = this.editable;
        this.editable = editable;
        this.firePropertyChange(PROP_EDITABLE, oldEditable, this.editable);
    }
    
    /**
     * Paints the current rating on the panel.
     * 
     * @param g A valid Graphics instance.
     */
    @Override
    public void paint(Graphics g)
    {
        paintScore(this, g, 0, 0, this.score);
    }
    
    /**
     * Paints any rating on the panel.
     * 
     * @param g A valid Graphics instance.
     * @param score The rating to redraw.
     */
    public void paintScore(Component c, Graphics g, int x, int y, int score)
    {
        //do superclass first
        super.paint(g);
        //for each star
        for (int s = 0; s < this.scale; s++)
        {
            //is checked
            if (s < score)
            {
                //draw bright star
                if (this.imageIconStarOn != null)
                    imageIconStarOn.paintIcon(c, g, x + s*this.imageIconStarOn.getIconWidth(), y);
            }
            //isn't checked
            else
            {
                //draw gray star
                if (this.imageIconStarOff != null)
                    imageIconStarOff.paintIcon(c, g, x + s*this.imageIconStarOff.getIconWidth(), y);
            }
        }
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        paintScore(c, g, x, y, this.score);
    }

    @Override
    public int getIconWidth() {
        return this.scale * this.imageIconStarOff.getIconWidth();
    }

    @Override
    public int getIconHeight() {
        return this.imageIconStarOff.getIconHeight();
    }
    
    public ImageIcon toImageIcon() {
        //first create an image
        Image image = new BufferedImage(this.getIconWidth(), this.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        this.paintIcon(this, image.getGraphics(), 0, 0);
        return new ImageIcon(image);
    }

}