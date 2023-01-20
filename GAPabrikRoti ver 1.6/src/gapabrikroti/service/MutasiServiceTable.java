/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.Mutasi;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cvgs
 */
public class MutasiServiceTable extends AbstractTableModel {
    private static final long serialVersionUID = -4126490061056267691L;
    private List<Mutasi> list = new ArrayList<Mutasi>();
    
    public void setList(List<Mutasi> list) {
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
            default : return null;
        }
    }

    public Mutasi set(int index, Mutasi element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Mutasi remove(int index) {
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
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 :  return list.get(rowIndex).getNoMutasi();
            case 1 :  return list.get(rowIndex).getMutasiX();
            case 2 : return list.get(rowIndex).getMutasiY();
            case 3 : return list.get(rowIndex).getFitness();
            case 4 : return list.get(rowIndex).getC();
            default : return null;
        }
    }

    public boolean add(Mutasi mutasi) {
        try {
            return list.add(mutasi);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }
    
}
