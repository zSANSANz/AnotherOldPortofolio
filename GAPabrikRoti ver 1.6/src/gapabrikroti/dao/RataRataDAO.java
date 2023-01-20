/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao;

import gapabrikroti.error.RataRataException;
import gapabrikroti.model.RataRata;
import java.util.List;

/**
 *
 * @author cvgs
 */
public interface RataRataDAO {
    public void addRataRata(RataRata rataRata) throws RataRataException;
    public List<RataRata> getAllRataRata() throws RataRataException;
    public void clearRataRata() throws RataRataException;
}
