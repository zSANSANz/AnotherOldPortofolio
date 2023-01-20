/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.controller;

import gapabrikroti.error.KoordinatException;
import gapabrikroti.service.KoordinatServiceImpl;
import gapabrikroti.view.KoordinatView;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author cvgs
 */
public class KoordinatController {
    private KoordinatServiceImpl koordinatServiceImpl;

    public void setKoordinat(KoordinatServiceImpl koordinatServiceImpl) {
        this.koordinatServiceImpl = koordinatServiceImpl;
    }

    public void resetKoordinat(KoordinatView koordinatView) {
        koordinatServiceImpl.resetKoordinat();
    }

    public void insertKoordinat(KoordinatView koordinatView) throws KoordinatException {
        Integer x = Integer.parseInt(koordinatView.getTextX().getText());
        Integer y = Integer.parseInt(koordinatView.getTextY().getText());
        Integer bobot = Integer.parseInt(koordinatView.getTextBobot().getText());
        
        if (x.toString().equals("")) {
            JOptionPane.showMessageDialog(koordinatView, "Koordinat x masih Kosong");
        } else if (y.toString().equals("")) {
            JOptionPane.showMessageDialog(koordinatView, "Koordinat y Masih Kosong");
        } else if (bobot.toString().equals("")) {
            JOptionPane.showMessageDialog(koordinatView, "Bobot Masih Kosong");
        } else {
            koordinatServiceImpl.setX(x);
            koordinatServiceImpl.setY(y);
            koordinatServiceImpl.setBobot(bobot);
            try {
                koordinatServiceImpl.insertKoordinat();
                JOptionPane.showMessageDialog(koordinatView, "Koordinat Berhasil di Tambah");
                koordinatServiceImpl.resetKoordinat();
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(koordinatView, new Object[]{
                    "terjadi error di database dengan pesan : ",
                    
                });
            }
        }
    }
    
    public void updateKoordinat(KoordinatView koordinatView) throws KoordinatException {
        if(koordinatView.getTblKoordinat().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(koordinatView, "Id Koordinat Belum di Pilih");
            return;
        }
        
        Integer id = Integer.parseInt(koordinatView.getTextId().getText());
        Integer x = Integer.parseInt(koordinatView.getTextX().getText());
        Integer y = Integer.parseInt(koordinatView.getTextY().getText());
        Integer bobot = Integer.parseInt(koordinatView.getTextBobot().getText());
        
        if (x.toString().equals("")) {
            JOptionPane.showMessageDialog(koordinatView, "Koordinat x masih Kosong");
        } else if (y.toString().equals("")) {
            JOptionPane.showMessageDialog(koordinatView, "Koordinat y Masih Kosong");
        } else if (bobot.toString().equals("")) {
            JOptionPane.showMessageDialog(koordinatView, "Bobot Masih Kosong");
        } else {
            koordinatServiceImpl.setId(id);
            koordinatServiceImpl.setX(x);
            koordinatServiceImpl.setY(y);
            koordinatServiceImpl.setBobot(bobot);
            try {
                koordinatServiceImpl.updateKoordinat();
                JOptionPane.showMessageDialog(koordinatView, "Koordinat Berhasil di Ubah");
                koordinatServiceImpl.resetKoordinat();
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(koordinatView, new Object[]{
                    "terjadi error di database dengan pesan : ",
                    
                });
            }
        }
    }
    
    public void deleteKoordinat(KoordinatView koordinatView) throws KoordinatException {
        if(koordinatView.getTblKoordinat().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(koordinatView, "Id Koordinat Belum di Pilih");
            return;
        }
        
        Integer id = Integer.parseInt(koordinatView.getTextId().getText());
        koordinatServiceImpl.setId(id);
            try {
                koordinatServiceImpl.deleteKoordinat();
                JOptionPane.showMessageDialog(koordinatView, "Koordinat yang Telah di Pilih Berhasil di Delete");
                koordinatServiceImpl.resetKoordinat();
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(koordinatView, new Object[]{
                    "terjadi error di database dengan pesan : ",

                });
            }
    }
}
