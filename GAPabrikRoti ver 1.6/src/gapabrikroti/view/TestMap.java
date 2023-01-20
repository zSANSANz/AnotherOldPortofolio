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
import gapabrikroti.dao.EvaluasiGenerationDAO;
import gapabrikroti.error.EvaluasiGenerationException;
import gapabrikroti.model.EvaluasiGeneration;
import gapabrikroti.utility.databaseUtility;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Path2D;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;
import org.openstreetmap.gui.jmapviewer.interfaces.ICoordinate;

public class TestMap {

    public static class MapPolyLine extends MapPolygonImpl {

        public MapPolyLine(List<? extends ICoordinate> points) {
            super(null, null, points);
        }

        @Override
        public void paint(Graphics g, List<Point> points) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(getColor());
            g2d.setStroke(getStroke());
            Path2D path = buildPath(points);
            g2d.draw(path);
            g2d.dispose();
        }

        private Path2D buildPath(List<Point> points) {
            Path2D path = new Path2D.Double();
            if (points != null && points.size() > 0) {
                Point firstPoint = points.get(0);
                path.moveTo(firstPoint.getX(), firstPoint.getY());
                for (Point p : points) {
                    path.lineTo(p.getX(), p.getY());
                }
            }
            return path;
        }
    }

    private static void createAndShowUI() throws SQLException, EvaluasiGenerationException {
        JFrame frame = new JFrame("Demo");
        JMapViewer viewer = new JMapViewer();

        int x, y;

        EvaluasiGenerationDAO evaluasiGenerationDAO;
        evaluasiGenerationDAO = databaseUtility.getEvaluasiGenerationDAO();
        List<EvaluasiGeneration> evaluasiGeneration = evaluasiGenerationDAO.getAllEvaluasiGenerationByProbabilitas();
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        //membangkitkan evaluasi
        for (EvaluasiGeneration itemEvaluasi : evaluasiGeneration) {
            x = (int) itemEvaluasi.getEvaluasiX();
            y = (int) itemEvaluasi.getEvaluasiY();
            coordinates.add(new Coordinate(x - 25, y + 100));

        }

        MapPolyLine polyLine = new MapPolyLine(coordinates);
        viewer.addMapPolygon(polyLine);

        frame.add(viewer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowUI();
                } catch (SQLException ex) {
                    Logger.getLogger(TestMap.class.getName()).log(Level.SEVERE, null, ex);
                } catch (EvaluasiGenerationException ex) {
                    Logger.getLogger(TestMap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
