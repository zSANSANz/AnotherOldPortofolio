/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao.impl.jdbc;

import com.mysql.jdbc.Statement;
import gapabrikroti.dao.DaftarIndexDAO;
import gapabrikroti.error.DaftarIndexException;
import gapabrikroti.model.DaftarIndex;
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
public class DaftarIndexDAOImpl implements DaftarIndexDAO {
    private Connection connection;
    private final String InsertDaftarIndex="INSERT INTO daftar_index(istilah, deskripsi) VALUES(?, ?)";
    private final String UpdateDaftarIndex="UPDATE daftar_index SET istilah = ?, deskripsi = ? WHERE id = ?";
    private final String DeleteDaftarIndex="DELETE FROM daftar_index WHERE id = ?";
    private final String SelectAllDaftarIndex="SELECT * FROM daftar_index";
    private final String GetDaftarIndexById="";
    
    public DaftarIndexDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void addDaftarIndex(DaftarIndex daftarIndex) throws DaftarIndexException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(InsertDaftarIndex);
            statement.setString(1, daftarIndex.getIstilah());
            statement.setString(2, daftarIndex.getDeskripsi());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new DaftarIndexException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    Logger.getLogger(DaftarIndexDAOImpl.class.getName()).log(Level.SEVERE, null, exception);
                }
            } 
        }
    }

    @Override
    public void editDaftarIndex(DaftarIndex daftarIndex) throws DaftarIndexException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(UpdateDaftarIndex);
            statement.setString(1, daftarIndex.getIstilah());
            statement.setString(2, daftarIndex.getDeskripsi());
            statement.setInt(3, daftarIndex.getId());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new DaftarIndexException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    Logger.getLogger(DaftarIndexDAOImpl.class.getName()).log(Level.SEVERE, null, exception);
                }
            }
        }
    }

    @Override
    public void deleteDaftarIndex(int id) throws DaftarIndexException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(DeleteDaftarIndex);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException exception) {
           throw new DaftarIndexException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException exception) {
                Logger.getLogger(DaftarIndexDAOImpl.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
    }

    @Override
    public List<DaftarIndex> getAllDaftarIndex() throws DaftarIndexException {
        Statement statement = null;
        List<DaftarIndex> list = new ArrayList<DaftarIndex>();
        
        try {
            statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery(SelectAllDaftarIndex);
            while (result.next()){
                DaftarIndex daftarIndex = new DaftarIndex();
                daftarIndex.setId(result.getInt("id"));
                daftarIndex.setIstilah(result.getString("istilah"));
                daftarIndex.setDeskripsi(result.getString("deskripsi"));
                list.add(daftarIndex);
            }
            return list;
        } catch (SQLException exception) {
            throw new DaftarIndexException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, exception);
                }
            }
        }
    }

    @Override
    public DaftarIndex getDaftarIndexById(int id) throws DaftarIndexException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
