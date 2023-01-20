/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.Evaluasi;

/**
 *
 * @author cvgs
 */
public interface EvaluasiService {
    public void onChange(EvaluasiServiceImpl evaluasiServiceImpl);
    public void onInsert(Evaluasi evaluasi);
    public void onUpdate(Evaluasi evaluasi);
    public void onDelete();
}
