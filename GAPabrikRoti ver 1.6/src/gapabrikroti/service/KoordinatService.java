/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.Koordinat;

/**
 *
 * @author cvgs
 */
public interface KoordinatService {
    public void onChange(KoordinatServiceImpl koordinatServiceImpl);
    public void onInsert(Koordinat koordinat);
    public void onUpdate(Koordinat koordinat);
    public void onDelete();
}
