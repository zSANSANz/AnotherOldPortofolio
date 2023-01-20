/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao.impl.jdbc;

import gapabrikroti.dao.RouleteWheelDAO;
import gapabrikroti.error.EvaluasiException;
import gapabrikroti.error.RouleteWheelException;
import gapabrikroti.model.RouleteWheel;
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
public class RouleteWheelDAOImpl implements RouleteWheelDAO {
    private Connection connection;
    private final String insertRouleteWheel="INSERT INTO roulete_wheel(roulete_wheel_gen_x, roulete_wheel_gen_y) VALUES (?, ?)";
    private final String selectAllRouleteWheel="SELECT * FROM roulete_wheel";
    private final String deleteAllRouleteWheel="TRUNCATE roulete_wheel";
    
    public RouleteWheelDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addRouleteWheel(RouleteWheel rouleteWheel) throws RouleteWheelException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(insertRouleteWheel);
            statement.setDouble(1, rouleteWheel.getRouleteWheelGenX());
            statement.setDouble(2, rouleteWheel.getRouleteWheelGenY());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new RouleteWheelException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(RouleteWheelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

    @Override
    public List<RouleteWheel> getAllRouleteWheel() throws RouleteWheelException {
        Statement statement = null;
        List<RouleteWheel> list = new ArrayList<RouleteWheel>();
        
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAllRouleteWheel);
            while (result.next()) {
                RouleteWheel rouleteWheel = new RouleteWheel();
                rouleteWheel.setRouleteWheelId(result.getInt("roulete_wheel_id"));
                rouleteWheel.setRouleteWheelGenX(result.getDouble("roulete_wheel_gen_x"));
                rouleteWheel.setRouleteWheelGenY(result.getDouble("roulete_wheel_gen_y"));
                list.add(rouleteWheel);
            }
            return list;
        } catch (SQLException exception) {
            throw new RouleteWheelException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(RouleteWheelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void clearRouleteWheel() throws RouleteWheelException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(deleteAllRouleteWheel);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new RouleteWheelException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(RouleteWheelDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
