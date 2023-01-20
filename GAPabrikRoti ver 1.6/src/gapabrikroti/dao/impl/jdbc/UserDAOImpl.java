/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao.impl.jdbc;

import com.mysql.jdbc.Statement;
import gapabrikroti.dao.UserDAO;
import gapabrikroti.error.UserException;
import gapabrikroti.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author cvgs
 */
public class UserDAOImpl implements UserDAO{
    public Connection connection;
    private final String InsertUser="INSERT INTO user(userName, password, hakAkses) VALUES(?, ?, ?)";
    private final String UpdateUser="UPDATE user SET password = ?, hakAkses = ? WHERE userName = ?";
    private final String DeleteUser="DELETE FROM user WHERE userName = ?";
    private final String SelectAllUser="SELECT * FROM user";
    private final String GetUserByUserName="SELECT * FROM user WHERE userName = ? AND password = ?";
    
    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addUser(User user) throws UserException {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(InsertUser);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getHakAkses());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new UserException(exception.getMessage());
        } finally{
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
    public void editUser(User user) throws UserException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UpdateUser);
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getHakAkses());
            statement.setString(3, user.getUserName());
            statement.executeUpdate();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
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
    public void deleteUser(String userName) throws UserException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(DeleteUser);
            statement.setString(1, userName);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new UserException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch(SQLException exception) {
                    Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, exception);
                }
            }
        }
    }

    @Override
    public List<User> getAllUser() throws UserException {
        Statement statement = null;
        List<User> list = new ArrayList<User>();
        
        try {
            statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery(SelectAllUser);
            while (result.next()){
                User user = new User();
                user.setUserName(result.getString("userName"));
                user.setPassword(result.getString("password"));
                user.setHakAkses(result.getString("hakAkses"));
                list.add(user);
            }
            return list;
        } catch (SQLException exception) {
            throw new UserException(exception.getMessage());
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
    public User getUserByUserName(String userName, String password) throws UserException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(GetUserByUserName);
            statement.setString(1, userName);
            statement.setString(2, password);
            
            ResultSet result = statement.executeQuery();
            User user = null;
            if (result.next()) {
                user = new User();
                user.setUserName("userName");
                user.setPassword("password");
                user.setHakAkses("hakAkses");
            } else {
                throw new UserException("data tidak di temukan");
            }
            return user;
        } catch (SQLException exception) {
            throw new UserException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
