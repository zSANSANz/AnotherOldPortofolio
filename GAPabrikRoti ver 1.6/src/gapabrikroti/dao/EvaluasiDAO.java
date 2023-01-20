/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao;

import gapabrikroti.error.EvaluasiException;
import gapabrikroti.model.Evaluasi;
import java.util.List;

/**
 *
 * @author cvgs
 */
public interface EvaluasiDAO {
    public void addEvaluasi(Evaluasi evaluasi) throws EvaluasiException;
    public List<Evaluasi> getAllEvaluasi() throws EvaluasiException;
    public Evaluasi getAllEvaluasiForSel() throws EvaluasiException;
    public void clearEvaluasi() throws EvaluasiException;
}
