/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao;

import gapabrikroti.error.MutasiException;
import gapabrikroti.model.Mutasi;
import java.util.List;

/**
 *
 * @author cvgs
 */
public interface MutasiDAO {
    public void addMutasi(Mutasi mutasi) throws MutasiException;
    public List<Mutasi> getAllMutasi() throws MutasiException;
    public void clearMutasi() throws MutasiException;
    
}
