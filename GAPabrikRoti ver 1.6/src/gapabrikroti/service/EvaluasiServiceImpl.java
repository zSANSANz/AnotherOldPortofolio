/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.dao.EvaluasiDAO;
import gapabrikroti.error.EvaluasiException;
import gapabrikroti.model.Evaluasi;
import gapabrikroti.utility.databaseUtility;
import java.sql.SQLException;

/**
 *
 * @author cvgs
 */
public class EvaluasiServiceImpl {
    private int noEvaluasi;
    private double EvaluasiX;
    private double EvaluasiY;
    private double fitness;
    private double c;
    private double Pi;
    private double probabilitasCumulatif;
    private EvaluasiService evaluasiService;

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

    public EvaluasiService getEvaluasiService() {
        return evaluasiService;
    }

    public void setEvaluasiService(EvaluasiService evaluasiService) {
        this.evaluasiService = evaluasiService;
    }
    
    protected void fireOnChange() {
        if (evaluasiService != null) {
            evaluasiService.onChange(this);
        }
    }
    
    protected void fireOnInsert(Evaluasi evaluasi) {
        if (evaluasiService != null) {
            evaluasiService.onInsert(evaluasi);
        }
    }
    
    public void insertEvaluasi() throws SQLException, EvaluasiException {
        EvaluasiDAO evaluasiDAO = databaseUtility.getEvaluasiDAO();
        
        Evaluasi evaluasi = new Evaluasi();
        evaluasi.setEvaluasiX(getEvaluasiX());
        evaluasi.setEvaluasiY(getEvaluasiY());
        evaluasi.setFitness(getFitness());
        evaluasi.setC(getC());
        evaluasi.setPi(getPi());
        evaluasi.setProbabilitasCumulatif(probabilitasCumulatif);
        
        evaluasiDAO.addEvaluasi(evaluasi);
        
        fireOnInsert(evaluasi);
    }

    public void deleteEvaluasi() throws SQLException, EvaluasiException {
        EvaluasiDAO evaluasiDAO = databaseUtility.getEvaluasiDAO();
        
        Evaluasi evaluasi = new Evaluasi();
        
        evaluasiDAO.clearEvaluasi();
    }
}
