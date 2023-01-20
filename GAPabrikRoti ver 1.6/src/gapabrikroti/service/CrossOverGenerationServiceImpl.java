/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.dao.CrossOverGenerationDAO;
import gapabrikroti.error.CrossOverGenerationException;
import gapabrikroti.model.CrossOverGeneration;
import gapabrikroti.utility.databaseUtility;
import java.sql.SQLException;

/**
 *
 * @author cvgs
 */
public class CrossOverGenerationServiceImpl {
    private int noCrossOver;
    private double crossOverX;
    private double crossOverY;
    private double fitness;
    private double c;
    private CrossOverGenerationService crossOverGenerationService;
    private int generationNo;

    public int getGenerationNo() {
        return generationNo;
    }

    public void setGenerationNo(int generationNo) {
        this.generationNo = generationNo;
    }

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

    public CrossOverGenerationService getCrossOverService() {
        return crossOverGenerationService;
    }

    public void setCrossOverGenerationService(CrossOverGenerationService crossOverGenerationService) {
        this.crossOverGenerationService = crossOverGenerationService;
    }
    
    protected void fireOnChange() {
        if (crossOverGenerationService != null) {
            crossOverGenerationService.onChange(this);
        }
    }
    
    protected void fireOnInsert(CrossOverGeneration crossOverGeneration) {
        if (crossOverGenerationService != null) {
            crossOverGenerationService.onInsert(crossOverGeneration);
        }
    }
    
    public void insertCrossOverGeneration() throws SQLException, CrossOverGenerationException {
        CrossOverGenerationDAO crossOverGenerationDAO = databaseUtility.getCrossOverGenerationDAO();
        
        CrossOverGeneration crossOverGeneration = new CrossOverGeneration();
        crossOverGeneration.setCrossOverX(getCrossOverX());
        crossOverGeneration.setCrossOverY(getCrossOverY());
        crossOverGeneration.setFitness(getFitness());
        crossOverGeneration.setC(getC());
        crossOverGeneration.setGenerationNo(getGenerationNo());
        
        crossOverGenerationDAO.addCrossOverGeneration(crossOverGeneration);
        
        fireOnInsert(crossOverGeneration);
    }
    
    public void deleteCrossOverGeneration() throws SQLException, CrossOverGenerationException {
        CrossOverGenerationDAO crossOverGenerationDAO = databaseUtility.getCrossOverGenerationDAO();
        
        crossOverGenerationDAO.clearCrossOverGeneration();
    }
}
