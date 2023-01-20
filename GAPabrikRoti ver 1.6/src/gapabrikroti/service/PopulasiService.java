/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.Populasi;

/**
 *
 * @author cvgs
 */
public interface PopulasiService {
    public void onChange(PopulasiServiceImpl populasiServiceImpl);
    public void onInsert(Populasi populasi);
    public void onUpdate(Populasi populasi);
    public void onDelete();
}
