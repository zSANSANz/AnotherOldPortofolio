/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao.impl.jdbc;

import gapabrikroti.dao.ParameterDAO;
import gapabrikroti.error.ParameterException;
import gapabrikroti.model.Parameter;
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
public class ParameterDAOImpl implements ParameterDAO {
    private Connection connection;
    private final String insertParameter="INSERT INTO parameter(nama_parameter, nilai) VALUES(?, ?)";
    private final String updateParameter="UPDATE parameter SET nama_parameter = ?, nilai = ? WHERE id = ?";
    private final String deleteParameter="DELETE FROM parameter WHERE id = ?";
    private final String selectAllParameter="SELECT * FROM parameter";
    private final String selectByNamaParameter="SELECT * FROM parameter WHERE nama_parameter = ?";
    
    public ParameterDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void addParameter(Parameter parameter) throws ParameterException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(insertParameter);
            statement.setString(1, parameter.getNamaParameter());
            statement.setDouble(2, parameter.getNilai());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new ParameterException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    Logger.getLogger(ParameterDAOImpl.class.getName()).log(Level.SEVERE, null, exception);
                }
            }
        }
    }

    @Override
    public void editParameter(Parameter parameter) throws ParameterException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(updateParameter);
            statement.setString(1, parameter.getNamaParameter());
            statement.setDouble(2, parameter.getNilai());
            statement.setInt(3, parameter.getId());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new ParameterException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    Logger.getLogger(ParameterDAOImpl.class.getName()).log(Level.SEVERE, null, exception);
                }
            }
        }
        
        
    }

    @Override
    public void deleteParameter(int id) throws ParameterException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(deleteParameter);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new ParameterException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                    Logger.getLogger(ParameterDAOImpl.class.getName()).log(Level.SEVERE, null, exception);
                }
            }
        }
    }

    @Override
    public List<Parameter> getAllParameter() throws ParameterException {
        Statement statement = null;
        List<Parameter> list = new ArrayList<Parameter>();
        
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAllParameter);
            while (result.next()) {
                Parameter parameter = new Parameter();
                parameter.setId(result.getInt("id"));
                parameter.setNamaParameter(result.getString("nama_parameter"));
                parameter.setNilai(result.getFloat("nilai"));
                list.add(parameter);
            }
            return list;
        } catch (SQLException exception) {
            throw new ParameterException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ParameterDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Parameter getParameterByNamaParameter(String namaParameter) throws ParameterException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(selectByNamaParameter);
            statement.setString(1, namaParameter);

            ResultSet  result = statement.executeQuery();
            Parameter parameter = null;
            if (result.next()) {
                parameter = new Parameter();
                parameter.setNilai(result.getDouble("nilai"));
            } else {
                throw new ParameterException("Nama Parameter Tidak Ada");
            }
            return parameter;
        } catch(SQLException exception)  {
            throw new ParameterException(exception.getMessage());
        } finally {
            if (statement!= null) {
                try {
                    statement.close();
                } catch (SQLException exception) {

                }
            }
        }
    }
    
}
