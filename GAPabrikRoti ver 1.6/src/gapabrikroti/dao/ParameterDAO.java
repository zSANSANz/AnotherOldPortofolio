/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao;


import gapabrikroti.error.ParameterException;
import gapabrikroti.model.Parameter;
import java.util.List;

/**
 *
 * @author cvgs
 */
public interface ParameterDAO {
    public void addParameter(Parameter parameter) throws ParameterException;
    public void editParameter(Parameter parameter) throws ParameterException;
    public void deleteParameter(int id) throws ParameterException;
    public List<Parameter> getAllParameter() throws ParameterException;
    public Parameter getParameterByNamaParameter(String namaParameter) throws ParameterException;
}
