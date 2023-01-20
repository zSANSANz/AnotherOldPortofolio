/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao.impl.jdbc;

import gapabrikroti.dao.RouleteWheelGenerationDAO;
import gapabrikroti.error.RouleteWheelGenerationException;
import gapabrikroti.model.RouleteWheelGeneration;
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
public class RouleteWheelGenerationDAOImpl implements RouleteWheelGenerationDAO {
    private Connection connection;
    private final String insertRouleteWheelGeneration="INSERT INTO roulete_wheel_generasi(roulete_wheel_gen_x, roulete_wheel_gen_y, jml_generasi) VALUES (?, ?, ?)";
    private final String selectAllRouleteWheelGeneration="SELECT * FROM roulete_wheel_generasi";
    private final String deleteAllRouleteWheelGeneration="TRUNCATE roulete_wheel_generasi";
    
    public RouleteWheelGenerationDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addRouleteWheelGeneration(RouleteWheelGeneration rouleteWheelGeneration) throws RouleteWheelGenerationException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(insertRouleteWheelGeneration);
            statement.setDouble(1, rouleteWheelGeneration.getRouleteWheelGenX());
            statement.setDouble(2, rouleteWheelGeneration.getRouleteWheelGenY());
            statement.setInt(3, rouleteWheelGeneration.getGenerationNo());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new RouleteWheelGenerationException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(RouleteWheelGenerationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

    @Override
    public List<RouleteWheelGeneration> getAllRouleteWheelGeneration() throws RouleteWheelGenerationException {
        Statement statement = null;
        List<RouleteWheelGeneration> list = new ArrayList<RouleteWheelGeneration>();
        
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAllRouleteWheelGeneration);
            while (result.next()) {
                RouleteWheelGeneration rouleteWheelGeneration = new RouleteWheelGeneration();
                rouleteWheelGeneration.setRouleteWheelId(result.getInt("roulete_wheel_id"));
                rouleteWheelGeneration.setRouleteWheelGenX(result.getDouble("roulete_wheel_gen_x"));
                rouleteWheelGeneration.setRouleteWheelGenY(result.getDouble("roulete_wheel_gen_y"));
                rouleteWheelGeneration.setGenerationNo(result.getInt("jml_generasi"));
                list.add(rouleteWheelGeneration);
            }
            return list;
        } catch (SQLException exception) {
            throw new RouleteWheelGenerationException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(RouleteWheelGenerationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void clearRouleteWheelGeneration() throws RouleteWheelGenerationException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(deleteAllRouleteWheelGeneration);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new RouleteWheelGenerationException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(RouleteWheelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
