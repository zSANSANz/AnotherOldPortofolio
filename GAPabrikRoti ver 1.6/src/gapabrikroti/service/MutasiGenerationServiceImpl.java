/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.dao.MutasiGenerationDAO;
import gapabrikroti.error.MutasiGenerationException;
import gapabrikroti.model.MutasiGeneration;
import gapabrikroti.utility.databaseUtility;
import java.sql.SQLException;

/**
 *
 * @author cvgs
 */
public class MutasiGenerationServiceImpl {
    private int noMutasi;
    private double mutasiX;
    private double mutasiY;
    private double fitness;
    private double nilaiC;
    private MutasiGenerationService mutasiGenerationService;
    private int generationNo;

    public int getGenerationNo() {
        return generationNo;
    }

    public void setGenerationNo(int generationNo) {
        this.generationNo = generationNo;
    }

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

    public MutasiGenerationService getMutasiService() {
        return mutasiGenerationService;
    }

    public void setMutasiGenerationService(MutasiGenerationService mutasiGenerationService) {
        this.mutasiGenerationService = mutasiGenerationService;
    }
    
    protected void fireOnChange() {
        if (mutasiGenerationService != null) {
            mutasiGenerationService.onChance(this);
        }
    }
    
    protected void fireOnInsert(MutasiGeneration mutasiGeneration) {
        if (mutasiGenerationService != null) {
            mutasiGenerationService.onInsert(mutasiGeneration);
        }
    }
    
    public void insertMutasiGeneration() throws SQLException, MutasiGenerationException {
        MutasiGenerationDAO mutasiGenerationDAO = databaseUtility.getMutasiGenerationDAO();
        
        MutasiGeneration mutasiGeneration = new MutasiGeneration();
        mutasiGeneration.setMutasiX(getMutasiX());
        mutasiGeneration.setMutasiY(getMutasiY());
        mutasiGeneration.setFitness(getFitness());
        mutasiGeneration.setC(getNilaiC());
        mutasiGeneration.setGenerationNo(getGenerationNo());
        
        mutasiGenerationDAO.addMutasiGeneration(mutasiGeneration);
        
        fireOnInsert(mutasiGeneration);
    }
    
    public void deleteMutasiGeneration() throws SQLException, MutasiGenerationException {
        MutasiGenerationDAO mutasiGenerationDAO = databaseUtility.getMutasiGenerationDAO();
        
        mutasiGenerationDAO.clearMutasiGeneration();
    }
        
}
