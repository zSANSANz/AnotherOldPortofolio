/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.RouleteWheel;

/**
 *
 * @author cvgs
 */
public interface RouleteWheelService {
    public void onChange(RouleteWheelServiceImpl rouleteWheelServiceImpl);
    public void onInsert(RouleteWheel rouleteWheel);
    public void onUpdate(RouleteWheel rouleteWheel);
    public void onDelete();
}
