/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cvgs
 */
public class UserServiceTable  extends AbstractTableModel {

    private List<User> list = new ArrayList<User>();

    public void setList(List<User> list) {
        this.list = list;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0 : return "userName";
            case 1 : return "password";
            case 2 : return "hakAkses";
            default : return null;
        }
    }

    public User set(int index, User element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public User remove(int index) {
      try {
        return list.remove(index);
      } finally {
          fireTableRowsDeleted(index, index);
      }
    }

    public User get(int index) {
        return list.get(index);
    }

    public boolean add(User user) {
        try {
            return list.add(user);
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
            case 0 :  return list.get(rowIndex).getUserName();
            case 1 : return list.get(rowIndex).getPassword();
            case 2 : return list.get(rowIndex).getHakAkses();
            default : return null;
        }
    }
    
}
