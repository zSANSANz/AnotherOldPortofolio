/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.dao.EvaluasiDAO;
import gapabrikroti.dao.EvaluasiGenerationDAO;
import gapabrikroti.error.EvaluasiException;
import gapabrikroti.error.EvaluasiGenerationException;
import gapabrikroti.model.Evaluasi;
import gapabrikroti.model.EvaluasiGeneration;
import gapabrikroti.utility.databaseUtility;
import java.sql.SQLException;

/**
 *
 * @author cvgs
 */
public class EvaluasiGenerationServiceImpl {
    private int noEvaluasi;
    private double EvaluasiX;
    private double EvaluasiY;
    private double fitness;
    private double c;
    private double Pi;
    private double probabilitasCumulatif;
    private EvaluasiGenerationService evaluasiGenerationService;
    private int generationNo;

    public int getGenerationNo() {
        return generationNo;
    }

    public void setGenerationNo(int generationNo) {
        this.generationNo = generationNo;
    }

    public int getNoEvaluasi() {
        return noEvaluasi;
    }

    public void setNoEvaluasi(int noEvaluasi) {
        this.noEvaluasi = noEvaluasi;
    }

    public double getEvaluasiX() {
        return EvaluasiX;
    }

    public void setEvaluasiX(double EvaluasiX) {
        this.EvaluasiX = EvaluasiX;
    }

    public double getEvaluasiY() {
        return EvaluasiY;
    }

    public void setEvaluasiY(double EvaluasiY) {
        this.EvaluasiY = EvaluasiY;
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

    public double getPi() {
        return Pi;
    }

    public void setPi(double Pi) {
        this.Pi = Pi;
    }

    public double getProbabilitasCumulatif() {
        return probabilitasCumulatif;
    }

    public void setProbabilitasCumulatif(double probabilitasCumulatif) {
        this.probabilitasCumulatif = probabilitasCumulatif;
    }

    public EvaluasiGenerationService getEvaluasiGenerationService() {
        return evaluasiGenerationService;
    }

    public void setEvaluasiGenerationService(EvaluasiGenerationService evaluasiGenerationService) {
        this.evaluasiGenerationService = evaluasiGenerationService;
    }
    
    protected void fireOnChange() {
        if (evaluasiGenerationService != null) {
            evaluasiGenerationService.onChange(this);
        }
    }
    
    protected void fireOnInsert(EvaluasiGeneration evaluasiGeneration) {
        if (evaluasiGenerationService != null) {
            evaluasiGenerationService.onInsert(evaluasiGeneration);
        }
    }
    
    public void insertEvaluasiGeneration() throws SQLException, EvaluasiGenerationException {
        EvaluasiGenerationDAO evaluasiGenerationDAO = databaseUtility.getEvaluasiGenerationDAO();
        
        EvaluasiGeneration evaluasiGeneration = new EvaluasiGeneration();
        evaluasiGeneration.setEvaluasiX(getEvaluasiX());
        evaluasiGeneration.setEvaluasiY(getEvaluasiY());
        evaluasiGeneration.setFitness(getFitness());
        evaluasiGeneration.setC(getC());
        evaluasiGeneration.setPi(getPi());
        evaluasiGeneration.setProbabilitasCumulatif(probabilitasCumulatif);
        evaluasiGeneration.setGenerationNo(getGenerationNo());
        
        evaluasiGenerationDAO.addEvaluasiGeneration(evaluasiGeneration);
        
        fireOnInsert(evaluasiGeneration);
    }

    public void deleteEvaluasiGeneration() throws SQLException, EvaluasiGenerationException {
        EvaluasiGenerationDAO evaluasiGenerationDAO = databaseUtility.getEvaluasiGenerationDAO();
        
        evaluasiGenerationDAO.clearEvaluasiGeneration();
    }
}
