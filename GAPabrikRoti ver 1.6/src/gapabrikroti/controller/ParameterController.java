/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.controller;

import gapabrikroti.error.ParameterException;
import gapabrikroti.service.ParameterServiceImpl;
import gapabrikroti.view.ParameterView;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author cvgs
 */
public class ParameterController {
    private ParameterServiceImpl parameterServiceImpl;
    
    public void setParameter(ParameterServiceImpl parameterServiceImpl) {
        this.parameterServiceImpl = parameterServiceImpl;
    }
    
    public void resetParameter(ParameterView parameterView) {
        parameterServiceImpl.resetParameter();
    }
    
    public void insertParameter(ParameterView parameterView) throws ParameterException {
        String namaParameter = parameterView.getTextNamaParameter().getText();
        Double nilai = Double.parseDouble(parameterView.getTextNilai().getText());
        
        if (namaParameter.trim().equals("")) {
            JOptionPane.showMessageDialog(parameterView, "Nama Parameter Masih Kosong");
        } else if (nilai.equals("")) {
            JOptionPane.showMessageDialog(parameterView, "Nilai Masih Kosong");
        } else {
            parameterServiceImpl.setNamaParameter(namaParameter);
            parameterServiceImpl.setNilai(nilai);
            try {
                parameterServiceImpl.insertParameter();
                JOptionPane.showMessageDialog(parameterView, "Data Parameter Berhasil di Tambah");
                parameterServiceImpl.resetParameter();
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(parameterView, new Object[] {
                    "terjadi error di database dengan pesan : ",
                    
                });
            }
        }
    }
    
    public void updateParameter(ParameterView parameterView) throws ParameterException {
        if (parameterView.getTblParameter().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(parameterView, "Id Parameter Belum di Pilih");
        }
        
        Integer id = Integer.parseInt(parameterView.getTextId().getText());
        String namaParameter = parameterView.getTextNamaParameter().getText();
        Float nilai = Float.parseFloat(parameterView.getTextNilai().getText());
        
        if (id.equals("")) {
            JOptionPane.showMessageDialog(parameterView, "Id Parameter Masih Kosong");
        } else if (namaParameter.trim().equals("")) {
            JOptionPane.showMessageDialog(parameterView, "Nama Parameter Masih Kosong");
        } else if (nilai == null) {
            JOptionPane.showMessageDialog(parameterView, "Nilai Masih kosong");
        } else {
            parameterServiceImpl.setId(id);
            parameterServiceImpl.setNamaParameter(namaParameter);
            parameterServiceImpl.setNilai(nilai);
            try {
                parameterServiceImpl.updateParameter();
                JOptionPane.showMessageDialog(parameterView, "Data Parameter Berhasil di Update");
                parameterServiceImpl.resetParameter();
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(parameterView, new Object[] {
                    "terjadi error di database dengan pesan : "
                });
            }
        }
    }
    
    public void deleteParameter(ParameterView parameterView) throws ParameterException {
        if (parameterView.getTblParameter().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(parameterView, "Id Parameter Belum di Pilih");
            return;
        }
        
        Integer id = Integer.parseInt(parameterView.getTextId().getText());
        parameterServiceImpl.setId(id);
        try {
            parameterServiceImpl.deleteParameter();
            JOptionPane.showMessageDialog(parameterView, "Data Parameter Berhasil di Hapus");
            parameterServiceImpl.resetParameter();
        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(parameterView, new Object[] {
                "terjadi error di database dengan pesan : "
            });
        }
        
        
    }
}
