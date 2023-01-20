/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.Evaluasi;
import gapabrikroti.model.EvaluasiGeneration;

/**
 *
 * @author cvgs
 */
public interface EvaluasiGenerationService {
    public void onChange(EvaluasiGenerationServiceImpl evaluasiGenerationServiceImpl);
    public void onInsert(EvaluasiGeneration evaluasiGeneration);
    public void onUpdate(EvaluasiGeneration evaluasiGeneration);
    public void onDelete();
}
