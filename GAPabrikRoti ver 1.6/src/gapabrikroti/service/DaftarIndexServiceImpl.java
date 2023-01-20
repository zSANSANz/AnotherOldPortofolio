/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.dao.DaftarIndexDAO;
import gapabrikroti.error.DaftarIndexException;
import gapabrikroti.model.DaftarIndex;
import gapabrikroti.utility.databaseUtility;
import java.sql.SQLException;

/**
 *
 * @author cvgs
 */
public class DaftarIndexServiceImpl {
    private int id;
    private String istilah;
    private String deskripsi;
    private DaftarIndexService daftarIndexService;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIstilah() {
        return istilah;
    }

    public void setIstilah(String istilah) {
        this.istilah = istilah;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public DaftarIndexService getDaftarIndexService() {
        return daftarIndexService;
    }

    public void setDaftarIndexService(DaftarIndexService daftarIndexService) {
        this.daftarIndexService = daftarIndexService;
    }
    
    protected void fireOnChange() {
        if(daftarIndexService != null) {
            daftarIndexService.onChange(this);
        }
    }

    protected void fireOnInsert(DaftarIndex daftarIndex) {
        if(daftarIndexService != null) {
            daftarIndexService.onInsert(daftarIndex);
        }
    }

    protected void fireOnUpdate(DaftarIndex daftarIndex) {
        if(daftarIndexService != null) {
            daftarIndexService.onUpdate(daftarIndex);
        }
    }

    protected void fireOnDelete() {
        if(daftarIndexService != null) {
            daftarIndexService.onDelete();
        }
    }

    public void resetDaftarIndex() {
        setId(0);
        setIstilah("");
        setDeskripsi("");
    }

    public void insertDaftarIndex() throws SQLException, DaftarIndexException {
        DaftarIndexDAO daftarIndexDAO = databaseUtility.getDaftarIndexDAO();

        DaftarIndex daftarIndex = new DaftarIndex();
        daftarIndex.setId(id);
        daftarIndex.setIstilah(istilah);
        daftarIndex.setDeskripsi(deskripsi);
        
        daftarIndexDAO.addDaftarIndex(daftarIndex);

        fireOnInsert(daftarIndex);
    }
    
    public void updateDaftarIndex() throws SQLException, DaftarIndexException {
        DaftarIndexDAO daftarIndexDAO = databaseUtility.getDaftarIndexDAO();

        DaftarIndex daftarIndex = new DaftarIndex();
        daftarIndex.setId(id);
        daftarIndex.setIstilah(istilah);
        daftarIndex.setDeskripsi(deskripsi);
        
        daftarIndexDAO.editDaftarIndex(daftarIndex);

        fireOnUpdate(daftarIndex);
    }
    
    public void deleteDaftarIndex() throws SQLException, DaftarIndexException {
        DaftarIndexDAO daftarIndexDao = databaseUtility.getDaftarIndexDAO();

        daftarIndexDao.deleteDaftarIndex(id);

        fireOnDelete();
    }
    
}
