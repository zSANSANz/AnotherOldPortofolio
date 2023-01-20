/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.Mutasi;

/**
 *
 * @author cvgs
 */
public interface MutasiService {
    public void onChance(MutasiServiceImpl mutasiServiceImpl);
    public void onInsert(Mutasi mutasi);
    public void onUpdate(Mutasi mutasi);
    public void onDelete();
}
