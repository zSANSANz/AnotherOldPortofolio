/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao;

import gapabrikroti.error.DaftarIndexException;
import gapabrikroti.model.DaftarIndex;
import java.util.List;

/**
 *
 * @author cvgs
 */
public interface DaftarIndexDAO {
    public void addDaftarIndex(DaftarIndex daftarIndex) throws DaftarIndexException;
    public void editDaftarIndex(DaftarIndex daftarIndex) throws DaftarIndexException;
    public void deleteDaftarIndex(int id) throws DaftarIndexException;
    public List<DaftarIndex> getAllDaftarIndex() throws DaftarIndexException;
    public DaftarIndex getDaftarIndexById(int id) throws DaftarIndexException;
    
}
