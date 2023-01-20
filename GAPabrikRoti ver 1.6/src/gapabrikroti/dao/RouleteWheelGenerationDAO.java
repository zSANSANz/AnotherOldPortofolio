/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao;

import gapabrikroti.error.RouleteWheelGenerationException;
import gapabrikroti.model.RouleteWheelGeneration;
import java.util.List;

/**
 *
 * @author cvgs
 */
public interface RouleteWheelGenerationDAO {
    public void addRouleteWheelGeneration(RouleteWheelGeneration rouleteWheelGeneration) throws RouleteWheelGenerationException;
    public List<RouleteWheelGeneration> getAllRouleteWheelGeneration() throws RouleteWheelGenerationException;
    public void clearRouleteWheelGeneration() throws RouleteWheelGenerationException;
}
