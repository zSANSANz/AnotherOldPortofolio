/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao;

import gapabrikroti.error.EvaluasiGenerationException;
import gapabrikroti.model.EvaluasiGeneration;
import java.util.List;

/**
 *
 * @author cvgs
 */
public interface EvaluasiGenerationDAO {
    public void addEvaluasiGeneration(EvaluasiGeneration evaluasiGeneration) throws EvaluasiGenerationException;
    public List<EvaluasiGeneration> getAllEvaluasiGeneration() throws EvaluasiGenerationException;
    public EvaluasiGeneration getAllEvaluasiForSelGeneration() throws EvaluasiGenerationException;
    public void clearEvaluasiGeneration() throws EvaluasiGenerationException;
    public List<EvaluasiGeneration> getAllEvaluasiGenerationByProbabilitas() throws EvaluasiGenerationException;
}
