/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao.impl.jdbc;

import gapabrikroti.dao.CrossOverDAO;
import gapabrikroti.error.CrossOverException;
import gapabrikroti.model.CrossOver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cvgs
 */
public class CrossOverDAOImpl implements CrossOverDAO {
    private Connection connection;
    private final String insertCrossOver="INSERT INTO cross_over(cross_over_x, cross_over_y, fitness, c) VALUES(?, ? ,? ,?)";
    private final String selectAllCrossOver="SELECT * FROM cross_over";
    private final String deleteAllCrossOver="TRUNCATE cross_over";
    
    public CrossOverDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addCrossOver(CrossOver crossOver) throws CrossOverException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(insertCrossOver);
            statement.setDouble(1, crossOver.getCrossOverX());
            statement.setDouble(2, crossOver.getCrossOverY());
            statement.setDouble(3, crossOver.getFitness());
            statement.setDouble(4, crossOver.getC());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new CrossOverException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(CrossOverDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<CrossOver> getAllCrossOver() throws CrossOverException {
        Statement statement = null;
        List<CrossOver> list = new ArrayList<CrossOver>();
        
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAllCrossOver);
            while (result.next()) {
                CrossOver crossOver = new CrossOver();
                crossOver.setNoCrossOver(result.getInt("no_cross_over"));
                crossOver.setCrossOverX(result.getDouble("cross_over_x"));
                crossOver.setCrossOverY(result.getDouble("cross_over_y"));
                crossOver.setFitness(result.getDouble("fitness"));
                crossOver.setC(result.getDouble("c"));
                list.add(crossOver);
            }
            return list;
        } catch (SQLException exception) {
            throw new CrossOverException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CrossOverDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void clearCrossOver() throws CrossOverException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(deleteAllCrossOver);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new CrossOverException(ex.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(CrossOverDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
