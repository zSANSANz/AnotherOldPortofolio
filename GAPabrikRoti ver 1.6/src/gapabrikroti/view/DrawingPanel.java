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
import gapabrikroti.dao.KoordinatDAO;
import gapabrikroti.error.KoordinatException;
import gapabrikroti.model.Koordinat;
import gapabrikroti.utility.databaseUtility;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class DrawingPanel extends JPanel {

    private static final String IMG_PATH = "src/gapabrikroti/resources/image/indonesia_map.jpg";
    private static final Color DRAWING_COLOR = new Color(255, 100, 200);
    private static final Color FINAL_DRAWING_COLOR = Color.red;

    private BufferedImage backgroundImg;
    private Point startPt = null;
    private Point endPt = null;
    private Point currentPt = null;
    private int prefW;
    private int prefH;

    JButton btnAddFlight = new JButton("Add Flight");

    public DrawingPanel() throws IOException {

        BufferedImage bImg = ImageIO.read(new File(IMG_PATH));
        prefW = bImg.getWidth();
        prefH = bImg.getHeight();
        backgroundImg = new BufferedImage(prefW, prefH,
                BufferedImage.TYPE_INT_ARGB);
        Graphics g = backgroundImg.getGraphics();
        g.drawImage(bImg, 0, 0, this);
        g.dispose();

        MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
        addMouseMotionListener(myMouseAdapter);
        addMouseListener(myMouseAdapter);
        
        // FlightInfo setbounds
        btnAddFlight.setBounds(60, 400, 220, 30);
        btnAddFlight.setVisible(true);
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        if (backgroundImg != null) {
            g.drawImage(backgroundImg, 0, 0, this);
        }
        KoordinatDAO KoordinatDAO;
        try {
            int x, y;
            KoordinatDAO = databaseUtility.getKoordinatDAO();
            java.util.List<Koordinat> koordinat = KoordinatDAO.getAllKoordinat();
            g.setColor(DRAWING_COLOR);

            //membangkitkan evaluasi
            for (Koordinat itemkoordinat : koordinat) {
                x = (int) itemkoordinat.getX() * 10;
                y = (int) itemkoordinat.getY() * 10;
                g.fillArc(x, y, 2 * 20, 2 * 20, 75, 30);
            }
            g.setColor(FINAL_DRAWING_COLOR);
            g.fillArc(310, 200, 2 * 20, 2 * 20, 75, 30);
            g.fillArc(520, 330, 2 * 20, 2 * 20, 75, 30);
            
//            JButton btn1 = new JButton(new AbstractAction("Click to add") {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                SwingUtilities.invokeLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        
//                        g.setColor(DRAWING_COLOR);
//                        g.setColor(FINAL_DRAWING_COLOR);
//                        g.fillArc(24, 32, 2 * 20, 2 * 20, 75, 30);
//                    }
//                });
//                }
//            });
//        
//            add(btn1);

        } catch (SQLException ex) {
            Logger.getLogger(DrawingPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KoordinatException ex) {
            Logger.getLogger(DrawingPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (startPt != null && currentPt != null) {
            g.setColor(DRAWING_COLOR);
            int x = Math.min(startPt.x, currentPt.x);
            int y = Math.min(startPt.y, currentPt.y);
            int width = Math.abs(startPt.x - currentPt.x);
            int height = Math.abs(startPt.y - currentPt.y);
            g.fillArc(x, y, 2 * 20, 2 * 20, 75, 30);
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(prefW, prefH);
    }

    public void drawToBackground() {
        Graphics g = backgroundImg.getGraphics();
        g.setColor(FINAL_DRAWING_COLOR);
        int x = Math.min(startPt.x, endPt.x);
        int y = Math.min(startPt.y, endPt.y);
        int width = Math.abs(startPt.x - endPt.x);
        int height = Math.abs(startPt.y - endPt.y);
        //g.drawRect(x, y, width, height);
        g.fillArc(x, y, 2 * 20, 2 * 20, 75, 30);
        g.dispose();

        startPt = null;
        repaint();
    }

    private class MyMouseAdapter extends MouseAdapter {

        @Override
        public void mouseDragged(MouseEvent mEvt) {
            currentPt = mEvt.getPoint();
            DrawingPanel.this.repaint();
        }

        @Override
        public void mouseReleased(MouseEvent mEvt) {
            endPt = mEvt.getPoint();
            currentPt = null;
            drawToBackground();
        }

        @Override
        public void mousePressed(MouseEvent mEvt) {
            startPt = mEvt.getPoint();
        }
    }

    private static void createAndShowGui() {
        DrawingPanel mainPanel = null;
        try {
            mainPanel = new DrawingPanel();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        JFrame frame = new JFrame("Drawing Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}
