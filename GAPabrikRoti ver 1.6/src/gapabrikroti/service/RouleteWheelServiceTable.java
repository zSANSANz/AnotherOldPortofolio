/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.RouleteWheel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cvgs
 */
public class RouleteWheelServiceTable extends AbstractTableModel {
    private List<RouleteWheel> list = new ArrayList<RouleteWheel>();
    
    public void setList(List<RouleteWheel> list) {
        this.list = list;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "no";
            case 1 : return "Gen X";
            case 2 : return "Gen Y";
            default : return null;
        }
    }

    public RouleteWheel set(int index, RouleteWheel element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public RouleteWheel remove(int index) {
      try {
        return list.remove(index);
      } finally {
          fireTableRowsDeleted(index, index);
      }
    }

    public RouleteWheel get(int index) {
        return list.get(index);
    }

    public boolean add(RouleteWheel rouleteWheel) {
        try {
            return list.add(rouleteWheel);
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
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 :  return list.get(rowIndex).getRouleteWheelId();
            case 1 :  return list.get(rowIndex).getRouleteWheelGenX();
            case 2 : return list.get(rowIndex).getRouleteWheelGenY();
            default : return null;
        }
    }
    
}
