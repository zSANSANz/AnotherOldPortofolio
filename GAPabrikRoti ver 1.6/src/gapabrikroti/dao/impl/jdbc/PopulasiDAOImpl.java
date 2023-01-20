/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao.impl.jdbc;

import gapabrikroti.dao.PopulasiDAO;
import gapabrikroti.error.PopulasiException;
import gapabrikroti.model.Populasi;
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
public class PopulasiDAOImpl implements PopulasiDAO {
    private Connection connection;
    private final String insertPopulasi="INSERT INTO populasi(binerX, binerY) VALUES(?, ?)";
    private final String selectAllPopulasi="SELECT * FROM populasi";
    private final String deleteAllPopulasi="TRUNCATE populasi";
    
    public PopulasiDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addPopulasi(Populasi populasi) throws PopulasiException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(insertPopulasi);
            statement.setInt(1, populasi.getBinerX());
            statement.setInt(2, populasi.getBinerY());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new PopulasiException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException exception) {
                Logger.getLogger(PopulasiDAOImpl.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
    }

    @Override
    public List<Populasi> getAllPopulasi() throws PopulasiException {
        Statement statement = null;
        List<Populasi> list = new ArrayList<Populasi>();
        
        try {
            statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery(selectAllPopulasi);
            while (result.next()){
                Populasi populasi = new Populasi();
                populasi.setNoKromosom(result.getInt("noKromosom"));
                populasi.setBinerX(result.getInt("binerX"));
                populasi.setBinerY(result.getInt("binerY"));
                list.add(populasi);
            }
            return list;
        } catch (SQLException exception) {
            throw new PopulasiException(exception.getMessage());
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
    public void clearPopulasi() throws PopulasiException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(deleteAllPopulasi);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new PopulasiException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(PopulasiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Populasi getAllPopulasiForEv() throws PopulasiException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(selectAllPopulasi);
            
            ResultSet  result = statement.executeQuery();
            Populasi populasi = null;
            if (result.next()) {
                populasi = new Populasi();
                populasi.setBinerX(result.getInt("binerX"));
                populasi.setBinerY(result.getInt("binerY"));
            } else {
                throw new PopulasiException("data tidak di temukan");
            }
            return populasi;
        } catch(SQLException exception)  {
            throw new PopulasiException(exception.getMessage());
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException exception) {
                
                }
            }
        }
    }
}
