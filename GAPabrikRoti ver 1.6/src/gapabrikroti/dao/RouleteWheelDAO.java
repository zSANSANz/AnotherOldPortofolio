/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao;

import gapabrikroti.error.RouleteWheelException;
import gapabrikroti.model.RouleteWheel;
import java.util.List;

/**
 *
 * @author cvgs
 */
public interface RouleteWheelDAO {
    public void addRouleteWheel(RouleteWheel rouleteWheel) throws RouleteWheelException;
    public List<RouleteWheel> getAllRouleteWheel() throws RouleteWheelException;
    public void clearRouleteWheel() throws RouleteWheelException;
}
