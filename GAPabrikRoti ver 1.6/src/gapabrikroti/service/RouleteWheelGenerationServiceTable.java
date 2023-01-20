/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.RouleteWheel;
import gapabrikroti.model.RouleteWheelGeneration;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cvgs
 */
public class RouleteWheelGenerationServiceTable extends AbstractTableModel {
    private List<RouleteWheelGeneration> list = new ArrayList<RouleteWheelGeneration>();
    
    public void setList(List<RouleteWheelGeneration> list) {
        this.list = list;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "no";
            case 1 : return "Gen X";
            case 2 : return "Gen Y";
            case 3 : return "generasi ke";
            default : return null;
        }
    }

    public RouleteWheelGeneration set(int index, RouleteWheelGeneration element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public RouleteWheelGeneration remove(int index) {
      try {
        return list.remove(index);
      } finally {
          fireTableRowsDeleted(index, index);
      }
    }

    public RouleteWheelGeneration get(int index) {
        return list.get(index);
    }

    public boolean add(RouleteWheelGeneration rouleteWheelGeneration) {
        try {
            return list.add(rouleteWheelGeneration);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 :  return list.get(rowIndex).getRouleteWheelId();
            case 1 :  return list.get(rowIndex).getRouleteWheelGenX();
            case 2 : return list.get(rowIndex).getRouleteWheelGenY();
            case 3 : return list.get(rowIndex).getGenerationNo();
            default : return null;
        }
    }
    
}
