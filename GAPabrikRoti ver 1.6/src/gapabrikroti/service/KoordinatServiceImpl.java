/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.dao.KoordinatDAO;
import gapabrikroti.error.KoordinatException;
import gapabrikroti.model.Koordinat;
import gapabrikroti.utility.databaseUtility;
import java.sql.SQLException;

/**
 *
 * @author cvgs
 */
public class KoordinatServiceImpl {
    private int id;
    private int x;
    private int y;
    private int bobot;
    private int XMax;
    private int YMax;
    private int XMin;
    private int YMin;
    private KoordinatService koordinatService;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getBobot() {
        return bobot;
    }

    public void setBobot(int bobot) {
        this.bobot = bobot;
    }

    public KoordinatService getKoordinatService() {
        return koordinatService;
    }

    public void setKoordinatService(KoordinatService koordinatService) {
        this.koordinatService = koordinatService;
    }

    public int getXMax() {
        return XMax;
    }

    public void setXMax(int XMax) {
        this.XMax = XMax;
    }

    public int getYMax() {
        return YMax;
    }

    public void setYMax(int YMax) {
        this.YMax = YMax;
    }

    public int getXMin() {
        return XMin;
    }

    public void setXMin(int XMin) {
        this.XMin = XMin;
    }

    public int getYMin() {
        return YMin;
    }

    public void setYMin(int YMin) {
        this.YMin = YMin;
    }

    protected void fireOnChange() {
        if (koordinatService != null) {
            koordinatService.onChange(this);
        }
    }

    protected void fireOnInsert(Koordinat koordinat) {
        if (koordinatService != null) {
            koordinatService.onInsert(koordinat);
        }
    }

    protected void fireOnUpdate(Koordinat koordinat) {
        if (koordinatService != null) {
            koordinatService.onUpdate(koordinat);
        }
    }

    protected void fireOnDelete() {
        if (koordinatService != null) {
            koordinatService.onDelete();
        }
    }

    public void resetKoordinat() {
        setId(0);
        setX(0);
        setY(0);
        setBobot(0);
    }

    public void insertKoordinat() throws SQLException, KoordinatException {
        KoordinatDAO koordinatDAO = databaseUtility.getKoordinatDAO();

        Koordinat koordinat = new Koordinat();
        koordinat.setId(id);
        koordinat.setX(x);
        koordinat.setY(y);
        koordinat.setBobot(bobot);
        
        koordinatDAO.addKoordinat(koordinat);
        
        fireOnInsert(koordinat);
    }
    
    public void updateKoordinat() throws SQLException, KoordinatException {
        KoordinatDAO koordinatDAO = databaseUtility.getKoordinatDAO();

        Koordinat koordinat = new Koordinat();
        koordinat.setId(id);
        koordinat.setX(x);
        koordinat.setY(y);
        koordinat.setBobot(bobot);
        
        koordinatDAO.editKoordinat(koordinat);
        
        fireOnInsert(koordinat);
    }
    
    public void deleteKoordinat() throws SQLException, KoordinatException {
        KoordinatDAO koordinatDAO = databaseUtility.getKoordinatDAO();

        koordinatDAO.deleteKoordinat(id);

        fireOnDelete();
    }
    
    public void minMaxKoordinat() throws SQLException, KoordinatException {
        KoordinatDAO koordinatDAO = databaseUtility.getKoordinatDAO();

        koordinatDAO.getMaxKoordinat();
        
        fireOnChange();
    }

    
}
