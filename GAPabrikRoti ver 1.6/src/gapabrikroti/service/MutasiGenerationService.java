/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.Mutasi;
import gapabrikroti.model.MutasiGeneration;

/**
 *
 * @author cvgs
 */
public interface MutasiGenerationService {
    public void onChance(MutasiGenerationServiceImpl mutasiGenerationServiceImpl);
    public void onInsert(MutasiGeneration mutasiGeneration);
    public void onUpdate(MutasiGeneration mutasiGeneration);
    public void onDelete();
}
