/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.dao.PopulasiDAO;
import gapabrikroti.error.PopulasiException;
import gapabrikroti.model.Populasi;
import gapabrikroti.utility.databaseUtility;
import java.sql.SQLException;

/**
 *
 * @author cvgs
 */
public class PopulasiServiceImpl {
    private int noKromosom;
    private int binerX;
    private int binerY;
    private PopulasiService populasiService;

    public int getNoKromosom() {
        return noKromosom;
    }

    public void setNoKromosom(int noKromosom) {
        this.noKromosom = noKromosom;
    }

    public int getBinerX() {
        return binerX;
    }

    public void setBinerX(int binerX) {
        this.binerX = binerX;
    }

    public int getBinerY() {
        return binerY;
    }

    public void setBinerY(int binerY) {
        this.binerY = binerY;
    }

    public PopulasiService getPopulasiService() {
        return populasiService;
    }

    public void setPopulasiService(PopulasiService populasiService) {
        this.populasiService = populasiService;
    }
    
    protected void fireOnChange() {
        if (populasiService != null) {
            populasiService.onChange(this);
        }
    }
    
    protected void fireOnInsert(Populasi populasi) {
        if (populasiService != null) {
            populasiService.onInsert(populasi);
        }
    }
    
    public void insertPopulasi() throws SQLException, PopulasiException {
        PopulasiDAO populasiDAO = databaseUtility.getPopulasiDAO();
        
        Populasi populasi = new Populasi();
        populasi.setBinerX(binerX);
        populasi.setBinerY(binerY);
        
        populasiDAO.addPopulasi(populasi);
        
        fireOnInsert(populasi);
    }

    public void deletePopulasi() throws SQLException, PopulasiException {
        PopulasiDAO populasiDAO = databaseUtility.getPopulasiDAO();
        
        Populasi populasi = new Populasi();
        
        populasiDAO.clearPopulasi();
    }
}
