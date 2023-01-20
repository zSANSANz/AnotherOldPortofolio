/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.dao.impl.jdbc;

import gapabrikroti.dao.EvaluasiDAO;
import gapabrikroti.error.EvaluasiException;
import gapabrikroti.model.Evaluasi;
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
public class EvaluasiDAOImpl implements EvaluasiDAO {
    private Connection connection;
    private final String insertEvaluasi="INSERT INTO evaluasi(evaluasiX, evaluasiY, fitness, C, probabilitas, probabilitas_cumulatif) VALUES(?, ?, ?, ?, ?, ?)";
    private final String selectAllEvaluasi="SELECT * FROM evaluasi";
    private final String deleteALLEvaluasi="TRUNCATE evaluasi";
    
    public EvaluasiDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void addEvaluasi(Evaluasi evaluasi) throws EvaluasiException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(insertEvaluasi);
            statement.setDouble(1, evaluasi.getEvaluasiX());
            statement.setDouble(2, evaluasi.getEvaluasiY());
            statement.setDouble(3, evaluasi.getFitness());
            statement.setDouble(4, evaluasi.getC());
            statement.setDouble(5, evaluasi.getPi());
            statement.setDouble(6, evaluasi.getProbabilitasCumulatif());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new EvaluasiException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(EvaluasiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    @Override
    public List<Evaluasi> getAllEvaluasi() throws EvaluasiException {
        Statement statement = null;
        List<Evaluasi> list = new ArrayList<Evaluasi>();
        
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAllEvaluasi);
            while (result.next()) {
                Evaluasi evaluasi = new Evaluasi();
                evaluasi.setNoEvaluasi(result.getInt("noEvaluasi"));
                evaluasi.setEvaluasiX(result.getDouble("evaluasiX"));
                evaluasi.setEvaluasiY(result.getDouble("evaluasiY"));
                evaluasi.setFitness(result.getDouble("fitness"));
                evaluasi.setC(result.getDouble("c"));
                evaluasi.setPi(result.getDouble("probabilitas"));
                evaluasi.setProbabilitasCumulatif(result.getDouble("probabilitas_cumulatif"));
                list.add(evaluasi);
            }
            return list;
        } catch (SQLException exception) {
            throw new EvaluasiException(exception.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(EvaluasiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }

    @Override
    public Evaluasi getAllEvaluasiForSel() throws EvaluasiException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(selectAllEvaluasi);
            
            ResultSet result = statement.executeQuery();
            Evaluasi evaluasi = null;
            if (result.next()) {
                evaluasi = new Evaluasi();
                evaluasi.setEvaluasiX(result.getDouble("evaluasiX"));
                evaluasi.setEvaluasiY(result.getDouble("evaluasiY"));
            } else {
                throw new EvaluasiException("data tidak di temukan");
            }
            return evaluasi;
        } catch (SQLException exception) {
            throw new EvaluasiException(exception.getMessage());
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
    public void clearEvaluasi() throws EvaluasiException {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareStatement(deleteALLEvaluasi);
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new EvaluasiException(exception.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(PopulasiDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
