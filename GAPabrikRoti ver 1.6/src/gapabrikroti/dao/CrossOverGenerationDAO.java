/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao;

import gapabrikroti.error.CrossOverGenerationException;
import gapabrikroti.model.CrossOverGeneration;
import java.util.List;

/**
 *
 * @author cvgs
 */
public interface CrossOverGenerationDAO {
    public void addCrossOverGeneration(CrossOverGeneration crossOverGeneration) throws CrossOverGenerationException;
    public List<CrossOverGeneration> getAllCrossOverGeneration() throws CrossOverGenerationException;
    public void clearCrossOverGeneration() throws CrossOverGenerationException;
}
