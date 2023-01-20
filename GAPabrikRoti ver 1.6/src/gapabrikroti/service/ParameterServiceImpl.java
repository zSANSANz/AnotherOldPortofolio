/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.service;

import gapabrikroti.dao.ParameterDAO;
import gapabrikroti.error.ParameterException;
import gapabrikroti.model.Parameter;
import gapabrikroti.utility.databaseUtility;
import java.sql.SQLException;

/**
 *
 * @author cvgs
 */
public class ParameterServiceImpl {
    private int id;
    private String namaParameter;
    private double nilai;
    private ParameterService parameterService;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaParameter() {
        return namaParameter;
    }

    public void setNamaParameter(String namaParameter) {
        this.namaParameter = namaParameter;
    }

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }

    public ParameterService getParameterService() {
        return parameterService;
    }

    public void setParameterService(ParameterService parameterService) {
        this.parameterService = parameterService;
    }
 
    protected void fireOnChange() {
        if (parameterService != null) {
            parameterService.onChange(this);
        }
    }
    
    protected void fireOnInsert(Parameter parameter) {
        if (parameterService != null) {
            parameterService.onInsert(parameter);
        }
    }
    
    protected void fireOnUpdate(Parameter parameter) {
        if (parameterService != null) {
            parameterService.onUpdate(parameter);
        }
    }
    
    protected void fireOnDelete() {
        if (parameterService != null) {
            parameterService.onDelete();
        }
    }
    
    public void resetParameter() {
        setId(0);
        setNamaParameter("");
        setNilai(0);
    }
    
    public void insertParameter() throws SQLException, ParameterException {
        ParameterDAO parameterDAO = databaseUtility.getParameterDAO();
        
        Parameter parameter = new Parameter();
        parameter.setId(id);
        parameter.setNamaParameter(namaParameter);
        parameter.setNilai(nilai);
        
        parameterDAO.addParameter(parameter);
        
        fireOnInsert(parameter);
    }
    
    public void updateParameter() throws SQLException, ParameterException {
        ParameterDAO parameterDAO = databaseUtility.getParameterDAO();
        
        Parameter parameter = new Parameter();
        parameter.setId(id);
        parameter.setNamaParameter(namaParameter);
        parameter.setNilai(nilai);
        
        parameterDAO.editParameter(parameter);
        
        fireOnUpdate(parameter);
    }
    
    public void deleteParameter() throws SQLException, ParameterException {
        ParameterDAO parameterDAO = databaseUtility.getParameterDAO();
        
        parameterDAO.deleteParameter(id);
        
        fireOnDelete();
    }
    
}
