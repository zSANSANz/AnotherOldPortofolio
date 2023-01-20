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
public class CrossOverGeneration {
    private int noCrossOver;
    private double CrossOverX;
    private double CrossOverY;
    private double fitness;
    private double c;
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
        return CrossOverX;
    }

    public void setCrossOverX(double CrossOverX) {
        this.CrossOverX = CrossOverX;
    }

    public double getCrossOverY() {
        return CrossOverY;
    }

    public void setCrossOverY(double CrossOverY) {
        this.CrossOverY = CrossOverY;
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
