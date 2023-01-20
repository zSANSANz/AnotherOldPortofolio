/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao.impl.jdbc;

import com.mysql.jdbc.Statement;
import gapabrikroti.dao.KoordinatDAO;
import gapabrikroti.error.KoordinatException;
import gapabrikroti.model.Koordinat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cvgs
 */
public class KoordinatDAOImpl implements KoordinatDAO {
    private Connection connection;
    private final String InsertKoordinat="INSERT INTO koordinat(x, y, bobot) VALUES(?, ?, ?)";
    private final String UpdateKoordinat="UPDATE koordinat SET x = ?, y = ?, bobot = ? WHERE id = ?";
    private final String DeleteKoordinat="DELETE FROM koordinat WHERE id = ?";
    private final String SelectAllKoordinat="SELECT * FROM koordinat";
    private final String selectMaxKoordinat="SELECT MAX(x), MIN(x), MAX(y), MIN(y) FROM koordinat";
    
    public KoordinatDAOImpl(Connection connection) {
        this.connection = connection;
    }
        
    @Override
    public void addKoordinat(Koordinat koordinat) throws KoordinatException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(InsertKoordinat);
            statement.setInt(1, koordinat.getX());
            statement.setInt(2, koordinat.getY());
            statement.setInt(3, koordinat.getBobot());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new KoordinatException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException exception) {
                Logger.getLogger(KoordinatDAOImpl.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
        
    }

    @Override
    public void editKoordinat(Koordinat koordinat) throws KoordinatException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(UpdateKoordinat);
            statement.setInt(1, koordinat.getX());
            statement.setInt(2, koordinat.getY());
            statement.setInt(3, koordinat.getBobot());
            statement.setInt(4, koordinat.getId());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new KoordinatException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException exception) {
                Logger.getLogger(KoordinatDAOImpl.class.getName()).log(Level.SEVERE, null, exception);
            }    
        }
    }

    @Override
    public void deleteKoordinat(int id) throws KoordinatException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(DeleteKoordinat);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new KoordinatException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(KoordinatDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

    @Override
    public List<Koordinat> getAllKoordinat() throws KoordinatException {
        Statement statement = null;
        List<Koordinat> list = new ArrayList<Koordinat>();
        
        try {
            statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery(SelectAllKoordinat);
            while (result.next()){
                Koordinat koordinat = new Koordinat();
                koordinat.setId(result.getInt("id"));
                koordinat.setX(result.getInt("x"));
                koordinat.setY(result.getInt("y"));
                koordinat.setBobot(result.getInt("bobot"));
                list.add(koordinat);
            }
            return list;
        } catch (SQLException exception) {
            throw new KoordinatException(exception.getMessage());
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
    public Koordinat getKoordinatBobot() throws KoordinatException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(selectMaxKoordinat);
            
            ResultSet  result = statement.executeQuery();
            Koordinat koordinat = null;
            if (result.next()) {
                koordinat = new Koordinat();
                koordinat.setId(result.getInt("id"));
                koordinat.setX(result.getInt("x"));
                koordinat.setY(result.getInt("y"));
                koordinat.setBobot(result.getInt("bobot"));
            } else {
                throw new KoordinatException("max dan min tidak di temukan");
            }
            return koordinat;
        } catch(SQLException exception)  {
            throw new KoordinatException(exception.getMessage());
        } finally {
            if(statement!= null){
                try {
                    statement.close();
                } catch (SQLException exception) {
                
                }
            }
        }
    }

    @Override
    public Koordinat getMaxKoordinat() throws KoordinatException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(selectMaxKoordinat);
            
            ResultSet  result = statement.executeQuery();
            Koordinat koordinat = null;
            if (result.next()) {
                koordinat = new Koordinat();
                koordinat.setXMax(result.getInt("MAX(x)"));
                koordinat.setXMin(result.getInt("MIN(x)"));
                koordinat.setYMax(result.getInt("MAX(y)"));
                koordinat.setYMin(result.getInt("MIN(y)"));
            } else {
                throw new KoordinatException("max dan min tidak di temukan");
            }
            return koordinat;
        } catch(SQLException exception)  {
            throw new KoordinatException(exception.getMessage());
        } finally {
            if(statement!= null){
                try {
                    statement.close();
                } catch (SQLException exception) {
                
                }
            }
        }
    }
    
}
