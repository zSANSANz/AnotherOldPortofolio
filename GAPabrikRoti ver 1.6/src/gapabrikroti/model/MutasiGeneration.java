/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.model;

/**
 *
 * @author cvgs
 */
public class MutasiGeneration {
    private int noMutasi;
    private double MutasiX;
    private double MutasiY;
    private double fitness;
    private double c;
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
        return MutasiX;
    }

    public void setMutasiX(double MutasiX) {
        this.MutasiX = MutasiX;
    }

    public double getMutasiY() {
        return MutasiY;
    }

    public void setMutasiY(double MutasiY) {
        this.MutasiY = MutasiY;
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
    
}
