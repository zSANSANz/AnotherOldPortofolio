/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.dao.CrossOverDAO;
import gapabrikroti.error.CrossOverException;
import gapabrikroti.model.CrossOver;
import gapabrikroti.model.Mutasi;
import gapabrikroti.utility.databaseUtility;
import java.sql.SQLException;

/**
 *
 * @author cvgs
 */
public class CrossOverServiceImpl {
    private int noCrossOver;
    private double crossOverX;
    private double crossOverY;
    private double fitness;
    private double c;
    private CrossOverService crossOverService;

    public int getNoCrossOver() {
        return noCrossOver;
    }

    public void setNoCrossOver(int noCrossOver) {
        this.noCrossOver = noCrossOver;
    }

    public double getCrossOverX() {
        return crossOverX;
    }

    public void setCrossOverX(double crossOverX) {
        this.crossOverX = crossOverX;
    }

    public double getCrossOverY() {
        return crossOverY;
    }

    public void setCrossOverY(double crossOverY) {
        this.crossOverY = crossOverY;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public CrossOverService getCrossOverService() {
        return crossOverService;
    }

    public void setCrossOverService(CrossOverService crossOverService) {
        this.crossOverService = crossOverService;
    }
    
    protected void fireOnChange() {
        if (crossOverService != null) {
            crossOverService.onChange(this);
        }
    }
    
    protected void fireOnInsert(CrossOver crossOver) {
        if (crossOverService != null) {
            crossOverService.onInsert(crossOver);
        }
    }
    
    public void insertCrossOver() throws SQLException, CrossOverException {
        CrossOverDAO crossOverDAO = databaseUtility.getCrossOverDAO();
        
        CrossOver crossOver = new CrossOver();
        crossOver.setCrossOverX(getCrossOverX());
        crossOver.setCrossOverY(getCrossOverY());
        crossOver.setFitness(getFitness());
        crossOver.setC(getC());
        
        crossOverDAO.addCrossOver(crossOver);
        
        fireOnInsert(crossOver);
    }
    
    public void deleteCrossOver() throws SQLException, CrossOverException {
        CrossOverDAO crossOverDAO = databaseUtility.getCrossOverDAO();
        
        crossOverDAO.clearCrossOver();
    }
}
