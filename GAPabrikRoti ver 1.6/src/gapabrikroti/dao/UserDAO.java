/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao;

import gapabrikroti.error.UserException;
import gapabrikroti.model.User;
import java.util.List;

/**
 *
 * @author cvgs
 */
public interface UserDAO {
    public void addUser(User user) throws UserException;
    public void editUser(User user) throws UserException;
    public void deleteUser(String userName) throws UserException;
    public List<User> getAllUser() throws UserException;
    public User getUserByUserName(String userName, String password) throws UserException;

}
