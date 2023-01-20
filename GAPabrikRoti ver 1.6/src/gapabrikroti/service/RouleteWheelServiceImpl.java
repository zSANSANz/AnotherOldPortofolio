/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.dao.RouleteWheelDAO;
import gapabrikroti.error.RouleteWheelException;
import gapabrikroti.model.RouleteWheel;
import gapabrikroti.utility.databaseUtility;
import java.sql.SQLException;

/**
 *
 * @author cvgs
 */
public class RouleteWheelServiceImpl {
    private int rouleteWheelId;
    private double rouleteWheelGenX;
    private double rouleteWheelGenY;
    private RouleteWheelService rouleteWheelService;

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

    public RouleteWheelService getRouleteWheelService() {
        return rouleteWheelService;
    }

    public void setRouleteWheelService(RouleteWheelService rouleteWheelService) {
        this.rouleteWheelService = rouleteWheelService;
    }
    
    protected void fireOnInsert(RouleteWheel rouleteWheel) {
        if (rouleteWheelService != null) {
            rouleteWheelService.onInsert(rouleteWheel);
        }
    }
    
    public void insertRouleteWheel() throws SQLException, RouleteWheelException {
        RouleteWheelDAO rouleteWheelDAO = databaseUtility.getRouleteWheelDAO();
        
        RouleteWheel rouleteWheel = new RouleteWheel();
        rouleteWheel.setRouleteWheelGenX(getRouleteWheelGenX());
        rouleteWheel.setRouleteWheelGenY(getRouleteWheelGenY());
        
        rouleteWheelDAO.addRouleteWheel(rouleteWheel);
        
        fireOnInsert(rouleteWheel);
    }

    public void deleteRouleteWheel() throws SQLException, RouleteWheelException {
        RouleteWheelDAO rouleteWheelDAO = databaseUtility.getRouleteWheelDAO();
        
        RouleteWheel rouleteWheel = new RouleteWheel();
        
        rouleteWheelDAO.clearRouleteWheel();
    }
}
