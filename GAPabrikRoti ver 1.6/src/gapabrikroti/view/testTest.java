/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.view;

/**
 *
 * @author cvgs
 */
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.event.*;

public class testTest extends JPanel {

    private BufferedImage backImage, frontImage;
    private float alpha = 1;

    public testTest() {
        try {
            backImage = ImageIO.read(new File("mong.jpg"));
            frontImage = ImageIO.read(new File("dukeWaveRed.gif"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(backImage.getWidth(), backImage.getHeight());
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Paint background image Graphics2D g2 = (Graphics2D) g; int x = (getWidth() - backImage.getWidth())/2; int y = (getHeight()- backImage.getHeight())/2; g2.drawRenderedImage(backImage, AffineTransform.getTranslateInstance(x, y)); // Paint foreground image with appropriate alpha value Composite old = g2.getComposite(); g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha)); x = (getWidth() - frontImage.getWidth())/2; y = (getHeight()- frontImage.getHeight())/2; g2.drawRenderedImage(frontImage, AffineTransform.getTranslateInstance(x, y)); g2.setComposite(old); } private static void createAndShowUI() { final TransparentImage app = new TransparentImage(); JSlider slider = new JSlider(); slider.addChangeListener(new ChangeListener() { public void stateChanged(ChangeEvent e) { JSlider source = (JSlider) e.getSource(); app.setAlpha(source.getValue()/100f); } }); slider.setValue(100); JFrame frame = new JFrame("Transparent Image"); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); frame.add( app ); frame.add(slider, BorderLayout.SOUTH); frame.setLocationByPlatform( true ); frame.pack(); frame.setVisible( true ); } public static void main(String[] args) { EventQueue.invokeLater(new Runnable() { public void run() { createAndShowUI(); } }); } } 
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new testTest().setVisible(true);
            }
        });

    }
}