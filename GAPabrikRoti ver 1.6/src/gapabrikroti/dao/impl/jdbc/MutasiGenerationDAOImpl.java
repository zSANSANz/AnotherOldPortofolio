/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao.impl.jdbc;

import gapabrikroti.dao.MutasiGenerationDAO;
import gapabrikroti.error.MutasiGenerationException;
import gapabrikroti.model.MutasiGeneration;
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
public class MutasiGenerationDAOImpl implements MutasiGenerationDAO {
    private Connection connection;
    private final String insertMutasiGeneration="INSERT INTO mutasi_generasi(mutasi_x, mutasi_y, fitness, c, jml_generasi) VALUES(?, ? ,? ,?, ?)";
    private final String selectAllMutasiGeneration="SELECT * FROM mutasi_generasi";
    private final String deleteAllMutasiGeneration="TRUNCATE mutasi_generasi";
    
    public MutasiGenerationDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addMutasiGeneration(MutasiGeneration mutasiGeneration) throws MutasiGenerationException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(insertMutasiGeneration);
            statement.setDouble(1, mutasiGeneration.getMutasiX());
            statement.setDouble(2, mutasiGeneration.getMutasiY());
            statement.setDouble(3, mutasiGeneration.getFitness());
            statement.setDouble(4, mutasiGeneration.getC());
            statement.setInt(5, mutasiGeneration.getGenerationNo());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new MutasiGenerationException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(MutasiGenerationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<MutasiGeneration> getAllMutasiGeneration() throws MutasiGenerationException {
        Statement statement = null;
        List<MutasiGeneration> list = new ArrayList<MutasiGeneration>();
        
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAllMutasiGeneration);
            while (result.next()) {
                MutasiGeneration mutasiGeneration = new MutasiGeneration();
                mutasiGeneration.setNoMutasi(result.getInt("no_mutasi"));
                mutasiGeneration.setMutasiX(result.getDouble("mutasi_x"));
                mutasiGeneration.setMutasiY(result.getDouble("mutasi_y"));
                mutasiGeneration.setFitness(result.getDouble("fitness"));
                mutasiGeneration.setC(result.getDouble("c"));
                mutasiGeneration.setGenerationNo(result.getInt("jml_generasi"));
                list.add(mutasiGeneration);
            }
            return list;
        } catch (SQLException exception) {
            throw new MutasiGenerationException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MutasiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void clearMutasiGeneration() throws MutasiGenerationException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(deleteAllMutasiGeneration);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new MutasiGenerationException(ex.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(MutasiGenerationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
