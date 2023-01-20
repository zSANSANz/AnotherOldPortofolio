/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao;

import gapabrikroti.error.PopulasiException;
import gapabrikroti.model.Populasi;
import java.util.List;

/**
 *
 * @author cvgs
 */
public interface PopulasiDAO {
    public void addPopulasi(Populasi populasi) throws PopulasiException;
    public List<Populasi> getAllPopulasi() throws PopulasiException;
    public Populasi getAllPopulasiForEv() throws PopulasiException;
    public void clearPopulasi() throws PopulasiException;
}
