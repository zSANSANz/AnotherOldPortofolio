/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.Koordinat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cvgs
 */
public class KoordinatServiceTable extends AbstractTableModel {
    private static final long serialVersionUID = -4126490061056267691L;
    private List<Koordinat> list = new ArrayList<Koordinat>();

    public void setList(List<Koordinat> list) {
        this.list = list;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "id";
            case 1 : return "x";
            case 2 : return "y";
            case 3 : return "bobot";
            default : return null;
        }
    }

    public Koordinat set(int index, Koordinat element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Koordinat remove(int index) {
      try {
        return list.remove(index);
      } finally {
          fireTableRowsDeleted(index, index);
      }
    }

    public Koordinat get(int index) {
        return list.get(index);
    }

    public boolean add(Koordinat koordinat) {
        try {
            return list.add(koordinat);
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
            case 0 :  return list.get(rowIndex).getId();
            case 1 :  return list.get(rowIndex).getX();
            case 2 : return list.get(rowIndex).getY();
            case 3 : return list.get(rowIndex).getBobot();
            default : return null;
        }
    }
}
