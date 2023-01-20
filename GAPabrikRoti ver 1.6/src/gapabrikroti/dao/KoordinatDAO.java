/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao;

import gapabrikroti.error.KoordinatException;
import gapabrikroti.model.Koordinat;
import java.util.List;

/**
 *
 * @author cvgs
 */
public interface KoordinatDAO {
    public void addKoordinat(Koordinat koordinat) throws KoordinatException;
    public void editKoordinat(Koordinat koordinat) throws KoordinatException;
    public void deleteKoordinat(int id) throws KoordinatException;
    public List<Koordinat> getAllKoordinat() throws KoordinatException;
    public Koordinat getKoordinatBobot() throws KoordinatException;
    public Koordinat getMaxKoordinat() throws KoordinatException;
    
}
