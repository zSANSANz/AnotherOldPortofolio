/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.CrossOver;
import gapabrikroti.model.CrossOverGeneration;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cvgs
 */
public class CrossOverGenerationServiceTable extends AbstractTableModel {
    private static final long serialVersionUID = -4126490061056267691L;
    private List<CrossOverGeneration> list = new ArrayList<CrossOverGeneration>();
    
    public void setList(List<CrossOverGeneration> list) {
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

    public CrossOverGeneration set(int index, CrossOverGeneration element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public CrossOverGeneration remove(int index) {
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
            case 0 :  return list.get(rowIndex).getNoCrossOver();
            case 1 :  return list.get(rowIndex).getCrossOverX();
            case 2 : return list.get(rowIndex).getCrossOverY();
            case 3 : return list.get(rowIndex).getFitness();
            case 4 : return list.get(rowIndex).getC();
            case 5 : return list.get(rowIndex).getGenerationNo();
            default : return null;
        }
    }

    public boolean add(CrossOverGeneration crossOverGeneration) {
        try {
            return list.add(crossOverGeneration);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }
    
}
