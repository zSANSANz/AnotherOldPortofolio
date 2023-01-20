/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.CrossOverGeneration;

/**
 *
 * @author cvgs
 */
public interface CrossOverGenerationService {
    public void onChange(CrossOverGenerationServiceImpl crossOverGenerationServiceImpl);
    public void onInsert(CrossOverGeneration crossOverGeneration);
    public void onUpdate(CrossOverGeneration crossOverGeneration);
    public void onDelete();

}
