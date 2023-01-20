/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao.impl.jdbc;

import gapabrikroti.dao.EvaluasiGenerationDAO;
import gapabrikroti.error.EvaluasiGenerationException;
import gapabrikroti.model.EvaluasiGeneration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cvgs
 */
public class EvaluasiGenerationDAOImpl implements EvaluasiGenerationDAO {
    private Connection connection;
    private final String insertEvaluasiGeneration="INSERT INTO evaluasi_generasi(evaluasiX, evaluasiY, fitness, C, probabilitas, probabilitas_cumulatif, jml_generasi) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private final String selectAllEvaluasiGeneration="SELECT * FROM evaluasi_generasi";
    private final String selectAllEvaluasiGenerationByProbabilitas="SELECT * FROM evaluasi_generasi WHERE  jml_generasi >=1 AND probabilitas_cumulatif BETWEEN 0.99 AND 1.1";
    private final String deleteALLEvaluasiGeneration="TRUNCATE evaluasi_generasi";
    
    public EvaluasiGenerationDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void addEvaluasiGeneration(EvaluasiGeneration evaluasiGeneration) throws EvaluasiGenerationException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(insertEvaluasiGeneration);
            statement.setDouble(1, evaluasiGeneration.getEvaluasiX());
            statement.setDouble(2, evaluasiGeneration.getEvaluasiY());
            statement.setDouble(3, evaluasiGeneration.getFitness());
            statement.setDouble(4, evaluasiGeneration.getC());
            statement.setDouble(5, evaluasiGeneration.getPi());
            statement.setDouble(6, evaluasiGeneration.getProbabilitasCumulatif());
            statement.setInt(7, evaluasiGeneration.getGenerationNo());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new EvaluasiGenerationException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(EvaluasiGenerationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public List<EvaluasiGeneration> getAllEvaluasiGeneration() throws EvaluasiGenerationException {
        Statement statement = null;
        List<EvaluasiGeneration> list = new ArrayList<EvaluasiGeneration>();
        
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAllEvaluasiGeneration);
            while (result.next()) {
                EvaluasiGeneration evaluasiGeneration = new EvaluasiGeneration();
                evaluasiGeneration.setNoEvaluasi(result.getInt("noEvaluasi"));
                evaluasiGeneration.setEvaluasiX(result.getDouble("evaluasiX"));
                evaluasiGeneration.setEvaluasiY(result.getDouble("evaluasiY"));
                evaluasiGeneration.setFitness(result.getDouble("fitness"));
                evaluasiGeneration.setC(result.getDouble("c"));
                evaluasiGeneration.setPi(result.getDouble("probabilitas"));
                evaluasiGeneration.setProbabilitasCumulatif(result.getDouble("probabilitas_cumulatif"));
                evaluasiGeneration.setGenerationNo(result.getInt("jml_generasi"));
                list.add(evaluasiGeneration);
            }
            return list;
        } catch (SQLException exception) {
            throw new EvaluasiGenerationException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EvaluasiGenerationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }

    @Override
    public EvaluasiGeneration getAllEvaluasiForSelGeneration() throws EvaluasiGenerationException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(selectAllEvaluasiGeneration);
            
            ResultSet result = statement.executeQuery();
            EvaluasiGeneration evaluasiGeneration = null;
            if (result.next()) {
                evaluasiGeneration = new EvaluasiGeneration();
                evaluasiGeneration.setEvaluasiX(result.getDouble("evaluasiX"));
                evaluasiGeneration.setEvaluasiY(result.getDouble("evaluasiY"));
            } else {
                throw new EvaluasiGenerationException("data tidak di temukan");
            }
            return evaluasiGeneration;
        } catch (SQLException exception) {
            throw new EvaluasiGenerationException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    
                }
            }
        } 
    }

    @Override
    public void clearEvaluasiGeneration() throws EvaluasiGenerationException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(deleteALLEvaluasiGeneration);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new EvaluasiGenerationException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(EvaluasiGenerationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<EvaluasiGeneration> getAllEvaluasiGenerationByProbabilitas() throws EvaluasiGenerationException {
        Statement statement = null;
        List<EvaluasiGeneration> list = new ArrayList<EvaluasiGeneration>();
        
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAllEvaluasiGenerationByProbabilitas);
            while (result.next()) {
                EvaluasiGeneration evaluasiGeneration = new EvaluasiGeneration();
                evaluasiGeneration.setNoEvaluasi(result.getInt("noEvaluasi"));
                evaluasiGeneration.setEvaluasiX(result.getDouble("evaluasiX"));
                evaluasiGeneration.setEvaluasiY(result.getDouble("evaluasiY"));
                evaluasiGeneration.setFitness(result.getDouble("fitness"));
                evaluasiGeneration.setC(result.getDouble("c"));
                evaluasiGeneration.setPi(result.getDouble("probabilitas"));
                evaluasiGeneration.setProbabilitasCumulatif(result.getDouble("probabilitas_cumulatif"));
                evaluasiGeneration.setGenerationNo(result.getInt("jml_generasi"));
                list.add(evaluasiGeneration);
            }
            return list;
        } catch (SQLException exception) {
            throw new EvaluasiGenerationException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EvaluasiGenerationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
