/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.Populasi;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cvgs
 */
public class PopulasiServiceTable extends AbstractTableModel {
    private static final long serialVersionUID = -4126490061056267691L;
    private List<Populasi> list = new ArrayList<Populasi>();

    public void setList(List<Populasi> list) {
        this.list = list;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "no kromosom";
            case 1 : return "decX";
            case 2 : return "decY";
            default : return null;
        }
    }

    public Populasi set(int index, Populasi element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Populasi remove(int index) {
      try {
        return list.remove(index);
      } finally {
          fireTableRowsDeleted(index, index);
      }
    }

    public Populasi get(int index) {
        return list.get(index);
    }

    public boolean add(Populasi populasi) {
        try {
            return list.add(populasi);
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
            case 0 :  return list.get(rowIndex).getNoKromosom();
            case 1 :  return list.get(rowIndex).getBinerX();
            case 2 : return list.get(rowIndex).getBinerY();
            default : return null;
        }
    }
    
}
