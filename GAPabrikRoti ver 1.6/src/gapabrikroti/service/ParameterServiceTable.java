/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.Parameter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cvgs
 */
public class ParameterServiceTable extends AbstractTableModel {
    private List<Parameter> list = new ArrayList<Parameter>();

    public void setList(List<Parameter> list) {
        this.list = list;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "id";
            case 1 : return "nama_parameter";
            case 2 : return "nilai";
            default : return null;
        }
    }

    public Parameter set(int index, Parameter element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Parameter remove(int index) {
      try {
        return list.remove(index);
      } finally {
          fireTableRowsDeleted(index, index);
      }
    }

    public Parameter get(int index) {
        return list.get(index);
    }

    public boolean add(Parameter parameter) {
        try {
            return list.add(parameter);
        } finally {
            
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
                case 0 :  return list.get(rowIndex).getId();
                case 1 : return list.get(rowIndex).getNamaParameter();
                case 2 : return list.get(rowIndex).getNilai();
                default : return null;
        }
    }
    
}
