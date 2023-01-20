package gapabrikroti.view;

import gapabrikroti.dao.KoordinatDAO;
import gapabrikroti.error.KoordinatException;
import gapabrikroti.model.Koordinat;
import gapabrikroti.utility.databaseUtility;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import org.openstreetmap.gui.jmapviewer.Coordinate;

public class ContohDrawKoordinat extends JFrame {

    public ContohDrawKoordinat() {
        setTitle("Remkomendasi Koordinat Pabrik Baru");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon image = new ImageIcon("src/gapabrikroti/resources/image/indonesia_map.png");
        JLabel label = new JLabel(image);
        JScrollPane scrollPane = new JScrollPane(label);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        add(new PanelKoordinat());
        add(scrollPane, BorderLayout.CENTER);
        pack();
        
    }

    public static void main(String[] args) {
        ContohDrawKoordinat frame = new ContohDrawKoordinat();
        //frame.setOpacity(0.9f);
        frame.setSize(1600, 1200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setIconImage(new ImageIcon("src/gapabrikroti/resources/image/indonesia_map.png").getImage());//set the frame icon to an image loaded from a file
        frame.setLocationRelativeTo(null);//window centered over null(center)
        frame.setResizable(false);
        frame.setVisible(true);//display frame
        frame.getContentPane().setLayout(new AbsoluteLayout());
    }
}

class PanelKoordinat extends JPanel {
    protected void paintComponent(Graphics g) {
        int x, y;
        try {
            super.paintComponent(g);
            KoordinatDAO KoordinatDAO;
            KoordinatDAO = databaseUtility.getKoordinatDAO();
            List<Koordinat> koordinat = KoordinatDAO.getAllKoordinat();
            List<Coordinate> coordinates = new ArrayList<Coordinate>();
            //membangkitkan evaluasi
            for (Koordinat itemkoordinat : koordinat) {
                x = (int) itemkoordinat.getX() * 10;
                y = (int) itemkoordinat.getY() * 10;
                g.fillArc(x, y, 2 * 20, 2 * 20, 75, 30);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KoordinatException ex) {
            Logger.getLogger(PanelKoordinat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class MyViewPort extends JViewport {
    public MyViewPort() {
        setOpaque(false);
    }
}