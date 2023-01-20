/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.dao.RataRataDAO;
import gapabrikroti.error.RataRataException;
import gapabrikroti.model.RataRata;
import gapabrikroti.utility.databaseUtility;
import java.sql.SQLException;

/**
 *
 * @author cvgs
 */
public class RataRataServiceImpl {
    private int noRataRata;
    private double rataRataX;
    private double rataRataY;
    private double totalFitness;
    private double probabilitasKumulatif;
    private RataRataService rataRataService;
    
    public int getNoRataRata() {
        return noRataRata;
    }

    public void setNoRataRata(int noRataRata) {
        this.noRataRata = noRataRata;
    }

    public double getRataRataX() {
        return rataRataX;
    }

    public void setRataRataX(double rataRataX) {
        this.rataRataX = rataRataX;
    }

    public double getRataRataY() {
        return rataRataY;
    }

    public void setRataRataY(double rataRataY) {
        this.rataRataY = rataRataY;
    }

    public double getTotalFitness() {
        return totalFitness;
    }

    public void setTotalFitness(double totalFitness) {
        this.totalFitness = totalFitness;
    }

    public double getProbabilitasKumulatif() {
        return probabilitasKumulatif;
    }

    public void setProbabilitasKumulatif(double probabilitasKumulatif) {
        this.probabilitasKumulatif = probabilitasKumulatif;
    }

    public RataRataService getRataRataService() {
        return rataRataService;
    }

    public void setRataRataService(RataRataService rataRataService) {
        this.rataRataService = rataRataService;
    }
    
    protected void fireOnChange() {
        if (rataRataService != null) {
            rataRataService.onChange(this);
        }
    }
    
    protected void fireOnInsert(RataRata rataRata) {
//        if (rataRataService != null) {
//            rataRataService.onInsert(rataRata);
//        }
    }
    
    public void insertRataRata() throws SQLException, RataRataException {
        RataRataDAO rataRataDAO = databaseUtility.getRataRataDAO();
        
        RataRata rataRata = new RataRata();
        rataRata.setRataRataX(rataRataX);
        rataRata.setRataRataY(rataRataY);
        rataRata.setTotalFitness(totalFitness);
        rataRata.setProbabilitasKumulatif(probabilitasKumulatif);
        
        rataRataDAO.addRataRata(rataRata);
        
        fireOnInsert(rataRata);
    }

    public void deleteRataRata() throws SQLException, RataRataException {
        RataRataDAO rataRataDAO = databaseUtility.getRataRataDAO();
        
        RataRata rataRata = new RataRata();
        
        rataRataDAO.clearRataRata();
    }
    
}
