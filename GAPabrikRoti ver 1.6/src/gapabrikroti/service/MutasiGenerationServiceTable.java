/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.Mutasi;
import gapabrikroti.model.MutasiGeneration;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cvgs
 */
public class MutasiGenerationServiceTable extends AbstractTableModel {
    private static final long serialVersionUID = -4126490061056267691L;
    private List<MutasiGeneration> list = new ArrayList<MutasiGeneration>();
    
    public void setList(List<MutasiGeneration> list) {
        this.list = list;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "no";
            case 1 : return "Gen X";
            case 2 : return "Gen Y";
            case 3 : return "Nilai fitness";
            case 4 : return "Nilai C";
            case 5 : return "generasi ke";
            default : return null;
        }
    }

    public MutasiGeneration set(int index, MutasiGeneration element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public MutasiGeneration remove(int index) {
      try {
        return list.remove(index);
      } finally {
          fireTableRowsDeleted(index, index);
      }
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 :  return list.get(rowIndex).getNoMutasi();
            case 1 :  return list.get(rowIndex).getMutasiX();
            case 2 : return list.get(rowIndex).getMutasiY();
            case 3 : return list.get(rowIndex).getFitness();
            case 4 : return list.get(rowIndex).getC();
            case 5 : return list.get(rowIndex).getGenerationNo();
            default : return null;
        }
    }

    public boolean add(MutasiGeneration mutasiGeneration) {
        try {
            return list.add(mutasiGeneration);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }
    
}
