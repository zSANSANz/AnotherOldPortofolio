/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.dao.MutasiDAO;
import gapabrikroti.error.MutasiException;
import gapabrikroti.model.Mutasi;
import gapabrikroti.utility.databaseUtility;
import java.sql.SQLException;

/**
 *
 * @author cvgs
 */
public class MutasiServiceImpl {
    private int noMutasi;
    private double mutasiX;
    private double mutasiY;
    private double fitness;
    private double nilaiC;
    private MutasiService mutasiService;

    public int getNoMutasi() {
        return noMutasi;
    }

    public void setNoMutasi(int noMutasi) {
        this.noMutasi = noMutasi;
    }

    public double getMutasiX() {
        return mutasiX;
    }

    public void setMutasiX(double mutasiX) {
        this.mutasiX = mutasiX;
    }

    public double getMutasiY() {
        return mutasiY;
    }

    public void setMutasiY(double mutasiY) {
        this.mutasiY = mutasiY;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getNilaiC() {
        return nilaiC;
    }

    public void setNilaiC(double nilaiC) {
        this.nilaiC = nilaiC;
    }

    public MutasiService getMutasiService() {
        return mutasiService;
    }

    public void setMutasiService(MutasiService mutasiService) {
        this.mutasiService = mutasiService;
    }
    
    protected void fireOnChange() {
        if (mutasiService != null) {
            mutasiService.onChance(this);
        }
    }
    
    protected void fireOnInsert(Mutasi mutasi) {
        if (mutasiService != null) {
            mutasiService.onInsert(mutasi);
        }
    }
    
    public void insertMutasi() throws SQLException, MutasiException {
        MutasiDAO mutasiDAO = databaseUtility.getMutasiDAO();
        
        Mutasi mutasi = new Mutasi();
        mutasi.setMutasiX(getMutasiX());
        mutasi.setMutasiY(getMutasiY());
        mutasi.setFitness(getFitness());
        mutasi.setC(getNilaiC());
        
        mutasiDAO.addMutasi(mutasi);
        
        fireOnInsert(mutasi);
    }
    
    public void deleteMutasi() throws SQLException, MutasiException {
        MutasiDAO mutasiDAO = databaseUtility.getMutasiDAO();
        
        mutasiDAO.clearMutasi();
    }
        
}
