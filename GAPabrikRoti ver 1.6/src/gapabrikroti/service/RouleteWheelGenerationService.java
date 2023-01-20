/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.RouleteWheel;
import gapabrikroti.model.RouleteWheelGeneration;

/**
 *
 * @author cvgs
 */
public interface RouleteWheelGenerationService {
    public void onChange(RouleteWheelGenerationServiceImpl rouleteWheelGenerationServiceImpl);
    public void onInsert(RouleteWheelGeneration rouleteWheelGeneration);
    public void onUpdate(RouleteWheelGeneration rouleteWheelGeneration);
    public void onDelete();
}
