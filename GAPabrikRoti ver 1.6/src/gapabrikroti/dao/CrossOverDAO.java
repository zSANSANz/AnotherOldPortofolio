/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao;

import gapabrikroti.error.CrossOverException;
import gapabrikroti.model.CrossOver;
import java.util.List;

/**
 *
 * @author cvgs
 */
public interface CrossOverDAO {
    public void addCrossOver(CrossOver crossOver) throws CrossOverException;
    public List<CrossOver> getAllCrossOver() throws CrossOverException;
    public void clearCrossOver() throws CrossOverException;
}
