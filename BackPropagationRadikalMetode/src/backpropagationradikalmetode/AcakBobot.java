/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backpropagationradikalmetode;

import backpropagationradikalmetode.utility.jdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Abd-Allah
 */
public class AcakBobot extends javax.swing.JPanel {

    private static DefaultTableModel tblNormalisasiDua;

    private static DefaultTableModel tblBobot;
    private static DefaultTableModel tblVector;
    private static DefaultTableModel tblBobotBaru;
    private static DefaultTableModel tblBias;
    private static DefaultTableModel tblAcak;
    private static DefaultTableModel tblAcakOutput;
    private static DefaultTableModel tblNormalisasi;
    private static DefaultTableModel tblFeedforward;
    private static DefaultTableModel tblHiddenLayer;
    private static DefaultTableModel tblSinyal;
    private static DefaultTableModel tblSinyalOutput;

    private static DefaultTableModel tblFaktorError;
    private static DefaultTableModel tblKoreksiError;
    private static DefaultTableModel tblDeltaHidden;
    private static DefaultTableModel tblFaktorKoreksi;
    private static DefaultTableModel tblTermFrekuensi;

    private static DefaultTableModel tblNw10;
    private static DefaultTableModel tblSegitigaw10;
    private static DefaultTableModel tblDelta11;

    private static DefaultTableModel tblW10;
    private static DefaultTableModel tbl9NilaiBiasAwal;
    private static DefaultTableModel tbl13;

    int iterMaxx = 1;
    double learningRatee = 0.5;

    
    /**
     * Creates new form ProsesPelatihan
     */
    public AcakBobot() {
        initComponents();
        
        tampilkanTermFrekuensi();
        bobotTableConfig();
        vectorTableConfig();
        bobotTableBaruConfig();
        biasTableConfig();
        acakTableConfig();
        acakOutputConfig();
        acakOutputShow();
        FeedForwardConfig();
        hiddenLayerConfig();
        sinyalTableConfig();
        sinyalOutputTableConfig();
        aktivasiTableW();
        aktivasiTable9NilaiBiasAwal();
        aktivasiTable13();

        try {
            termNormalisasi();
            bobotTableShow();
            panjangVectorShow();
            biasShow();
            acakShow();
            outputShow();
            NormalisasiShow();
            hiddenLayerShow();
            hitungFeedForwardShow();
        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class.getName()).log(Level.SEVERE, null, ex);
        }

        //aktivasiTabelSinyal();
        aktivasiFaktorErro();
        aktivasiKoreksiError();
        aktivasiAcak();
        aktivasiDeltaHidden();
        aktivasiFaktorKoreksi();
        aktivasiTermFrekuensi();
        aktivasiNw10();
        aktivasiSeigtigaV();
        aktivasiDelta11();

        try {
            sinyalOperation();
            sinyalShow();
            sinyalOutputShow();
            feedForwardLanjut();
            feedForward();
            hiddenLayerShow();
            hitungNw10();
            hitungDeltaV11();
            truncateW10();
            hitungW10();
            tampilkanW10();
            truncateHitung9NilaiBiasAwal();
            hitung9NilaiBiasAwal();
            truncateHitungTable13();
            hitungTable13();

        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    AcakBobot(int iterMax, double learningRate) {
        initComponents();

        this.iterMaxx = iterMax;
        this.learningRatee = learningRate;

        tampilkanTermFrekuensi();
        bobotTableConfig();
        vectorTableConfig();
        bobotTableBaruConfig();
        biasTableConfig();
        acakTableConfig();
        acakOutputConfig();
        acakOutputShow();
        FeedForwardConfig();
        hiddenLayerConfig();
        sinyalTableConfig();
        sinyalOutputTableConfig();
        aktivasiTableW();
        aktivasiTable9NilaiBiasAwal();
        aktivasiTable13();

        try {
            termNormalisasi();
            bobotTableShow();
            panjangVectorShow();
            biasShow();
            acakShow();
            outputShow();
            NormalisasiShow();
            hiddenLayerShow();
            hitungFeedForwardShow();
        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class.getName()).log(Level.SEVERE, null, ex);
        }

        //aktivasiTabelSinyal();
        aktivasiFaktorErro();
        aktivasiKoreksiError();
        aktivasiAcak();
        aktivasiDeltaHidden();
        aktivasiFaktorKoreksi();
        aktivasiTermFrekuensi();
        aktivasiNw10();
        aktivasiSeigtigaV();
        aktivasiDelta11();

        try {
            sinyalOperation();
            sinyalShow();
            sinyalOutputShow();
            feedForwardLanjut();
            feedForward();
            hiddenLayerShow();
            hitungNw10();
            hitungDeltaV11();
            truncateW10();
            hitungW10();
            tampilkanW10();
            truncateHitung9NilaiBiasAwal();
            hitung9NilaiBiasAwal();
            truncateHitungTable13();
            hitungTable13();

        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        TblSinyalOutput = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TblAcak = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        TblAcakOutput = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        TblNormalisasi = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        TblBobot = new javax.swing.JTable();
        cmdAcak = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        TblFeedforward = new javax.swing.JTable();
        cmdExcel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        TblHiddenLayer = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        TblVector = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TblBobotBaru = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        TblSinyal = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TblBias = new javax.swing.JTable();
        jScrollPane17 = new javax.swing.JScrollPane();
        TblFaktorKoreksi = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        TblKoderksiError = new javax.swing.JTable();
        jScrollPane20 = new javax.swing.JScrollPane();
        TblTermFrekuensi = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        TblFaktorError = new javax.swing.JTable();
        jScrollPane25 = new javax.swing.JScrollPane();
        TblDeltaHidden = new javax.swing.JTable();
        jScrollPane26 = new javax.swing.JScrollPane();
        TblNw10 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        TblSegitigaw10 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        TblSegitigaw11 = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane27 = new javax.swing.JScrollPane();
        TblW10 = new javax.swing.JTable();
        jScrollPane28 = new javax.swing.JScrollPane();
        Tbl9NilaiBiasAwal = new javax.swing.JTable();
        jScrollPane22 = new javax.swing.JScrollPane();
        Tbl13 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        TblNormalisasiDua = new javax.swing.JTable();

        jInternalFrame1.setVisible(true);

        TblSinyalOutput.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane16.setViewportView(TblSinyalOutput);

        jLabel2.setText("Nilai Bias Awal");

        TblAcak.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(TblAcak);

        jLabel3.setText("bobot dari hidden layer ke output layer (wkj)");

        TblAcakOutput.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(TblAcakOutput);

        jLabel6.setText("inialisasi bias dari hidden layer ke output layer");

        jLabel7.setText("nilai input x");

        TblNormalisasi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(TblNormalisasi);

        TblBobot.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(TblBobot);

        cmdAcak.setText("Acak");
        cmdAcak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAcakActionPerformed(evt);
            }
        });

        jLabel8.setText("1");

        TblFeedforward.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane11.setViewportView(TblFeedforward);

        cmdExcel.setText("Pakai Data Excel");
        cmdExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdExcelActionPerformed(evt);
            }
        });

        jLabel4.setText("Bobot");

        jLabel9.setText("2");

        jLabel1.setText("Panjang Vector");

        TblHiddenLayer.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane12.setViewportView(TblHiddenLayer);

        TblVector.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(TblVector);

        jLabel10.setText("3");

        TblBobotBaru.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(TblBobotBaru);

        TblSinyal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane13.setViewportView(TblSinyal);

        jLabel5.setText("Bobot Baru");

        jLabel11.setText("4");

        TblBias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(TblBias);

        TblFaktorKoreksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane17.setViewportView(TblFaktorKoreksi);

        jLabel12.setText("7");

        jLabel13.setText("5");

        jLabel14.setText("8");

        jLabel15.setText("nilai input x");

        TblKoderksiError.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane19.setViewportView(TblKoderksiError);

        TblTermFrekuensi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane20.setViewportView(TblTermFrekuensi);

        jLabel17.setText("nilai koreksi error bobot");

        TblFaktorError.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane24.setViewportView(TblFaktorError);

        TblDeltaHidden.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane25.setViewportView(TblDeltaHidden);

        TblNw10.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane26.setViewportView(TblNw10);

        jLabel16.setText("6");

        TblSegitigaw10.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane18.setViewportView(TblSegitigaw10);

        jLabel18.setText("9");

        TblSegitigaw11.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane21.setViewportView(TblSegitigaw11);

        jLabel19.setText("13");

        TblW10.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane27.setViewportView(TblW10);

        Tbl9NilaiBiasAwal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane28.setViewportView(Tbl9NilaiBiasAwal);

        Tbl13.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane22.setViewportView(Tbl13);

        jLabel20.setText("11");

        jLabel21.setText("12");

        jLabel22.setText("10");

        TblNormalisasiDua.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane14.setViewportView(TblNormalisasiDua);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(152, 152, 152)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(167, 167, 167)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(167, 167, 167)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(42, 42, 42))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(51, 51, 51))
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(127, 127, 127)))
                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(156, 156, 156)
                                    .addComponent(jLabel1))
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cmdAcak)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdExcel)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(266, 266, 266)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(80, 80, 80)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(417, 417, 417)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(249, 249, 249)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(386, 386, 386)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 3684, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 3684, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(12, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2004, 2004, 2004)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel20)
                                .addGap(634, 634, 634)
                                .addComponent(jLabel21)
                                .addGap(2092, 2092, 2092)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1741, 1741, 1741))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel8))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(145, 145, 145))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(151, 151, 151))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(145, 145, 145)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 512, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdAcak)
                    .addComponent(cmdExcel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 12808, Short.MAX_VALUE)
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdExcelActionPerformed
        try {
            truncateBobot();
            truncateNilaiBiasAwal();
            truncateAcak();
            truncateAcakOutput();
            truncateHiddenLayer();

            String sqlInsertBobot = "INSERT INTO `tb_bobot` (`i`, `j1`, `j2`, `j3`, `j4`, `j5`, `j6`) VALUES\n"
                    + "(1, 0.438438, 0.314413, 0.339549, 0.394739, -0.146223, 0.255688),\n"
                    + "(2, 0.123975, 0.0561696, 0.155181, 0.119594, 0.132971, 0.423236),\n"
                    + "(3, 0.263088, 0.098059, -0.0667108, 0.111957, 0.164236, 0.183657),\n"
                    + "(4, -0.0909224, 0.35887, -0.3173, 0.0521931, 0.0206424, 0.189115),\n"
                    + "(5, -0.27313, -0.233615, 0.0638504, -0.312051, -0.352161, -0.0594913),\n"
                    + "(6, 0.420169, 0.26228, -0.254946, 0.357454, 0.253905, 0.00446632);";
            //System.out.println(sqlInsertBobot);
            Statement statementInsertBobot = (Statement) jdbc.getConnection().createStatement();
            statementInsertBobot.executeUpdate(sqlInsertBobot);

            String sqlInsertNilaiBias = "INSERT INTO `tb_nilai_bias_awal` (`i`, `j1`, `j2`, `j3`, `j4`, `j5`, `j6`) VALUES\n"
                    + "(1, -0.0797596, 0.00347801, 0.668622, -0.256869, -0.258446, -0.576929);";
            //System.out.println(sqlInsertBobot);
            Statement statementInsertNilaiBias = (Statement) jdbc.getConnection().createStatement();
            statementInsertNilaiBias.executeUpdate(sqlInsertNilaiBias);

            String sqlInsertAcak = "INSERT INTO `tb_acak` (`wkj`, `k`) VALUES\n"
                    + "(1, 0.248233),\n"
                    + "(2, -0.135561),\n"
                    + "(3, -0.31332),\n"
                    + "(4, -0.244401),\n"
                    + "(5, -0.301978),\n"
                    + "(6, 0.326706);\n"
                    + ";";
            Statement statementInsertAcak = (Statement) jdbc.getConnection().createStatement();
            statementInsertAcak.executeUpdate(sqlInsertAcak);

            String sqlInsertAcakOutput = "INSERT INTO `tb_acak_Output` (`wk0`, `k`) VALUES\n"
                    + "(1, 0.451);\n"
                    + ";";
            Statement statementInsertAcakOutput = (Statement) jdbc.getConnection().createStatement();
            statementInsertAcakOutput.executeUpdate(sqlInsertAcakOutput);

        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            bobotTableShow();
            panjangVectorShow();
            biasShow();
            acakShow();
            outputShow();
            feedForward();
            hiddenLayerShow();
            sinyalOperation();
            sinyalShow();
            sinyalOutputShow();

        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdExcelActionPerformed

    private void cmdAcakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAcakActionPerformed
        try {
            truncateBobot();
            truncateNilaiBiasAwal();
            truncateAcak();
            truncateAcakOutput();
            truncateHiddenLayer();

            float randomSatu, randomDua, randomTiga, randomEmpat, randomLima, randomEnam;
            int jumlah;
            jumlah = 6;
            for (int i = 1; i <= jumlah; i++) {
                randomSatu = (float) (Math.random() * (-0.5 - 0.5) + 0.5);
                randomDua = (float) (Math.random() * (-0.5 - 0.5) + 0.5);
                randomTiga = (float) (Math.random() * (-0.5 - 0.5) + 0.5);
                randomEmpat = (float) (Math.random() * (-0.5 - 0.5) + 0.5);
                randomLima = (float) (Math.random() * (-0.5 - 0.5) + 0.5);
                randomEnam = (float) (Math.random() * (-0.5 - 0.5) + 0.5);
                String sqlInsertBobotAcak = "INSERT INTO `tb_bobot` (`i`, `j1`, `j2`, `j3`, `j4`, `j5`, `j6`) VALUES("
                        + "NULL,"
                        + "'" + randomSatu + "',"
                        + "'" + randomDua + "',"
                        + "'" + randomTiga + "',"
                        + "'" + randomEmpat + "',"
                        + "'" + randomLima + "',"
                        + "'" + randomEnam + "')";
                Statement statementInsertBobotAcak = (Statement) jdbc.getConnection().createStatement();
                statementInsertBobotAcak.executeUpdate(sqlInsertBobotAcak);

            }

            for (int i = 1; i <= jumlah; i++) {
                randomSatu = (float) (Math.random() * (-0.5 - 0.5) + 0.5);
                String sqlInsertAcak = "INSERT INTO `tb_acak` (`wkj`, `k`) VALUES("
                        + "NULL,"
                        + "'" + randomSatu + "')";
                Statement statementInsertAcak = (Statement) jdbc.getConnection().createStatement();
                statementInsertAcak.executeUpdate(sqlInsertAcak);

            }

            randomSatu = (float) (Math.random() * (-0.5 - 0.5) + 0.5);
            String sqlInsertAcakOutput = "INSERT INTO `tb_acak_output` (`wk0`, `k`) VALUES("
                    + "NULL,"
                    + "'" + randomSatu + "')";
            Statement statementInsertAcakOutput = (Statement) jdbc.getConnection().createStatement();
            statementInsertAcakOutput.executeUpdate(sqlInsertAcakOutput);

            float randomSatuBias, randomDuaBias, randomTigaBias, randomEmpatBias, randomLimaBias, randomEnamBias;
            float pangkat, bil1, bil2;
            bil1 = 1;
            bil2 = 6;
            pangkat = bil1 / bil2;
            float faktorSkala = (float) Math.pow((Math.abs(6)), pangkat);
            float faktorSkalaDua = (float) (0.7 * faktorSkala);

            randomSatuBias = (float) (Math.random() * (-faktorSkalaDua - faktorSkalaDua) + faktorSkalaDua);
            randomDuaBias = (float) (Math.random() * (-faktorSkalaDua - faktorSkalaDua) + faktorSkalaDua);
            randomTigaBias = (float) (Math.random() * (-faktorSkalaDua - faktorSkalaDua) + faktorSkalaDua);
            randomEmpatBias = (float) (Math.random() * (-faktorSkalaDua - faktorSkalaDua) + faktorSkalaDua);
            randomLimaBias = (float) (Math.random() * (-faktorSkalaDua - faktorSkalaDua) + faktorSkalaDua);
            randomEnamBias = (float) (Math.random() * (-faktorSkalaDua - faktorSkalaDua) + faktorSkalaDua);

            String sqlInsertNilaiBias = "INSERT INTO `tb_nilai_bias_awal` (`i`, `j1`, `j2`, `j3`, `j4`, `j5`, `j6`) VALUES\n"
                    + "(1, "
                    + "'" + randomSatuBias + "',"
                    + "'" + randomDuaBias + "',"
                    + "'" + randomTigaBias + "',"
                    + "'" + randomEmpatBias + "',"
                    + "'" + randomLimaBias + "',"
                    + "'" + randomEnamBias + "')";
            //System.out.println(sqlInsertBobot);
            Statement statementInsertNilaiBias = (Statement) jdbc.getConnection().createStatement();
            statementInsertNilaiBias.executeUpdate(sqlInsertNilaiBias);

            try {
                bobotTableShow();
                panjangVectorShow();
                biasShow();
                acakShow();
                outputShow();
                feedForward();
                //FeedForwardShow();
                hiddenLayerShow();
                sinyalOperation();
                sinyalShow();
                sinyalOutputShow();
            } catch (SQLException ex) {
                Logger.getLogger(AcakBobot.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmdAcakActionPerformed

    private void bobotTableConfig() {
        tblBobot = new DefaultTableModel();
        TblBobot.setModel(tblBobot);
        tblBobot.addColumn("i");
        tblBobot.addColumn("j1");
        tblBobot.addColumn("j2");
        tblBobot.addColumn("j3");
        tblBobot.addColumn("j4");
        tblBobot.addColumn("j5");
        tblBobot.addColumn("j6");

    }

    private void bobotTableBaruConfig() {
        tblBobotBaru = new DefaultTableModel();
        TblBobotBaru.setModel(tblBobotBaru);
        tblBobotBaru.addColumn("i");
        tblBobotBaru.addColumn("j1");
        tblBobotBaru.addColumn("j2");
        tblBobotBaru.addColumn("j3");
        tblBobotBaru.addColumn("j4");
        tblBobotBaru.addColumn("j5");
        tblBobotBaru.addColumn("j6");

    }

    private void bobotTableShow() throws SQLException {
        tblBobot.getDataVector().removeAllElements();
        tblBobot.fireTableDataChanged();

        String sqlSelectBobotTable = "SELECT * FROM tb_bobot";
        Statement statementSelectBobotTable = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetSelectBobotTable = statementSelectBobotTable.executeQuery(sqlSelectBobotTable);

        while (resultSetSelectBobotTable.next()) {
            Object[] objectSelectBobotTable = new Object[7];
            objectSelectBobotTable[0] = resultSetSelectBobotTable.getString("i");
            objectSelectBobotTable[1] = resultSetSelectBobotTable.getString("j1");
            objectSelectBobotTable[2] = resultSetSelectBobotTable.getString("j2");
            objectSelectBobotTable[3] = resultSetSelectBobotTable.getString("j3");
            objectSelectBobotTable[4] = resultSetSelectBobotTable.getString("j4");
            objectSelectBobotTable[5] = resultSetSelectBobotTable.getString("j5");
            objectSelectBobotTable[6] = resultSetSelectBobotTable.getString("j6");

            tblBobot.addRow(objectSelectBobotTable);
        }
    }

    private void truncateBobot() {
        try {
            String sqlTruncateBobot = "TRUNCATE tb_bobot";
            Statement statementTruncateBobot = (Statement) jdbc.getConnection().createStatement();
            statementTruncateBobot.executeUpdate(sqlTruncateBobot);
        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tbl13;
    private javax.swing.JTable Tbl9NilaiBiasAwal;
    private javax.swing.JTable TblAcak;
    private javax.swing.JTable TblAcakOutput;
    private javax.swing.JTable TblBias;
    private javax.swing.JTable TblBobot;
    private javax.swing.JTable TblBobotBaru;
    private javax.swing.JTable TblDeltaHidden;
    private javax.swing.JTable TblFaktorError;
    private javax.swing.JTable TblFaktorKoreksi;
    private javax.swing.JTable TblFeedforward;
    private javax.swing.JTable TblHiddenLayer;
    private javax.swing.JTable TblKoderksiError;
    private javax.swing.JTable TblNormalisasi;
    private javax.swing.JTable TblNormalisasiDua;
    private javax.swing.JTable TblNw10;
    private javax.swing.JTable TblSegitigaw10;
    private javax.swing.JTable TblSegitigaw11;
    private javax.swing.JTable TblSinyal;
    private javax.swing.JTable TblSinyalOutput;
    private javax.swing.JTable TblTermFrekuensi;
    private javax.swing.JTable TblVector;
    private javax.swing.JTable TblW10;
    private javax.swing.JButton cmdAcak;
    private javax.swing.JButton cmdExcel;
    private javax.swing.JInternalFrame jInternalFrame1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables

    private void panjangVectorShow() throws SQLException {
        try {
            String sqlTruncateBobot = "TRUNCATE tb_16";
            Statement statementTruncateBobot = (Statement) jdbc.getConnection().createStatement();
            statementTruncateBobot.executeUpdate(sqlTruncateBobot);
        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class.getName()).log(Level.SEVERE, null, ex);
        }

        tblVector.getDataVector().removeAllElements();
        tblVector.fireTableDataChanged();

        tblBobotBaru.getDataVector().removeAllElements();
        tblBobotBaru.fireTableDataChanged();

        String sqlPanjangVector = "SELECT * FROM tb_bobot";
        Statement statementPanjangVector = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetPanjangVector = statementPanjangVector.executeQuery(sqlPanjangVector);

        float j1, j2, j3, j4, j5, j6;
        float jumlahJ1 = 0, jumlahJ2 = 0, jumlahJ3 = 0, jumlahJ4 = 0, jumlahJ5 = 0, jumlahJ6 = 0;

        while (resultSetPanjangVector.next()) {
            j1 = Float.parseFloat(resultSetPanjangVector.getString("j1"));
            j2 = Float.parseFloat(resultSetPanjangVector.getString("j2"));
            j3 = Float.parseFloat(resultSetPanjangVector.getString("j3"));
            j4 = Float.parseFloat(resultSetPanjangVector.getString("j4"));
            j5 = Float.parseFloat(resultSetPanjangVector.getString("j5"));
            j6 = Float.parseFloat(resultSetPanjangVector.getString("j6"));

            jumlahJ1 = (float) (jumlahJ1 + Math.pow(j1, 2));
            jumlahJ2 = (float) (jumlahJ2 + Math.pow(j2, 2));
            jumlahJ3 = (float) (jumlahJ3 + Math.pow(j3, 2));
            jumlahJ4 = (float) (jumlahJ4 + Math.pow(j4, 2));
            jumlahJ5 = (float) (jumlahJ5 + Math.pow(j5, 2));
            jumlahJ6 = (float) (jumlahJ6 + Math.pow(j6, 2));

        }

        double hasilJ1 = Math.sqrt(jumlahJ1);
        double hasilJ2 = Math.sqrt(jumlahJ2);
        double hasilJ3 = Math.sqrt(jumlahJ3);
        double hasilJ4 = Math.sqrt(jumlahJ4);
        double hasilJ5 = Math.sqrt(jumlahJ5);
        double hasilJ6 = Math.sqrt(jumlahJ6);

        float pangkat, bil1, bil2;
        bil1 = 1;
        bil2 = 6;
        pangkat = bil1 / bil2;
        float faktorSkala = (float) Math.pow((Math.abs(6)), pangkat);
        float faktorSkalaDua = (float) (0.7 * faktorSkala);

        int i = 1;

        String sqlBobotBaru = "SELECT * FROM tb_bobot";
        Statement statementBobotBaru = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetBobotBaru = statementBobotBaru.executeQuery(sqlBobotBaru);

        while (resultSetBobotBaru.next()) {
            i = Integer.parseInt(resultSetBobotBaru.getString("i"));
            j1 = (float) ((faktorSkalaDua * Float.parseFloat(resultSetBobotBaru.getString("j1")) / hasilJ1));
            j2 = (float) ((faktorSkalaDua * Float.parseFloat(resultSetBobotBaru.getString("j2")) / hasilJ2));
            j3 = (float) ((faktorSkalaDua * Float.parseFloat(resultSetBobotBaru.getString("j3")) / hasilJ3));
            j4 = (float) ((faktorSkalaDua * Float.parseFloat(resultSetBobotBaru.getString("j4")) / hasilJ4));
            j5 = (float) ((faktorSkalaDua * Float.parseFloat(resultSetBobotBaru.getString("j5")) / hasilJ5));
            j6 = (float) ((faktorSkalaDua * Float.parseFloat(resultSetBobotBaru.getString("j6")) / hasilJ6));

            //disini
            String sqlInsertFeedForward = "INSERT INTO `tb_16` (`data_ke`, `z_net1`, `z_net2`, `z_net3`, `z_net4`, `z_net5`, `z_net6`) VALUES\n"
                    + "(null,"
                    + "'" + j1 + "',"
                    + "'" + j2 + "',"
                    + "'" + j3 + "',"
                    + "'" + j4 + "',"
                    + "'" + j5 + "',"
                    + "'" + j6 + "')";
            //System.out.println(sqlInsertFeedForward);
            Statement statementInsertFeedForward = (Statement) jdbc.getConnection().createStatement();
            statementInsertFeedForward.executeUpdate(sqlInsertFeedForward);

            //System.out.println(j1);
            Object[] objectHasilBobot = new Object[7];
            objectHasilBobot[0] = i;
            objectHasilBobot[1] = j1;
            objectHasilBobot[2] = j2;
            objectHasilBobot[3] = j3;
            objectHasilBobot[4] = j4;
            objectHasilBobot[5] = j5;
            objectHasilBobot[6] = j6;

            tblBobotBaru.addRow(objectHasilBobot);
        }

        Object[] objectHasil = new Object[7];
        objectHasil[0] = hasilJ1;
        objectHasil[1] = hasilJ2;
        objectHasil[2] = hasilJ3;
        objectHasil[3] = hasilJ4;
        objectHasil[4] = hasilJ5;
        objectHasil[5] = hasilJ6;

        tblVector.addRow(objectHasil);
    }

    private void vectorTableConfig() {
        tblVector = new DefaultTableModel();
        TblVector.setModel(tblVector);
        tblVector.addColumn("j1");
        tblVector.addColumn("j2");
        tblVector.addColumn("j3");
        tblVector.addColumn("j4");
        tblVector.addColumn("j5");
        tblVector.addColumn("j6");
    }

    private void biasTableConfig() {
        tblBias = new DefaultTableModel();
        TblBias.setModel(tblBias);
        tblBias.addColumn("j1");
        tblBias.addColumn("j2");
        tblBias.addColumn("j3");
        tblBias.addColumn("j4");
        tblBias.addColumn("j5");
        tblBias.addColumn("j6");
    }

    private void biasShow() throws SQLException {
        tblBias.getDataVector().removeAllElements();
        tblBias.fireTableDataChanged();

        String sqlSelectBiasTable = "SELECT * FROM tb_nilai_bias_awal";
        Statement statementSelectBiasTable = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetSelectBiasTable = statementSelectBiasTable.executeQuery(sqlSelectBiasTable);

        while (resultSetSelectBiasTable.next()) {
            Object[] objectSelectBiasTable = new Object[6];
            objectSelectBiasTable[0] = resultSetSelectBiasTable.getString("j1");
            objectSelectBiasTable[1] = resultSetSelectBiasTable.getString("j2");
            objectSelectBiasTable[2] = resultSetSelectBiasTable.getString("j3");
            objectSelectBiasTable[3] = resultSetSelectBiasTable.getString("j4");
            objectSelectBiasTable[4] = resultSetSelectBiasTable.getString("j5");
            objectSelectBiasTable[5] = resultSetSelectBiasTable.getString("j6");

            tblBias.addRow(objectSelectBiasTable);
        }
    }

    private void truncateNilaiBiasAwal() {
        try {
            String sqlTruncateBiasAwal = "TRUNCATE tb_nilai_bias_awal";
            Statement statementTruncateBiasAwal = (Statement) jdbc.getConnection().createStatement();
            statementTruncateBiasAwal.executeUpdate(sqlTruncateBiasAwal);
        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void truncateAcak() {
        try {
            String sqlTruncateAcak = "TRUNCATE tb_acak";
            Statement statementTruncateAcak = (Statement) jdbc.getConnection().createStatement();
            statementTruncateAcak.executeUpdate(sqlTruncateAcak);
        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void truncateAcakOutput() {
        try {
            String sqlTruncateAcak = "TRUNCATE tb_acak_output";
            Statement statementTruncateAcak = (Statement) jdbc.getConnection().createStatement();
            statementTruncateAcak.executeUpdate(sqlTruncateAcak);
        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void acakTableConfig() {
        tblAcak = new DefaultTableModel();
        TblAcak.setModel(tblAcak);
        tblAcak.addColumn("wkj");
        tblAcak.addColumn("k");

    }

    private void acakShow() throws SQLException {
        tblAcak.getDataVector().removeAllElements();
        tblAcak.fireTableDataChanged();

        String sqlSelectAcakTable = "SELECT * FROM tb_acak";
        Statement statementSelectAcakTable = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetSelectAcakTable = statementSelectAcakTable.executeQuery(sqlSelectAcakTable);

        while (resultSetSelectAcakTable.next()) {
            Object[] objectSelectAcakTable = new Object[2];
            objectSelectAcakTable[0] = resultSetSelectAcakTable.getString("wkj");
            objectSelectAcakTable[1] = resultSetSelectAcakTable.getString("k");

            tblAcak.addRow(objectSelectAcakTable);
        }
    }

    private void acakOutputConfig() {
        tblAcakOutput = new DefaultTableModel();
        TblAcakOutput.setModel(tblAcakOutput);
        tblAcakOutput.addColumn("wkj");
        tblAcakOutput.addColumn("k");
    }

    private void outputShow() throws SQLException {
        tblAcakOutput.getDataVector().removeAllElements();
        tblAcakOutput.fireTableDataChanged();

        String sqlSelectAcakOutputTable = "SELECT * FROM tb_acak_output";
        Statement statementSelectAcakOutputTable = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetSelectAcakOutputTable = statementSelectAcakOutputTable.executeQuery(sqlSelectAcakOutputTable);

        while (resultSetSelectAcakOutputTable.next()) {
            Object[] objectSelectAcakOutputTable = new Object[2];
            objectSelectAcakOutputTable[0] = resultSetSelectAcakOutputTable.getString("wk0");
            objectSelectAcakOutputTable[1] = resultSetSelectAcakOutputTable.getString("k");

            tblAcakOutput.addRow(objectSelectAcakOutputTable);
        }
    }

    private void acakOutputShow() {
        tblNormalisasi = new DefaultTableModel();
        TblNormalisasi.setModel(tblNormalisasi);
        tblNormalisasi.addColumn("Id");
        tblNormalisasi.addColumn("kalimat yang di eksekusi");
        tblNormalisasi.addColumn("kb+ (x1)");
        tblNormalisasi.addColumn("kk+ (x2)");
        tblNormalisasi.addColumn("ks+ (x3)");
        tblNormalisasi.addColumn("kb- (x4)");
        tblNormalisasi.addColumn("kk- (x5)");
        tblNormalisasi.addColumn("ks- (x6)");
    }

    private void NormalisasiShow() throws SQLException {
        //normalisasi
        String sqlSelectAllNormalisasiHasil = "SELECT * FROM tb_normalisasi, tb_filtering WHERE tb_normalisasi.id = tb_filtering.id_filtering ";
        Statement stNormalisasiHasil = (Statement) jdbc.getConnection().createStatement();
        ResultSet rsNormalisasiHasil = stNormalisasiHasil.executeQuery(sqlSelectAllNormalisasiHasil);

        while (rsNormalisasiHasil.next()) {
            Object[] oNormalisasiHasil = new Object[9];
            oNormalisasiHasil[0] = rsNormalisasiHasil.getString("id");
            oNormalisasiHasil[1] = rsNormalisasiHasil.getString("deskripsi_filtering");
            oNormalisasiHasil[2] = rsNormalisasiHasil.getString("kbplus");
            oNormalisasiHasil[3] = rsNormalisasiHasil.getString("kkplus");
            oNormalisasiHasil[4] = rsNormalisasiHasil.getString("ksplus");
            oNormalisasiHasil[5] = rsNormalisasiHasil.getString("kbmin");
            oNormalisasiHasil[6] = rsNormalisasiHasil.getString("kkmin");
            oNormalisasiHasil[7] = rsNormalisasiHasil.getString("ksmin");
            oNormalisasiHasil[8] = rsNormalisasiHasil.getString("kelas_dokumen");

            tblNormalisasi.addRow(oNormalisasiHasil);
        }
    }

    private void FeedForwardConfig() {
        tblFeedforward = new DefaultTableModel();
        TblFeedforward.setModel(tblFeedforward);
        tblFeedforward.addColumn("data_ke");
        tblFeedforward.addColumn("z_net1");
        tblFeedforward.addColumn("z_net2");
        tblFeedforward.addColumn("z_net3");
        tblFeedforward.addColumn("z_net4");
        tblFeedforward.addColumn("z_net5");
        tblFeedforward.addColumn("z_net6");
        tblFeedforward.addColumn("iterasi-ke");
    }

    private void hiddenLayerConfig() {
        tblHiddenLayer = new DefaultTableModel();
        TblHiddenLayer.setModel(tblHiddenLayer);
        tblHiddenLayer.addColumn("data_ke");
        tblHiddenLayer.addColumn("z1");
        tblHiddenLayer.addColumn("z2");
        tblHiddenLayer.addColumn("z3");
        tblHiddenLayer.addColumn("z4");
        tblHiddenLayer.addColumn("z5");
        tblHiddenLayer.addColumn("z6");
        tblHiddenLayer.addColumn("iterasi-ke");
    }

    private void FeedForwardShow() throws SQLException {
        tblFeedforward.getDataVector().removeAllElements();
        tblFeedforward.fireTableDataChanged();

        String sqlSelectAllNormalisasiHasil = "SELECT * FROM tb_feedforward ";
        Statement stNormalisasiHasil = (Statement) jdbc.getConnection().createStatement();
        ResultSet rsNormalisasiHasil = stNormalisasiHasil.executeQuery(sqlSelectAllNormalisasiHasil);

        //NumberFormat formatter = new DecimalFormat("##.##");
        while (rsNormalisasiHasil.next()) {
            Object[] oNormalisasiHasil = new Object[8];

            //System.out.println(Double.valueOf(formatter.format(rsNormalisasiHasil.getDouble("z_net1")).toString()));
            oNormalisasiHasil[0] = rsNormalisasiHasil.getString("data_ke");
            oNormalisasiHasil[1] = rsNormalisasiHasil.getString("z_net1");
            oNormalisasiHasil[2] = rsNormalisasiHasil.getString("z_net2");
            oNormalisasiHasil[3] = rsNormalisasiHasil.getString("z_net3");
            oNormalisasiHasil[4] = rsNormalisasiHasil.getString("z_net4");
            oNormalisasiHasil[5] = rsNormalisasiHasil.getString("z_net5");
            oNormalisasiHasil[6] = rsNormalisasiHasil.getString("z_net6");
            tblFeedforward.addRow(oNormalisasiHasil);
        }
    }

    private void hiddenLayerShow() throws SQLException {
        tblHiddenLayer.getDataVector().removeAllElements();
        tblHiddenLayer.fireTableDataChanged();

        String sqlSelectAllNormalisasiHasil = "SELECT * FROM tb_hidden_layer";
        Statement stNormalisasiHasil = (Statement) jdbc.getConnection().createStatement();
        ResultSet rsNormalisasiHasil = stNormalisasiHasil.executeQuery(sqlSelectAllNormalisasiHasil);

        while (rsNormalisasiHasil.next()) {
            Object[] oNormalisasiHasil = new Object[8];
            oNormalisasiHasil[0] = rsNormalisasiHasil.getString("dokumen_ke");
            oNormalisasiHasil[1] = rsNormalisasiHasil.getString("z_net1");
            oNormalisasiHasil[2] = rsNormalisasiHasil.getString("z_net2");
            oNormalisasiHasil[3] = rsNormalisasiHasil.getString("z_net3");
            oNormalisasiHasil[4] = rsNormalisasiHasil.getString("z_net4");
            oNormalisasiHasil[5] = rsNormalisasiHasil.getString("z_net5");
            oNormalisasiHasil[6] = rsNormalisasiHasil.getString("z_net6");
            oNormalisasiHasil[7] = rsNormalisasiHasil.getString("iterasi");

            tblHiddenLayer.addRow(oNormalisasiHasil);
        }
    }

    private void feedForward() throws SQLException {
        String TruncateFeedForward = "TRUNCATE tb_feedforward";
        Statement statementTruncateFeedForward = (Statement) jdbc.getConnection().createStatement();
        statementTruncateFeedForward.executeUpdate(TruncateFeedForward);

        try {
            String sqlTruncateAcak = "TRUNCATE tb_hidden_layer";
            Statement statementTruncateAcak = (Statement) jdbc.getConnection().createStatement();
            statementTruncateAcak.executeUpdate(sqlTruncateAcak);
        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Integer> inputDokumen = new ArrayList<Integer>();
        List<Double> inputSatu = new ArrayList<Double>();
        List<Double> inputDua = new ArrayList<Double>();
        List<Double> inputTiga = new ArrayList<Double>();
        List<Double> inputEmpat = new ArrayList<Double>();
        List<Double> inputLima = new ArrayList<Double>();
        List<Double> inputEnam = new ArrayList<Double>();

        List<Double> bobotBaruSatu = new ArrayList<Double>();
        List<Double> bobotBaruDua = new ArrayList<Double>();
        List<Double> bobotBaruTiga = new ArrayList<Double>();
        List<Double> bobotBaruEmpat = new ArrayList<Double>();
        List<Double> bobotBaruLima = new ArrayList<Double>();
        List<Double> bobotBaruEnam = new ArrayList<Double>();

        String sqlSelectBiasTable = "SELECT * FROM tb_nilai_bias_awal";
        Statement statementSelectBiasTable = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetSelectBiasTable = statementSelectBiasTable.executeQuery(sqlSelectBiasTable);
        while (resultSetSelectBiasTable.next()) {
            Object[] objectSelectBiasTable = new Object[6];
            objectSelectBiasTable[0] = resultSetSelectBiasTable.getString("j1");
            objectSelectBiasTable[1] = resultSetSelectBiasTable.getString("j2");
            objectSelectBiasTable[2] = resultSetSelectBiasTable.getString("j3");
            objectSelectBiasTable[3] = resultSetSelectBiasTable.getString("j4");
            objectSelectBiasTable[4] = resultSetSelectBiasTable.getString("j5");
            objectSelectBiasTable[5] = resultSetSelectBiasTable.getString("j6");

            String sqlSelectAllNormalisasiHasil = "SELECT * FROM tb_normalisasi, tb_filtering WHERE tb_normalisasi.id = tb_filtering.id_filtering ";
            Statement stNormalisasiHasil = (Statement) jdbc.getConnection().createStatement();
            ResultSet rsNormalisasiHasil = stNormalisasiHasil.executeQuery(sqlSelectAllNormalisasiHasil);

            String sqlPanjangVector = "SELECT * FROM tb_bobot";
            Statement statementPanjangVector = (Statement) jdbc.getConnection().createStatement();
            ResultSet resultSetPanjangVector = statementPanjangVector.executeQuery(sqlPanjangVector);

            float j1, j2, j3, j4, j5, j6;
            float jumlahJ1 = 0, jumlahJ2 = 0, jumlahJ3 = 0, jumlahJ4 = 0, jumlahJ5 = 0, jumlahJ6 = 0;

            while (resultSetPanjangVector.next()) {
                j1 = Float.parseFloat(resultSetPanjangVector.getString("j1"));
                j2 = Float.parseFloat(resultSetPanjangVector.getString("j2"));
                j3 = Float.parseFloat(resultSetPanjangVector.getString("j3"));
                j4 = Float.parseFloat(resultSetPanjangVector.getString("j4"));
                j5 = Float.parseFloat(resultSetPanjangVector.getString("j5"));
                j6 = Float.parseFloat(resultSetPanjangVector.getString("j6"));

                jumlahJ1 = (float) (jumlahJ1 + Math.pow(j1, 2));
                jumlahJ2 = (float) (jumlahJ2 + Math.pow(j2, 2));
                jumlahJ3 = (float) (jumlahJ3 + Math.pow(j3, 2));
                jumlahJ4 = (float) (jumlahJ4 + Math.pow(j4, 2));
                jumlahJ5 = (float) (jumlahJ5 + Math.pow(j5, 2));
                jumlahJ6 = (float) (jumlahJ6 + Math.pow(j6, 2));

            }

            double hasilJ1 = Math.sqrt(jumlahJ1);
            double hasilJ2 = Math.sqrt(jumlahJ2);
            double hasilJ3 = Math.sqrt(jumlahJ3);
            double hasilJ4 = Math.sqrt(jumlahJ4);
            double hasilJ5 = Math.sqrt(jumlahJ5);
            double hasilJ6 = Math.sqrt(jumlahJ6);

            float pangkat, bil1, bil2;
            bil1 = 1;
            bil2 = 6;
            pangkat = bil1 / bil2;
            float faktorSkala = (float) Math.pow((Math.abs(6)), pangkat);
            float faktorSkalaDua = (float) (0.7 * faktorSkala);

            int i = 1;

            String sqlBobotBaru = "SELECT * FROM tb_bobot";
            Statement statementBobotBaru = (Statement) jdbc.getConnection().createStatement();
            ResultSet resultSetBobotBaru = statementBobotBaru.executeQuery(sqlBobotBaru);

            while (resultSetBobotBaru.next()) {
                i = Integer.parseInt(resultSetBobotBaru.getString("i"));
                j1 = (float) ((faktorSkalaDua * Float.parseFloat(resultSetBobotBaru.getString("j1")) / hasilJ1));
                j2 = (float) ((faktorSkalaDua * Float.parseFloat(resultSetBobotBaru.getString("j2")) / hasilJ2));
                j3 = (float) ((faktorSkalaDua * Float.parseFloat(resultSetBobotBaru.getString("j3")) / hasilJ3));
                j4 = (float) ((faktorSkalaDua * Float.parseFloat(resultSetBobotBaru.getString("j4")) / hasilJ4));
                j5 = (float) ((faktorSkalaDua * Float.parseFloat(resultSetBobotBaru.getString("j5")) / hasilJ5));
                j6 = (float) ((faktorSkalaDua * Float.parseFloat(resultSetBobotBaru.getString("j6")) / hasilJ6));

                //System.out.println(j1);
                Object[] objectHasilBobot = new Object[7];

                objectHasilBobot[0] = i;
                objectHasilBobot[1] = j1;
                objectHasilBobot[2] = j2;
                objectHasilBobot[3] = j3;
                objectHasilBobot[4] = j4;
                objectHasilBobot[5] = j5;
                objectHasilBobot[6] = j6;

                bobotBaruSatu.add(Double.parseDouble(objectHasilBobot[1].toString()));
                bobotBaruDua.add(Double.parseDouble(objectHasilBobot[2].toString()));
                bobotBaruTiga.add(Double.parseDouble(objectHasilBobot[3].toString()));
                bobotBaruEmpat.add(Double.parseDouble(objectHasilBobot[4].toString()));
                bobotBaruLima.add(Double.parseDouble(objectHasilBobot[5].toString()));
                bobotBaruEnam.add(Double.parseDouble(objectHasilBobot[6].toString()));

            }

            while (rsNormalisasiHasil.next()) {
                Object[] oNormalisasiHasil = new Object[8];
                oNormalisasiHasil[0] = rsNormalisasiHasil.getString("id");
                oNormalisasiHasil[1] = rsNormalisasiHasil.getString("deskripsi_filtering");
                oNormalisasiHasil[2] = rsNormalisasiHasil.getString("kbplus");
                oNormalisasiHasil[3] = rsNormalisasiHasil.getString("kkplus");
                oNormalisasiHasil[4] = rsNormalisasiHasil.getString("ksplus");
                oNormalisasiHasil[5] = rsNormalisasiHasil.getString("kbmin");
                oNormalisasiHasil[6] = rsNormalisasiHasil.getString("kkmin");
                oNormalisasiHasil[7] = rsNormalisasiHasil.getString("ksmin");

                inputDokumen.add(Integer.parseInt(oNormalisasiHasil[0].toString()));
                inputSatu.add(Double.parseDouble(oNormalisasiHasil[2].toString()));
                inputDua.add(Double.parseDouble(oNormalisasiHasil[3].toString()));
                inputTiga.add(Double.parseDouble(oNormalisasiHasil[4].toString()));
                inputEmpat.add(Double.parseDouble(oNormalisasiHasil[5].toString()));
                inputLima.add(Double.parseDouble(oNormalisasiHasil[6].toString()));
                inputEnam.add(Double.parseDouble(oNormalisasiHasil[7].toString()));

            }

            double feedForwardSatu, feedForwardDua, feedForwardTiga, feedForwardEmpat, feedForwardLima, feedForwardEnam;
            double hiddenLayerSatu, hiddenLayerDua, hiddenLayerTiga, hiddenLayerEmpat, hiddenLayerLima, hiddenLayerEnam;

            int max;

            for (int iterasi = 1; iterasi <= this.iterMaxx; iterasi++) {
                for (max = 0; max <= 5; max++) {
                    feedForwardSatu = (Double.parseDouble(objectSelectBiasTable[0].toString()))
                            + ((Double.parseDouble(inputSatu.get(max).toString())) * (Double.parseDouble(bobotBaruSatu.get(0).toString())))
                            + ((Double.parseDouble(inputDua.get(max).toString())) * (Double.parseDouble(bobotBaruSatu.get(1).toString())))
                            + ((Double.parseDouble(inputTiga.get(max).toString())) * (Double.parseDouble(bobotBaruSatu.get(2).toString())))
                            + ((Double.parseDouble(inputEmpat.get(max).toString())) * (Double.parseDouble(bobotBaruSatu.get(3).toString())))
                            + ((Double.parseDouble(inputLima.get(max).toString())) * (Double.parseDouble(bobotBaruSatu.get(4).toString())))
                            + ((Double.parseDouble(inputEnam.get(max).toString())) * (Double.parseDouble(bobotBaruSatu.get(5).toString())));
                    System.out.println(feedForwardSatu);
                    hiddenLayerSatu = 1 / (1 + Math.exp(-feedForwardSatu));

                    feedForwardDua = (Double.parseDouble(objectSelectBiasTable[1].toString()))
                            + ((Double.parseDouble(inputSatu.get(max).toString())) * (Double.parseDouble(bobotBaruDua.get(0).toString())))
                            + ((Double.parseDouble(inputDua.get(max).toString())) * (Double.parseDouble(bobotBaruDua.get(1).toString())))
                            + ((Double.parseDouble(inputTiga.get(max).toString())) * (Double.parseDouble(bobotBaruDua.get(2).toString())))
                            + ((Double.parseDouble(inputEmpat.get(max).toString())) * (Double.parseDouble(bobotBaruDua.get(3).toString())))
                            + ((Double.parseDouble(inputLima.get(max).toString())) * (Double.parseDouble(bobotBaruDua.get(4).toString())))
                            + ((Double.parseDouble(inputEnam.get(max).toString())) * (Double.parseDouble(bobotBaruDua.get(5).toString())));
                    System.out.println(feedForwardDua);
                    hiddenLayerDua = 1 / (1 + Math.exp(-feedForwardDua));

                    feedForwardTiga = (Double.parseDouble(objectSelectBiasTable[2].toString()))
                            + ((Double.parseDouble(inputSatu.get(max).toString())) * (Double.parseDouble(bobotBaruTiga.get(0).toString())))
                            + ((Double.parseDouble(inputDua.get(max).toString())) * (Double.parseDouble(bobotBaruTiga.get(1).toString())))
                            + ((Double.parseDouble(inputTiga.get(max).toString())) * (Double.parseDouble(bobotBaruTiga.get(2).toString())))
                            + ((Double.parseDouble(inputEmpat.get(max).toString())) * (Double.parseDouble(bobotBaruTiga.get(3).toString())))
                            + ((Double.parseDouble(inputLima.get(max).toString())) * (Double.parseDouble(bobotBaruTiga.get(4).toString())))
                            + ((Double.parseDouble(inputEnam.get(max).toString())) * (Double.parseDouble(bobotBaruTiga.get(5).toString())));
                    System.out.println(feedForwardTiga);
                    hiddenLayerTiga = 1 / (1 + Math.exp(-feedForwardTiga));

                    feedForwardEmpat = (Double.parseDouble(objectSelectBiasTable[3].toString()))
                            + ((Double.parseDouble(inputSatu.get(max).toString())) * (Double.parseDouble(bobotBaruEmpat.get(0).toString())))
                            + ((Double.parseDouble(inputDua.get(max).toString())) * (Double.parseDouble(bobotBaruEmpat.get(1).toString())))
                            + ((Double.parseDouble(inputTiga.get(max).toString())) * (Double.parseDouble(bobotBaruEmpat.get(2).toString())))
                            + ((Double.parseDouble(inputEmpat.get(max).toString())) * (Double.parseDouble(bobotBaruEmpat.get(3).toString())))
                            + ((Double.parseDouble(inputLima.get(max).toString())) * (Double.parseDouble(bobotBaruEmpat.get(4).toString())))
                            + ((Double.parseDouble(inputEnam.get(max).toString())) * (Double.parseDouble(bobotBaruEmpat.get(5).toString())));
                    System.out.println(feedForwardEmpat);
                    hiddenLayerEmpat = 1 / (1 + Math.exp(-feedForwardEmpat));

                    feedForwardLima = (Double.parseDouble(objectSelectBiasTable[4].toString()))
                            + ((Double.parseDouble(inputSatu.get(max).toString())) * (Double.parseDouble(bobotBaruLima.get(0).toString())))
                            + ((Double.parseDouble(inputDua.get(max).toString())) * (Double.parseDouble(bobotBaruLima.get(1).toString())))
                            + ((Double.parseDouble(inputTiga.get(max).toString())) * (Double.parseDouble(bobotBaruLima.get(2).toString())))
                            + ((Double.parseDouble(inputEmpat.get(max).toString())) * (Double.parseDouble(bobotBaruLima.get(3).toString())))
                            + ((Double.parseDouble(inputLima.get(max).toString())) * (Double.parseDouble(bobotBaruLima.get(4).toString())))
                            + ((Double.parseDouble(inputEnam.get(max).toString())) * (Double.parseDouble(bobotBaruLima.get(5).toString())));
                    System.out.println(feedForwardLima);
                    hiddenLayerLima = 1 / (1 + Math.exp(-feedForwardLima));

                    feedForwardEnam = (Double.parseDouble(objectSelectBiasTable[5].toString()))
                            + ((Double.parseDouble(inputSatu.get(max).toString())) * (Double.parseDouble(bobotBaruEnam.get(0).toString())))
                            + ((Double.parseDouble(inputDua.get(max).toString())) * (Double.parseDouble(bobotBaruEnam.get(1).toString())))
                            + ((Double.parseDouble(inputTiga.get(max).toString())) * (Double.parseDouble(bobotBaruEnam.get(2).toString())))
                            + ((Double.parseDouble(inputEmpat.get(max).toString())) * (Double.parseDouble(bobotBaruEnam.get(3).toString())))
                            + ((Double.parseDouble(inputLima.get(max).toString())) * (Double.parseDouble(bobotBaruEnam.get(4).toString())))
                            + ((Double.parseDouble(inputEnam.get(max).toString())) * (Double.parseDouble(bobotBaruEnam.get(5).toString())));
                    System.out.println(feedForwardEnam);
                    hiddenLayerEnam = 1 / (1 + Math.exp(-feedForwardEnam));

                    String sqlInsertFeedForward = "INSERT INTO `tb_feedforward` (`data_ke`, `z_net1`, `z_net2`, `z_net3`, `z_net4`, `z_net5`, `z_net6`, `dokumen_ke`, `iterasi_ke`) VALUES\n"
                            + "(null,"
                            + "'" + feedForwardSatu + "',"
                            + "'" + feedForwardDua + "',"
                            + "'" + feedForwardTiga + "',"
                            + "'" + feedForwardEmpat + "',"
                            + "'" + feedForwardLima + "',"
                            + "'" + feedForwardEnam + "',"
                            + "" + Integer.parseInt(inputDokumen.get(max).toString()) + ","
                            + "" + iterasi + ")";
                    //System.out.println(sqlInsertFeedForward);
                    Statement statementInsertFeedForward = (Statement) jdbc.getConnection().createStatement();
                    statementInsertFeedForward.executeUpdate(sqlInsertFeedForward);

                    String sqlInsertHiddenLayer = "INSERT INTO `tb_hidden_layer` (`data_ke`, `z_net1`, `z_net2`, `z_net3`, `z_net4`, `z_net5`, `z_net6`, `dokumen_ke`, iterasi) VALUES\n"
                            + "(null,"
                            + "'" + hiddenLayerSatu + "',"
                            + "'" + hiddenLayerDua + "',"
                            + "'" + hiddenLayerTiga + "',"
                            + "'" + hiddenLayerEmpat + "',"
                            + "'" + hiddenLayerLima + "',"
                            + "'" + hiddenLayerEnam + "',"
                            + "" + Integer.parseInt(inputDokumen.get(max).toString()) + ","
                            + "" + iterasi + ")";
                    //System.out.println(sqlInsertFeedForward);
                    Statement statementInsertHiddenLayer = (Statement) jdbc.getConnection().createStatement();
                    statementInsertHiddenLayer.executeUpdate(sqlInsertHiddenLayer);

                }
            }

        }

    }

    private void truncateHiddenLayer() {
        try {
            String sqlTruncateAcak = "TRUNCATE tb_hidden_layer";
            Statement statementTruncateAcak = (Statement) jdbc.getConnection().createStatement();
            statementTruncateAcak.executeUpdate(sqlTruncateAcak);
        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sinyalOperation() throws SQLException {
        double sinyal, sinyalDua, acak = 0;

        List<Integer> hiddenDokumen = new ArrayList<Integer>();
        List<Double> hiddenSatu = new ArrayList<Double>();
        List<Double> hiddenDua = new ArrayList<Double>();
        List<Double> hiddenTiga = new ArrayList<Double>();
        List<Double> hiddenEmpat = new ArrayList<Double>();
        List<Double> hiddenLima = new ArrayList<Double>();
        List<Double> hiddenEnam = new ArrayList<Double>();

        List<Double> acakSatu = new ArrayList<Double>();

        String sqlTruncateSinyal = "TRUNCATE tb_sinyal";
        Statement statementTruncateSinyal = (Statement) jdbc.getConnection().createStatement();
        statementTruncateSinyal.executeUpdate(sqlTruncateSinyal);

        String sqlTruncateSinyalAktivasi = "TRUNCATE tb_sinyal_aktivasi";
        Statement statementTruncateSinyalAktivasi = (Statement) jdbc.getConnection().createStatement();
        statementTruncateSinyalAktivasi.executeUpdate(sqlTruncateSinyalAktivasi);

        for (int iterasi = 1; iterasi <= iterMaxx; iterasi++) {

            String sqlSelectAllNormalisasiHasil = "SELECT * FROM tb_hidden_layer";
            Statement stNormalisasiHasil = (Statement) jdbc.getConnection().createStatement();
            ResultSet rsNormalisasiHasil = stNormalisasiHasil.executeQuery(sqlSelectAllNormalisasiHasil);
            while (rsNormalisasiHasil.next()) {
                Object[] oNormalisasiHasil = new Object[8];
                oNormalisasiHasil[0] = rsNormalisasiHasil.getString("data_ke");
                oNormalisasiHasil[1] = rsNormalisasiHasil.getString("z_net1");
                oNormalisasiHasil[2] = rsNormalisasiHasil.getString("z_net2");
                oNormalisasiHasil[3] = rsNormalisasiHasil.getString("z_net3");
                oNormalisasiHasil[4] = rsNormalisasiHasil.getString("z_net4");
                oNormalisasiHasil[5] = rsNormalisasiHasil.getString("z_net5");
                oNormalisasiHasil[6] = rsNormalisasiHasil.getString("z_net6");

                hiddenDokumen.add(Integer.parseInt(oNormalisasiHasil[0].toString()));
                hiddenSatu.add(Double.parseDouble(oNormalisasiHasil[1].toString()));
                hiddenDua.add(Double.parseDouble(oNormalisasiHasil[2].toString()));
                hiddenTiga.add(Double.parseDouble(oNormalisasiHasil[3].toString()));
                hiddenEmpat.add(Double.parseDouble(oNormalisasiHasil[4].toString()));
                hiddenLima.add(Double.parseDouble(oNormalisasiHasil[5].toString()));
                hiddenEnam.add(Double.parseDouble(oNormalisasiHasil[6].toString()));

                //System.out.println(oNormalisasiHasil[1]);
            }

            String sqlSelectAcakTable = "SELECT * FROM tb_acak";
            Statement statementSelectAcakTable = (Statement) jdbc.getConnection().createStatement();
            ResultSet resultSetSelectAcakTable = statementSelectAcakTable.executeQuery(sqlSelectAcakTable);
            while (resultSetSelectAcakTable.next()) {
                Object[] objectSelectAcakTable = new Object[2];
                objectSelectAcakTable[0] = resultSetSelectAcakTable.getString("wkj");
                objectSelectAcakTable[1] = resultSetSelectAcakTable.getString("k");

                acakSatu.add(Double.parseDouble(objectSelectAcakTable[1].toString()));

                //System.out.println(objectSelectAcakTable[1]);
            }

            String sqlSelectAcakOutputTable = "SELECT * FROM tb_acak_output";
            Statement statementSelectAcakOutputTable = (Statement) jdbc.getConnection().createStatement();
            ResultSet resultSetSelectAcakOutputTable = statementSelectAcakOutputTable.executeQuery(sqlSelectAcakOutputTable);
            while (resultSetSelectAcakOutputTable.next()) {
                Object[] objectSelectAcakOutputTable = new Object[2];
                objectSelectAcakOutputTable[0] = resultSetSelectAcakOutputTable.getString("wk0");
                objectSelectAcakOutputTable[1] = resultSetSelectAcakOutputTable.getString("k");

                acak = Double.parseDouble(objectSelectAcakOutputTable[1].toString());
            }

            int max;
            for (max = 0; max <= 5; max++) {

                sinyal = acak
                        + ((Double.parseDouble(hiddenSatu.get(max).toString())) *
                        (Double.parseDouble(acakSatu.get(0).toString())))
                        + ((Double.parseDouble(hiddenDua.get(max).toString())) *
                        (Double.parseDouble(acakSatu.get(1).toString())))
                        + ((Double.parseDouble(hiddenTiga.get(max).toString())) * 
                        (Double.parseDouble(acakSatu.get(2).toString())))
                        + ((Double.parseDouble(hiddenEmpat.get(max).toString())) *
                        (Double.parseDouble(acakSatu.get(3).toString())))
                        + ((Double.parseDouble(hiddenLima.get(max).toString())) *
                        (Double.parseDouble(acakSatu.get(4).toString())))
                        + ((Double.parseDouble(hiddenEnam.get(max).toString())) *
                        (Double.parseDouble(acakSatu.get(5).toString())));

                System.out.println(acak + " +( " + ((Double.parseDouble(hiddenSatu.get(max).toString())) + " * " + (Double.parseDouble(acakSatu.get(0).toString())) + ") "));
                System.out.println(" + (" + ((Double.parseDouble(hiddenDua.get(max).toString())) + " * " + (Double.parseDouble(acakSatu.get(1).toString())) + ") "));
                System.out.println(" + (" + ((Double.parseDouble(hiddenTiga.get(max).toString())) + " * " + (Double.parseDouble(acakSatu.get(2).toString())) + ") "));
                System.out.println(" + (" + ((Double.parseDouble(hiddenEmpat.get(max).toString())) + " * " + (Double.parseDouble(acakSatu.get(3).toString())) + ") "));
                System.out.println(" + (" + ((Double.parseDouble(hiddenLima.get(max).toString())) + " * " + (Double.parseDouble(acakSatu.get(4).toString())) + ") "));
                System.out.println(" + (" + ((Double.parseDouble(hiddenEnam.get(max).toString())) + " * " + (Double.parseDouble(acakSatu.get(5).toString())) + ") "));
                System.out.println("------------");
                System.out.println(sinyal);
                System.out.println("------------");

                sinyalDua = 1 / (1 + Math.exp(-sinyal));

                System.out.println(sinyalDua);
                System.out.println("------------");
                System.out.println(" ");

                String sqlInsertSinyal = "INSERT INTO `tb_sinyal` (`wkj`, `k`, `dokumen_ke`, `iterasi_ke`) VALUES\n"
                        + "(null,"
                        + "'" + sinyal + "',"
                        + "" + Integer.parseInt(hiddenDokumen.get(max).toString()) + ","
                        + "" + iterasi + ")";
                //System.out.println(sqlInsertFeedForward);
                Statement statementInsertSinyal = (Statement) jdbc.getConnection().createStatement();
                statementInsertSinyal.executeUpdate(sqlInsertSinyal);

                String sqlInsertSinyalAktivasi = "INSERT INTO `tb_sinyal_aktivasi` (`wkj`, `k`, `dokumen_ke`, `iterasi_ke`) VALUES\n"
                        + "(null,"
                        + "'" + sinyalDua + "',"
                        + "" + Integer.parseInt(hiddenDokumen.get(max).toString()) + ","
                        + "" + iterasi + ")";
                //System.out.println(sqlInsertFeedForward);
                Statement statementInsertSinyalAktivasi = (Statement) jdbc.getConnection().createStatement();
                statementInsertSinyalAktivasi.executeUpdate(sqlInsertSinyalAktivasi);

            }
        }
    }

    private void sinyalTableConfig() {
        tblSinyal = new DefaultTableModel();
        TblSinyal.setModel(tblSinyal);
        tblSinyal.addColumn("wkj");
        tblSinyal.addColumn("y_net1");
        tblSinyal.addColumn("iterasi_ke");
    }

    private void sinyalOutputTableConfig() {
        tblSinyalOutput = new DefaultTableModel();
        TblSinyalOutput.setModel(tblSinyalOutput);
        tblSinyalOutput.addColumn("wkj");
        tblSinyalOutput.addColumn("yk");
        tblSinyalOutput.addColumn("iterasi_ke");
    }

    private void sinyalShow() throws SQLException {
        tblSinyal.getDataVector().removeAllElements();
        tblSinyal.fireTableDataChanged();

        String sqlSelectSinyal = "SELECT * FROM tb_sinyal";
        Statement statementSelectSinyal = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetSelectSinyal = statementSelectSinyal.executeQuery(sqlSelectSinyal);

        while (resultSetSelectSinyal.next()) {
            Object[] objectSetSelectSinyal = new Object[3];
            objectSetSelectSinyal[0] = resultSetSelectSinyal.getString("dokumen_ke");
            objectSetSelectSinyal[1] = resultSetSelectSinyal.getString("k");
            objectSetSelectSinyal[2] = resultSetSelectSinyal.getString("iterasi_ke");

            tblSinyal.addRow(objectSetSelectSinyal);
        }
    }

    private void sinyalOutputShow() throws SQLException {
        tblSinyalOutput.getDataVector().removeAllElements();
        tblSinyalOutput.fireTableDataChanged();

        String sqlSelectSinyalOutput = "SELECT * FROM tb_sinyal_aktivasi";
        Statement statementSelectSinyalOutput = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetSelectSinyalOutput = statementSelectSinyalOutput.executeQuery(sqlSelectSinyalOutput);

        while (resultSetSelectSinyalOutput.next()) {
            Object[] objectSetSelectSinyalOutput = new Object[3];
            objectSetSelectSinyalOutput[0] = resultSetSelectSinyalOutput.getString("dokumen_ke");
            objectSetSelectSinyalOutput[1] = resultSetSelectSinyalOutput.getString("k");
            objectSetSelectSinyalOutput[2] = resultSetSelectSinyalOutput.getString("iterasi_ke");

            tblSinyalOutput.addRow(objectSetSelectSinyalOutput);
        }
    }

    private void feedForwardLanjut() throws SQLException {
        String sqlTruncateErrorDeltaLayera = "TRUNCATE tb_faktor_koreksi_error";
        Statement statementTruncateErrorDeltaLayera = (Statement) jdbc.getConnection().createStatement();
        statementTruncateErrorDeltaLayera.executeUpdate(sqlTruncateErrorDeltaLayera);

        String sqlTruncateErrorDeltaLayer = "TRUNCATE tb_delta_hidden_layer";
        Statement statementTruncateErrorDeltaLayer = (Statement) jdbc.getConnection().createStatement();
        statementTruncateErrorDeltaLayer.executeUpdate(sqlTruncateErrorDeltaLayer);

        String sqlTruncateErrorDelta = "TRUNCATE tb_koreksi_error_bobot";
        Statement statementTruncateErrorDelta = (Statement) jdbc.getConnection().createStatement();
        statementTruncateErrorDelta.executeUpdate(sqlTruncateErrorDelta);

        String sqlTruncateFaktorError = "TRUNCATE tb_faktor_error";
        Statement statementTruncateFaktorError = (Statement) jdbc.getConnection().createStatement();
        statementTruncateFaktorError.executeUpdate(sqlTruncateFaktorError);

        List<Double> aktifasiOutput = new ArrayList<Double>();
        List<Integer> aktifasiDokumen = new ArrayList<Integer>();

        double errorBobot, wkj0, wkj1, wkj2, wkj3, wkj4, wkj5, wkj6 = 0;
        double wkj0delta, wkj1delta, wkj2delta, wkj3delta, wkj4delta, wkj5delta;

        for (int iterasi = 1; iterasi <= iterMaxx; iterasi++) {

            String sqlSelectSinyalOutput = "SELECT * FROM tb_sinyal_aktivasi";
            Statement statementSelectSinyalOutput = (Statement) jdbc.getConnection().createStatement();
            ResultSet resultSetSelectSinyalOutput = statementSelectSinyalOutput.executeQuery(sqlSelectSinyalOutput);

            while (resultSetSelectSinyalOutput.next()) {
                Object[] objectSetSelectSinyalOutput = new Object[3];
                objectSetSelectSinyalOutput[0] = resultSetSelectSinyalOutput.getString("wkj");
                objectSetSelectSinyalOutput[1] = resultSetSelectSinyalOutput.getString("k");
                objectSetSelectSinyalOutput[2] = resultSetSelectSinyalOutput.getString("dokumen_ke");

                aktifasiOutput.add(Double.parseDouble(objectSetSelectSinyalOutput[1].toString()));
                aktifasiDokumen.add(Integer.parseInt(objectSetSelectSinyalOutput[2].toString()));

            }

            //System.out.println(((Double.parseDouble(aktifasiOutput.get(0).toString()))));
            for (int i = 0; i <= 2; i++) {
                errorBobot = (0.1 - ((Double.parseDouble(aktifasiOutput.get(i).toString()))))
                        * ((Double.parseDouble(aktifasiOutput.get(i).toString())))
                        * (1 - (((Double.parseDouble(aktifasiOutput.get(i).toString())))));
                //System.out.println(errorBobot);
                String sqlInsertSinyal = "INSERT INTO `tb_faktor_error` (`wkj`, `k`, `dokumen_ke`, `iterasi_ke`) VALUES\n"
                        + "(null,"
                        + "'" + errorBobot + "',"
                        + "" + Integer.parseInt(aktifasiDokumen.get(i).toString()) + ","
                        + "" + iterasi + ")";
                System.out.println(sqlInsertSinyal);
                Statement statementInsertSinyal = (Statement) jdbc.getConnection().createStatement();
                statementInsertSinyal.executeUpdate(sqlInsertSinyal);

            }

            for (int i = 3; i <= 5; i++) {
                errorBobot = (0.9 - ((Double.parseDouble(aktifasiOutput.get(i).toString()))))
                        * ((Double.parseDouble(aktifasiOutput.get(i).toString())))
                        * (1 - (((Double.parseDouble(aktifasiOutput.get(i).toString())))));
                //System.out.println(errorBobot);
                String sqlInsertSinyal = "INSERT INTO `tb_faktor_error` (`wkj`, `k`, `dokumen_ke`, `iterasi_ke`) VALUES\n"
                        + "(null,"
                        + "'" + errorBobot + "',"
                        + "" + Integer.parseInt(aktifasiDokumen.get(i).toString()) + ","
                        + "" + iterasi + ")";
                //System.out.println(sqlInsertFeedForward);
                Statement statementInsertSinyal = (Statement) jdbc.getConnection().createStatement();
                statementInsertSinyal.executeUpdate(sqlInsertSinyal);

            }

            String sqlSelectAllNormalisasiHasil = "SELECT * "
                    + "FROM tb_hidden_layer "
                    + "INNER JOIN tb_faktor_error "
                    + "ON tb_hidden_layer.data_ke = tb_faktor_error.wkj";
            Statement stNormalisasiHasil = (Statement) jdbc.getConnection().createStatement();
            ResultSet rsNormalisasiHasil = stNormalisasiHasil.executeQuery(sqlSelectAllNormalisasiHasil);

            while (rsNormalisasiHasil.next()) {
                Object[] objectSelectBiasTable = new Object[6];
                objectSelectBiasTable[0] = rsNormalisasiHasil.getString("k");

                Object[] oNormalisasiHasil = new Object[8];
                oNormalisasiHasil[0] = rsNormalisasiHasil.getString("data_ke");
                oNormalisasiHasil[1] = rsNormalisasiHasil.getString("z_net1");
                oNormalisasiHasil[2] = rsNormalisasiHasil.getString("z_net2");
                oNormalisasiHasil[3] = rsNormalisasiHasil.getString("z_net3");
                oNormalisasiHasil[4] = rsNormalisasiHasil.getString("z_net4");
                oNormalisasiHasil[5] = rsNormalisasiHasil.getString("z_net5");
                oNormalisasiHasil[6] = rsNormalisasiHasil.getString("z_net6");

                wkj0 = 0.2 * 1 * Double.parseDouble(objectSelectBiasTable[0].toString());
                wkj1 = 0.2 * Double.parseDouble(oNormalisasiHasil[1].toString()) * Double.parseDouble(objectSelectBiasTable[0].toString());
                wkj2 = 0.2 * Double.parseDouble(oNormalisasiHasil[2].toString()) * Double.parseDouble(objectSelectBiasTable[0].toString());
                wkj3 = 0.2 * Double.parseDouble(oNormalisasiHasil[3].toString()) * Double.parseDouble(objectSelectBiasTable[0].toString());
                wkj4 = 0.2 * Double.parseDouble(oNormalisasiHasil[4].toString()) * Double.parseDouble(objectSelectBiasTable[0].toString());
                wkj5 = 0.2 * Double.parseDouble(oNormalisasiHasil[5].toString()) * Double.parseDouble(objectSelectBiasTable[0].toString());
                wkj6 = 0.2 * Double.parseDouble(oNormalisasiHasil[6].toString()) * Double.parseDouble(objectSelectBiasTable[0].toString());

                //System.out.println(wkj0 + " " + wkj1 + " " + wkj2 + " " + wkj3 + " " + wkj4 + " " + wkj5 + " " + wkj6);
                String sqlInsertFeedForward = "INSERT INTO `tb_koreksi_error_bobot` VALUES\n"
                        + "(null,"
                        + "'" + wkj0 + "',"
                        + "'" + wkj1 + "',"
                        + "'" + wkj2 + "',"
                        + "'" + wkj3 + "',"
                        + "'" + wkj4 + "',"
                        + "'" + wkj5 + "',"
                        + "'" + wkj6 + "')";
                //System.out.println(sqlInsertFeedForward);
                Statement statementInsertFeedForward = (Statement) jdbc.getConnection().createStatement();
                statementInsertFeedForward.executeUpdate(sqlInsertFeedForward);

            }

            List<Double> acak = new ArrayList<Double>();
            List<Integer> no_dokumen = new ArrayList<Integer>();

            String sqlSelectAcakTable = "SELECT * FROM tb_acak";
            Statement statementSelectAcakTable = (Statement) jdbc.getConnection().createStatement();
            ResultSet resultSetSelectAcakTable = statementSelectAcakTable.executeQuery(sqlSelectAcakTable);

            while (resultSetSelectAcakTable.next()) {
                Object[] objectSelectAcakTable = new Object[2];
                objectSelectAcakTable[0] = resultSetSelectAcakTable.getString("wkj");
                objectSelectAcakTable[1] = resultSetSelectAcakTable.getString("k");

                acak.add(Double.parseDouble(objectSelectAcakTable[1].toString()));
                no_dokumen.add(Integer.parseInt(objectSelectAcakTable[0].toString()));
            }

            double deltaSatu, deltaDua, deltaTiga, deltaEmpat, deltaLima, deltaEnam;

            String sqlSelectAllFaktor = "SELECT * FROM tb_faktor_error "
                    + "INNER JOIN tb_hidden_layer "
                    + "ON tb_faktor_error.wkj = tb_hidden_layer.data_ke";

            Statement stFaktor = (Statement) jdbc.getConnection().createStatement();
            ResultSet rsFaktor = stFaktor.executeQuery(sqlSelectAllFaktor);

            while (rsFaktor.next()) {
                Object[] objectSelectBiasTable = new Object[2];
                objectSelectBiasTable[0] = rsFaktor.getString("k");
                objectSelectBiasTable[1] = rsFaktor.getString("dokumen_ke");

                deltaSatu = Double.parseDouble(objectSelectBiasTable[0].toString()) * (Double.parseDouble(acak.get(0).toString()));
                deltaDua = Double.parseDouble(objectSelectBiasTable[0].toString()) * (Double.parseDouble(acak.get(1).toString()));
                deltaTiga = Double.parseDouble(objectSelectBiasTable[0].toString()) * (Double.parseDouble(acak.get(2).toString()));
                deltaEmpat = Double.parseDouble(objectSelectBiasTable[0].toString()) * (Double.parseDouble(acak.get(3).toString()));
                deltaLima = Double.parseDouble(objectSelectBiasTable[0].toString()) * (Double.parseDouble(acak.get(4).toString()));
                deltaEnam = Double.parseDouble(objectSelectBiasTable[0].toString()) * (Double.parseDouble(acak.get(5).toString()));

                //System.out.println(deltaSatu + " " + deltaDua + " " + deltaTiga + " " + deltaEmpat + " " + deltaLima + " " + deltaEnam);
                String sqlInsertFeedForward = "INSERT INTO `tb_delta_hidden_layer` VALUES\n"
                        + "(null,"
                        + "'" + deltaSatu + "',"
                        + "'" + deltaDua + "',"
                        + "'" + deltaTiga + "',"
                        + "'" + deltaEmpat + "',"
                        + "'" + deltaLima + "',"
                        + "'" + deltaEnam + "',"
                        + "" + Integer.parseInt(objectSelectBiasTable[1].toString()) + ","
                        + "" + iterasi + ")";

                //System.out.println(sqlInsertFeedForward);
                Statement statementInsertFeedForward = (Statement) jdbc.getConnection().createStatement();
                statementInsertFeedForward.executeUpdate(sqlInsertFeedForward);

                Object[] oNormalisasiHasila = new Object[8];
                oNormalisasiHasila[0] = rsFaktor.getString("data_ke");
                oNormalisasiHasila[1] = rsFaktor.getString("z_net1");
                oNormalisasiHasila[2] = rsFaktor.getString("z_net2");
                oNormalisasiHasila[3] = rsFaktor.getString("z_net3");
                oNormalisasiHasila[4] = rsFaktor.getString("z_net4");
                oNormalisasiHasila[5] = rsFaktor.getString("z_net5");
                oNormalisasiHasila[6] = rsFaktor.getString("z_net6");

                //System.out.println(Double.parseDouble(oNormalisasiHasila[0].toString()) + " " + Double.parseDouble(oNormalisasiHasila[1].toString()) + " " + Double.parseDouble(oNormalisasiHasila[2].toString()) + " " + Double.parseDouble(oNormalisasiHasila[3].toString()) + " " + Double.parseDouble(oNormalisasiHasila[4].toString()) + " " + Double.parseDouble(oNormalisasiHasila[5].toString()));
                wkj0delta = Double.parseDouble(oNormalisasiHasila[1].toString()) * deltaSatu * (1 - Double.parseDouble(oNormalisasiHasila[1].toString()));
                wkj1delta = Double.parseDouble(oNormalisasiHasila[2].toString()) * deltaDua * (1 - Double.parseDouble(oNormalisasiHasila[2].toString()));
                wkj2delta = Double.parseDouble(oNormalisasiHasila[3].toString()) * deltaTiga * (1 - Double.parseDouble(oNormalisasiHasila[3].toString()));
                wkj3delta = Double.parseDouble(oNormalisasiHasila[4].toString()) * deltaEmpat * (1 - Double.parseDouble(oNormalisasiHasila[4].toString()));
                wkj4delta = Double.parseDouble(oNormalisasiHasila[5].toString()) * deltaLima * (1 - Double.parseDouble(oNormalisasiHasila[5].toString()));
                wkj5delta = Double.parseDouble(oNormalisasiHasila[6].toString()) * deltaEnam * (1 - Double.parseDouble(oNormalisasiHasila[6].toString()));

                //System.out.println(wkj0 + " " + wkj1 + " " + wkj2 + " " + wkj3 + " " + wkj4 + " " + wkj5 + " " + wkj6);
                String sqlInsertFeedForwarda = "INSERT INTO `tb_faktor_koreksi_error` VALUES\n"
                        + "(null,"
                        + "'" + wkj0delta + "',"
                        + "'" + wkj1delta + "',"
                        + "'" + wkj2delta + "',"
                        + "'" + wkj3delta + "',"
                        + "'" + wkj4delta + "',"
                        + "'" + wkj5delta + "',"
                        + "" + Integer.parseInt(objectSelectBiasTable[1].toString()) + ","
                        + "" + iterasi + ")";

                //System.out.println(sqlInsertFeedForward);
                Statement statementInsertFeedForwarda = (Statement) jdbc.getConnection().createStatement();
                statementInsertFeedForwarda.executeUpdate(sqlInsertFeedForwarda);

                //normalisasi
                String sqlSelectAllTermNormalisasiHasil = "SELECT * FROM tb_normalisasi, tb_filtering WHERE tb_normalisasi.id = tb_filtering.id_filtering ";
                Statement stTermNormalisasiHasil = (Statement) jdbc.getConnection().createStatement();
                ResultSet rsTermNormalisasiHasil = stTermNormalisasiHasil.executeQuery(sqlSelectAllTermNormalisasiHasil);

                while (rsTermNormalisasiHasil.next()) {
                    Object[] oNormalisasiHasil = new Object[8];
                    oNormalisasiHasil[0] = rsTermNormalisasiHasil.getString("id");
                    oNormalisasiHasil[1] = rsTermNormalisasiHasil.getString("deskripsi_filtering");
                    oNormalisasiHasil[2] = rsTermNormalisasiHasil.getString("kbplus");
                    oNormalisasiHasil[3] = rsTermNormalisasiHasil.getString("kkplus");
                    oNormalisasiHasil[4] = rsTermNormalisasiHasil.getString("ksplus");
                    oNormalisasiHasil[5] = rsTermNormalisasiHasil.getString("kbmin");
                    oNormalisasiHasil[6] = rsTermNormalisasiHasil.getString("kkmin");
                    oNormalisasiHasil[7] = rsTermNormalisasiHasil.getString("ksmin");

                    double koreksiErrorSatu = 0.2 * Double.parseDouble(oNormalisasiHasil[2].toString()) * wkj0delta;
                    double koreksiErrorDua = 0.2 * Double.parseDouble(oNormalisasiHasil[3].toString()) * wkj0delta;
                    double koreksiErrorTiga = 0.2 * Double.parseDouble(oNormalisasiHasil[4].toString()) * wkj0delta;
                    double koreksiErrorEmpat = 0.2 * Double.parseDouble(oNormalisasiHasil[5].toString()) * wkj0delta;
                    double koreksiErrorLima = 0.2 * Double.parseDouble(oNormalisasiHasil[6].toString()) * wkj0delta;
                    double koreksiErrorEnam = 0.2 * Double.parseDouble(oNormalisasiHasil[7].toString()) * wkj0delta;

                    System.out.println(koreksiErrorSatu + " " + koreksiErrorDua + " " + koreksiErrorTiga + " " + koreksiErrorEmpat + " " + koreksiErrorLima + " " + koreksiErrorEnam);
                }
            }
//            aktivasiOutputJaringan();
            faktorKoreksiErrorBobot();
            faktorKoreksiErrorBobot();
            nilaiKoreksiErrorBobot();
            hiddenLayer();
            deltaBobotHiddenLayer();
            faktorKoreksiErrorBobotVjj();
            termFrekuensi();
        }
    }

//    private void aktivasiOutputJaringan() throws SQLException {
//        tblSinyal.getDataVector().removeAllElements();
//        tblSinyal.fireTableDataChanged();
//
//        String sqlSelectSinyalOutput = "SELECT * FROM tb_sinyal_aktivasi";
//        Statement statementSelectSinyalOutput = (Statement) jdbc.getConnection().createStatement();
//        ResultSet resultSetSelectSinyalOutput = statementSelectSinyalOutput.executeQuery(sqlSelectSinyalOutput);
//
//        while (resultSetSelectSinyalOutput.next()) {
//            Object[] objectSetSelectSinyalOutput = new Object[2];
//            objectSetSelectSinyalOutput[0] = resultSetSelectSinyalOutput.getString("wkj");
//            objectSetSelectSinyalOutput[1] = resultSetSelectSinyalOutput.getString("k");
//f
//            tblSinyal.addRow(objectSetSelectSinyalOutput);
//        }
//    }
    private void faktorKoreksiErrorBobot() throws SQLException {
        tblFaktorError.getDataVector().removeAllElements();
        tblFaktorError.fireTableDataChanged();

        String sqlSelectAllNormalisasiHasil = "SELECT * "
                + "FROM  tb_faktor_error ";
        Statement stNormalisasiHasil = (Statement) jdbc.getConnection().createStatement();
        ResultSet rsNormalisasiHasil = stNormalisasiHasil.executeQuery(sqlSelectAllNormalisasiHasil);

        while (rsNormalisasiHasil.next()) {
            Object[] objectSelectBiasTable = new Object[3];
            objectSelectBiasTable[0] = rsNormalisasiHasil.getString("dokumen_ke");
            objectSelectBiasTable[1] = rsNormalisasiHasil.getString("k");
            objectSelectBiasTable[2] = rsNormalisasiHasil.getString("iterasi_ke");

            tblFaktorError.addRow(objectSelectBiasTable);

        }
    }

    private void nilaiKoreksiErrorBobot() throws SQLException {
        tblKoreksiError.getDataVector().removeAllElements();
        tblKoreksiError.fireTableDataChanged();

        String sqlSelectAllNormalisasiHasil = "SELECT * "
                + "FROM tb_koreksi_error_bobot ";
        Statement stNormalisasiHasil = (Statement) jdbc.getConnection().createStatement();
        ResultSet rsNormalisasiHasil = stNormalisasiHasil.executeQuery(sqlSelectAllNormalisasiHasil);

        while (rsNormalisasiHasil.next()) {

            Object[] oNormalisasiHasil = new Object[8];
            oNormalisasiHasil[0] = rsNormalisasiHasil.getString("data_ke");
            oNormalisasiHasil[1] = rsNormalisasiHasil.getString("delta_wkj_satu");
            oNormalisasiHasil[2] = rsNormalisasiHasil.getString("delta_wkj_dua");
            oNormalisasiHasil[3] = rsNormalisasiHasil.getString("delta_wkj_tiga");
            oNormalisasiHasil[4] = rsNormalisasiHasil.getString("delta_wkj_empat");
            oNormalisasiHasil[5] = rsNormalisasiHasil.getString("delta_wkj_lima");
            oNormalisasiHasil[6] = rsNormalisasiHasil.getString("delta_wkj_enam");

            tblKoreksiError.addRow(oNormalisasiHasil);
        }
    }

    private void hiddenLayer() throws SQLException {
        tblAcak.getDataVector().removeAllElements();
        tblAcak.fireTableDataChanged();

        String sqlSelectAcakTable = "SELECT * FROM tb_acak";
        Statement statementSelectAcakTable = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetSelectAcakTable = statementSelectAcakTable.executeQuery(sqlSelectAcakTable);

        while (resultSetSelectAcakTable.next()) {
            Object[] objectSelectAcakTable = new Object[2];
            objectSelectAcakTable[0] = resultSetSelectAcakTable.getString("wkj");
            objectSelectAcakTable[1] = resultSetSelectAcakTable.getString("k");

            tblAcak.addRow(objectSelectAcakTable);
        }
    }

    private void deltaBobotHiddenLayer() throws SQLException {
        tblDeltaHidden.getDataVector().removeAllElements();
        tblDeltaHidden.fireTableDataChanged();

        String sqlSelectAllNormalisasiHasil = "SELECT * "
                + "FROM tb_delta_hidden_layer ";
        Statement stNormalisasiHasil = (Statement) jdbc.getConnection().createStatement();
        ResultSet rsNormalisasiHasil = stNormalisasiHasil.executeQuery(sqlSelectAllNormalisasiHasil);

        while (rsNormalisasiHasil.next()) {

            Object[] oNormalisasiHasil = new Object[8];
            oNormalisasiHasil[0] = rsNormalisasiHasil.getString("dokumen_ke");
            oNormalisasiHasil[1] = rsNormalisasiHasil.getString("z_net1");
            oNormalisasiHasil[2] = rsNormalisasiHasil.getString("z_net2");
            oNormalisasiHasil[3] = rsNormalisasiHasil.getString("z_net3");
            oNormalisasiHasil[4] = rsNormalisasiHasil.getString("z_net4");
            oNormalisasiHasil[5] = rsNormalisasiHasil.getString("z_net5");
            oNormalisasiHasil[6] = rsNormalisasiHasil.getString("z_net6");
            oNormalisasiHasil[7] = rsNormalisasiHasil.getString("iterasi_ke");

            tblDeltaHidden.addRow(oNormalisasiHasil);
        }
    }

    private void faktorKoreksiErrorBobotVjj() throws SQLException {
        tblFaktorKoreksi.getDataVector().removeAllElements();
        tblFaktorKoreksi.fireTableDataChanged();

        String sqlSelectAllNormalisasiHasil = "SELECT * "
                + "FROM tb_faktor_koreksi_error ";
        Statement stNormalisasiHasil = (Statement) jdbc.getConnection().createStatement();
        ResultSet rsNormalisasiHasil = stNormalisasiHasil.executeQuery(sqlSelectAllNormalisasiHasil);

        while (rsNormalisasiHasil.next()) {

            Object[] oNormalisasiHasil = new Object[8];
            oNormalisasiHasil[0] = rsNormalisasiHasil.getString("dokumen_ke");
            oNormalisasiHasil[1] = rsNormalisasiHasil.getString("z_net1");
            oNormalisasiHasil[2] = rsNormalisasiHasil.getString("z_net2");
            oNormalisasiHasil[3] = rsNormalisasiHasil.getString("z_net3");
            oNormalisasiHasil[4] = rsNormalisasiHasil.getString("z_net4");
            oNormalisasiHasil[5] = rsNormalisasiHasil.getString("z_net5");
            oNormalisasiHasil[6] = rsNormalisasiHasil.getString("z_net6");
            oNormalisasiHasil[7] = rsNormalisasiHasil.getString("iterasi_ke");

            tblFaktorKoreksi.addRow(oNormalisasiHasil);
        }
    }

    private void termFrekuensi() throws SQLException {
        tblTermFrekuensi.getDataVector().removeAllElements();
        tblTermFrekuensi.fireTableDataChanged();

        //normalisasi
        String sqlSelectAllTermNormalisasiHasil = "SELECT * FROM tb_normalisasi, tb_filtering WHERE tb_normalisasi.id = tb_filtering.id_filtering ";
        Statement stTermNormalisasiHasil = (Statement) jdbc.getConnection().createStatement();
        ResultSet rsTermNormalisasiHasil = stTermNormalisasiHasil.executeQuery(sqlSelectAllTermNormalisasiHasil);

        while (rsTermNormalisasiHasil.next()) {
            Object[] oNormalisasiHasil = new Object[8];
            oNormalisasiHasil[0] = rsTermNormalisasiHasil.getString("id");
            oNormalisasiHasil[1] = rsTermNormalisasiHasil.getString("deskripsi_filtering");
            oNormalisasiHasil[2] = rsTermNormalisasiHasil.getString("kbplus");
            oNormalisasiHasil[3] = rsTermNormalisasiHasil.getString("kkplus");
            oNormalisasiHasil[4] = rsTermNormalisasiHasil.getString("ksplus");
            oNormalisasiHasil[5] = rsTermNormalisasiHasil.getString("kbmin");
            oNormalisasiHasil[6] = rsTermNormalisasiHasil.getString("kkmin");
            oNormalisasiHasil[7] = rsTermNormalisasiHasil.getString("ksmin");
            tblTermFrekuensi.addRow(oNormalisasiHasil);
        }
    }

//    private void aktivasiTabelSinyal() {
//        tblSinyal = new DefaultTableModel();
//        TblSinyal.setModel(tblSinyal);
//        tblSinyal.addColumn("data ke");
//        tblSinyal.addColumn("yk");
//    }
    private void aktivasiFaktorErro() {
        tblFaktorError = new DefaultTableModel();
        TblFaktorError.setModel(tblFaktorError);
        tblFaktorError.addColumn("data ke");
        tblFaktorError.addColumn("δk");
        tblFaktorError.addColumn("iterasi ke");
    }

    private void aktivasiKoreksiError() {
        tblKoreksiError = new DefaultTableModel();
        TblKoderksiError.setModel(tblKoreksiError);
        tblKoreksiError.addColumn("data_ke");
        tblKoreksiError.addColumn("z_net1");
        tblKoreksiError.addColumn("z_net2");
        tblKoreksiError.addColumn("z_net3");
        tblKoreksiError.addColumn("z_net4");
        tblKoreksiError.addColumn("z_net5");
        tblKoreksiError.addColumn("z_net6");
        tblKoreksiError.addColumn("iterasi ke");
    }

    private void aktivasiAcak() {
        tblAcak = new DefaultTableModel();
        TblAcak.setModel(tblAcak);
        tblAcak.addColumn("data ke");
        tblAcak.addColumn("yk");
        tblAcak.addColumn("iterasi ke");

    }

    private void aktivasiDeltaHidden() {
        tblDeltaHidden = new DefaultTableModel();
        TblDeltaHidden.setModel(tblDeltaHidden);
        tblDeltaHidden.addColumn("data_ke");
        tblDeltaHidden.addColumn("δ_net1");
        tblDeltaHidden.addColumn("δ_net2");
        tblDeltaHidden.addColumn("δ_net3");
        tblDeltaHidden.addColumn("δ_net4");
        tblDeltaHidden.addColumn("δ_net5");
        tblDeltaHidden.addColumn("δ_net6");
        tblDeltaHidden.addColumn("iterasi ke");

    }

    private void aktivasiFaktorKoreksi() {
        tblFaktorKoreksi = new DefaultTableModel();
        TblFaktorKoreksi.setModel(tblFaktorKoreksi);
        tblFaktorKoreksi.addColumn("data_ke");
        tblFaktorKoreksi.addColumn("δ1");
        tblFaktorKoreksi.addColumn("δ2");
        tblFaktorKoreksi.addColumn("δ3");
        tblFaktorKoreksi.addColumn("δ4");
        tblFaktorKoreksi.addColumn("δ5");
        tblFaktorKoreksi.addColumn("δ6");
        tblFaktorKoreksi.addColumn("iterasi ke");
    }

    private void aktivasiTermFrekuensi() {
        tblTermFrekuensi = new DefaultTableModel();
        TblTermFrekuensi.setModel(tblTermFrekuensi);
        tblTermFrekuensi.addColumn("Id");
        tblTermFrekuensi.addColumn("kalimat yang di eksekusi");
        tblTermFrekuensi.addColumn("kb+ (x1)");
        tblTermFrekuensi.addColumn("kk+ (x2)");
        tblTermFrekuensi.addColumn("ks+ (x3)");
        tblTermFrekuensi.addColumn("kb- (x4)");
        tblTermFrekuensi.addColumn("kk- (x5)");
        tblTermFrekuensi.addColumn("ks- (x6)");
        tblTermFrekuensi.addColumn("iterasi ke");

    }

    private void aktivasiNw10() {
        tblNw10 = new DefaultTableModel();
        TblNw10.setModel(tblNw10);
        tblNw10.addColumn("data_ke");
        tblNw10.addColumn("ΔW10");
        tblNw10.addColumn("ΔW11");
        tblNw10.addColumn("ΔW12");
        tblNw10.addColumn("ΔW13");
        tblNw10.addColumn("ΔW14");
        tblNw10.addColumn("ΔW15");
        tblNw10.addColumn("ΔW16");
        tblNw10.addColumn("iterasi ke");

    }

    private void aktivasiTableW() {
        tblW10 = new DefaultTableModel();
        TblW10.setModel(tblW10);
        tblW10.addColumn("data_ke");
        tblW10.addColumn("W10");
        tblW10.addColumn("W11");
        tblW10.addColumn("W12");
        tblW10.addColumn("W13");
        tblW10.addColumn("W14");
        tblW10.addColumn("W15");
        tblW10.addColumn("W16");
        tblW10.addColumn("iterasi ke");

    }

    private void hitungNw10() throws SQLException {
        try {
            String sqlTruncateBobot = "TRUNCATE tb_sigma_w";
            Statement statementTruncateBobot = (Statement) jdbc.getConnection().createStatement();
            statementTruncateBobot.executeUpdate(sqlTruncateBobot);
        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            String sqlTruncateBobotd = "TRUNCATE tb_segitiga_v";
            Statement statementTruncateBobotd = (Statement) jdbc.getConnection().createStatement();
            statementTruncateBobotd.executeUpdate(sqlTruncateBobotd);
        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class.getName()).log(Level.SEVERE, null, ex);
        }

        tblNw10.getDataVector().removeAllElements();
        tblNw10.fireTableDataChanged();

        String sqlSelectAllNormalisasiHasilDua;
//disini mencari learning rate

        sqlSelectAllNormalisasiHasilDua = "SELECT * FROM tb_hidden_layer, tb_faktor_error WHERE tb_hidden_layer.data_ke = tb_faktor_error.wkj";
        Statement stNormalisasiHasilDua = (Statement) jdbc.getConnection().createStatement();
        ResultSet rsNormalisasiHasilDua = stNormalisasiHasilDua.executeQuery(sqlSelectAllNormalisasiHasilDua);

        while (rsNormalisasiHasilDua.next()) {
            Object[] oNormalisasiHasilDua = new Object[9];
            oNormalisasiHasilDua[0] = rsNormalisasiHasilDua.getString("data_ke");
            oNormalisasiHasilDua[1] = rsNormalisasiHasilDua.getString("z_net1");
            oNormalisasiHasilDua[2] = rsNormalisasiHasilDua.getString("z_net2");
            oNormalisasiHasilDua[3] = rsNormalisasiHasilDua.getString("z_net3");
            oNormalisasiHasilDua[4] = rsNormalisasiHasilDua.getString("z_net4");
            oNormalisasiHasilDua[5] = rsNormalisasiHasilDua.getString("z_net5");
            oNormalisasiHasilDua[6] = rsNormalisasiHasilDua.getString("z_net6");
            oNormalisasiHasilDua[7] = rsNormalisasiHasilDua.getString("iterasi_ke");
            oNormalisasiHasilDua[8] = rsNormalisasiHasilDua.getString("dokumen_ke");

            Object[] objectSelectBiasTable = new Object[6];
            objectSelectBiasTable[0] = rsNormalisasiHasilDua.getString("wkj");
            objectSelectBiasTable[1] = rsNormalisasiHasilDua.getString("k");

            double wkj0delta = Double.parseDouble(objectSelectBiasTable[1].toString()) * learningRatee * 1;
            double wkj1delta = Double.parseDouble(objectSelectBiasTable[1].toString()) * learningRatee * Double.parseDouble(oNormalisasiHasilDua[1].toString());
            double wkj2delta = Double.parseDouble(objectSelectBiasTable[1].toString()) * learningRatee * Double.parseDouble(oNormalisasiHasilDua[2].toString());
            double wkj3delta = Double.parseDouble(objectSelectBiasTable[1].toString()) * learningRatee * Double.parseDouble(oNormalisasiHasilDua[3].toString());
            double wkj4delta = Double.parseDouble(objectSelectBiasTable[1].toString()) * learningRatee * Double.parseDouble(oNormalisasiHasilDua[4].toString());
            double wkj5delta = Double.parseDouble(objectSelectBiasTable[1].toString()) * learningRatee * Double.parseDouble(oNormalisasiHasilDua[5].toString());
            double wkj6delta = Double.parseDouble(objectSelectBiasTable[1].toString()) * learningRatee * Double.parseDouble(oNormalisasiHasilDua[6].toString());

            String sqlInsertFeedForwarda = "INSERT INTO `tb_sigma_w` VALUES\n"
                    + "(null,"
                    + "'" + wkj0delta + "',"
                    + "'" + wkj1delta + "',"
                    + "'" + wkj2delta + "',"
                    + "'" + wkj3delta + "',"
                    + "'" + wkj4delta + "',"
                    + "'" + wkj5delta + "',"
                    + "'" + wkj6delta + "',"
                    + "" + Integer.parseInt(oNormalisasiHasilDua[8].toString()) + ","
                    + "" + Integer.parseInt(oNormalisasiHasilDua[7].toString()) + ")";

            //System.out.println(sqlInsertFeedForward);
            Statement statementInsertFeedForwarda = (Statement) jdbc.getConnection().createStatement();
            statementInsertFeedForwarda.executeUpdate(sqlInsertFeedForwarda);

        }

        String sqlSelectSinyalOutput = "SELECT * FROM tb_sigma_w";
        Statement statementSelectSinyalOutput = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetSelectSinyalOutput = statementSelectSinyalOutput.executeQuery(sqlSelectSinyalOutput);

        while (resultSetSelectSinyalOutput.next()) {
            Object[] objectSetSelectSinyalOutput = new Object[9];
            objectSetSelectSinyalOutput[0] = resultSetSelectSinyalOutput.getString("dokumen_ke");
            objectSetSelectSinyalOutput[1] = resultSetSelectSinyalOutput.getString("nw10");
            objectSetSelectSinyalOutput[2] = resultSetSelectSinyalOutput.getString("nw11");
            objectSetSelectSinyalOutput[3] = resultSetSelectSinyalOutput.getString("nw12");
            objectSetSelectSinyalOutput[4] = resultSetSelectSinyalOutput.getString("nw13");
            objectSetSelectSinyalOutput[5] = resultSetSelectSinyalOutput.getString("nw14");
            objectSetSelectSinyalOutput[6] = resultSetSelectSinyalOutput.getString("nw15");
            objectSetSelectSinyalOutput[7] = resultSetSelectSinyalOutput.getString("nw16");
            objectSetSelectSinyalOutput[8] = resultSetSelectSinyalOutput.getString("iterasi_ke");

            System.out.println(Double.parseDouble(objectSetSelectSinyalOutput[1].toString()));

            tblNw10.addRow(objectSetSelectSinyalOutput);
        }

        String sqlSelectSinyalOutputSigma = "SELECT * "
                + "FROM tb_faktor_koreksi_error ";
        Statement statementSelectSinyalOutputSigma = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetSelectSinyalOutputSigma = statementSelectSinyalOutputSigma.executeQuery(sqlSelectSinyalOutputSigma);

        while (resultSetSelectSinyalOutputSigma.next()) {
            Object[] objectSetSelectSinyalOutputSigma = new Object[9];
            objectSetSelectSinyalOutputSigma[0] = resultSetSelectSinyalOutputSigma.getString("data_ke");
            objectSetSelectSinyalOutputSigma[1] = resultSetSelectSinyalOutputSigma.getString("z_net1");
            objectSetSelectSinyalOutputSigma[2] = resultSetSelectSinyalOutputSigma.getString("z_net2");
            objectSetSelectSinyalOutputSigma[3] = resultSetSelectSinyalOutputSigma.getString("z_net3");
            objectSetSelectSinyalOutputSigma[4] = resultSetSelectSinyalOutputSigma.getString("z_net4");
            objectSetSelectSinyalOutputSigma[5] = resultSetSelectSinyalOutputSigma.getString("z_net5");
            objectSetSelectSinyalOutputSigma[6] = resultSetSelectSinyalOutputSigma.getString("z_net6");
            objectSetSelectSinyalOutputSigma[7] = resultSetSelectSinyalOutputSigma.getString("dokumen_ke");
            objectSetSelectSinyalOutputSigma[8] = resultSetSelectSinyalOutputSigma.getString("iterasi_ke");

            double wkji0delta1 = Double.parseDouble(objectSetSelectSinyalOutputSigma[1].toString()) * 0.5 * 1;
            double wkji1delta1 = Double.parseDouble(objectSetSelectSinyalOutputSigma[2].toString()) * 0.5 * 1;
            double wkji2delta1 = Double.parseDouble(objectSetSelectSinyalOutputSigma[3].toString()) * 0.5 * 1;
            double wkji3delta1 = Double.parseDouble(objectSetSelectSinyalOutputSigma[4].toString()) * 0.5 * 1;
            double wkji4delta1 = Double.parseDouble(objectSetSelectSinyalOutputSigma[5].toString()) * 0.5 * 1;
            double wkji5delta1 = Double.parseDouble(objectSetSelectSinyalOutputSigma[6].toString()) * 0.5 * 1;

            String sqlInsertFeedForwardaDua = "INSERT INTO `tb_segitiga_v` VALUES\n"
                    + "(null,"
                    + "'" + wkji0delta1 + "',"
                    + "'" + wkji1delta1 + "',"
                    + "'" + wkji2delta1 + "',"
                    + "'" + wkji3delta1 + "',"
                    + "'" + wkji4delta1 + "',"
                    + "'" + wkji5delta1 + "',"
                    + "" + Integer.parseInt(objectSetSelectSinyalOutputSigma[7].toString()) + ","
                    + "" + Integer.parseInt(objectSetSelectSinyalOutputSigma[8].toString()) + ")";

            Statement statementInsertFeedForwardaDua = (Statement) jdbc.getConnection().createStatement();
            statementInsertFeedForwardaDua.executeUpdate(sqlInsertFeedForwardaDua);
        }

        String sqlSelectSinyalOutputSegitiga = "SELECT * FROM tb_segitiga_v";
        Statement statementSelectSinyalOutputSegitiga = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetSelectSinyalOutputSegitiga = statementSelectSinyalOutputSegitiga.executeQuery(sqlSelectSinyalOutputSegitiga);

        while (resultSetSelectSinyalOutputSegitiga.next()) {
            Object[] objectSetSelectSinyalOutputSegitiga = new Object[8];
            objectSetSelectSinyalOutputSegitiga[0] = resultSetSelectSinyalOutputSegitiga.getString("dokumen_ke");
            objectSetSelectSinyalOutputSegitiga[1] = resultSetSelectSinyalOutputSegitiga.getString("segitiga_v_10");
            objectSetSelectSinyalOutputSegitiga[2] = resultSetSelectSinyalOutputSegitiga.getString("segitiga_v_20");
            objectSetSelectSinyalOutputSegitiga[3] = resultSetSelectSinyalOutputSegitiga.getString("segitiga_v_30");
            objectSetSelectSinyalOutputSegitiga[4] = resultSetSelectSinyalOutputSegitiga.getString("segitiga_v_40");
            objectSetSelectSinyalOutputSegitiga[5] = resultSetSelectSinyalOutputSegitiga.getString("segitiga_v_50");
            objectSetSelectSinyalOutputSegitiga[6] = resultSetSelectSinyalOutputSegitiga.getString("segitiga_v_60");
            objectSetSelectSinyalOutputSegitiga[7] = resultSetSelectSinyalOutputSegitiga.getString("iterasi_ke");

            tblSegitigaw10.addRow(objectSetSelectSinyalOutputSegitiga);
        }
    }

    private void aktivasiSeigtigaV() {
        tblSegitigaw10 = new DefaultTableModel();
        TblSegitigaw10.setModel(tblSegitigaw10);
        tblSegitigaw10.addColumn("data_ke");
        tblSegitigaw10.addColumn("Δv10");
        tblSegitigaw10.addColumn("Δv20");
        tblSegitigaw10.addColumn("Δv30");
        tblSegitigaw10.addColumn("Δv40");
        tblSegitigaw10.addColumn("Δv50");
        tblSegitigaw10.addColumn("Δv60");
        tblSegitigaw10.addColumn("iterasi ke");

    }

    private void aktivasiDelta11() {
        tblDelta11 = new DefaultTableModel();
        TblSegitigaw11.setModel(tblDelta11);
        tblDelta11.addColumn("data_ke");
        tblDelta11.addColumn("Δv11");
        tblDelta11.addColumn("Δv21");
        tblDelta11.addColumn("Δv31");
        tblDelta11.addColumn("Δv41");
        tblDelta11.addColumn("Δv51");
        tblDelta11.addColumn("Δv61");
        tblDelta11.addColumn("Δv12");
        tblDelta11.addColumn("Δv22");
        tblDelta11.addColumn("Δv32");
        tblDelta11.addColumn("Δv42");
        tblDelta11.addColumn("Δv52");
        tblDelta11.addColumn("Δv62");
        tblDelta11.addColumn("Δv13");
        tblDelta11.addColumn("Δv23");
        tblDelta11.addColumn("Δv33");
        tblDelta11.addColumn("Δv43");
        tblDelta11.addColumn("Δv53");
        tblDelta11.addColumn("Δv63");
        tblDelta11.addColumn("Δv14");
        tblDelta11.addColumn("Δv24");
        tblDelta11.addColumn("Δv34");
        tblDelta11.addColumn("Δv44");
        tblDelta11.addColumn("Δv54");
        tblDelta11.addColumn("Δv64");
        tblDelta11.addColumn("Δv15");
        tblDelta11.addColumn("Δv25");
        tblDelta11.addColumn("Δv35");
        tblDelta11.addColumn("Δv45");
        tblDelta11.addColumn("Δv55");
        tblDelta11.addColumn("Δv65");
        tblDelta11.addColumn("Δv16");
        tblDelta11.addColumn("Δv26");
        tblDelta11.addColumn("Δv36");
        tblDelta11.addColumn("Δv46");
        tblDelta11.addColumn("Δv56");
        tblDelta11.addColumn("Δv66");
        tblDelta11.addColumn("iterasi_ke");

    }

    private void hitungDeltaV11() throws SQLException {
        try {
            String sqlTruncateBobot = "TRUNCATE tb_delta_v";
            Statement statementTruncateBobot = (Statement) jdbc.getConnection().createStatement();
            statementTruncateBobot.executeUpdate(sqlTruncateBobot);

        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        tblDelta11.getDataVector().removeAllElements();
        tblDelta11.fireTableDataChanged();

        for (int iterasi = 1; iterasi <= iterMaxx; iterasi++) {

            String sqlSelectAllNormalisasiHasil = "SELECT * FROM tb_normalisasi, tb_filtering, tb_faktor_koreksi_error WHERE tb_normalisasi.id = tb_filtering.id_filtering AND tb_faktor_koreksi_error.data_ke = tb_filtering.id_filtering";
            Statement stNormalisasiHasil = (Statement) jdbc.getConnection().createStatement();
            ResultSet rsNormalisasiHasil = stNormalisasiHasil.executeQuery(sqlSelectAllNormalisasiHasil);

            while (rsNormalisasiHasil.next()) {
                Object[] oNormalisasiHasil = new Object[8];
                oNormalisasiHasil[0] = rsNormalisasiHasil.getString("id");
                oNormalisasiHasil[1] = rsNormalisasiHasil.getString("deskripsi_filtering");
                oNormalisasiHasil[2] = rsNormalisasiHasil.getString("kbplus");
                oNormalisasiHasil[3] = rsNormalisasiHasil.getString("kkplus");
                oNormalisasiHasil[4] = rsNormalisasiHasil.getString("ksplus");
                oNormalisasiHasil[5] = rsNormalisasiHasil.getString("kbmin");
                oNormalisasiHasil[6] = rsNormalisasiHasil.getString("kkmin");
                oNormalisasiHasil[7] = rsNormalisasiHasil.getString("ksmin");

                Object[] objectSetSelectSinyalOutputSigma = new Object[9];
                objectSetSelectSinyalOutputSigma[0] = rsNormalisasiHasil.getString("data_ke");
                objectSetSelectSinyalOutputSigma[1] = rsNormalisasiHasil.getString("z_net1");
                objectSetSelectSinyalOutputSigma[2] = rsNormalisasiHasil.getString("z_net2");
                objectSetSelectSinyalOutputSigma[3] = rsNormalisasiHasil.getString("z_net3");
                objectSetSelectSinyalOutputSigma[4] = rsNormalisasiHasil.getString("z_net4");
                objectSetSelectSinyalOutputSigma[5] = rsNormalisasiHasil.getString("z_net5");
                objectSetSelectSinyalOutputSigma[6] = rsNormalisasiHasil.getString("z_net6");
                objectSetSelectSinyalOutputSigma[7] = rsNormalisasiHasil.getString("dokumen_ke");
                objectSetSelectSinyalOutputSigma[8] = rsNormalisasiHasil.getString("iterasi_ke");

                double v11 = Double.parseDouble(objectSetSelectSinyalOutputSigma[1].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kbplus".toString())) * 0.5;
                double v21 = Double.parseDouble(objectSetSelectSinyalOutputSigma[2].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kbplus".toString())) * 0.5;
                double v31 = Double.parseDouble(objectSetSelectSinyalOutputSigma[3].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kbplus".toString())) * 0.5;
                double v41 = Double.parseDouble(objectSetSelectSinyalOutputSigma[4].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kbplus".toString())) * 0.5;
                double v51 = Double.parseDouble(objectSetSelectSinyalOutputSigma[5].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kbplus".toString())) * 0.5;
                double v61 = Double.parseDouble(objectSetSelectSinyalOutputSigma[6].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kbplus".toString())) * 0.5;

                double v12 = Double.parseDouble(objectSetSelectSinyalOutputSigma[1].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kkplus".toString())) * 0.5;
                double v22 = Double.parseDouble(objectSetSelectSinyalOutputSigma[2].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kkplus".toString())) * 0.5;
                double v32 = Double.parseDouble(objectSetSelectSinyalOutputSigma[3].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kkplus".toString())) * 0.5;
                double v42 = Double.parseDouble(objectSetSelectSinyalOutputSigma[4].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kkplus".toString())) * 0.5;
                double v52 = Double.parseDouble(objectSetSelectSinyalOutputSigma[5].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kkplus".toString())) * 0.5;
                double v62 = Double.parseDouble(objectSetSelectSinyalOutputSigma[6].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kkplus".toString())) * 0.5;

                double v13 = Double.parseDouble(objectSetSelectSinyalOutputSigma[1].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("ksplus".toString())) * 0.5;
                double v23 = Double.parseDouble(objectSetSelectSinyalOutputSigma[2].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("ksplus".toString())) * 0.5;
                double v33 = Double.parseDouble(objectSetSelectSinyalOutputSigma[3].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("ksplus".toString())) * 0.5;
                double v43 = Double.parseDouble(objectSetSelectSinyalOutputSigma[4].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("ksplus".toString())) * 0.5;
                double v53 = Double.parseDouble(objectSetSelectSinyalOutputSigma[5].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("ksplus".toString())) * 0.5;
                double v63 = Double.parseDouble(objectSetSelectSinyalOutputSigma[6].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("ksplus".toString())) * 0.5;

                double v14 = Double.parseDouble(objectSetSelectSinyalOutputSigma[1].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kbmin".toString())) * 0.5;
                double v24 = Double.parseDouble(objectSetSelectSinyalOutputSigma[2].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kbmin".toString())) * 0.5;
                double v34 = Double.parseDouble(objectSetSelectSinyalOutputSigma[3].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kbmin".toString())) * 0.5;
                double v44 = Double.parseDouble(objectSetSelectSinyalOutputSigma[4].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kbmin".toString())) * 0.5;
                double v54 = Double.parseDouble(objectSetSelectSinyalOutputSigma[5].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kbmin".toString())) * 0.5;
                double v64 = Double.parseDouble(objectSetSelectSinyalOutputSigma[6].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kbmin".toString())) * 0.5;

                double v15 = Double.parseDouble(objectSetSelectSinyalOutputSigma[1].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kkmin".toString())) * 0.5;
                double v25 = Double.parseDouble(objectSetSelectSinyalOutputSigma[2].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kkmin".toString())) * 0.5;
                double v35 = Double.parseDouble(objectSetSelectSinyalOutputSigma[3].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kkmin".toString())) * 0.5;
                double v45 = Double.parseDouble(objectSetSelectSinyalOutputSigma[4].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kkmin".toString())) * 0.5;
                double v55 = Double.parseDouble(objectSetSelectSinyalOutputSigma[5].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kkmin".toString())) * 0.5;
                double v65 = Double.parseDouble(objectSetSelectSinyalOutputSigma[6].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("kkmin".toString())) * 0.5;

                double v16 = Double.parseDouble(objectSetSelectSinyalOutputSigma[1].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("ksmin".toString())) * 0.5;
                double v26 = Double.parseDouble(objectSetSelectSinyalOutputSigma[2].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("ksmin".toString())) * 0.5;
                double v36 = Double.parseDouble(objectSetSelectSinyalOutputSigma[3].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("ksmin".toString())) * 0.5;
                double v46 = Double.parseDouble(objectSetSelectSinyalOutputSigma[4].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("ksmin".toString())) * 0.5;
                double v56 = Double.parseDouble(objectSetSelectSinyalOutputSigma[5].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("ksmin".toString())) * 0.5;
                double v66 = Double.parseDouble(objectSetSelectSinyalOutputSigma[6].toString()) * Double.parseDouble(rsNormalisasiHasil.getString("ksmin".toString())) * 0.5;

                String sqlInsertFeedForwardaDua = "INSERT INTO `tb_delta_v` VALUES\n"
                        + "(null,"
                        + "'" + v11 + "',"
                        + "'" + v21 + "',"
                        + "'" + v31 + "',"
                        + "'" + v41 + "',"
                        + "'" + v51 + "',"
                        + "'" + v61 + "',"
                        + "'" + v12 + "',"
                        + "'" + v22 + "',"
                        + "'" + v32 + "',"
                        + "'" + v42 + "',"
                        + "'" + v52 + "',"
                        + "'" + v62 + "',"
                        + "'" + v13 + "',"
                        + "'" + v23 + "',"
                        + "'" + v33 + "',"
                        + "'" + v43 + "',"
                        + "'" + v53 + "',"
                        + "'" + v63 + "',"
                        + "'" + v14 + "',"
                        + "'" + v24 + "',"
                        + "'" + v34 + "',"
                        + "'" + v44 + "',"
                        + "'" + v54 + "',"
                        + "'" + v64 + "',"
                        + "'" + v15 + "',"
                        + "'" + v25 + "',"
                        + "'" + v35 + "',"
                        + "'" + v45 + "',"
                        + "'" + v55 + "',"
                        + "'" + v65 + "',"
                        + "'" + v16 + "',"
                        + "'" + v26 + "',"
                        + "'" + v36 + "',"
                        + "'" + v46 + "',"
                        + "'" + v56 + "',"
                        + "'" + v66 + "',"
                        + "" + Integer.parseInt(objectSetSelectSinyalOutputSigma[7].toString()) + ","
                        + "" + iterasi + ")";

                Statement statementInsertFeedForwardaDua = (Statement) jdbc.getConnection().createStatement();
                statementInsertFeedForwardaDua.executeUpdate(sqlInsertFeedForwardaDua);

            }
        }

        String sqlSelectSinyalOutputDeltaV = "SELECT * FROM tb_delta_v";
        Statement statementSelectSinyalOutputDeltaV = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetSelectSinyalOutputDeltaV = statementSelectSinyalOutputDeltaV.executeQuery(sqlSelectSinyalOutputDeltaV);

        while (resultSetSelectSinyalOutputDeltaV.next()) {
            Object[] objectSetSelectSinyalOutputDeltaV = new Object[38];
            objectSetSelectSinyalOutputDeltaV[0] = resultSetSelectSinyalOutputDeltaV.getString("dokumen_ke");
            objectSetSelectSinyalOutputDeltaV[1] = resultSetSelectSinyalOutputDeltaV.getString("v11");
            objectSetSelectSinyalOutputDeltaV[2] = resultSetSelectSinyalOutputDeltaV.getString("v21");
            objectSetSelectSinyalOutputDeltaV[3] = resultSetSelectSinyalOutputDeltaV.getString("v31");
            objectSetSelectSinyalOutputDeltaV[4] = resultSetSelectSinyalOutputDeltaV.getString("v41");
            objectSetSelectSinyalOutputDeltaV[5] = resultSetSelectSinyalOutputDeltaV.getString("v51");
            objectSetSelectSinyalOutputDeltaV[6] = resultSetSelectSinyalOutputDeltaV.getString("v61");

            objectSetSelectSinyalOutputDeltaV[7] = resultSetSelectSinyalOutputDeltaV.getString("v12");
            objectSetSelectSinyalOutputDeltaV[8] = resultSetSelectSinyalOutputDeltaV.getString("v22");
            objectSetSelectSinyalOutputDeltaV[9] = resultSetSelectSinyalOutputDeltaV.getString("v32");
            objectSetSelectSinyalOutputDeltaV[10] = resultSetSelectSinyalOutputDeltaV.getString("v42");
            objectSetSelectSinyalOutputDeltaV[11] = resultSetSelectSinyalOutputDeltaV.getString("v52");
            objectSetSelectSinyalOutputDeltaV[12] = resultSetSelectSinyalOutputDeltaV.getString("v62");

            objectSetSelectSinyalOutputDeltaV[13] = resultSetSelectSinyalOutputDeltaV.getString("v13");
            objectSetSelectSinyalOutputDeltaV[14] = resultSetSelectSinyalOutputDeltaV.getString("v23");
            objectSetSelectSinyalOutputDeltaV[15] = resultSetSelectSinyalOutputDeltaV.getString("v33");
            objectSetSelectSinyalOutputDeltaV[16] = resultSetSelectSinyalOutputDeltaV.getString("v43");
            objectSetSelectSinyalOutputDeltaV[17] = resultSetSelectSinyalOutputDeltaV.getString("v53");
            objectSetSelectSinyalOutputDeltaV[18] = resultSetSelectSinyalOutputDeltaV.getString("v63");

            objectSetSelectSinyalOutputDeltaV[19] = resultSetSelectSinyalOutputDeltaV.getString("v14");
            objectSetSelectSinyalOutputDeltaV[20] = resultSetSelectSinyalOutputDeltaV.getString("v24");
            objectSetSelectSinyalOutputDeltaV[21] = resultSetSelectSinyalOutputDeltaV.getString("v34");
            objectSetSelectSinyalOutputDeltaV[22] = resultSetSelectSinyalOutputDeltaV.getString("v44");
            objectSetSelectSinyalOutputDeltaV[23] = resultSetSelectSinyalOutputDeltaV.getString("v54");
            objectSetSelectSinyalOutputDeltaV[24] = resultSetSelectSinyalOutputDeltaV.getString("v64");

            objectSetSelectSinyalOutputDeltaV[25] = resultSetSelectSinyalOutputDeltaV.getString("v15");
            objectSetSelectSinyalOutputDeltaV[26] = resultSetSelectSinyalOutputDeltaV.getString("v25");
            objectSetSelectSinyalOutputDeltaV[27] = resultSetSelectSinyalOutputDeltaV.getString("v35");
            objectSetSelectSinyalOutputDeltaV[28] = resultSetSelectSinyalOutputDeltaV.getString("v45");
            objectSetSelectSinyalOutputDeltaV[29] = resultSetSelectSinyalOutputDeltaV.getString("v55");
            objectSetSelectSinyalOutputDeltaV[30] = resultSetSelectSinyalOutputDeltaV.getString("v65");

            objectSetSelectSinyalOutputDeltaV[31] = resultSetSelectSinyalOutputDeltaV.getString("v16");
            objectSetSelectSinyalOutputDeltaV[32] = resultSetSelectSinyalOutputDeltaV.getString("v26");
            objectSetSelectSinyalOutputDeltaV[33] = resultSetSelectSinyalOutputDeltaV.getString("v36");
            objectSetSelectSinyalOutputDeltaV[34] = resultSetSelectSinyalOutputDeltaV.getString("v46");
            objectSetSelectSinyalOutputDeltaV[35] = resultSetSelectSinyalOutputDeltaV.getString("v56");
            objectSetSelectSinyalOutputDeltaV[36] = resultSetSelectSinyalOutputDeltaV.getString("v66");
            objectSetSelectSinyalOutputDeltaV[37] = resultSetSelectSinyalOutputDeltaV.getString("iterasi_ke");

            tblDelta11.addRow(objectSetSelectSinyalOutputDeltaV);
        }
    }

    private void hitungW10() throws SQLException {

        List<Double> WN = new ArrayList<Double>();

        String sqlSelectAcakTable = "SELECT * FROM tb_acak";
        Statement statementSelectAcakTable = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetSelectAcakTable = statementSelectAcakTable.executeQuery(sqlSelectAcakTable);

        while (resultSetSelectAcakTable.next()) {
            Object[] objectSelectAcakTable = new Object[2];
            objectSelectAcakTable[0] = resultSetSelectAcakTable.getString("wkj");
            objectSelectAcakTable[1] = resultSetSelectAcakTable.getString("k");

            WN.add(Double.parseDouble(objectSelectAcakTable[1].toString()));
        }

        String sqlSelectSinyalOutput = "SELECT * FROM tb_sigma_w";
        Statement statementSelectSinyalOutput = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetSelectSinyalOutput = statementSelectSinyalOutput.executeQuery(sqlSelectSinyalOutput);

        while (resultSetSelectSinyalOutput.next()) {
            Object[] objectSetSelectSinyalOutput = new Object[10];
            objectSetSelectSinyalOutput[0] = resultSetSelectSinyalOutput.getString("data_ke");
            objectSetSelectSinyalOutput[1] = resultSetSelectSinyalOutput.getString("nw10");
            objectSetSelectSinyalOutput[2] = resultSetSelectSinyalOutput.getString("nw11");
            objectSetSelectSinyalOutput[3] = resultSetSelectSinyalOutput.getString("nw12");
            objectSetSelectSinyalOutput[4] = resultSetSelectSinyalOutput.getString("nw13");
            objectSetSelectSinyalOutput[5] = resultSetSelectSinyalOutput.getString("nw14");
            objectSetSelectSinyalOutput[6] = resultSetSelectSinyalOutput.getString("nw15");
            objectSetSelectSinyalOutput[7] = resultSetSelectSinyalOutput.getString("nw16");
            objectSetSelectSinyalOutput[8] = resultSetSelectSinyalOutput.getString("dokumen_ke");
            objectSetSelectSinyalOutput[9] = resultSetSelectSinyalOutput.getString("iterasi_ke");

            String sqlSelectAcakOutputTable = "SELECT * FROM tb_acak_output";
            Statement statementSelectAcakOutputTable = (Statement) jdbc.getConnection().createStatement();
            ResultSet resultSetSelectAcakOutputTable = statementSelectAcakOutputTable.executeQuery(sqlSelectAcakOutputTable);

            while (resultSetSelectAcakOutputTable.next()) {
                Object[] objectSelectAcakOutputTable = new Object[4];
                objectSelectAcakOutputTable[0] = resultSetSelectAcakOutputTable.getString("wk0");
                objectSelectAcakOutputTable[1] = resultSetSelectAcakOutputTable.getString("k");

                double w10 = Double.parseDouble(objectSetSelectSinyalOutput[1].toString()) + Double.parseDouble(objectSelectAcakOutputTable[1].toString());
                double w11 = Double.parseDouble(objectSetSelectSinyalOutput[2].toString()) + WN.get(0);
                double w12 = Double.parseDouble(objectSetSelectSinyalOutput[3].toString()) + WN.get(1);
                double w13 = Double.parseDouble(objectSetSelectSinyalOutput[4].toString()) + WN.get(2);
                double w14 = Double.parseDouble(objectSetSelectSinyalOutput[5].toString()) + WN.get(3);
                double w15 = Double.parseDouble(objectSetSelectSinyalOutput[6].toString()) + WN.get(4);
                double w16 = Double.parseDouble(objectSetSelectSinyalOutput[7].toString()) + WN.get(5);

                String sqlInsertFeedForwardaDua = "INSERT INTO `tb_w` VALUES\n"
                        + "(null,"
                        + "'" + w10 + "',"
                        + "'" + w11 + "',"
                        + "'" + w12 + "',"
                        + "'" + w13 + "',"
                        + "'" + w14 + "',"
                        + "'" + w15 + "',"
                        + "'" + w16 + "',"
                        + "" + Integer.parseInt(objectSetSelectSinyalOutput[8].toString()) + ","
                        + "" + Integer.parseInt(objectSetSelectSinyalOutput[9].toString()) + ")";

                Statement statementInsertFeedForwardaDua = (Statement) jdbc.getConnection().createStatement();
                statementInsertFeedForwardaDua.executeUpdate(sqlInsertFeedForwardaDua);

            }
        }
    }

    private void tampilkanW10() throws SQLException {
        String sqlSelectSinyalOutput = "SELECT * FROM tb_w";
        Statement statementSelectSinyalOutput = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetSelectSinyalOutput = statementSelectSinyalOutput.executeQuery(sqlSelectSinyalOutput);

        while (resultSetSelectSinyalOutput.next()) {
            Object[] objectSetSelectSinyalOutput = new Object[9];
            objectSetSelectSinyalOutput[0] = resultSetSelectSinyalOutput.getString("dokumen_ke");
            objectSetSelectSinyalOutput[1] = resultSetSelectSinyalOutput.getString("w10");
            objectSetSelectSinyalOutput[2] = resultSetSelectSinyalOutput.getString("w11");
            objectSetSelectSinyalOutput[3] = resultSetSelectSinyalOutput.getString("w12");
            objectSetSelectSinyalOutput[4] = resultSetSelectSinyalOutput.getString("w13");
            objectSetSelectSinyalOutput[5] = resultSetSelectSinyalOutput.getString("w14");
            objectSetSelectSinyalOutput[6] = resultSetSelectSinyalOutput.getString("w15");
            objectSetSelectSinyalOutput[7] = resultSetSelectSinyalOutput.getString("w16");
            objectSetSelectSinyalOutput[8] = resultSetSelectSinyalOutput.getString("iterasi_ke");

            tblW10.addRow(objectSetSelectSinyalOutput);
        }
    }

    private void tampilkanTermFrekuensi() {
        tblNormalisasiDua = new DefaultTableModel();
        TblNormalisasiDua.setModel(tblNormalisasiDua);
        tblNormalisasiDua.addColumn("Id");
        tblNormalisasiDua.addColumn("kb+ (x1)");
        tblNormalisasiDua.addColumn("kk+ (x2)");
        tblNormalisasiDua.addColumn("ks+ (x3)");
        tblNormalisasiDua.addColumn("kb- (x4)");
        tblNormalisasiDua.addColumn("kk- (x5)");
        tblNormalisasiDua.addColumn("ks- (x6)");
        tblNormalisasiDua.addColumn("kelas dokumen");
    }

    private void termNormalisasi() throws SQLException {
        //normalisasi
        String sqlSelectAllNormalisasiHasil = "SELECT * FROM tb_normalisasi, tb_filtering WHERE tb_normalisasi.id = tb_filtering.id_filtering";
        Statement stNormalisasiHasil = (Statement) jdbc.getConnection().createStatement();
        ResultSet rsNormalisasiHasil = stNormalisasiHasil.executeQuery(sqlSelectAllNormalisasiHasil);

        while (rsNormalisasiHasil.next()) {
            Object[] oNormalisasiHasil = new Object[8];
            oNormalisasiHasil[0] = rsNormalisasiHasil.getString("id");
            oNormalisasiHasil[1] = rsNormalisasiHasil.getString("kbplus");
            oNormalisasiHasil[2] = rsNormalisasiHasil.getString("kkplus");
            oNormalisasiHasil[3] = rsNormalisasiHasil.getString("ksplus");
            oNormalisasiHasil[4] = rsNormalisasiHasil.getString("kbmin");
            oNormalisasiHasil[5] = rsNormalisasiHasil.getString("kkmin");
            oNormalisasiHasil[6] = rsNormalisasiHasil.getString("ksmin");
            oNormalisasiHasil[7] = rsNormalisasiHasil.getString("kelas_dokumen");
            tblNormalisasiDua.addRow(oNormalisasiHasil);
        }
    }

    private void hitung9NilaiBiasAwal() throws SQLException {

        String sqlSelectSinyalOutputSegitiga = "SELECT * FROM tb_segitiga_v";
        Statement statementSelectSinyalOutputSegitiga = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetSelectSinyalOutputSegitiga = statementSelectSinyalOutputSegitiga.executeQuery(sqlSelectSinyalOutputSegitiga);

        while (resultSetSelectSinyalOutputSegitiga.next()) {
            Object[] objectSetSelectSinyalOutputSegitiga = new Object[9];
            objectSetSelectSinyalOutputSegitiga[0] = resultSetSelectSinyalOutputSegitiga.getString("data_ke");
            objectSetSelectSinyalOutputSegitiga[1] = resultSetSelectSinyalOutputSegitiga.getString("segitiga_v_10");
            objectSetSelectSinyalOutputSegitiga[2] = resultSetSelectSinyalOutputSegitiga.getString("segitiga_v_20");
            objectSetSelectSinyalOutputSegitiga[3] = resultSetSelectSinyalOutputSegitiga.getString("segitiga_v_30");
            objectSetSelectSinyalOutputSegitiga[4] = resultSetSelectSinyalOutputSegitiga.getString("segitiga_v_40");
            objectSetSelectSinyalOutputSegitiga[5] = resultSetSelectSinyalOutputSegitiga.getString("segitiga_v_50");
            objectSetSelectSinyalOutputSegitiga[6] = resultSetSelectSinyalOutputSegitiga.getString("segitiga_v_60");
            objectSetSelectSinyalOutputSegitiga[7] = resultSetSelectSinyalOutputSegitiga.getString("dokumen_ke");
            objectSetSelectSinyalOutputSegitiga[8] = resultSetSelectSinyalOutputSegitiga.getString("iterasi_ke");

            String sqlSelectBiasTable = "SELECT * FROM tb_nilai_bias_awal";
            Statement statementSelectBiasTable = (Statement) jdbc.getConnection().createStatement();
            ResultSet resultSetSelectBiasTable = statementSelectBiasTable.executeQuery(sqlSelectBiasTable);

            while (resultSetSelectBiasTable.next()) {
                Object[] objectSelectBiasTable = new Object[6];
                objectSelectBiasTable[0] = resultSetSelectBiasTable.getString("j1");
                objectSelectBiasTable[1] = resultSetSelectBiasTable.getString("j2");
                objectSelectBiasTable[2] = resultSetSelectBiasTable.getString("j3");
                objectSelectBiasTable[3] = resultSetSelectBiasTable.getString("j4");
                objectSelectBiasTable[4] = resultSetSelectBiasTable.getString("j5");
                objectSelectBiasTable[5] = resultSetSelectBiasTable.getString("j6");

                double w10 = Double.parseDouble(objectSelectBiasTable[0].toString()) + Double.parseDouble(objectSetSelectSinyalOutputSegitiga[1].toString());
                double w11 = Double.parseDouble(objectSelectBiasTable[1].toString()) + Double.parseDouble(objectSetSelectSinyalOutputSegitiga[2].toString());
                double w12 = Double.parseDouble(objectSelectBiasTable[2].toString()) + Double.parseDouble(objectSetSelectSinyalOutputSegitiga[3].toString());
                double w13 = Double.parseDouble(objectSelectBiasTable[3].toString()) + Double.parseDouble(objectSetSelectSinyalOutputSegitiga[4].toString());
                double w14 = Double.parseDouble(objectSelectBiasTable[4].toString()) + Double.parseDouble(objectSetSelectSinyalOutputSegitiga[5].toString());
                double w15 = Double.parseDouble(objectSelectBiasTable[5].toString()) + Double.parseDouble(objectSetSelectSinyalOutputSegitiga[6].toString());

                String sqlInsertFeedForwardaDua = "INSERT INTO `tb_9_nilai_bias_awal` VALUES\n"
                        + "(null,"
                        + "'" + w10 + "',"
                        + "'" + w11 + "',"
                        + "'" + w12 + "',"
                        + "'" + w13 + "',"
                        + "'" + w14 + "',"
                        + "'" + w15 + "',"
                        + "" + Integer.parseInt(objectSetSelectSinyalOutputSegitiga[7].toString()) + ","
                        + "" + Integer.parseInt(objectSetSelectSinyalOutputSegitiga[8].toString()) + ")";

                System.out.println(sqlInsertFeedForwardaDua);
                Statement statementInsertFeedForwardaDua = (Statement) jdbc.getConnection().createStatement();
                statementInsertFeedForwardaDua.executeUpdate(sqlInsertFeedForwardaDua);

            }

        }

        String sqlSelectSinyalOutputSegitigaBias = "SELECT * FROM tb_9_nilai_bias_awal";
        Statement statementSelectSinyalOutputSegitigaBias = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetSelectSinyalOutputSegitigaBias = statementSelectSinyalOutputSegitigaBias.executeQuery(sqlSelectSinyalOutputSegitigaBias);

        while (resultSetSelectSinyalOutputSegitigaBias.next()) {
            Object[] objectSetSelectSinyalOutputSegitigaBias = new Object[8];
            objectSetSelectSinyalOutputSegitigaBias[0] = resultSetSelectSinyalOutputSegitigaBias.getString("dokumen_ke");
            objectSetSelectSinyalOutputSegitigaBias[1] = resultSetSelectSinyalOutputSegitigaBias.getString("deltav10");
            objectSetSelectSinyalOutputSegitigaBias[2] = resultSetSelectSinyalOutputSegitigaBias.getString("deltav20");
            objectSetSelectSinyalOutputSegitigaBias[3] = resultSetSelectSinyalOutputSegitigaBias.getString("deltav30");
            objectSetSelectSinyalOutputSegitigaBias[4] = resultSetSelectSinyalOutputSegitigaBias.getString("deltav40");
            objectSetSelectSinyalOutputSegitigaBias[5] = resultSetSelectSinyalOutputSegitigaBias.getString("deltav50");
            objectSetSelectSinyalOutputSegitigaBias[6] = resultSetSelectSinyalOutputSegitigaBias.getString("deltav60");
            objectSetSelectSinyalOutputSegitigaBias[7] = resultSetSelectSinyalOutputSegitigaBias.getString("iterasi_ke");
            tbl9NilaiBiasAwal.addRow(objectSetSelectSinyalOutputSegitigaBias);
        }
    }

    private void aktivasiTable9NilaiBiasAwal() {
        tbl9NilaiBiasAwal = new DefaultTableModel();
        Tbl9NilaiBiasAwal.setModel(tbl9NilaiBiasAwal);
        tbl9NilaiBiasAwal.addColumn("data ke");
        tbl9NilaiBiasAwal.addColumn("v10");
        tbl9NilaiBiasAwal.addColumn("v20");
        tbl9NilaiBiasAwal.addColumn("v30");
        tbl9NilaiBiasAwal.addColumn("v40");
        tbl9NilaiBiasAwal.addColumn("v50");
        tbl9NilaiBiasAwal.addColumn("v60");
        tbl9NilaiBiasAwal.addColumn("iterasi ke");

    }

    private void aktivasiTable13() {
        tbl13 = new DefaultTableModel();
        Tbl13.setModel(tbl13);
        tbl13.addColumn("data_ke");
        tbl13.addColumn("v11");
        tbl13.addColumn("v21");
        tbl13.addColumn("v31");
        tbl13.addColumn("v41");
        tbl13.addColumn("v51");
        tbl13.addColumn("v61");
        tbl13.addColumn("v12");
        tbl13.addColumn("v22");
        tbl13.addColumn("v32");
        tbl13.addColumn("v42");
        tbl13.addColumn("v52");
        tbl13.addColumn("v62");
        tbl13.addColumn("v13");
        tbl13.addColumn("v23");
        tbl13.addColumn("v33");
        tbl13.addColumn("v43");
        tbl13.addColumn("v53");
        tbl13.addColumn("v63");
        tbl13.addColumn("v14");
        tbl13.addColumn("v24");
        tbl13.addColumn("v34");
        tbl13.addColumn("v44");
        tbl13.addColumn("v54");
        tbl13.addColumn("v64");
        tbl13.addColumn("v15");
        tbl13.addColumn("v25");
        tbl13.addColumn("v35");
        tbl13.addColumn("v45");
        tbl13.addColumn("v55");
        tbl13.addColumn("v65");
        tbl13.addColumn("v16");
        tbl13.addColumn("v26");
        tbl13.addColumn("v36");
        tbl13.addColumn("v46");
        tbl13.addColumn("v56");
        tbl13.addColumn("v66");
        tbl13.addColumn("iterasi_ke");

    }

    private void hitungTable13() throws SQLException {

        List<Double> v1 = new ArrayList<Double>();
        List<Double> v2 = new ArrayList<Double>();
        List<Double> v3 = new ArrayList<Double>();
        List<Double> v4 = new ArrayList<Double>();
        List<Double> v5 = new ArrayList<Double>();
        List<Double> v6 = new ArrayList<Double>();

        String sqlBobotBaru = "SELECT * FROM tb_12";
        Statement statementBobotBaru = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetBobotBaru = statementBobotBaru.executeQuery(sqlBobotBaru);

        while (resultSetBobotBaru.next()) {

            Object[] objectHasilBobot = new Object[7];
            objectHasilBobot[0] = resultSetBobotBaru.getString("data_ke");
            objectHasilBobot[1] = resultSetBobotBaru.getString("j1");
            objectHasilBobot[2] = resultSetBobotBaru.getString("j2");
            objectHasilBobot[3] = resultSetBobotBaru.getString("j3");
            objectHasilBobot[4] = resultSetBobotBaru.getString("j4");
            objectHasilBobot[5] = resultSetBobotBaru.getString("j5");
            objectHasilBobot[6] = resultSetBobotBaru.getString("j6");

            v1.add(Double.parseDouble(objectHasilBobot[1].toString()));
            v2.add(Double.parseDouble(objectHasilBobot[2].toString()));
            v3.add(Double.parseDouble(objectHasilBobot[3].toString()));
            v4.add(Double.parseDouble(objectHasilBobot[4].toString()));
            v5.add(Double.parseDouble(objectHasilBobot[5].toString()));
            v6.add(Double.parseDouble(objectHasilBobot[6].toString()));

        }

        String sqlSelectSinyalOutputDeltaV = "SELECT * FROM tb_delta_v";
        Statement statementSelectSinyalOutputDeltaV = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetSelectSinyalOutputDeltaV = statementSelectSinyalOutputDeltaV.executeQuery(sqlSelectSinyalOutputDeltaV);

        while (resultSetSelectSinyalOutputDeltaV.next()) {
            Object[] objectSetSelectSinyalOutputDeltaV = new Object[39];
            objectSetSelectSinyalOutputDeltaV[0] = resultSetSelectSinyalOutputDeltaV.getString("data_ke");

//            System.out.println(resultSetSelectSinyalOutputDeltaV.getString("v11") + " + " + v1.get(0));
//            System.out.println(resultSetSelectSinyalOutputDeltaV.getString("v21") + " + " + v1.get(0));
//            System.out.println(resultSetSelectSinyalOutputDeltaV.getString("v31") + " + " + v1.get(0));
//            System.out.println(resultSetSelectSinyalOutputDeltaV.getString("v41") + " + " + v1.get(0));
//            System.out.println(resultSetSelectSinyalOutputDeltaV.getString("v51") + " + " + v1.get(0));
//            System.out.println(resultSetSelectSinyalOutputDeltaV.getString("v61") + " + " + v1.get(0));
//            
            objectSetSelectSinyalOutputDeltaV[1] = resultSetSelectSinyalOutputDeltaV.getString("v11");
            objectSetSelectSinyalOutputDeltaV[2] = resultSetSelectSinyalOutputDeltaV.getString("v21");
            objectSetSelectSinyalOutputDeltaV[3] = resultSetSelectSinyalOutputDeltaV.getString("v31");
            objectSetSelectSinyalOutputDeltaV[4] = resultSetSelectSinyalOutputDeltaV.getString("v41");
            objectSetSelectSinyalOutputDeltaV[5] = resultSetSelectSinyalOutputDeltaV.getString("v51");
            objectSetSelectSinyalOutputDeltaV[6] = resultSetSelectSinyalOutputDeltaV.getString("v61");

            objectSetSelectSinyalOutputDeltaV[7] = resultSetSelectSinyalOutputDeltaV.getString("v12");
            objectSetSelectSinyalOutputDeltaV[8] = resultSetSelectSinyalOutputDeltaV.getString("v22");
            objectSetSelectSinyalOutputDeltaV[9] = resultSetSelectSinyalOutputDeltaV.getString("v32");
            objectSetSelectSinyalOutputDeltaV[10] = resultSetSelectSinyalOutputDeltaV.getString("v42");
            objectSetSelectSinyalOutputDeltaV[11] = resultSetSelectSinyalOutputDeltaV.getString("v52");
            objectSetSelectSinyalOutputDeltaV[12] = resultSetSelectSinyalOutputDeltaV.getString("v62");

            objectSetSelectSinyalOutputDeltaV[13] = resultSetSelectSinyalOutputDeltaV.getString("v13");
            objectSetSelectSinyalOutputDeltaV[14] = resultSetSelectSinyalOutputDeltaV.getString("v23");
            objectSetSelectSinyalOutputDeltaV[15] = resultSetSelectSinyalOutputDeltaV.getString("v33");
            objectSetSelectSinyalOutputDeltaV[16] = resultSetSelectSinyalOutputDeltaV.getString("v43");
            objectSetSelectSinyalOutputDeltaV[17] = resultSetSelectSinyalOutputDeltaV.getString("v53");
            objectSetSelectSinyalOutputDeltaV[18] = resultSetSelectSinyalOutputDeltaV.getString("v63");

            objectSetSelectSinyalOutputDeltaV[19] = resultSetSelectSinyalOutputDeltaV.getString("v14");
            objectSetSelectSinyalOutputDeltaV[20] = resultSetSelectSinyalOutputDeltaV.getString("v24");
            objectSetSelectSinyalOutputDeltaV[21] = resultSetSelectSinyalOutputDeltaV.getString("v34");
            objectSetSelectSinyalOutputDeltaV[22] = resultSetSelectSinyalOutputDeltaV.getString("v44");
            objectSetSelectSinyalOutputDeltaV[23] = resultSetSelectSinyalOutputDeltaV.getString("v54");
            objectSetSelectSinyalOutputDeltaV[24] = resultSetSelectSinyalOutputDeltaV.getString("v64");

            objectSetSelectSinyalOutputDeltaV[25] = resultSetSelectSinyalOutputDeltaV.getString("v15");
            objectSetSelectSinyalOutputDeltaV[26] = resultSetSelectSinyalOutputDeltaV.getString("v25");
            objectSetSelectSinyalOutputDeltaV[27] = resultSetSelectSinyalOutputDeltaV.getString("v35");
            objectSetSelectSinyalOutputDeltaV[28] = resultSetSelectSinyalOutputDeltaV.getString("v45");
            objectSetSelectSinyalOutputDeltaV[29] = resultSetSelectSinyalOutputDeltaV.getString("v55");
            objectSetSelectSinyalOutputDeltaV[30] = resultSetSelectSinyalOutputDeltaV.getString("v65");

            objectSetSelectSinyalOutputDeltaV[31] = resultSetSelectSinyalOutputDeltaV.getString("v16");
            objectSetSelectSinyalOutputDeltaV[32] = resultSetSelectSinyalOutputDeltaV.getString("v26");
            objectSetSelectSinyalOutputDeltaV[33] = resultSetSelectSinyalOutputDeltaV.getString("v36");
            objectSetSelectSinyalOutputDeltaV[34] = resultSetSelectSinyalOutputDeltaV.getString("v46");
            objectSetSelectSinyalOutputDeltaV[35] = resultSetSelectSinyalOutputDeltaV.getString("v56");
            objectSetSelectSinyalOutputDeltaV[36] = resultSetSelectSinyalOutputDeltaV.getString("v66");
            objectSetSelectSinyalOutputDeltaV[37] = resultSetSelectSinyalOutputDeltaV.getString("dokumen_ke");
            objectSetSelectSinyalOutputDeltaV[38] = resultSetSelectSinyalOutputDeltaV.getString("iterasi_ke");

            double v11 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[1].toString()) + v1.get(0);
            double v21 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[2].toString()) + v2.get(0);
            double v31 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[3].toString()) + v3.get(0);
            double v41 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[4].toString()) + v4.get(0);
            double v51 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[5].toString()) + v5.get(0);
            double v61 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[6].toString()) + v6.get(0);

            double v12 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[7].toString()) + v1.get(1);
            double v22 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[8].toString()) + v2.get(1);
            double v32 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[9].toString()) + v3.get(1);
            double v42 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[10].toString()) + v4.get(1);
            double v52 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[11].toString()) + v5.get(1);
            double v62 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[12].toString()) + v6.get(1);

            double v13 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[13].toString()) + v1.get(2);
            double v23 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[14].toString()) + v2.get(2);
            double v33 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[15].toString()) + v3.get(2);
            double v43 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[16].toString()) + v4.get(2);
            double v53 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[17].toString()) + v5.get(2);
            double v63 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[18].toString()) + v6.get(2);

            double v14 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[19].toString()) + v1.get(3);
            double v24 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[20].toString()) + v2.get(3);
            double v34 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[21].toString()) + v3.get(3);
            double v44 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[22].toString()) + v4.get(3);
            double v54 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[23].toString()) + v5.get(3);
            double v64 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[24].toString()) + v6.get(3);

            double v15 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[25].toString()) + v1.get(4);
            double v25 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[26].toString()) + v2.get(4);
            double v35 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[27].toString()) + v3.get(4);
            double v45 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[28].toString()) + v4.get(4);
            double v55 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[29].toString()) + v5.get(4);
            double v65 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[30].toString()) + v6.get(4);

            double v16 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[31].toString()) + v1.get(5);
            double v26 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[32].toString()) + v2.get(5);
            double v36 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[33].toString()) + v3.get(5);
            double v46 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[34].toString()) + v4.get(5);
            double v56 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[35].toString()) + v5.get(5);
            double v66 = Double.parseDouble(objectSetSelectSinyalOutputDeltaV[36].toString()) + v6.get(5);

            String sqlInsertFeedForwardaDua = "INSERT INTO `tb_13` VALUES\n"
                    + "(null,"
                    + "'" + v11 + "',"
                    + "'" + v21 + "',"
                    + "'" + v31 + "',"
                    + "'" + v41 + "',"
                    + "'" + v51 + "',"
                    + "'" + v61 + "',"
                    + "'" + v12 + "',"
                    + "'" + v22 + "',"
                    + "'" + v32 + "',"
                    + "'" + v42 + "',"
                    + "'" + v52 + "',"
                    + "'" + v62 + "',"
                    + "'" + v13 + "',"
                    + "'" + v23 + "',"
                    + "'" + v33 + "',"
                    + "'" + v43 + "',"
                    + "'" + v53 + "',"
                    + "'" + v63 + "',"
                    + "'" + v14 + "',"
                    + "'" + v24 + "',"
                    + "'" + v34 + "',"
                    + "'" + v44 + "',"
                    + "'" + v54 + "',"
                    + "'" + v64 + "',"
                    + "'" + v15 + "',"
                    + "'" + v25 + "',"
                    + "'" + v35 + "',"
                    + "'" + v45 + "',"
                    + "'" + v55 + "',"
                    + "'" + v65 + "',"
                    + "'" + v16 + "',"
                    + "'" + v26 + "',"
                    + "'" + v36 + "',"
                    + "'" + v46 + "',"
                    + "'" + v56 + "',"
                    + "'" + v66 + "',"
                    + "" + Integer.parseInt(objectSetSelectSinyalOutputDeltaV[37].toString()) + ","
                    + "" + Integer.parseInt(objectSetSelectSinyalOutputDeltaV[38].toString()) + ")";
            System.out.println(sqlInsertFeedForwardaDua);
            Statement statementInsertFeedForwardaDua = (Statement) jdbc.getConnection().createStatement();
            statementInsertFeedForwardaDua.executeUpdate(sqlInsertFeedForwardaDua);

        }

        String sqlSelectSinyalOutputDeltaV13 = "SELECT * FROM tb_13";
        Statement statementSelectSinyalOutputDeltaV13 = (Statement) jdbc.getConnection().createStatement();
        ResultSet resultSetSelectSinyalOutputDeltaV13 = statementSelectSinyalOutputDeltaV13.executeQuery(sqlSelectSinyalOutputDeltaV13);

        while (resultSetSelectSinyalOutputDeltaV13.next()) {
            Object[] objectSetSelectSinyalOutputDeltaV13 = new Object[38];
            objectSetSelectSinyalOutputDeltaV13[0] = resultSetSelectSinyalOutputDeltaV13.getString("dokumen_ke");
            objectSetSelectSinyalOutputDeltaV13[1] = resultSetSelectSinyalOutputDeltaV13.getString("v11");
            objectSetSelectSinyalOutputDeltaV13[2] = resultSetSelectSinyalOutputDeltaV13.getString("v21");
            objectSetSelectSinyalOutputDeltaV13[3] = resultSetSelectSinyalOutputDeltaV13.getString("v31");
            objectSetSelectSinyalOutputDeltaV13[4] = resultSetSelectSinyalOutputDeltaV13.getString("v41");
            objectSetSelectSinyalOutputDeltaV13[5] = resultSetSelectSinyalOutputDeltaV13.getString("v51");
            objectSetSelectSinyalOutputDeltaV13[6] = resultSetSelectSinyalOutputDeltaV13.getString("v61");

            objectSetSelectSinyalOutputDeltaV13[7] = resultSetSelectSinyalOutputDeltaV13.getString("v12");
            objectSetSelectSinyalOutputDeltaV13[8] = resultSetSelectSinyalOutputDeltaV13.getString("v22");
            objectSetSelectSinyalOutputDeltaV13[9] = resultSetSelectSinyalOutputDeltaV13.getString("v32");
            objectSetSelectSinyalOutputDeltaV13[10] = resultSetSelectSinyalOutputDeltaV13.getString("v42");
            objectSetSelectSinyalOutputDeltaV13[11] = resultSetSelectSinyalOutputDeltaV13.getString("v52");
            objectSetSelectSinyalOutputDeltaV13[12] = resultSetSelectSinyalOutputDeltaV13.getString("v62");

            objectSetSelectSinyalOutputDeltaV13[13] = resultSetSelectSinyalOutputDeltaV13.getString("v13");
            objectSetSelectSinyalOutputDeltaV13[14] = resultSetSelectSinyalOutputDeltaV13.getString("v23");
            objectSetSelectSinyalOutputDeltaV13[15] = resultSetSelectSinyalOutputDeltaV13.getString("v33");
            objectSetSelectSinyalOutputDeltaV13[16] = resultSetSelectSinyalOutputDeltaV13.getString("v43");
            objectSetSelectSinyalOutputDeltaV13[17] = resultSetSelectSinyalOutputDeltaV13.getString("v53");
            objectSetSelectSinyalOutputDeltaV13[18] = resultSetSelectSinyalOutputDeltaV13.getString("v63");

            objectSetSelectSinyalOutputDeltaV13[19] = resultSetSelectSinyalOutputDeltaV13.getString("v14");
            objectSetSelectSinyalOutputDeltaV13[20] = resultSetSelectSinyalOutputDeltaV13.getString("v24");
            objectSetSelectSinyalOutputDeltaV13[21] = resultSetSelectSinyalOutputDeltaV13.getString("v34");
            objectSetSelectSinyalOutputDeltaV13[22] = resultSetSelectSinyalOutputDeltaV13.getString("v44");
            objectSetSelectSinyalOutputDeltaV13[23] = resultSetSelectSinyalOutputDeltaV13.getString("v54");
            objectSetSelectSinyalOutputDeltaV13[24] = resultSetSelectSinyalOutputDeltaV13.getString("v64");

            objectSetSelectSinyalOutputDeltaV13[25] = resultSetSelectSinyalOutputDeltaV13.getString("v15");
            objectSetSelectSinyalOutputDeltaV13[26] = resultSetSelectSinyalOutputDeltaV13.getString("v25");
            objectSetSelectSinyalOutputDeltaV13[27] = resultSetSelectSinyalOutputDeltaV13.getString("v35");
            objectSetSelectSinyalOutputDeltaV13[28] = resultSetSelectSinyalOutputDeltaV13.getString("v45");
            objectSetSelectSinyalOutputDeltaV13[29] = resultSetSelectSinyalOutputDeltaV13.getString("v55");
            objectSetSelectSinyalOutputDeltaV13[30] = resultSetSelectSinyalOutputDeltaV13.getString("v65");

            objectSetSelectSinyalOutputDeltaV13[31] = resultSetSelectSinyalOutputDeltaV13.getString("v16");
            objectSetSelectSinyalOutputDeltaV13[32] = resultSetSelectSinyalOutputDeltaV13.getString("v26");
            objectSetSelectSinyalOutputDeltaV13[33] = resultSetSelectSinyalOutputDeltaV13.getString("v36");
            objectSetSelectSinyalOutputDeltaV13[34] = resultSetSelectSinyalOutputDeltaV13.getString("v46");
            objectSetSelectSinyalOutputDeltaV13[35] = resultSetSelectSinyalOutputDeltaV13.getString("v56");
            objectSetSelectSinyalOutputDeltaV13[36] = resultSetSelectSinyalOutputDeltaV13.getString("v66");
            objectSetSelectSinyalOutputDeltaV13[37] = resultSetSelectSinyalOutputDeltaV13.getString("iterasi_ke");

            tbl13.addRow(objectSetSelectSinyalOutputDeltaV13);
        }
    }

    private void truncateW10() throws SQLException {
        try {
            String sqlTruncateBobot = "TRUNCATE tb_w";
            Statement statementTruncateBobot = (Statement) jdbc.getConnection().createStatement();
            statementTruncateBobot.executeUpdate(sqlTruncateBobot);

        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        String sqlInsertAcak = "INSERT INTO `tb_w` VALUES\n"
                + "(1, 0.451, 0.248233, -0.135561, -0.31332, -0.244401, -0.301978, 0.326706,0,0);";

        System.out.println(sqlInsertAcak);
        Statement statementInsertAcak = (Statement) jdbc.getConnection().createStatement();
        statementInsertAcak.executeUpdate(sqlInsertAcak);

    }

    private void truncateHitung9NilaiBiasAwal() throws SQLException {
        try {
            String sqlTruncateBobot = "TRUNCATE tb_9_nilai_bias_awal";
            Statement statementTruncateBobot = (Statement) jdbc.getConnection().createStatement();
            statementTruncateBobot.executeUpdate(sqlTruncateBobot);

        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        String sqlInsertNilaiBias = "INSERT INTO `tb_9_nilai_bias_awal` VALUES\n"
                + "(1, -0.0797596, 0.00347801, 0.668622, -0.256869, -0.258446, -0.576929,0,0);";
        //System.out.println(sqlInsertBobot);
        Statement statementInsertNilaiBias = (Statement) jdbc.getConnection().createStatement();
        statementInsertNilaiBias.executeUpdate(sqlInsertNilaiBias);
    }

    private void truncateHitungTable13() throws SQLException {
        try {
            String sqlTruncateBobot = "TRUNCATE tb_13";
            Statement statementTruncateBobot = (Statement) jdbc.getConnection().createStatement();
            statementTruncateBobot.executeUpdate(sqlTruncateBobot);

        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        List<Double> satu = new ArrayList<Double>();
        List<Double> dua = new ArrayList<Double>();
        List<Double> tiga = new ArrayList<Double>();
        List<Double> empat = new ArrayList<Double>();
        List<Double> lima = new ArrayList<Double>();
        List<Double> enam = new ArrayList<Double>();

        //there is
        String sqlSelectAllNormalisasiHasil = "SELECT * FROM tb_16 ";
        Statement stNormalisasiHasil = (Statement) jdbc.getConnection().createStatement();
        ResultSet rsNormalisasiHasil = stNormalisasiHasil.executeQuery(sqlSelectAllNormalisasiHasil);

        while (rsNormalisasiHasil.next()) {
            Object[] oNormalisasiHasil = new Object[8];

            oNormalisasiHasil[0] = rsNormalisasiHasil.getString("data_ke");
            oNormalisasiHasil[1] = rsNormalisasiHasil.getString("z_net1");
            oNormalisasiHasil[2] = rsNormalisasiHasil.getString("z_net2");
            oNormalisasiHasil[3] = rsNormalisasiHasil.getString("z_net3");
            oNormalisasiHasil[4] = rsNormalisasiHasil.getString("z_net4");
            oNormalisasiHasil[5] = rsNormalisasiHasil.getString("z_net5");
            oNormalisasiHasil[6] = rsNormalisasiHasil.getString("z_net6");

            satu.add(Double.parseDouble(oNormalisasiHasil[1].toString()));
            dua.add(Double.parseDouble(oNormalisasiHasil[2].toString()));
            tiga.add(Double.parseDouble(oNormalisasiHasil[3].toString()));
            empat.add(Double.parseDouble(oNormalisasiHasil[4].toString()));
            lima.add(Double.parseDouble(oNormalisasiHasil[5].toString()));
            enam.add(Double.parseDouble(oNormalisasiHasil[6].toString()));

        }

        String sqlInsertBobot = "INSERT INTO `tb_13` VALUES (\n"
                + "    1,\n"
                + Double.parseDouble(satu.get(0).toString()) + ",\n"
                + Double.parseDouble(dua.get(0).toString()) + ",\n"
                + Double.parseDouble(tiga.get(0).toString()) + ",\n"
                + Double.parseDouble(empat.get(0).toString()) + ",\n"
                + Double.parseDouble(lima.get(0).toString()) + ",\n"
                + Double.parseDouble(enam.get(0).toString()) + ",\n"
                + Double.parseDouble(satu.get(1).toString()) + ",\n"
                + Double.parseDouble(dua.get(1).toString()) + ",\n"
                + Double.parseDouble(tiga.get(1).toString()) + ",\n"
                + Double.parseDouble(empat.get(1).toString()) + ",\n"
                + Double.parseDouble(lima.get(1).toString()) + ",\n"
                + Double.parseDouble(enam.get(1).toString()) + ",\n"
                + Double.parseDouble(satu.get(2).toString()) + ",\n"
                + Double.parseDouble(dua.get(2).toString()) + ",\n"
                + Double.parseDouble(tiga.get(2).toString()) + ",\n"
                + Double.parseDouble(empat.get(2).toString()) + ",\n"
                + Double.parseDouble(lima.get(2).toString()) + ",\n"
                + Double.parseDouble(enam.get(2).toString()) + ",\n"
                + Double.parseDouble(satu.get(3).toString()) + ",\n"
                + Double.parseDouble(dua.get(3).toString()) + ",\n"
                + Double.parseDouble(tiga.get(3).toString()) + ",\n"
                + Double.parseDouble(empat.get(3).toString()) + ",\n"
                + Double.parseDouble(lima.get(3).toString()) + ",\n"
                + Double.parseDouble(enam.get(3).toString()) + ",\n"
                + Double.parseDouble(satu.get(4).toString()) + ",\n"
                + Double.parseDouble(dua.get(4).toString()) + ",\n"
                + Double.parseDouble(tiga.get(4).toString()) + ",\n"
                + Double.parseDouble(empat.get(4).toString()) + ",\n"
                + Double.parseDouble(lima.get(4).toString()) + ",\n"
                + Double.parseDouble(enam.get(4).toString()) + ",\n"
                + Double.parseDouble(satu.get(5).toString()) + ",\n"
                + Double.parseDouble(dua.get(5).toString()) + ",\n"
                + Double.parseDouble(tiga.get(5).toString()) + ",\n"
                + Double.parseDouble(empat.get(5).toString()) + ",\n"
                + Double.parseDouble(lima.get(5).toString()) + ",\n"
                + Double.parseDouble(enam.get(5).toString()) + ",\n"
                + "0" + ",\n"
                + "0" + ")";

        System.out.println(sqlInsertBobot);
        Statement statementInsertBobot = (Statement) jdbc.getConnection().createStatement();
        statementInsertBobot.executeUpdate(sqlInsertBobot);

    }

    private void hitungFeedForwardShow() throws SQLException {
        try {
            String sqlTruncateBobot = "TRUNCATE tb_feedforward";
            Statement statementTruncateBobot = (Statement) jdbc.getConnection().createStatement();
            statementTruncateBobot.executeUpdate(sqlTruncateBobot);

        } catch (SQLException ex) {
            Logger.getLogger(AcakBobot.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 1; i <= iterMaxx; i++) {

            String sqlSelectSinyalOutputSegitigaBias = "SELECT * FROM tb_9_nilai_bias_awal,tb_normalisasi,tb_13 "
                    + "where tb_9_nilai_bias_awal.data_ke = tb_normalisasi.id "
                    + "and"
                    + " tb_13.data_ke = tb_9_nilai_bias_awal.data_ke";
            Statement statementSelectSinyalOutputSegitigaBias = (Statement) jdbc.getConnection().createStatement();
            ResultSet resultSetSelectSinyalOutputSegitigaBias = statementSelectSinyalOutputSegitigaBias.executeQuery(sqlSelectSinyalOutputSegitigaBias);

            System.out.println(sqlSelectSinyalOutputSegitigaBias);

            double z_net1, z_net2, z_net3, z_net4, z_net5, z_net6;

            while (resultSetSelectSinyalOutputSegitigaBias.next()) {
                Object[] objectSetSelectSinyalOutputSegitigaBias = new Object[8];

                //=CZ64+(B65*DG64)+(C65*DM64)+(D65*DS64)+(E65*DY64)+(F65*EE64)+(G65*EK64)
                z_net1 = Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("deltav10"))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kbplus")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v11")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kkplus")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v12")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("ksplus")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v13")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kbmin")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v14")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kkmin")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v15")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("ksmin")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v16")));

                z_net2 = Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("deltav20"))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kbplus")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v21")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kkplus")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v22")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("ksplus")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v23")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kbmin")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v24")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kkmin")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v25")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("ksmin")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v26")));

                z_net3 = Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("deltav30"))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kbplus")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v31")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kkplus")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v32")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("ksplus")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v33")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kbmin")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v34")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kkmin")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v35")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("ksmin")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v36")));

                z_net4 = Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("deltav40"))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kbplus")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v41")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kkplus")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v42")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("ksplus")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v43")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kbmin")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v44")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kkmin")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v45")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("ksmin")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v46")));

                z_net5 = Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("deltav50"))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kbplus")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v51")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kkplus")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v52")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("ksplus")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v53")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kbmin")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v54")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kkmin")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v55")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("ksmin")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v56")));

                z_net6 = Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("deltav60"))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kbplus")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v61")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kkplus")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v62")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("ksplus")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v63")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kbmin")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v64")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("kkmin")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v65")))
                        + (Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("ksmin")) * Double.parseDouble(resultSetSelectSinyalOutputSegitigaBias.getString("v66")));

                String sqlInsertBobotAcak = "INSERT INTO `tb_feedforward` (`data_ke`, `z_net1`, `z_net2`, `z_net3`, `z_net4`, `z_net5`, `z_net6`, `dokumen_ke`, `iterasi_ke`) VALUES\n"
                        + "(NULL,"
                        + "'" + z_net1 + "',"
                        + "'" + z_net2 + "',"
                        + "'" + z_net3 + "',"
                        + "'" + z_net4 + "',"
                        + "'" + z_net5 + "',"
                        + "'" + z_net6 + "',"
                        + "" + resultSetSelectSinyalOutputSegitigaBias.getString("data_ke") + ","
                        + "" + i + ")";
                System.out.println(sqlInsertBobotAcak);
                Statement statementInsertBobotAcak = (Statement) jdbc.getConnection().createStatement();
                statementInsertBobotAcak.executeUpdate(sqlInsertBobotAcak);

                objectSetSelectSinyalOutputSegitigaBias[0] = resultSetSelectSinyalOutputSegitigaBias.getString("data_ke");
                objectSetSelectSinyalOutputSegitigaBias[1] = z_net1;
                objectSetSelectSinyalOutputSegitigaBias[2] = z_net2;
                objectSetSelectSinyalOutputSegitigaBias[3] = z_net3;
                objectSetSelectSinyalOutputSegitigaBias[4] = z_net4;
                objectSetSelectSinyalOutputSegitigaBias[5] = z_net5;
                objectSetSelectSinyalOutputSegitigaBias[6] = z_net6;
                objectSetSelectSinyalOutputSegitigaBias[7] = i;

                tblFeedforward.addRow(objectSetSelectSinyalOutputSegitigaBias);
            }
        }
    }
}
