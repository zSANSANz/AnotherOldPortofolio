/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.Evaluasi;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cvgs
 */
public class EvaluasiServiceTable extends AbstractTableModel {
    private static final long serialVersionUID = -4126490061056267691L;
    private List<Evaluasi> list = new ArrayList<Evaluasi>();

    public void setList(List<Evaluasi> list) {
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
            case 5 : return "Probabilitas";
            case 6 : return "probabilitas cumulatif";
            default : return null;
        }
    }

    public Evaluasi set(int index, Evaluasi element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Evaluasi remove(int index) {
      try {
        return list.remove(index);
      } finally {
          fireTableRowsDeleted(index, index);
      }
    }

    public Evaluasi get(int index) {
        return list.get(index);
    }

    public boolean add(Evaluasi evaluasi) {
        try {
            return list.add(evaluasi);
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
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case 0 :  return list.get(rowIndex).getNoEvaluasi();
            case 1 :  return list.get(rowIndex).getEvaluasiX();
            case 2 : return list.get(rowIndex).getEvaluasiY();
            case 3 : return list.get(rowIndex).getFitness();
            case 4 : return list.get(rowIndex).getC();
            case 5 : return list.get(rowIndex).getPi();
            case 6 : return list.get(rowIndex).getProbabilitasCumulatif();
            default : return null;
        }
    }
}
