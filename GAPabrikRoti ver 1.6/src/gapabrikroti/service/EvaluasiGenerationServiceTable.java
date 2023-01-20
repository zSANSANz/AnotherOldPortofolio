/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.Evaluasi;
import gapabrikroti.model.EvaluasiGeneration;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cvgs
 */
public class EvaluasiGenerationServiceTable extends AbstractTableModel {
    private static final long serialVersionUID = -4126490061056267691L;
    private List<EvaluasiGeneration> list = new ArrayList<EvaluasiGeneration>();

    public void setList(List<EvaluasiGeneration> list) {
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
            case 7 : return "generasi ke";
            default : return null;
        }
    }

    public EvaluasiGeneration set(int index, EvaluasiGeneration element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public EvaluasiGeneration remove(int index) {
      try {
        return list.remove(index);
      } finally {
          fireTableRowsDeleted(index, index);
      }
    }

    public EvaluasiGeneration get(int index) {
        return list.get(index);
    }

    public boolean add(EvaluasiGeneration evaluasiGeneration) {
        try {
            return list.add(evaluasiGeneration);
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
        return 8;
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
            case 7 : return list.get(rowIndex).getGenerationNo();
            default : return null;
        }
    }
}
