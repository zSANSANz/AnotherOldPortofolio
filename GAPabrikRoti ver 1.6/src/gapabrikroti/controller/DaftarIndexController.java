/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.controller;

import gapabrikroti.error.DaftarIndexException;
import gapabrikroti.service.DaftarIndexServiceImpl;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import gapabrikroti.view.DaftarIndexView;

/**
 *
 * @author cvgs
 */
public class DaftarIndexController {
    private DaftarIndexServiceImpl daftarIndexServiceImpl;

    public void setDaftarIndex(DaftarIndexServiceImpl daftarIndexServiceImpl) {
        this.daftarIndexServiceImpl = daftarIndexServiceImpl;
    }

    public void resetDaftarIndex(DaftarIndexView daftarIndexView) {
        daftarIndexServiceImpl.resetDaftarIndex();
    }

    public void insertDaftarIndex(DaftarIndexView daftarIndexView) throws DaftarIndexException {
        String istilah = daftarIndexView.getTextIstilah().getText();
        String deskripsi = daftarIndexView.getTextDeskripsi().getText();
        
        if (istilah.trim().equals("")) {
            JOptionPane.showMessageDialog(daftarIndexView, "istilah masih Kosong");
        } else if (deskripsi.trim().equals("")) {
            JOptionPane.showMessageDialog(daftarIndexView, "deskripsi Masih Kosong");
        } else {
            daftarIndexServiceImpl.setIstilah(istilah);
            daftarIndexServiceImpl.setDeskripsi(deskripsi);
            try {
                daftarIndexServiceImpl.insertDaftarIndex();
                JOptionPane.showMessageDialog(daftarIndexView, "Daftar Index Berhasil di Tambah");
                daftarIndexServiceImpl.resetDaftarIndex();
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(daftarIndexView, new Object[]{
                    "terjadi error di database dengan pesan : ",
                    
                });
            }
        }
    }
    
    public void updateDaftarIndex(DaftarIndexView daftarIndexView) throws DaftarIndexException {
        if(daftarIndexView.getTblDaftarIndex().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(daftarIndexView, "Id Daftar Index Belum di Pilih");
            return;
        }
        
        Integer id = Integer.parseInt(daftarIndexView.getTextId().getText());
        String istilah = daftarIndexView.getTextIstilah().getText();
        String deskripsi = daftarIndexView.getTextDeskripsi().getText();
        
        if (istilah.trim().equals("")) {
            JOptionPane.showMessageDialog(daftarIndexView, "istilah masih Kosong");
        } else if (deskripsi.trim().equals("")) {
            JOptionPane.showMessageDialog(daftarIndexView, "deskripsi Masih Kosong");
        } else {
            daftarIndexServiceImpl.setId(id);
            daftarIndexServiceImpl.setIstilah(istilah);
            daftarIndexServiceImpl.setDeskripsi(deskripsi);
            try {
                daftarIndexServiceImpl.updateDaftarIndex();
                JOptionPane.showMessageDialog(daftarIndexView, "Daftar Index Berhasil di Ubah");
                daftarIndexServiceImpl.resetDaftarIndex();
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(daftarIndexView, new Object[]{
                    "terjadi error di database dengan pesan : ",
                    
                });
            }
        }
    }
    
    public void deleteDaftarIndex(DaftarIndexView daftarIndexView) throws DaftarIndexException {
        if (daftarIndexView.getTblDaftarIndex().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(daftarIndexView, "Id Daftar Index Belum di Pilih");
            return;
        }
        
        Integer id = Integer.parseInt(daftarIndexView.getTextId().getText());
        daftarIndexServiceImpl.setId(id);
        try {
            daftarIndexServiceImpl.deleteDaftarIndex();
            JOptionPane.showMessageDialog(daftarIndexView, "Daftar Index yang Telah di Pilih Berhasil di Delete");
            daftarIndexServiceImpl.resetDaftarIndex();
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(daftarIndexView, new Object[]{
                "terjadi error di database dengan pesan : ",

            });
        }
    }
}
