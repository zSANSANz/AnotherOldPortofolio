/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.controller;

import gapabrikroti.error.CrossOverException;
import gapabrikroti.error.CrossOverGenerationException;
import gapabrikroti.error.EvaluasiException;
import gapabrikroti.error.EvaluasiGenerationException;
import gapabrikroti.error.MutasiException;
import gapabrikroti.error.MutasiGenerationException;
import gapabrikroti.error.PopulasiException;
import gapabrikroti.error.RataRataException;
import gapabrikroti.error.RouleteWheelException;
import gapabrikroti.error.RouleteWheelGenerationException;
import gapabrikroti.service.CrossOverGenerationServiceImpl;
import gapabrikroti.service.CrossOverServiceImpl;
import gapabrikroti.service.EvaluasiGenerationServiceImpl;
import gapabrikroti.service.EvaluasiServiceImpl;
import gapabrikroti.service.KoordinatServiceImpl;
import gapabrikroti.service.MutasiGenerationServiceImpl;
import gapabrikroti.service.MutasiServiceImpl;
import gapabrikroti.service.PopulasiServiceImpl;
import gapabrikroti.service.RataRataServiceImpl;
import gapabrikroti.service.RouleteWheelGenerationServiceImpl;
import gapabrikroti.service.RouleteWheelServiceImpl;
import gapabrikroti.view.HasilPerhitunganView;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author cvgs
 */
public class PerhitunganController {
    private KoordinatServiceImpl koordinatServiceImpl;
    private PopulasiServiceImpl populasiServiceImpl;
    private RataRataServiceImpl rataRataServiceImpl;
    private EvaluasiServiceImpl evaluasiServiceImpl;
    private RouleteWheelServiceImpl rouleteWheelServiceImpl;
    private CrossOverServiceImpl crossOverServiceImpl; 
    private MutasiServiceImpl mutasiServiceImpl;
    private EvaluasiGenerationServiceImpl evaluasiGenerationServiceImpl;
    private RouleteWheelGenerationServiceImpl rouleteWheelGenerationServiceImpl;
    private CrossOverGenerationServiceImpl crossOverGenerationServiceImpl; 
    private MutasiGenerationServiceImpl mutasiGenerationServiceImpl;
    
    public void setKoordinat(KoordinatServiceImpl koordinatServiceImpl) {
        this.koordinatServiceImpl = koordinatServiceImpl;
    }
    
    public void setPopulasi(PopulasiServiceImpl populasiServiceImpl) {
        this.populasiServiceImpl = populasiServiceImpl;
    }
    
    public void setRataRata(RataRataServiceImpl rataRataServiceImpl) {
        this.rataRataServiceImpl = rataRataServiceImpl; 
    }
    
    public void setEvaluasi(EvaluasiServiceImpl evaluasiServiceImpl) {
        this.evaluasiServiceImpl = evaluasiServiceImpl;
    }
    
    public void setRouleteWheel(RouleteWheelServiceImpl rouleteWheelServiceImpl) {
        this.rouleteWheelServiceImpl = rouleteWheelServiceImpl;
    }
    
    public void setCrossOver(CrossOverServiceImpl crossOverServiceImpl) {
        this.crossOverServiceImpl = crossOverServiceImpl;
    }
    
    public void setMutasi(MutasiServiceImpl mutasiServiceImpl) {
        this.mutasiServiceImpl = mutasiServiceImpl;
    }
    
    public void setEvaluasiGeneration(EvaluasiGenerationServiceImpl evaluasiGenerationServiceImpl) {
        this.evaluasiGenerationServiceImpl = evaluasiGenerationServiceImpl;
    }
    
    public void setRouleteWheelGeneration(RouleteWheelGenerationServiceImpl rouleteWheelGenerationServiceImpl) {
        this.rouleteWheelGenerationServiceImpl = rouleteWheelGenerationServiceImpl;
    }
    
    public void setCrossOverGeneration(CrossOverGenerationServiceImpl crossOverGenerationServiceImpl) {
        this.crossOverGenerationServiceImpl = crossOverGenerationServiceImpl;
    }
    
    public void setMutasiGeneration(MutasiGenerationServiceImpl mutasiGenerationServiceImpl) {
        this.mutasiGenerationServiceImpl = mutasiGenerationServiceImpl;
    }
    
    public void insertPopulasi(HasilPerhitunganView hasilPerhitunganView) throws PopulasiException {
        Integer binX = hasilPerhitunganView.getRandDecX();
        Integer binY = hasilPerhitunganView.getRandDecY();
        
        populasiServiceImpl.setBinerX(binX);
        populasiServiceImpl.setBinerY(binY);
        try {
            populasiServiceImpl.insertPopulasi();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(hasilPerhitunganView, new Object[]{
                "terjadi error di database dengan pesan : "
            });
        }
    }
    
    public void insertRataRata(HasilPerhitunganView hasilPerhitunganView) throws RataRataException {
        Double rataRataX = hasilPerhitunganView.getRataRataX();
        Double rataRataY = hasilPerhitunganView.getRataRataY();
        Double totalFitness = hasilPerhitunganView.getTotalFitness();
        Double probabilitasKumulatif = hasilPerhitunganView.getProbabilitasKumulatif();
        
        rataRataServiceImpl.setRataRataX(rataRataX);
        rataRataServiceImpl.setRataRataY(rataRataY);
        rataRataServiceImpl.setTotalFitness(totalFitness);
        rataRataServiceImpl.setProbabilitasKumulatif(probabilitasKumulatif);
        try {
            rataRataServiceImpl.insertRataRata();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(hasilPerhitunganView, new Object[]{
                "terjadi error di database dengan pesan : "
            });
        }
    }
    
    public void clearPopulasi() throws PopulasiException, SQLException {
        populasiServiceImpl.deletePopulasi();
    }
    
    public void clearRataRata() throws RataRataException, SQLException {
        rataRataServiceImpl.deleteRataRata();
    }
    
    public void clearEvaluasi() throws EvaluasiException, SQLException {
        evaluasiServiceImpl.deleteEvaluasi();
    }
    
    public void clearRouleteWheel() throws RouleteWheelException, SQLException {
        rouleteWheelServiceImpl.deleteRouleteWheel();
    }
    
    public void clearCrossOver() throws CrossOverException, SQLException {
        crossOverServiceImpl.deleteCrossOver();
    }
    
    public void clearMutasi() throws MutasiException, SQLException {
        mutasiServiceImpl.deleteMutasi();
    }

    public void clearEvaluasiGeneration() throws EvaluasiGenerationException, SQLException {
        evaluasiGenerationServiceImpl.deleteEvaluasiGeneration();
    }
    
    public void clearRouleteWheelGeneration() throws RouleteWheelGenerationException, SQLException {
        rouleteWheelGenerationServiceImpl.deleteRouleteWheelGeneration();
    }
    
    public void clearCrossOverGeneration() throws CrossOverGenerationException, SQLException {
        crossOverGenerationServiceImpl.deleteCrossOverGeneration();
    }
    
    public void clearMutasiGeneration() throws MutasiGenerationException, SQLException {
        mutasiGenerationServiceImpl.deleteMutasiGeneration();
    }

    public void insertEvaluasi(HasilPerhitunganView hasilPerhitunganView) throws EvaluasiException {
        Double evaX = hasilPerhitunganView.getEvaluasiX();
        Double evaY = hasilPerhitunganView.getEvaluasiY();
        Double fitness = hasilPerhitunganView.getFi();
        Double c = hasilPerhitunganView.getCi();
        Double Pi = hasilPerhitunganView.getPi();
        Double probabilitasCumulatif = hasilPerhitunganView.getProbabilitasKumulatif();
        
        evaluasiServiceImpl.setEvaluasiX(evaX);
        evaluasiServiceImpl.setEvaluasiY(evaY);
        evaluasiServiceImpl.setFitness(fitness);
        evaluasiServiceImpl.setC(c);
        evaluasiServiceImpl.setPi(Pi);
        evaluasiServiceImpl.setProbabilitasCumulatif(probabilitasCumulatif);
        try {
            evaluasiServiceImpl.insertEvaluasi();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(hasilPerhitunganView, new Object[]{
                "terjadi error di database dengan pesan : "
            });
        }
    }
    
    public void insertRouleteWheel(HasilPerhitunganView hasilPerhitunganView) throws RouleteWheelException {
        Double rouleteWheelGenX = hasilPerhitunganView.getRouleteWheelGenX();
        Double rouleteWheelGenY = hasilPerhitunganView.getRouleteWheelGenY();
        
        rouleteWheelServiceImpl.setRouleteWheelGenX(rouleteWheelGenX);
        rouleteWheelServiceImpl.setRouleteWheelGenY(rouleteWheelGenY);
        try {
            rouleteWheelServiceImpl.insertRouleteWheel();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(hasilPerhitunganView, new Object[]{
                "terjadi error di database dengan pesan : "
            });
        }
    }
    
    public void insertCrossOver(HasilPerhitunganView hasilPerhitunganView) throws EvaluasiException, CrossOverException {
        Double crossOverGenX = hasilPerhitunganView.getCrossGenX();
        Double crossOverGenY = hasilPerhitunganView.getCrossGenY();
        Double crossOverNilaiC = hasilPerhitunganView.getCrossNilaiC();
        Double crossOverFitness = hasilPerhitunganView.getCrossFitness();
        
        crossOverServiceImpl.setCrossOverX(crossOverGenX);
        crossOverServiceImpl.setCrossOverY(crossOverGenY);
        crossOverServiceImpl.setC(crossOverNilaiC);
        crossOverServiceImpl.setFitness(crossOverFitness);
        try {
            crossOverServiceImpl.insertCrossOver();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(hasilPerhitunganView, new Object[]{
                "terjadi error di database dengan pesan : "
            });
        }
    }
    
    public void insertMutasi(HasilPerhitunganView hasilPerhitunganView) throws SQLException, MutasiException {
        Double mutasiGenX = hasilPerhitunganView.getMutasiGenX();
        Double mutasiGenY = hasilPerhitunganView.getMutasiGenY();
        Double mutasiNilaiC = hasilPerhitunganView.getMutasiNilaiC();
        Double mutasiFitness = hasilPerhitunganView.getMutasiFitness();
        
        mutasiServiceImpl.setMutasiX(mutasiGenX);
        mutasiServiceImpl.setMutasiY(mutasiGenY);
        mutasiServiceImpl.setNilaiC(mutasiNilaiC);
        mutasiServiceImpl.setFitness(mutasiFitness);
        try {
            mutasiServiceImpl.insertMutasi();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(hasilPerhitunganView, new Object[]{
                "terjadi error di database dengan pesan : "
            });
        }
    }
    
    public void insertEvaluasiGeneration(HasilPerhitunganView hasilPerhitunganView) throws EvaluasiGenerationException {
        Double evaX = hasilPerhitunganView.getEvaluasiX();
        Double evaY = hasilPerhitunganView.getEvaluasiY();
        Double fitness = hasilPerhitunganView.getFi();
        Double c = hasilPerhitunganView.getCi();
        Double Pi = hasilPerhitunganView.getPi();
        Double probabilitasCumulatif = hasilPerhitunganView.getProbabilitasKumulatif();
        Integer generasi = hasilPerhitunganView.getGenerasi();
        
        evaluasiGenerationServiceImpl.setEvaluasiX(evaX);
        evaluasiGenerationServiceImpl.setEvaluasiY(evaY);
        evaluasiGenerationServiceImpl.setFitness(fitness);
        evaluasiGenerationServiceImpl.setC(c);
        evaluasiGenerationServiceImpl.setPi(Pi);
        evaluasiGenerationServiceImpl.setProbabilitasCumulatif(probabilitasCumulatif);
        evaluasiGenerationServiceImpl.setGenerationNo(generasi);
        try {
            evaluasiGenerationServiceImpl.insertEvaluasiGeneration();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(hasilPerhitunganView, new Object[]{
                "terjadi error di database dengan pesan : "
            });
        }
    }
    
    public void insertRouleteWheelGeneration(HasilPerhitunganView hasilPerhitunganView) throws RouleteWheelGenerationException {
        Double rouleteWheelGenX = hasilPerhitunganView.getRouleteWheelGenX();
        Double rouleteWheelGenY = hasilPerhitunganView.getRouleteWheelGenY();
        Integer generasi = hasilPerhitunganView.getGenerasi();
        
        rouleteWheelGenerationServiceImpl.setRouleteWheelGenX(rouleteWheelGenX);
        rouleteWheelGenerationServiceImpl.setRouleteWheelGenY(rouleteWheelGenY);
        rouleteWheelGenerationServiceImpl.setGenerationNo(generasi);
        try {
            rouleteWheelGenerationServiceImpl.insertRouleteWheelGeneration();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(hasilPerhitunganView, new Object[]{
                "terjadi error di database dengan pesan : "
            });
        }
    }
    
    public void insertCrossOverGeneration(HasilPerhitunganView hasilPerhitunganView) throws EvaluasiException, CrossOverGenerationException {
        Double crossOverGenX = hasilPerhitunganView.getCrossGenX();
        Double crossOverGenY = hasilPerhitunganView.getCrossGenY();
        Double crossOverNilaiC = hasilPerhitunganView.getCrossNilaiC();
        Double crossOverFitness = hasilPerhitunganView.getCrossFitness();
        Integer crossOverGeneration = hasilPerhitunganView.getGenerasi();
        
        crossOverGenerationServiceImpl.setCrossOverX(crossOverGenX);
        crossOverGenerationServiceImpl.setCrossOverY(crossOverGenY);
        crossOverGenerationServiceImpl.setC(crossOverNilaiC);
        crossOverGenerationServiceImpl.setFitness(crossOverFitness);
        crossOverGenerationServiceImpl.setGenerationNo(crossOverGeneration);
        try {
            crossOverGenerationServiceImpl.insertCrossOverGeneration();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(hasilPerhitunganView, new Object[]{
                "terjadi error di database dengan pesan : "
            });
        }
    }
    
    public void insertMutasiGeneration(HasilPerhitunganView hasilPerhitunganView) throws SQLException, MutasiGenerationException {
        Double mutasiGenX = hasilPerhitunganView.getMutasiGenX();
        Double mutasiGenY = hasilPerhitunganView.getMutasiGenY();
        Double mutasiNilaiC = hasilPerhitunganView.getMutasiNilaiC();
        Double mutasiFitness = hasilPerhitunganView.getMutasiFitness();
        Integer mutasiGeneration = hasilPerhitunganView.getGenerasi();
        
        mutasiGenerationServiceImpl.setMutasiX(mutasiGenX);
        mutasiGenerationServiceImpl.setMutasiY(mutasiGenY);
        mutasiGenerationServiceImpl.setNilaiC(mutasiNilaiC);
        mutasiGenerationServiceImpl.setFitness(mutasiFitness);
        mutasiGenerationServiceImpl.setGenerationNo(mutasiGeneration);
        try {
            mutasiGenerationServiceImpl.insertMutasiGeneration();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(hasilPerhitunganView, new Object[]{
                "terjadi error di database dengan pesan : "
            });
        }
    }
}
