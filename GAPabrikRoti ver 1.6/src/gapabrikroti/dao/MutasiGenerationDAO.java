/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao;

import gapabrikroti.error.MutasiGenerationException;
import gapabrikroti.model.MutasiGeneration;
import java.util.List;

/**
 *
 * @author cvgs
 */
public interface MutasiGenerationDAO {
    public void addMutasiGeneration(MutasiGeneration mutasiGeneration) throws MutasiGenerationException;
    public List<MutasiGeneration> getAllMutasiGeneration() throws MutasiGenerationException;
    public void clearMutasiGeneration() throws MutasiGenerationException;
    
}
