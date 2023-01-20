/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.DaftarIndex;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cvgs
 */
public class DaftarIndexServiceTable extends AbstractTableModel {
    private List<DaftarIndex> list = new ArrayList<DaftarIndex>();

    public void setList(List<DaftarIndex> list) {
        this.list = list;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "no";
            case 1 : return "istilah";
            case 2 : return "deskripsi";
            default : return null;
        }
    }

    public DaftarIndex set(int index, DaftarIndex element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public DaftarIndex remove(int index) {
      try {
        return list.remove(index);
      } finally {
          fireTableRowsDeleted(index, index);
      }
    }

    public DaftarIndex get(int index) {
        return list.get(index);
    }

    public boolean add(DaftarIndex daftarIndex) {
        try {
            return list.add(daftarIndex);
        } finally {
            
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
            case 0 : return rowIndex + 1;
            case 1 : return list.get(rowIndex).getIstilah();
            case 2 : return list.get(rowIndex).getDeskripsi();
            default : return null;
        }
    }
}
