/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao.impl.jdbc;

import gapabrikroti.dao.CrossOverGenerationDAO;
import gapabrikroti.error.CrossOverGenerationException;
import gapabrikroti.model.CrossOverGeneration;
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
public class CrossOverGenerationDAOImpl implements CrossOverGenerationDAO {
    private Connection connection;
    private final String insertCrossOverGeneration="INSERT INTO cross_over_generasi(cross_over_x, cross_over_y, fitness, c, jml_generasi) VALUES(?, ? ,? ,?, ?)";
    private final String selectAllCrossOverGeneration="SELECT * FROM cross_over_generasi";
    private final String deleteAllCrossOverGeneration="TRUNCATE cross_over_generasi";
    
    public CrossOverGenerationDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addCrossOverGeneration(CrossOverGeneration crossOverGeneration) throws CrossOverGenerationException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(insertCrossOverGeneration);
            statement.setDouble(1, crossOverGeneration.getCrossOverX());
            statement.setDouble(2, crossOverGeneration.getCrossOverY());
            statement.setDouble(3, crossOverGeneration.getFitness());
            statement.setDouble(4, crossOverGeneration.getC());
            statement.setInt(5, crossOverGeneration.getGenerationNo());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new CrossOverGenerationException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(CrossOverGenerationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<CrossOverGeneration> getAllCrossOverGeneration() throws CrossOverGenerationException {
        Statement statement = null;
        List<CrossOverGeneration> list = new ArrayList<CrossOverGeneration>();
        
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAllCrossOverGeneration);
            while (result.next()) {
                CrossOverGeneration crossOverGeneration = new CrossOverGeneration();
                crossOverGeneration.setNoCrossOver(result.getInt("no_cross_over"));
                crossOverGeneration.setCrossOverX(result.getDouble("cross_over_x"));
                crossOverGeneration.setCrossOverY(result.getDouble("cross_over_y"));
                crossOverGeneration.setFitness(result.getDouble("fitness"));
                crossOverGeneration.setC(result.getDouble("c"));
                crossOverGeneration.setGenerationNo(result.getInt("jml_generasi"));
                list.add(crossOverGeneration);
            }
            return list;
        } catch (SQLException exception) {
            throw new CrossOverGenerationException(exception.getMessage());
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
    public void clearCrossOverGeneration() throws CrossOverGenerationException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(deleteAllCrossOverGeneration);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new CrossOverGenerationException(ex.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(CrossOverGenerationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
