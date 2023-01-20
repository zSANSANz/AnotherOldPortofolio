/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.view;

import gapabrikroti.dao.EvaluasiGenerationDAO;
import gapabrikroti.error.EvaluasiGenerationException;
import gapabrikroti.model.EvaluasiGeneration;
import gapabrikroti.utility.databaseUtility;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ContohDraw extends JFrame {

    private static final String IMG_PATH = "src/gapabrikroti/resources/image/indonesia_map.png";

    public ContohDraw() {
        setTitle("Remkomendasi Koordinat Pabrik Baru");
        add(new Panel());
    }

    public static void main(String[] args) {
        try {
            BufferedImage img = ImageIO.read(new File(IMG_PATH));
            ImageIcon icon = new ImageIcon(img);
            JLabel label = new JLabel(icon);
            JOptionPane.showMessageDialog(null, label);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ContohDraw frame = new ContohDraw();
        frame.setSize(1600, 1200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class Panel extends JPanel {

    protected void paintComponent(Graphics g) {
        int x, y;
        try {
            super.paintComponent(g);
            EvaluasiGenerationDAO evaluasiGenerationDAO;
            evaluasiGenerationDAO = databaseUtility.getEvaluasiGenerationDAO();
            List<EvaluasiGeneration> evaluasiGeneration = evaluasiGenerationDAO.getAllEvaluasiGenerationByProbabilitas();
            //membangkitkan evaluasi
            for (EvaluasiGeneration itemEvaluasi : evaluasiGeneration) {
                x = (int) itemEvaluasi.getEvaluasiX() * 10;
                y = (int) itemEvaluasi.getEvaluasiY() * 10;
                g.fillArc(x, y, 2 * 20, 2 * 20, 75, 30);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EvaluasiGenerationException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
