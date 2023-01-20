/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.controller;

import gapabrikroti.error.KoordinatException;
import gapabrikroti.error.ParameterException;
import gapabrikroti.error.UserException;
import gapabrikroti.service.UserServiceImpl;
import gapabrikroti.view.LoginView;
import gapabrikroti.view.MenuView;
import gapabrikroti.view.UserView;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;




/**
 *
 * @author cvgs
 */
public class UserController {
    private UserServiceImpl userServiceImpl;

    public void setUser(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    public void resetUser(UserView userView) {
        userServiceImpl.resetUser();
    }

    public void insertUser(UserView userView) throws UserException {
        String userName = userView.getTextUserName().getText();
        String password = userView.getTextPassword().getText();
        String hakAkses = userView.getTextHakakses().getText();
        
        if (userName.trim().equals("")) {
            JOptionPane.showMessageDialog(userView, "userName masih Kosong");
        } else if (password.trim().equals("")) {
            JOptionPane.showMessageDialog(userView, "Nama Asuransi Masih Kosong");
        } else if (password.trim().equals("")) {
            JOptionPane.showMessageDialog(userView, "HakAkses Masih Kosong");
        } else {
            userServiceImpl.setUserName(userName);
            userServiceImpl.setPassword(password);
            userServiceImpl.setHakAkses(hakAkses);
            try {
                userServiceImpl.insertUser();
                JOptionPane.showMessageDialog(userView, "User Berhasil di Tambah");
                userServiceImpl.resetUser();
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(userView, new Object[]{
                    "terjadi error di database dengan pesan : ",
                    
                });
            }
        }
    }
    
    public void updateUser(UserView userView) throws UserException {
        if (userView.getTblUser().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(userView, "UserName Belum di Pilih");
            return;
        }
        
        String password = userView.getTextPassword().getText();
        String hakAkses = userView.getTextHakakses().getText();
        String userName = userView.getTextUserName().getText();
        
        if (userName.trim().equals("")) {
            JOptionPane.showMessageDialog(userView, "username masih kosong");
        } else if (password.trim().equals("")) {
            JOptionPane.showMessageDialog(userView, "password masih kosong");
        } else if (hakAkses.trim().equals("")) {
            JOptionPane.showMessageDialog(userView, "hakAkses masih kosong");
        } else {
            userServiceImpl.setUserName(userName);
            userServiceImpl.setPassword(password);
            userServiceImpl.setHakAkses(hakAkses);
            try {
                userServiceImpl.updateUser();
                JOptionPane.showMessageDialog(userView, "User Berhasil di Ubah");
                userServiceImpl.resetUser();
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(userView, new Object[]{
                    "terjadi error di database dengan pesan : ",
                });
            }
        }
    }
    
    public void deleteUser(UserView userView) throws UserException {
        if (userView.getTblUser().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(userView, "UserName Belum di Pilih");
            return;
        }
        
        String userName = userView.getTextUserName().getText();
        userServiceImpl.setUserName(userName);
        try {
            userServiceImpl.deleteUser();
            JOptionPane.showMessageDialog(userView, "User yang Telah di Pilih Berhasil di Delete");
            userServiceImpl.resetUser();
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(userView, new Object[]{
                "terjadi error di database dengan pesan : ",

            });
        }
    }
    
    public void cekLogin(LoginView loginView) throws UserException, ParameterException, KoordinatException {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        
        try {
            if (userServiceImpl.checkPassword(loginView.getTextUserName().getText(), loginView.getTextPassword().getText())) {
                loginView.dispose();
                MenuView menuView = new MenuView();
                menuView.setVisible(true);
            } else {
                if (loginView.getTextUserName().getText() == "") {
                    JOptionPane.showMessageDialog(loginView, "UserName Balum di Isi");
                    return;
                } else if (loginView.getTextPassword().getText() == "") {
                    JOptionPane.showMessageDialog(loginView, "Password Belum di Isi");
                } else {
                    JOptionPane.showMessageDialog(loginView, "UserName / Password Anda Tidak Cocok");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
