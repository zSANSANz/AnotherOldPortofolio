/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao.impl.jdbc;

import gapabrikroti.dao.RataRataDAO;
import gapabrikroti.error.RataRataException;
import gapabrikroti.model.RataRata;
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
public class RataRataDAOImpl implements RataRataDAO {
    private Connection connection;
    private final String insertRataRata="INSERT INTO rata_rata(rata_rata_x, rata_rata_y, total_fitness, probabilitas_kumulatif) VALUES(?,?,?,?)";
    private final String selectAllRataRata="SELECT * FROM rata_rata";
    private final String deleteAllRataRata="TRUNCATE rata_rata";
    
    public RataRataDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void addRataRata(RataRata rataRata) throws RataRataException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(insertRataRata);
            statement.setDouble(1, rataRata.getRataRataX());
            statement.setDouble(2, rataRata.getRataRataY());
            statement.setDouble(3, rataRata.getTotalFitness());
            statement.setDouble(4, rataRata.getProbabilitasKumulatif());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new RataRataException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException exception) {
                Logger.getLogger(PopulasiDAOImpl.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
    }

    @Override
    public List<RataRata> getAllRataRata() throws RataRataException {
        Statement statement = null;
        List<RataRata> list = new ArrayList<RataRata>();
        
        try {
            statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery(selectAllRataRata);
            while (result.next()){
                RataRata rataRata = new RataRata();
                rataRata.setNoRataRata(result.getInt("no_rata_rata"));
                rataRata.setRataRataX(result.getDouble("rata_rata_x"));
                rataRata.setRataRataY(result.getDouble("rata_rata_y"));
                rataRata.setTotalFitness(result.getDouble("total_fitness"));
                rataRata.setProbabilitasKumulatif(result.getDouble("probabilitas_kumulatif"));
                list.add(rataRata);
            }
            return list;
        } catch (SQLException exception) {
            throw new RataRataException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    Logger.getLogger(KoordinatDAOImpl.class.getName()).log(Level.SEVERE, null, exception);
                }
            }
        }
    }

    @Override
    public void clearRataRata() throws RataRataException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(deleteAllRataRata);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new RataRataException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(PopulasiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
