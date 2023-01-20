/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.Parameter;

/**
 *
 * @author cvgs
 */
public interface ParameterService {
    public void onChange(ParameterServiceImpl parameterServiceImpl);
    public void onInsert(Parameter parameter);
    public void onUpdate(Parameter parameter);
    public void onDelete();
}
