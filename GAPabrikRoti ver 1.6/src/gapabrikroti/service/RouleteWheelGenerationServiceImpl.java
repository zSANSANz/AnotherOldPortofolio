/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.dao.RouleteWheelGenerationDAO;
import gapabrikroti.error.RouleteWheelGenerationException;
import gapabrikroti.model.RouleteWheelGeneration;
import gapabrikroti.utility.databaseUtility;
import java.sql.SQLException;

/**
 *
 * @author cvgs
 */
public class RouleteWheelGenerationServiceImpl {
    private int rouleteWheelId;
    private double rouleteWheelGenX;
    private double rouleteWheelGenY;
    private RouleteWheelGenerationService rouleteWheelGenerationService;
    private int generationNo;

    public int getGenerationNo() {
        return generationNo;
    }

    public void setGenerationNo(int generationNo) {
        this.generationNo = generationNo;
    }

    public int getRouleteWheelId() {
        return rouleteWheelId;
    }

    public void setRouleteWheelId(int rouleteWheelId) {
        this.rouleteWheelId = rouleteWheelId;
    }

    public double getRouleteWheelGenX() {
        return rouleteWheelGenX;
    }

    public void setRouleteWheelGenX(double rouleteWheelGenX) {
        this.rouleteWheelGenX = rouleteWheelGenX;
    }

    public double getRouleteWheelGenY() {
        return rouleteWheelGenY;
    }

    public void setRouleteWheelGenY(double rouleteWheelGenY) {
        this.rouleteWheelGenY = rouleteWheelGenY;
    }

    public RouleteWheelGenerationService getRouleteWheelGenerationService() {
        return rouleteWheelGenerationService;
    }

    public void setRouleteWheelGenerationService(RouleteWheelGenerationService rouleteWheelGenerationService) {
        this.rouleteWheelGenerationService = rouleteWheelGenerationService;
    }
    
    protected void fireOnInsert(RouleteWheelGeneration rouleteWheelGeneration) {
        if (rouleteWheelGenerationService != null) {
            rouleteWheelGenerationService.onInsert(rouleteWheelGeneration);
        }
    }
    
    public void insertRouleteWheelGeneration() throws SQLException, RouleteWheelGenerationException {
        RouleteWheelGenerationDAO rouleteWheelGenerationDAO = databaseUtility.getRouleteWheelGenerationDAO();
        
        RouleteWheelGeneration rouleteWheelGeneration = new RouleteWheelGeneration();
        rouleteWheelGeneration.setRouleteWheelGenX(getRouleteWheelGenX());
        rouleteWheelGeneration.setRouleteWheelGenY(getRouleteWheelGenY());
        rouleteWheelGeneration.setGenerationNo(getGenerationNo());
        
        rouleteWheelGenerationDAO.addRouleteWheelGeneration(rouleteWheelGeneration);
        
        fireOnInsert(rouleteWheelGeneration);
    }

    public void deleteRouleteWheelGeneration() throws SQLException, RouleteWheelGenerationException {
        RouleteWheelGenerationDAO rouleteWheelGenerationDAO = databaseUtility.getRouleteWheelGenerationDAO();
        
        rouleteWheelGenerationDAO.clearRouleteWheelGeneration();
    }
}
