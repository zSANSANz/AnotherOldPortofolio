/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.DaftarIndex;

/**
 *
 * @author cvgs
 */
public interface DaftarIndexService {
    public void onChange(DaftarIndexServiceImpl daftarIndexServiceImpl);
    public void onInsert(DaftarIndex daftarIndex);
    public void onUpdate(DaftarIndex daftarIndex);
    public void onDelete();
}
