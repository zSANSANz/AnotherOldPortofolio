<?php
/**
 * Created by PhpStorm.
 * User: heroes-4
 * Date: 12/25/2016
 * Time: 12:56 PM
 */

include("utility/header.php");


?>

<div class="wrapper">
    <div class="container">


        <div class="row">
            <div class="col-sm-12">
                <div class="card-box table-responsive">


                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card-box">
                                <a href="#1dataTableTokenizing"
                                   class="btn btn-danger waves-effect w-md waves-light m-b-5">Tokenizing</a>
                                <a href="#1dataTableFiltering"
                                   class="btn btn-success waves-effect w-md waves-light m-b-5">Filtering</a>
                                <a href="#1dataTableRemoveDuplikat"
                                   class="btn btn-primary waves-effect w-md waves-light m-b-5">Stemming</a>
                            </div>
                        </div><!-- end col -->
                    </div>
                    <!-- end row -->

                </div>
            </div><!-- end col -->
        </div>
        <!-- end row -->

        <?php

        include "koneksi/koneksi.php";

        $sqlTruncateCaseFolding = "TRUNCATE tb_case_folding";
        $conn->query($sqlTruncateCaseFolding);
        $sqlTruncateTokenizing = "TRUNCATE tb_tokenizing";
        $conn->query($sqlTruncateTokenizing);
        $sqlTruncateFiltering = "TRUNCATE tb_filtering";
        $conn->query($sqlTruncateFiltering);
        $sqlTruncateStemming = "TRUNCATE tb_stemming";
        $conn->query($sqlTruncateStemming);
        $sqlTruncateRemoveDuplikat = "TRUNCATE tb_remove_duplikat";
        $conn->query($sqlTruncateRemoveDuplikat);

        $sql = "SELECT * FROM tb_dokumen WHERE kelas_dokumen = 0 ORDER BY id_dokumen DESC";
        $result = $conn->query($sql);


        if ($result->num_rows > 0) {
            //output data of each row
            $i = 1;
            while ($row = $result->fetch_assoc()) {

                ?>

                <!--                    --><?php //echo $i; ?>
                <!---->
                <!--                    --><?php //echo $row["deskripsi_dokumen"]; ?>
                <!---->
                <!--                    --><?php
//
//                    if ($row["kelas_dokumen"] == 1) {
//                        echo "positif";
//                    } else if ($row["kelas_dokumen"] == -1) {
//                        echo "negatif";
//                    } else {
//                        echo "belum diketahui";
//                    }
//
//                    ?>

                <?php

                $sqlInsertCaseFolding = "INSERT INTO tb_case_folding VALUES(null,'" . strtolower($row["deskripsi_dokumen"]) . "'," . $row["kelas_dokumen"] . ")";

                $conn->query($sqlInsertCaseFolding);
                $i++;

            }
        } else {
            echo "0 results";
        }

        ?>




        <?php

        $sqlShowCaseFolding = "SELECT * FROM tb_case_folding";
        $resultShowCaseFolding = $conn->query($sqlShowCaseFolding);


        if ($resultShowCaseFolding->num_rows > 0) {
            //output data of each row
            $i = 1;
            while ($rowShowCaseFolding = $resultShowCaseFolding->fetch_assoc()) {

                ?>

                <!--                    --><?php //echo $i; ?><!----><?php //echo $rowShowCaseFolding["deskripsi_case_folding"]; ?>
                <!---->
                <!--                    --><?php
//
//                    if ($rowShowCaseFolding["kelas_case_folding"] == 1) {
//                        echo "positif";
//                    } else if ($rowShowCaseFolding["kelas_case_folding"] == -1) {
//                        echo "negatif";
//                    } else {
//                        echo "belum diketahui";
//                    }
//
//                    ?>

                <?php


                // include composer autoloader
                require_once __DIR__ . '/assets/tokenizer-master/vendor/autoload.php';

                $tokenizerFactory = new \Sastrawi\Tokenizer\TokenizerFactory();
                $tokenizer = $tokenizerFactory->createDefaultTokenizer();

                $tokens = $tokenizer->tokenize($rowShowCaseFolding["deskripsi_case_folding"]);

                for ($t = 0; $t < count($tokens); $t++) {
                    $sqlInsertTokenizing = "INSERT INTO tb_tokenizing VALUES(null,'" . $tokens[$t] . "'," . $rowShowCaseFolding["kelas_case_folding"] . ")";
                    $conn->query($sqlInsertTokenizing);
                }
                $i++;

            }
        } else {
            echo "0 results";
        }


        ?>


        <div class="row">
            <div class="col-sm-12">
                <div class="card-box table-responsive">

                    <h4 class="header-title m-t-0 m-b-30">Tokenizing</h4>
                    <table id="1dataTableTokenizing" class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>Tweets</th>

                        </tr>
                        </thead>

                        <tbody>
                        <?php

                        $sqlShowTokenizing = "SELECT * FROM tb_tokenizing ORDER BY id_tokenizing ASC";
                        $resultShowTokenizing = $conn->query($sqlShowTokenizing);


                        if ($resultShowTokenizing->num_rows > 0) {
                            //output data of each row
                            $i = 1;
                            while ($rowShowTokenizing = $resultShowTokenizing->fetch_assoc()) {

                                ?>

                                <tr>
                                    <td><?php echo $rowShowTokenizing["deskripsi_tokenizing"]; ?></td>


                                </tr>

                                <?php


                                $q = $rowShowTokenizing["deskripsi_tokenizing"];

                                $q = explode(" ", $q);
                                for ($i = 0; $i < count($q); $i++) {
                                    //$q[$i].'<p/>';// parsing
                                    $result = $conn->query("SELECT * FROM tb_katadasar WHERE katadasar = '$q[$i]'");
                                    if ($result->num_rows > 0) {// stopword removal
                                        $y[$i] = $q[$i];
                                    } else {
                                        $y[$i] = '';
                                    };
                                }
                                $q = implode(" ", $y);
                                //echo $q;

                                if ($q != "") {
                                    $sqlInsertFiltering = "INSERT INTO tb_filtering VALUES(null,'" . $q . "'," . $rowShowTokenizing["kelas_tokenizing"] . ")";
                                    //echo $sqlInsertFiltering;
                                    $conn->query($sqlInsertFiltering);
                                }
                                $i++;

                            }
                        } else {
                            echo "0 results";
                        }


                        ?>


                        </tbody>
                    </table>
                </div>
            </div><!-- end col -->
        </div>
        <!-- end row -->


        <div class="row">
            <div class="col-sm-12">
                <div class="card-box table-responsive">

                    <h4 class="header-title m-t-0 m-b-30">Filtering</h4>
                    <table id="1dataTableFiltering" class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>Tweets</th>


                        </tr>
                        </thead>

                        <tbody>
                        <?php

                        $sqlShowFiltering = "SELECT DISTINCT id_filtering,deskripsi_filtering,kelas_filtering FROM tb_filtering";
                        $resultShowFiltering = $conn->query($sqlShowFiltering);


                        if ($resultShowFiltering->num_rows > 0) {
                            //output data of each row
                            $i = 1;
                            while ($rowShowFiltering = $resultShowFiltering->fetch_assoc()) {

                                ?>

                                <tr>
                                    <td><?php echo $rowShowFiltering["deskripsi_filtering"]; ?></td>


                                </tr>

                                <?php


                                // Meload library Sastrawi
                                $stemmerFactory = new \Sastrawi\Stemmer\StemmerFactory();
                                $stemmer = $stemmerFactory->createStemmer();

                                // Menjalankan stemming pada kalimat yang ditentukan
                                $sentence = $rowShowFiltering["deskripsi_filtering"];
                                $output = $stemmer->stem($sentence);


                                $sqlInsertStemming = "INSERT INTO tb_stemming VALUES(null,'" . $output . "'," . $rowShowFiltering["kelas_filtering"] . ")";

                                $conn->query($sqlInsertStemming);
                                $i++;
                            }
                        } else {
                            echo "0 results";
                        }


                        ?>


                        </tbody>
                    </table>
                </div>
            </div><!-- end col -->
        </div>
        <!-- end row -->


        <?php

        $sqlShowStemming = "SELECT * FROM tb_stemming";
        $resultShowStemming = $conn->query($sqlShowStemming);


        if ($resultShowStemming->num_rows > 0) {
            //output data of each row
            $i = 1;
            while ($rowShowStemming = $resultShowStemming->fetch_assoc()) {

                ?>

                <!--                            --><?php //echo $i; ?>
                <!--                            --><?php //echo $rowShowStemming["deskripsi_stemming"]; ?>
                <!---->
                <!--                            --><?php
//
//                            if ($rowShowStemming["kelas_stemming"] == 1) {
//                                echo "positif";
//                            } else if ($rowShowStemming["kelas_stemming"] == -1) {
//                                echo "negatif";
//                            } else {
//                                echo "belum diketahui";
//                            }
//
//                            ?>

                <?php
                $i++;
            }

        }


        ?>


        <div class="row">
            <div class="col-sm-12">
                <div class="card-box table-responsive">

                    <h4 class="header-title m-t-0 m-b-30">Stemming</h4>
                    <table id="1dataTableRemoveDuplikat"
                           class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th>Deskripsi Dokumen</th>

                        </tr>
                        </thead>

                        <tbody>
                        <?php

                        $sqlShowDistinctStemming = "SELECT DISTINCT deskripsi_stemming, kelas_stemming from tb_stemming";
                        $resultShowDistinctStemming = $conn->query($sqlShowDistinctStemming);


                        if ($resultShowDistinctStemming->num_rows > 0) {
                            //output data of each row

                            while ($rowShowDistinctStemming = $resultShowDistinctStemming->fetch_assoc()) {

                                if ($rowShowDistinctStemming["deskripsi_stemming"] != "") {
                                    if ($rowShowDistinctStemming["kelas_stemming"] == 0) {
                                        $sqlInsertRemoveDuplikat = "INSERT INTO tb_remove_duplikat VALUES(null,'" . $rowShowDistinctStemming["deskripsi_stemming"] . "'," . $rowShowDistinctStemming["kelas_stemming"] . ")";

                                        $conn->query($sqlInsertRemoveDuplikat);
                                    }
                                }

                            }

                        }


                        ?>

                        <?php

                        $sqlShowRemoveDuplikat = "SELECT * FROM tb_remove_duplikat";
                        $resultShowRemoveDuplikat = $conn->query($sqlShowRemoveDuplikat);


                        if ($resultShowRemoveDuplikat->num_rows > 0) {
                            //output data of each row
                            $i = 1;
                            while ($rowShowRemoveDuplikat = $resultShowRemoveDuplikat->fetch_assoc()) {

                                ?>

                                <tr>
                                    <td><?php echo $rowShowRemoveDuplikat["deskripsi_remove_duplikat"]; ?></td>


                                </tr>

                                <?php
                                $i++;
                            }

                        }

                        $conn->close();

                        ?>

                        </tbody>
                    </table>
                </div>
            </div><!-- end col -->
        </div>
        <!-- end row -->

        <?php


        ?>
        <?php include("utility/footer.php"); ?>
