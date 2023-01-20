/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.CrossOver;
import gapabrikroti.model.Mutasi;

/**
 *
 * @author cvgs
 */
public interface CrossOverService {
    public void onChange(CrossOverServiceImpl crossOverServiceImpl);
    public void onInsert(CrossOver crossOver);
    public void onUpdate(CrossOver crossOver);
    public void onDelete();

}
