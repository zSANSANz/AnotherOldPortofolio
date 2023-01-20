/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.dao.UserDAO;
import gapabrikroti.error.UserException;
import gapabrikroti.model.User;
import gapabrikroti.utility.databaseUtility;
import java.sql.SQLException;

/**
 *
 * @author cvgs
 */
public class UserServiceImpl {
    private String userName;
    private String password;
    private String hakAkses;
    private UserService userService;
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        fireOnChange();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        fireOnChange();
    }

    public String getHakAkses() {
        return hakAkses;
    }

    public void setHakAkses(String hakAkses) {
        this.hakAkses = hakAkses;
        fireOnChange();
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    protected void fireOnChange() {
        if(userService != null) {
            userService.onChange(this);
        }
    }

    protected void fireOnInsert(User user) {
        if(userService != null) {
            userService.onInsert(user);
        }
    }

    protected void fireOnUpdate(User user) {
        if(userService != null) {
            userService.onUpdate(user);
        }
    }

    protected void fireOnDelete() {
        if(userService != null) {
            userService.onDelete();
        }
    }

    public void resetUser() {
        setUserName("");
        setPassword("");
        setHakAkses("");
    }

    public void insertUser() throws SQLException, UserException {
        UserDAO userDAO = databaseUtility.getUserDAO();

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setHakAkses(hakAkses);
        
        userDAO.addUser(user);

        fireOnInsert(user);
    }
    
    public void updateUser() throws SQLException, UserException {
        UserDAO userDAO = databaseUtility.getUserDAO();

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setHakAkses(hakAkses);
        
        userDAO.editUser(user);

        fireOnUpdate(user);
    }
    
    public void deleteUser() throws SQLException, UserException {
        UserDAO userDAO = databaseUtility.getUserDAO();

        userDAO.deleteUser(userName);

        fireOnDelete();
    }
    
    public boolean checkPassword(String userName, String password) throws SQLException, UserException {
        boolean result = false;
        
        UserDAO userDAO = databaseUtility.getUserDAO();
        
        User userdata = userDAO.getUserByUserName(userName, password);
        
        if (userdata == null) { 
            result = false; 
        } else {
            result = true;
        }
        
        return result;
    }
}
