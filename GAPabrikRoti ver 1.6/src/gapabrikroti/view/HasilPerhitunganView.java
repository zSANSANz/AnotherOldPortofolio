/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gapabrikroti.view;

import gapabrikroti.controller.KoordinatController;
import gapabrikroti.controller.PerhitunganController;
import gapabrikroti.dao.CrossOverDAO;
import gapabrikroti.dao.EvaluasiDAO;
import gapabrikroti.dao.EvaluasiGenerationDAO;
import gapabrikroti.dao.KoordinatDAO;
import gapabrikroti.dao.MutasiDAO;
import gapabrikroti.dao.ParameterDAO;
import gapabrikroti.dao.PopulasiDAO;
import gapabrikroti.dao.RouleteWheelDAO;
import gapabrikroti.error.CrossOverException;
import gapabrikroti.error.CrossOverGenerationException;
import gapabrikroti.error.EvaluasiException;
import gapabrikroti.error.EvaluasiGenerationException;
import gapabrikroti.error.KoordinatException;
import gapabrikroti.error.MutasiException;
import gapabrikroti.error.MutasiGenerationException;
import gapabrikroti.error.ParameterException;
import gapabrikroti.error.PopulasiException;
import gapabrikroti.error.RataRataException;
import gapabrikroti.error.RouleteWheelException;
import gapabrikroti.error.RouleteWheelGenerationException;
import gapabrikroti.model.CrossOver;
import gapabrikroti.model.CrossOverGeneration;
import gapabrikroti.model.Evaluasi;
import gapabrikroti.model.EvaluasiGeneration;
import gapabrikroti.model.Koordinat;
import gapabrikroti.model.Mutasi;
import gapabrikroti.model.MutasiGeneration;
import gapabrikroti.model.Populasi;
import gapabrikroti.model.RataRata;
import gapabrikroti.model.RouleteWheel;
import gapabrikroti.model.RouleteWheelGeneration;
import gapabrikroti.service.CrossOverGenerationService;
import gapabrikroti.service.CrossOverGenerationServiceImpl;
import gapabrikroti.service.CrossOverGenerationServiceTable;
import gapabrikroti.service.CrossOverService;
import gapabrikroti.service.CrossOverServiceImpl;
import gapabrikroti.service.CrossOverServiceTable;
import gapabrikroti.service.EvaluasiGenerationService;
import gapabrikroti.service.EvaluasiGenerationServiceImpl;
import gapabrikroti.service.EvaluasiGenerationServiceTable;
import gapabrikroti.service.EvaluasiService;
import gapabrikroti.service.EvaluasiServiceImpl;
import gapabrikroti.service.EvaluasiServiceTable;
import gapabrikroti.service.KoordinatService;
import gapabrikroti.service.KoordinatServiceImpl;
import gapabrikroti.service.KoordinatServiceTable;
import gapabrikroti.service.MutasiGenerationService;
import gapabrikroti.service.MutasiGenerationServiceImpl;
import gapabrikroti.service.MutasiGenerationServiceTable;
import gapabrikroti.service.MutasiService;
import gapabrikroti.service.MutasiServiceImpl;
import gapabrikroti.service.MutasiServiceTable;
import gapabrikroti.service.PopulasiService;
import gapabrikroti.service.PopulasiServiceImpl;
import gapabrikroti.service.PopulasiServiceTable;
import gapabrikroti.service.RataRataService;
import gapabrikroti.service.RataRataServiceImpl;
import gapabrikroti.service.RouleteWheelGenerationService;
import gapabrikroti.service.RouleteWheelGenerationServiceImpl;
import gapabrikroti.service.RouleteWheelGenerationServiceTable;
import gapabrikroti.service.RouleteWheelService;
import gapabrikroti.service.RouleteWheelServiceImpl;
import gapabrikroti.service.RouleteWheelServiceTable;
import gapabrikroti.utility.databaseUtility;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;


/**
 *
 * @author cvgs
 */
public class HasilPerhitunganView extends javax.swing.JFrame implements MutasiGenerationService, CrossOverGenerationService, RouleteWheelGenerationService, EvaluasiGenerationService, MutasiService, CrossOverService, RouleteWheelService, EvaluasiService, KoordinatService, PopulasiService, RataRataService, ListSelectionListener {

    /**
     * Creates new form HasilPerhitunganView
     */
    private KoordinatServiceTable koordinatServiceTable;
    private PopulasiServiceTable populasiServiceTable;
    private EvaluasiServiceTable evaluasiServiceTable;
    private RouleteWheelServiceTable rouleteServiceTable;
    private MutasiServiceTable mutasiServiceTable;
    private CrossOverServiceTable crossOverServiceTable;
    private EvaluasiGenerationServiceTable evaluasiGenerationServiceTable;
    private RouleteWheelGenerationServiceTable rouleteGenerationServiceTable;
    private MutasiGenerationServiceTable mutasiGenerationServiceTable;
    private CrossOverGenerationServiceTable crossOverGenerationServiceTable;
    
    private KoordinatServiceImpl koordinatServiceImpl;
    private PopulasiServiceImpl populasiServiceImpl;
    private RataRataServiceImpl rataRataServiceImpl;
    private EvaluasiServiceImpl evaluasiServiceImpl;
    private RouleteWheelServiceImpl rouleteWheelServiceImpl;
    private MutasiServiceImpl mutasiServiceImpl;
    private CrossOverServiceImpl crossOverServiceImpl;
    private EvaluasiGenerationServiceImpl evaluasiGenerationServiceImpl;
    private RouleteWheelGenerationServiceImpl rouleteWheelGenerationServiceImpl;
    private MutasiGenerationServiceImpl mutasiGenerationServiceImpl;
    private CrossOverGenerationServiceImpl crossOverGenerationServiceImpl;
    
    private KoordinatController koordinatController;
    private PerhitunganController perhitunganController;
    
    private int randDecX, randDecY, iterasi, generasi;
    private double evaluasiX, evaluasiY, rataRataX, rataRataY;
    private double Wi, WavgX, WavgY, Ci, Fi, totalFitness, totalFitnessMutasi, Pi, Pc, probabilitasKumulatif, 
            rouleteWheelGenX, rouleteWheelGenY, 
            crossGenX, crossGenY, crossFitness, crossNilaiC,
            mutasiGenX, mutasiGenY, mutasiFitness, mutasiNilaiC;
    DecimalFormat df = new DecimalFormat("#.##");
    
    public HasilPerhitunganView()  throws SQLException, KoordinatException, ParameterException, PopulasiException, EvaluasiException, RataRataException, RouleteWheelException, CrossOverException, MutasiException, EvaluasiGenerationException, RouleteWheelGenerationException, CrossOverGenerationException, MutasiGenerationException  {
        koordinatServiceImpl = new KoordinatServiceImpl();
        koordinatServiceImpl.setKoordinatService(this);
        populasiServiceImpl = new PopulasiServiceImpl();
        populasiServiceImpl.setPopulasiService(this);
        rataRataServiceImpl = new RataRataServiceImpl();
        rataRataServiceImpl.setRataRataService(this);
        
        evaluasiServiceImpl = new EvaluasiServiceImpl();
        evaluasiServiceImpl.setEvaluasiService(this);
        rouleteWheelServiceImpl = new RouleteWheelServiceImpl();
        rouleteWheelServiceImpl.setRouleteWheelService(this);
        mutasiServiceImpl = new MutasiServiceImpl();
        mutasiServiceImpl.setMutasiService(this);
        crossOverServiceImpl = new CrossOverServiceImpl();
        crossOverServiceImpl.setCrossOverService(this);
        
        evaluasiGenerationServiceImpl = new EvaluasiGenerationServiceImpl();
        evaluasiGenerationServiceImpl.setEvaluasiGenerationService(this);
        rouleteWheelGenerationServiceImpl = new RouleteWheelGenerationServiceImpl();
        rouleteWheelGenerationServiceImpl.setRouleteWheelGenerationService(this);
        mutasiGenerationServiceImpl = new MutasiGenerationServiceImpl();
        mutasiGenerationServiceImpl.setMutasiGenerationService(this);
        crossOverGenerationServiceImpl = new CrossOverGenerationServiceImpl();
        crossOverGenerationServiceImpl.setCrossOverGenerationService(this);
                
        
        koordinatController = new KoordinatController();
        koordinatController.setKoordinat(koordinatServiceImpl);
        
        
        perhitunganController = new PerhitunganController();
        perhitunganController.setPopulasi(populasiServiceImpl);
        perhitunganController.setRataRata(rataRataServiceImpl);
        
        perhitunganController.setEvaluasi(evaluasiServiceImpl);
        perhitunganController.setRouleteWheel(rouleteWheelServiceImpl);
        perhitunganController.setCrossOver(crossOverServiceImpl);
        perhitunganController.setMutasi(mutasiServiceImpl);
        
        perhitunganController.setEvaluasiGeneration(evaluasiGenerationServiceImpl);
        perhitunganController.setRouleteWheelGeneration(rouleteWheelGenerationServiceImpl);
        perhitunganController.setCrossOverGeneration(crossOverGenerationServiceImpl);
        perhitunganController.setMutasiGeneration(mutasiGenerationServiceImpl);
        
        
        koordinatServiceTable = new KoordinatServiceTable();
        populasiServiceTable = new PopulasiServiceTable();
        evaluasiServiceTable = new EvaluasiServiceTable();
        rouleteServiceTable = new RouleteWheelServiceTable();
        crossOverServiceTable = new CrossOverServiceTable();
        mutasiServiceTable = new MutasiServiceTable();
        
        evaluasiGenerationServiceTable = new EvaluasiGenerationServiceTable();
        rouleteGenerationServiceTable = new RouleteWheelGenerationServiceTable();
        crossOverGenerationServiceTable = new CrossOverGenerationServiceTable();
        mutasiGenerationServiceTable = new MutasiGenerationServiceTable();
        
        initComponents();
        
        tblKoordinat.getSelectionModel().addListSelectionListener(this);
        tblKoordinat.setModel(koordinatServiceTable);
        
        loadTblKoordinat();
        
        textXMax.enable(false);
        textXMin.enable(false);
        textYMax.enable(false);
        textYMin.enable(false);
        textL1Perhitungan.enable(false);
        textL2Perhitungan.enable(false);
        textL1Perhitungan2.enable(false);
        textL2Perhitungan2.enable(false);
        textL1.enable(false);
        textL2.enable(false);
        textLPerhitungan.enable(false);
        textL.enable(false);
        
        KoordinatDAO koordinatDAO = databaseUtility.getKoordinatDAO();
        
        double a1, a2, b1, b2, n, L, L1,L2;
        a1 = koordinatDAO.getMaxKoordinat().getXMin();
        a2 = koordinatDAO.getMaxKoordinat().getYMin();
        b1 = koordinatDAO.getMaxKoordinat().getXMax();
        b2 = koordinatDAO.getMaxKoordinat().getYMax();
        n  = 2;
        
        textXMin.setText(df.format(a1));
        textYMin.setText(df.format(a2));
        textXMax.setText(df.format(b1));
        textYMax.setText(df.format(b2));
        
        textL1Perhitungan.setText("L1 = [2Log[(" + b1 + "-" + a1 + ")10^" + n + "+1]]");
        textL1Perhitungan2.setText("L1 = [2Log[(" + (b1 - a1) + ")" + (Math.pow(10, n)) + "+1]]");
        L1 = (int) Math.log(((b1-a1)*((Math.pow(10,n))))+1)*2;
        
        textL2Perhitungan.setText("L2 = [2Log[(" + b2 + "-" + a2 + ")10^" + n + "+1]]");
        textL2Perhitungan2.setText("L2 = [2Log[(" + (b2 - a2) + ")" + (Math.pow(10, n)) + "+1]]");
        L2 = (int) Math.log(((b2-a2)*((Math.pow(10,n))))+1)*2;
        
        textL1.setText("L1 = " + df.format(L1));
        textL2.setText("L2 = " + df.format(L2));
        
        L = (int) (L1 + L2);
        textLPerhitungan.setText("L = " + df.format(L1) + " + " + df.format(L2));
        textL.setText("L = " + df.format(L));
        
        ParameterDAO parameterDAO = databaseUtility.getParameterDAO();
        
        double PopSize, Pc, Pm, Pk, G;
        
        PopSize = parameterDAO.getParameterByNamaParameter("popsize").getNilai();
        Pc = parameterDAO.getParameterByNamaParameter("crossover").getNilai();
        Pm = parameterDAO.getParameterByNamaParameter("mutasi").getNilai();
        Pk = parameterDAO.getParameterByNamaParameter("peluang kelestarian kromosom terbaik").getNilai();
        G = parameterDAO.getParameterByNamaParameter("generasi").getNilai();
        
        textPopSize.enable(false);
        textPc.enable(false);
        textPm.enable(false);
        textPk.enable(false);
        textGHasil.enable(false);
        
        textPopSize.setText(Double.toString(PopSize));
        textPc.setText(df.format(Pc));
        textPm.setText(df.format(Pm));
        textPk.setText(df.format(Pk));
        textGHasil.setText(df.format(G));
        
        //shortcut untuk nilai min dan max koordinat
        //L1 = 12;
        //L2 = 12;
        double PanjangKromosomX, PanjangKromosomY;
        PanjangKromosomX = (Math.pow(2, L1))-1;
        PanjangKromosomY = (Math.pow(2, L2))-1;
        
        String px = "";
        for (int ix=1; ix<=L1; ix++) {
            px = px + " 1 ";
        }
        
        String py = "";
        for (int iy=1; iy<=L2; iy++) {
            py = py + " 1 ";
        }
        
        textPanjangKromosomBinX.enable(false);
        textPanjangKromosomBinX.setText(px);
        textPanjangKromosomDecX.enable(false);
        textPanjangKromosomDecX.setText(Double.toString(PanjangKromosomX));
        
        textPanjangKromosomBinY.enable(false);
        textPanjangKromosomBinY.setText(py);
        textPanjangKromosomDecY.enable(false);
        textPanjangKromosomDecY.setText(Double.toString(PanjangKromosomY));
        
        //Algoritma Genetika diawali dari truncate semua table
        perhitunganController.clearPopulasi();
        perhitunganController.clearEvaluasi();
        perhitunganController.clearRataRata();
        
        for (int xy=1; xy<=PopSize; xy++) {
            //inisialisasi
            randDecX = (int)(Math.random() * PanjangKromosomX);
            randDecY = (int)(Math.random() * PanjangKromosomY);
            perhitunganController.insertPopulasi(this);
            
        }
        
        //memasukkan list populasi yg telah di buat secara random ke dalam list
        PopulasiDAO populasiDAO = databaseUtility.getPopulasiDAO();
        List<Populasi> populasi = populasiDAO.getAllPopulasi();
        
        //menampilkan list populasi untuk di evaluasi
        for (Populasi item : populasi) {
            evaluasiX = a1 + item.getBinerX() * (b1-a1)/PanjangKromosomX;
            evaluasiY = a2 + item.getBinerY() * (b2-a2)/PanjangKromosomY;
            //System.out.println(evaluasiX + " " + evaluasiY);
        
            //menghitung total nilai x dan y
            WavgX = WavgX + evaluasiX;
            WavgY = WavgY + evaluasiY;
            perhitunganController.insertEvaluasi(this);
        }
        
        //menghitung rata-rata x dan y
        rataRataX = WavgX / PopSize;
        rataRataY = WavgY / PopSize;
        perhitunganController.insertRataRata(this);
        
        perhitunganController.clearEvaluasi();
        perhitunganController.clearEvaluasiGeneration();
        
        for (Populasi item : populasi) {
            evaluasiX = a1 + item.getBinerX() * (b1-a1)/PanjangKromosomX;
            evaluasiY = a2 + item.getBinerY() * (b2-a2)/PanjangKromosomY;
            
            //System.out.println(evaluasiX + " " + evaluasiY);
            //System.out.println(rataRataX + " " + rataRataY);
            
            //fitness
            Wi = 3;
            Ci = Math.abs(Wi * (evaluasiX-(rataRataX))+(evaluasiY-(rataRataY)));
            Fi = 1 / Ci;
            
            //System.out.println(" " + evaluasiX + " " + evaluasiY + " " + Fi + " " + Ci + " " + Pi);
            //insert evaluasi fitness
            perhitunganController.insertEvaluasi(this);
            
            
            //hitung probabilitas
            totalFitness = totalFitness + Fi;
            //System.out.println(totalFitness);
        }
        
        //insert totalFitness
        perhitunganController.clearRataRata();
        perhitunganController.insertRataRata(this);
        //System.out.println(totalFitness);
        
        perhitunganController.clearEvaluasi();
        
        for (Populasi item : populasi) {
            evaluasiX = a1 + item.getBinerX() * (b1-a1)/PanjangKromosomX;
            evaluasiY = a2 + item.getBinerY() * (b2-a2)/PanjangKromosomY;
            
            //fitness
            //Wi = 3;
            Ci = Math.abs(Wi * (evaluasiX-(rataRataX))+(evaluasiY-(rataRataY)));
            Fi = 1 / Ci;
            
            //evaluasifitness
            Pi = Fi / totalFitness;
            //System.out.println(" " + evaluasiX + " " + evaluasiY + " " + Fi + " " + Ci + " " + Pi);
            //masukkan table evaluasi
            
            //menghitung cumulatif probabilitasnya 
            probabilitasKumulatif = probabilitasKumulatif + Pi;
            
            perhitunganController.insertEvaluasi(this);
            perhitunganController.insertEvaluasiGeneration(this);
            //System.out.println(probabilitasKumulatif);
        }    
        
        //System.out.println(probabilitasKumulatif);
        //masukkan ke table rata-rata
        perhitunganController.clearRataRata();
        perhitunganController.insertRataRata(this);
        
        perhitunganController.clearRouleteWheelGeneration();
        perhitunganController.clearCrossOverGeneration();
        perhitunganController.clearMutasiGeneration();
        
        //prosses iterasi atau proses generasi
        for (generasi=1; generasi<=G; generasi++) {
            //memasukkan list evaluasi yg telah di buat secara random ke dalam list
            EvaluasiDAO evaluasiDAO = databaseUtility.getEvaluasiDAO();
            List<Evaluasi> evaluasi = evaluasiDAO.getAllEvaluasi();

            //membangkitkan roulate wheel
            perhitunganController.clearRouleteWheel();
            double r;
            for (Evaluasi itemEvaluasi1 : evaluasi) {
                for (Evaluasi itemEvaluasi : evaluasi) {
                    r = (double)(Math.random() * probabilitasKumulatif);
                    //System.out.println(itemEvaluasi.getProbabilitasCumulatif()); 
                    if (r < itemEvaluasi.getProbabilitasCumulatif()) {
                        //System.out.println(itemEvaluasi.getNoEvaluasi() + " " + itemEvaluasi.getEvaluasiX() + " " + itemEvaluasi.getEvaluasiY());
                        rouleteWheelGenX = itemEvaluasi.getEvaluasiX();
                        rouleteWheelGenY = itemEvaluasi.getEvaluasiY();

                        //insertRoulateWheel
                        perhitunganController.insertRouleteWheel(this);
                        perhitunganController.insertRouleteWheelGeneration(this);
                        break;
                    }
                }
            }

            //clear data crossOver
            perhitunganController.clearCrossOver();

            //memasukkan list roulateWheel yg telah di buat secara random ke dalam list
            RouleteWheelDAO rouleteWheelDAO = databaseUtility.getRouleteWheelDAO();
            List<RouleteWheel> rouleteWheel = rouleteWheelDAO.getAllRouleteWheel();
            double R, weightCrossGenX = 0, weightCrossGenY = 0;
            int genCrossPosisi = 0;
            for (RouleteWheel itemRouleteWheel : rouleteWheel) {
                for (Evaluasi itemEvaluasi2 : evaluasi) {
                    //bangkitkan r sejumlah populasi
                    R = (Math.random() * 1);
                    if (R < itemEvaluasi2.getProbabilitasCumulatif()) {
                        //System.out.println(R);
                        genCrossPosisi = (int) (Math.random() * 2);
                        if (genCrossPosisi==0) {
                            //System.out.println("tukarY");
                            crossGenX = itemRouleteWheel.getRouleteWheelGenX();
                            crossGenY = itemEvaluasi2.getEvaluasiY();
                            //System.out.println(crossGenX + " " + crossGenY + " " + crossNilaiC + " " + crossFitness);
                        } else {
                            //System.out.println("tetapX");
                            crossGenX = itemEvaluasi2.getEvaluasiX();
                            crossGenY = itemRouleteWheel.getRouleteWheelGenY();
                            //System.out.println(crossGenX + " " + crossGenY + " " + crossNilaiC + " " + crossFitness);
                        }

                        weightCrossGenX = weightCrossGenX + crossGenX;
                        weightCrossGenY = weightCrossGenY + crossGenY;

                        //insert hasil crossover
                        perhitunganController.insertCrossOver(this);
                        break;
                    }
                }
            }

            double rataRataCrossX = weightCrossGenX/PopSize;
            double rataRataCrossY = weightCrossGenY/PopSize;

            CrossOverDAO crossOverDAO = databaseUtility.getCrossOverDAO();
            List<CrossOver> crossOver = crossOverDAO.getAllCrossOver();

            perhitunganController.clearCrossOver();

            for (CrossOver itemCrossOver : crossOver) {
                crossGenX = itemCrossOver.getCrossOverX();
                crossGenY = itemCrossOver.getCrossOverY();

                crossNilaiC = Math.abs(Wi * (crossGenX-(rataRataCrossX))+(crossGenY-(rataRataCrossY)));
                crossFitness = 1 / crossNilaiC;

                //System.out.println(crossGenX + " " + crossGenY + " " + crossNilaiC + " " + crossFitness);

                perhitunganController.insertCrossOver(this);
                perhitunganController.insertCrossOverGeneration(this);
            }

            perhitunganController.clearMutasi();
            //memasukkan list crossOver untuk di mutasi

            double totalGen, RMutasi, weightMutasiGenX = 0, weightMutasiGenY = 0, MutasiExeX, MutasiExeY;
            int genMutasiPosisi = 0;

            double randForMut1 = (b1-a1)/PanjangKromosomX;
            double randForMut2 = (b2-a2)/PanjangKromosomY;

            for (Evaluasi itemEvaluasi3 : evaluasi) {
                for (CrossOver crossOver1 : crossOver) {
                    //bangkitkan r sejumlah populasi
                    randForMut1 = (int)(Math.random() * PanjangKromosomX);
                    randForMut2 = (int)(Math.random() * PanjangKromosomY);
                    MutasiExeX = a1 + randForMut1 * (b1-a1)/PanjangKromosomX;
                    MutasiExeY = a2 + randForMut2 * (b2-a2)/PanjangKromosomY;
                    //System.out.println(" " + MutasiExeX + "  " + MutasiExeY);

                    totalGen = 2 * PopSize;
                    RMutasi = ((Math.random() * totalGen)/1000);
                    //System.out.println(RMutasi);
                    //System.out.println(Pm);
                    //System.out.println(" ");
                    if (RMutasi < Pm) {
                        genMutasiPosisi = (int) (Math.random() * 2);
                        if (genMutasiPosisi==1) {
                            //System.out.println("mutasiY");
                            mutasiGenX = MutasiExeX;
                            mutasiGenY = crossOver1.getCrossOverY();
                            //System.out.println(crossGenX + " " + crossGenY + " " + crossNilaiC + " " + crossFitness);
                        } else {
                            //System.out.println("mutasiX");
                            mutasiGenX = crossOver1.getCrossOverX();
                            mutasiGenY = MutasiExeY;
                            //System.out.println(crossGenX + " " + crossGenY + " " + crossNilaiC + " " + crossFitness);
                        }

                        weightMutasiGenX = weightMutasiGenX + mutasiGenX;
                        weightMutasiGenY = weightMutasiGenY + mutasiGenY;

                        //insert hasil crossover
                        perhitunganController.insertMutasi(this);
                        
                        break;
                    }
                }
            }

            double rataRataMutasiX = weightMutasiGenX/PopSize;
            double rataRataMutasiY = weightMutasiGenY/PopSize;

            MutasiDAO mutasiDAO = databaseUtility.getMutasiDAO();
            List<Mutasi> mutasi = mutasiDAO.getAllMutasi();

            perhitunganController.clearMutasi();
            
            totalFitnessMutasi = 0;
            Ci = 0;
            Fi = 0;
            
            for (Mutasi itemCrossOver1 : mutasi) {
                mutasiGenX = itemCrossOver1.getMutasiX();
                mutasiGenY = itemCrossOver1.getMutasiY();
                
                mutasiNilaiC = Math.abs(Wi * (mutasiGenX-(rataRataMutasiX))+(mutasiGenY-(rataRataMutasiY)));
                mutasiFitness = 1 / mutasiNilaiC;

                evaluasiX = itemCrossOver1.getMutasiX();
                evaluasiY = itemCrossOver1.getMutasiY();
                
                Ci = Math.abs(Wi * (mutasiGenX-(rataRataMutasiX))+(mutasiGenY-(rataRataMutasiY)));
                Fi = 1 / mutasiNilaiC;
                totalFitnessMutasi = totalFitnessMutasi + Fi;
                //System.out.println(mutasiGenX + " " + mutasiGenY + " " + mutasiNilaiC + " " + mutasiFitness);

                perhitunganController.insertMutasi(this);
                perhitunganController.insertMutasiGeneration(this);
            }
            
            //perhitunganController.clearEvaluasi();
            //reset nilai probabilitas kumulatif terlebih dahulu
            
            perhitunganController.clearEvaluasi();
            
            probabilitasKumulatif = 0;
            //kromosom baru yang akan di proses pada generasi atau iterasi selanjutyna
            for (Mutasi itemCrossOver2 : mutasi) {
                evaluasiX = itemCrossOver2.getMutasiX();
                evaluasiY = itemCrossOver2.getMutasiY();
                
                Ci = Math.abs(Wi * (evaluasiX-(rataRataMutasiX))+(evaluasiY-(rataRataMutasiY)));
                Fi = 1 / Ci;
                
                Pi = Fi / totalFitnessMutasi;
                
                probabilitasKumulatif = probabilitasKumulatif + Pi;
                //System.out.println(mutasiGenX + " " + mutasiGenY + " " + mutasiNilaiC + " " + mutasiFitness);

                perhitunganController.insertEvaluasi(this);
                perhitunganController.insertEvaluasiGeneration(this);
            }
        }
        
        tblMutasi.getSelectionModel().addListSelectionListener(this);
        tblMutasi.setModel(mutasiServiceTable);
        loadTblMutasi();
        
        tblCrossOver.getSelectionModel().addListSelectionListener(this);
        tblCrossOver.setModel(crossOverServiceTable);
        loadTblCrossOver();
        
        tblPopulasi.getSelectionModel().addListSelectionListener(this);
        tblPopulasi.setModel(populasiServiceTable);
        loadTblPopulasi();
                
        tblEvaluasi.getSelectionModel().addListSelectionListener(this);
        tblEvaluasi.setModel(evaluasiServiceTable);
        loadTblEvaluasi();
    
        tblRouleteWheel.getSelectionModel().addListSelectionListener(this);
        tblRouleteWheel.setModel(rouleteServiceTable);
        loadTblRouleteWheel();
        
    }

    public JTable getTblKoordinat() {
        return tblKoordinat;
    }

    public void setTblKoordinat(JTable tblKoordinat) {
        this.tblKoordinat = tblKoordinat;
    }
 
    public JTextField getTextXMax() {
        return textXMax;
    }

    public void setTextXMax(JTextField textXMax) {
        this.textXMax = textXMax;
    }

    public JTextField getTextXMin() {
        return textXMin;
    }

    public void setTextXMin(JTextField textXMin) {
        this.textXMin = textXMin;
    }

    public JTextField getTextYMax() {
        return textYMax;
    }

    public void setTextYMax(JTextField textYMax) {
        this.textYMax = textYMax;
    }

    public JTextField getTextYMin() {
        return textYMin;
    }

    public void setTextYMin(JTextField textYMin) {
        this.textYMin = textYMin;
    }

    public JTextField getTextGHasil() {
        return textGHasil;
    }

    public void setTextGHasil(JTextField textGHasil) {
        this.textGHasil = textGHasil;
    }

    public int getRandDecX() {
        return randDecX;
    }

    public int getRandDecY() {
        return randDecY;
    }

    public double getEvaluasiX() {
        return evaluasiX;
    }

    public double getEvaluasiY() {
        return evaluasiY;
    }

    public double getCi() {
        return Ci;
    }

    public double getFi() {
        return Fi;
    }

    public double getPi() {
        return Pi;
    }

    public double getRataRataX() {
        return rataRataX;
    }

    public double getRataRataY() {
        return rataRataY;
    }

    public double getWi() {
        return Wi;
    }

    public double getWavgX() {
        return WavgX;
    }

    public double getWavgY() {
        return WavgY;
    }

    public double getPc() {
        return Pc;
    }

    public double getTotalFitness() {
        return totalFitness;
    }

    public double getProbabilitasKumulatif() {
        return probabilitasKumulatif;
    }

    public double getRouleteWheelGenX() {
        return rouleteWheelGenX;
    }

    public double getRouleteWheelGenY() {
        return rouleteWheelGenY;
    }

    public double getCrossGenX() {
        return crossGenX;
    }

    public void setCrossGenX(double crossGenX) {
        this.crossGenX = crossGenX;
    }

    public double getCrossGenY() {
        return crossGenY;
    }

    public void setCrossGenY(double crossGenY) {
        this.crossGenY = crossGenY;
    }

    public double getCrossFitness() {
        return crossFitness;
    }

    public double getCrossNilaiC() {
        return crossNilaiC;
    }

    public double getMutasiGenX() {
        return mutasiGenX;
    }

    public void setMutasiGenX(double mutasiGenX) {
        this.mutasiGenX = mutasiGenX;
    }

    public double getMutasiGenY() {
        return mutasiGenY;
    }

    public void setMutasiGenY(double mutasiGenY) {
        this.mutasiGenY = mutasiGenY;
    }

    public double getMutasiFitness() {
        return mutasiFitness;
    }

    public void setMutasiFitness(double mutasiFitness) {
        this.mutasiFitness = mutasiFitness;
    }

    public double getMutasiNilaiC() {
        return mutasiNilaiC;
    }

    public void setMutasiNilaiC(double mutasiNilaiC) {
        this.mutasiNilaiC = mutasiNilaiC;
    }
    
    public int getGenerasi() {
        return generasi;
    }

    public int getIterasi() {
        return iterasi;
    }

    public void setIterasi(int iterasi) {
        this.iterasi = iterasi;
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tblPopulasi1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKoordinat = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textXMax = new javax.swing.JTextField();
        textYMax = new javax.swing.JTextField();
        textXMin = new javax.swing.JTextField();
        textYMin = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textL1 = new javax.swing.JTextField();
        textL2 = new javax.swing.JTextField();
        textL1Perhitungan = new javax.swing.JTextField();
        textL2Perhitungan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textLPerhitungan = new javax.swing.JTextField();
        textL = new javax.swing.JTextField();
        textL1Perhitungan2 = new javax.swing.JTextField();
        textL2Perhitungan2 = new javax.swing.JTextField();
        textPopSize = new javax.swing.JTextField();
        textPc = new javax.swing.JTextField();
        textPm = new javax.swing.JTextField();
        textPk = new javax.swing.JTextField();
        textGHasil = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        textPanjangKromosomBinX = new javax.swing.JTextField();
        textPanjangKromosomDecX = new javax.swing.JTextField();
        textPanjangKromosomBinY = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        textPanjangKromosomDecY = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPopulasi = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblEvaluasi = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblRouleteWheel = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblCrossOver = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblMutasi = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cmdIterasi = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        tblPopulasi1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblPopulasi1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPopulasi1.setRowHeight(22);
        jScrollPane3.setViewportView(tblPopulasi1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblKoordinat.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblKoordinat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblKoordinat.setRowHeight(22);
        jScrollPane1.setViewportView(tblKoordinat);

        jLabel1.setText("- Berdasarkan koordinat lokasi pabrik distribusi yang sudah ada di tabel di atas, maka di dapat nilai  sebagai berikut :");

        jLabel2.setText("nilai X max");

        jLabel3.setText("nilai Y max");

        jLabel4.setText("nilai X min");

        jLabel5.setText("nilai Y min");

        jLabel6.setText("Koordinat Pabrik yang Sudah Ada");

        jLabel7.setText("- Maka panjang kromosom sebagai berikut :");

        jLabel8.setText("L1 = [2Log[(b-a)10n+1]]");

        jLabel9.setText("L2 = [2Log[(b-a)10n+1]]");

        textL2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textL2ActionPerformed(evt);
            }
        });

        textL2Perhitungan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textL2PerhitunganActionPerformed(evt);
            }
        });

        jLabel10.setText("L = L1 + L2");

        textL1Perhitungan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textL1Perhitungan2ActionPerformed(evt);
            }
        });

        textPc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPcActionPerformed(evt);
            }
        });

        textPm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPmActionPerformed(evt);
            }
        });

        jLabel11.setText("Pop Size");

        jLabel12.setText("Pc(crossover)");

        jLabel13.setText("Pm(mutasi)");

        jLabel14.setText("Peluang Kromosom");

        jLabel15.setText("Jmlh Generalisasi");

        jLabel16.setText("- Parameter");

        jLabel17.setText("Panjang Kromosom X dalam biner ");

        jLabel18.setText("Panjang Kromosom X dalam decimal");

        textPanjangKromosomBinX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPanjangKromosomBinXActionPerformed(evt);
            }
        });

        textPanjangKromosomBinY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPanjangKromosomBinYActionPerformed(evt);
            }
        });

        jLabel19.setText("Panjang Kromosom Y dalam biner");

        jLabel20.setText("Panjang Kromosom Y dalam decimal");

        tblPopulasi.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblPopulasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPopulasi.setRowHeight(22);
        jScrollPane2.setViewportView(tblPopulasi);

        tblEvaluasi.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblEvaluasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblEvaluasi.setRowHeight(22);
        jScrollPane4.setViewportView(tblEvaluasi);

        jLabel21.setText("Roulete Wheel");

        jLabel22.setText("Evaluasi");

        tblRouleteWheel.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tblRouleteWheel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblRouleteWheel.setRowHeight(22);
        jScrollPane5.setViewportView(tblRouleteWheel);

        tblCrossOver.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(tblCrossOver);

        tblMutasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tblMutasi);

        jLabel23.setText("Cross Over");

        jLabel24.setText("Mutasi");

        cmdIterasi.setText("Lihat Generasi atau Iterasi");
        cmdIterasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdIterasiActionPerformed(evt);
            }
        });

        jButton1.setText("peta koordinat awal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("min max peta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("peta rekomendasi");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel6)
                                .addGap(613, 613, 613)
                                .addComponent(jLabel22))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textL1Perhitungan2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textYMax, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textXMax, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(67, 67, 67)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(textYMin, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmdIterasi, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textXMin, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton3))))
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(textL1Perhitungan)
                                                .addGap(40, 40, 40))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(150, 150, 150)))
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textL2Perhitungan2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textL2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textL2Perhitungan, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel12)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel14)
                                                    .addComponent(jLabel15))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(textPc, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textGHasil, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textPk, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textPm, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textPopSize, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel10)
                                            .addComponent(textLPerhitungan, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textL, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(61, 61, 61)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel19)
                                                        .addGap(16, 16, 16))
                                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(19, 19, 19)
                                                        .addComponent(textPanjangKromosomBinY, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(textPanjangKromosomDecY, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel18)
                                                    .addComponent(jLabel17))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textPanjangKromosomDecX, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(textPanjangKromosomBinX, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(textL1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(839, 839, 839)
                .addComponent(jLabel21)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(jLabel23))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textXMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(textYMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textL1Perhitungan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textL2Perhitungan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(textYMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(textXMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmdIterasi, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1)
                                    .addComponent(jButton3)
                                    .addComponent(jButton2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textL1Perhitungan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textL2Perhitungan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textLPerhitungan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13)
                                        .addGap(12, 12, 12))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(textPopSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textPc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textPm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel14))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textPk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(textGHasil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(textPanjangKromosomBinX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(textPanjangKromosomDecX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textPanjangKromosomBinY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(textPanjangKromosomDecY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(jLabel19)))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textL2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textL2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textL2ActionPerformed

    private void textL2PerhitunganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textL2PerhitunganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textL2PerhitunganActionPerformed

    private void textL1Perhitungan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textL1Perhitungan2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textL1Perhitungan2ActionPerformed

    private void textPmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPmActionPerformed

    private void textPcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPcActionPerformed

    private void textPanjangKromosomBinXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPanjangKromosomBinXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPanjangKromosomBinXActionPerformed

    private void textPanjangKromosomBinYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPanjangKromosomBinYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPanjangKromosomBinYActionPerformed

    private void cmdIterasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdIterasiActionPerformed
        try {
            HasilIterasiView Hiv = new HasilIterasiView();
            Hiv.setVisible(true);
        } catch (EvaluasiGenerationException ex) {
            Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RouleteWheelGenerationException ex) {
            Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CrossOverGenerationException ex) {
            Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MutasiGenerationException ex) {
            Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdIterasiActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            createAndShowUIAkhir();
        } catch (SQLException ex) {
            Logger.getLogger(HasilIterasiView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EvaluasiGenerationException ex) {
            Logger.getLogger(HasilIterasiView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            createAndShowUIMinMax();
        } catch (SQLException ex) {
            Logger.getLogger(HasilIterasiView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KoordinatException ex) {
            Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            createAndShowUIAkhirAwal();
        } catch (SQLException ex) {
            Logger.getLogger(HasilIterasiView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KoordinatException ex) {
            Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EvaluasiGenerationException ex) {
            Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HasilPerhitunganView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HasilPerhitunganView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HasilPerhitunganView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HasilPerhitunganView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HasilPerhitunganView().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (KoordinatException ex) {
                    Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParameterException ex) {
                    Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (PopulasiException ex) {
                    Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (EvaluasiException ex) {
                    Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RataRataException ex) {
                    Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RouleteWheelException ex) {
                    Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (CrossOverException ex) {
                    Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MutasiException ex) {
                    Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (EvaluasiGenerationException ex) {
                    Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RouleteWheelGenerationException ex) {
                    Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (CrossOverGenerationException ex) {
                    Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MutasiGenerationException ex) {
                    Logger.getLogger(HasilPerhitunganView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdIterasi;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable tblCrossOver;
    private javax.swing.JTable tblEvaluasi;
    private javax.swing.JTable tblKoordinat;
    private javax.swing.JTable tblMutasi;
    private javax.swing.JTable tblPopulasi;
    private javax.swing.JTable tblPopulasi1;
    private javax.swing.JTable tblRouleteWheel;
    private javax.swing.JTextField textGHasil;
    private javax.swing.JTextField textL;
    private javax.swing.JTextField textL1;
    private javax.swing.JTextField textL1Perhitungan;
    private javax.swing.JTextField textL1Perhitungan2;
    private javax.swing.JTextField textL2;
    private javax.swing.JTextField textL2Perhitungan;
    private javax.swing.JTextField textL2Perhitungan2;
    private javax.swing.JTextField textLPerhitungan;
    private javax.swing.JTextField textPanjangKromosomBinX;
    private javax.swing.JTextField textPanjangKromosomBinY;
    private javax.swing.JTextField textPanjangKromosomDecX;
    private javax.swing.JTextField textPanjangKromosomDecY;
    private javax.swing.JTextField textPc;
    private javax.swing.JTextField textPk;
    private javax.swing.JTextField textPm;
    private javax.swing.JTextField textPopSize;
    private javax.swing.JTextField textXMax;
    private javax.swing.JTextField textXMin;
    private javax.swing.JTextField textYMax;
    private javax.swing.JTextField textYMin;
    // End of variables declaration//GEN-END:variables

    private void loadTblKoordinat() throws SQLException, KoordinatException {
        KoordinatDAO koordinatDAO = databaseUtility.getKoordinatDAO();
        koordinatServiceTable.setList(koordinatDAO.getAllKoordinat());

    }
    
    private void loadTblPopulasi() throws SQLException, PopulasiException {
        PopulasiDAO populasiDAO = databaseUtility.getPopulasiDAO();
        populasiServiceTable.setList(populasiDAO.getAllPopulasi());
    
    }
    
    private void loadTblEvaluasi() throws SQLException, EvaluasiException {
        EvaluasiDAO evaluasiDAO = databaseUtility.getEvaluasiDAO();
        evaluasiServiceTable.setList(evaluasiDAO.getAllEvaluasi());
    
    }
    
    private void loadTblRouleteWheel() throws SQLException, RouleteWheelException {
        RouleteWheelDAO rouleteWheelDAO = databaseUtility.getRouleteWheelDAO();
        rouleteServiceTable.setList(rouleteWheelDAO.getAllRouleteWheel());
    
    }
    
    private void loadTblCrossOver() throws SQLException, CrossOverException {
        CrossOverDAO crossOverDAO = databaseUtility.getCrossOverDAO();
        crossOverServiceTable.setList(crossOverDAO.getAllCrossOver());
    
    }
    
    private void loadTblMutasi() throws SQLException, MutasiException {
        MutasiDAO mutasiDAO = databaseUtility.getMutasiDAO();
        mutasiServiceTable.setList(mutasiDAO.getAllMutasi());

    }
    
    @Override
    public void onChange(KoordinatServiceImpl koordinatServiceImpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onInsert(Koordinat koordinat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onUpdate(Koordinat koordinat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onDelete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onChange(PopulasiServiceImpl populasiServiceImpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onInsert(Populasi populasi) {
        populasiServiceTable.add(populasi);
    }

    @Override
    public void onUpdate(Populasi populasi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onChange(EvaluasiServiceImpl evaluasiServiceImpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onInsert(Evaluasi evaluasi) {
        evaluasiServiceTable.add(evaluasi);
    }

    @Override
    public void onInsert(EvaluasiGeneration evaluasiGeneration) {
        evaluasiGenerationServiceTable.add(evaluasiGeneration);
    }

    @Override
    public void onUpdate(Evaluasi evaluasi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onChange(RataRataServiceImpl rataRataServiceImpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onInsert(RataRata rataRata) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onChange(RouleteWheelServiceImpl rouleteWheelServiceImpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onInsert(RouleteWheel rouleteWheel) {
        rouleteServiceTable.add(rouleteWheel);
    }

    @Override
    public void onInsert(RouleteWheelGeneration rouleteWheelGeneration) {
        rouleteGenerationServiceTable.add(rouleteWheelGeneration);
    }
    
    @Override
    public void onUpdate(RouleteWheel rouleteWheel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onChance(MutasiServiceImpl mutasiServiceImpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onInsert(Mutasi mutasi) {
        mutasiServiceTable.add(mutasi);
    }

    @Override
    public void onInsert(MutasiGeneration mutasiGeneration) {
        mutasiGenerationServiceTable.add(mutasiGeneration);
    }

    @Override
    public void onUpdate(Mutasi mutasi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onChange(CrossOverServiceImpl crossOverServiceImpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onInsert(CrossOver crossOver) {
        crossOverServiceTable.add(crossOver);
    }

    @Override
    public void onInsert(CrossOverGeneration crossOverGeneration) {
        crossOverGenerationServiceTable.add(crossOverGeneration);
    }

    @Override
    public void onUpdate(CrossOver crossOver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onChance(MutasiGenerationServiceImpl mutasiGenerationServiceImpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onUpdate(MutasiGeneration mutasiGeneration) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onChange(CrossOverGenerationServiceImpl crossOverGenerationServiceImpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onUpdate(CrossOverGeneration crossOverGeneration) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onChange(RouleteWheelGenerationServiceImpl rouleteWheelGenerationServiceImpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onUpdate(RouleteWheelGeneration rouleteWheelGeneration) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onChange(EvaluasiGenerationServiceImpl evaluasiGenerationServiceImpl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void onUpdate(EvaluasiGeneration evaluasiGeneration) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void createAndShowUIAkhir() throws SQLException, EvaluasiGenerationException {
        JFrame frame = new JFrame("Demo");
        JMapViewer viewer = new JMapViewer();

        int x, y;

        EvaluasiGenerationDAO evaluasiGenerationDAO;
        evaluasiGenerationDAO = databaseUtility.getEvaluasiGenerationDAO();
        List<EvaluasiGeneration> evaluasiGeneration = evaluasiGenerationDAO.getAllEvaluasiGenerationByProbabilitas();
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        //membangkitkan evaluasi
        for (EvaluasiGeneration itemEvaluasi : evaluasiGeneration) {
            x = (int) itemEvaluasi.getEvaluasiX();
            y = (int) itemEvaluasi.getEvaluasiY();
            coordinates.add(new Coordinate(x - 25, y + 100));
            //System.out.println(x + " " + " " + y);
        }

        HasilIterasiView.MapPolyLine polyLine = new HasilIterasiView.MapPolyLine(coordinates);
        viewer.addMapPolygon(polyLine);

        frame.add(viewer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
        
    }
    
    private static void createAndShowUIMinMax() throws SQLException, KoordinatException {
        JFrame frame = new JFrame("Demo");
        JMapViewer viewer = new JMapViewer();

        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        //membangkitkan evaluasi
        KoordinatDAO koordinatDAO = databaseUtility.getKoordinatDAO();
        
        double a1, a2, b1, b2, n, L, L1,L2;
        a1 = koordinatDAO.getMaxKoordinat().getXMin();
        a2 = koordinatDAO.getMaxKoordinat().getYMin();
        b1 = koordinatDAO.getMaxKoordinat().getXMax();
        b2 = koordinatDAO.getMaxKoordinat().getYMax();
        n  = 2;
        
        //System.out.println(a1 + " " + " " + a2 + " " + " " + b1 + " " + " " + b2);
        
        coordinates.add(new Coordinate(b1 - 25, a2 + 100));
        coordinates.add(new Coordinate(b1 - 25, b2 + 100));
        coordinates.add(new Coordinate(a1 - 25, b2 + 100));
        coordinates.add(new Coordinate(a1 - 25, a2 + 100));
        coordinates.add(new Coordinate(b1 - 25, a2 + 100));
        
        
        HasilIterasiView.MapPolyLine polyLine = new HasilIterasiView.MapPolyLine(coordinates);
        viewer.addMapPolygon(polyLine);

        frame.add(viewer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }
    
    private static void createAndShowUIAkhirAwal() throws SQLException, EvaluasiGenerationException, KoordinatException {
        JFrame frame = new JFrame("Demo");
        JMapViewer viewer = new JMapViewer();

        int x, y;

        KoordinatDAO KoordinatDAO;
        KoordinatDAO = databaseUtility.getKoordinatDAO();
        List<Koordinat> koordinat = KoordinatDAO.getAllKoordinat();
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        //membangkitkan evaluasi
        for (Koordinat itemkoordinat : koordinat) {
            x = (int) itemkoordinat.getX();
            y = (int) itemkoordinat.getY();
            coordinates.add(new Coordinate(x - 25, y + 100));
            //System.out.println(x + " " + " " + y);
        }

        HasilIterasiView.MapPolyLine polyLine = new HasilIterasiView.MapPolyLine(coordinates);
        viewer.addMapPolygon(polyLine);

        frame.add(viewer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }
}
