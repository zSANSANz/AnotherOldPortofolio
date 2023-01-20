/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao.impl.jdbc;

import gapabrikroti.dao.MutasiDAO;
import gapabrikroti.error.MutasiException;
import gapabrikroti.model.Mutasi;
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
public class MutasiDAOImpl implements MutasiDAO {
    private Connection connection;
    private final String insertMutasi="INSERT INTO mutasi(mutasi_x, mutasi_y, fitness, c) VALUES(?, ? ,? ,?)";
    private final String selectAllMutasi="SELECT * FROM mutasi";
    private final String deleteAllMutasi="TRUNCATE mutasi";
    
    public MutasiDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addMutasi(Mutasi mutasi) throws MutasiException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(insertMutasi);
            statement.setDouble(1, mutasi.getMutasiX());
            statement.setDouble(2, mutasi.getMutasiY());
            statement.setDouble(3, mutasi.getFitness());
            statement.setDouble(4, mutasi.getC());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new MutasiException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(MutasiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Mutasi> getAllMutasi() throws MutasiException {
        Statement statement = null;
        List<Mutasi> list = new ArrayList<Mutasi>();
        
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAllMutasi);
            while (result.next()) {
                Mutasi mutasi = new Mutasi();
                mutasi.setNoMutasi(result.getInt("no_mutasi"));
                mutasi.setMutasiX(result.getDouble("mutasi_x"));
                mutasi.setMutasiY(result.getDouble("mutasi_y"));
                mutasi.setFitness(result.getDouble("fitness"));
                mutasi.setC(result.getDouble("c"));
                list.add(mutasi);
            }
            return list;
        } catch (SQLException exception) {
            throw new MutasiException(exception.getMessage());
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
    public void clearMutasi() throws MutasiException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(deleteAllMutasi);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new MutasiException(ex.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(MutasiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
