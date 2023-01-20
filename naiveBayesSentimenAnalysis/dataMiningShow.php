<?php

include "koneksi/koneksi.php";

$sqlTruncateTabelJumlahKataPositif = "TRUNCATE tb_jumlah_kata_positif";
$conn->query($sqlTruncateTabelJumlahKataPositif);

$sqlSelectStemming = "SELECT * FROM tb_remove_duplikat WHERE kelas_remove_duplikat = 0";
$resultSelectStemming = $conn->query($sqlSelectStemming);

$hasil_perkalian_class_positif = 0;

if ($resultSelectStemming->num_rows > 0) {
    //output data of each row
    while ($rowSelectStemming = $resultSelectStemming->fetch_assoc()) {

        $kataPositif = 0;
        $sql = "SELECT * FROM tb_dokumen WHERE kelas_dokumen = 1 ORDER BY id_dokumen ASC";
        $result = $conn->query($sql);
        if ($result->num_rows > 0) {
            //output data of each row
            while ($row = $result->fetch_assoc()) {

                $kata = substr_count(strtolower($row["deskripsi_dokumen"]), $rowSelectStemming["deskripsi_remove_duplikat"]);
                //echo $row["deskripsi_dokumen"] . " " . $rowSelectStemming["deskripsi_remove_duplikat"];

                if ($kata == 1) {
                    $kataPositif = $kataPositif + 1;

                }
            }
            //echo $kataPositif;
            $sqlInsertJumlahKataPositif = "INSERT INTO tb_jumlah_kata_positif VALUES(NULL, '" . $rowSelectStemming["deskripsi_remove_duplikat"] . "','" . $kataPositif . "') ";
            mysqli_query($conn, $sqlInsertJumlahKataPositif);

            $sqlCountPositif = "SELECT COUNT(id_dokumen) as count_positif FROM tb_dokumen WHERE kelas_dokumen = 1";
            $resultCountPositif = $conn->query($sqlCountPositif);
            if ($resultCountPositif->num_rows > 0) {
                while ($rowCountPositif = $resultCountPositif->fetch_assoc()) {
                    $CountPositif[0] = $rowCountPositif["count_positif"];
                    $probabilitasPositif = $CountPositif[0];
                    $class_positif = $kataPositif / $CountPositif[0];

                    if ($hasil_perkalian_class_positif == 0) {
                        $hasil_perkalian_class_positif = $class_positif;
                    } else {
                        $hasil_perkalian_class_positif = $hasil_perkalian_class_positif * $class_positif;
                    }


                    echo " (" . $kataPositif . " / " . $CountPositif[0] . ") " . " = " . $hasil_perkalian_class_positif . " <br/> X ";

                }
            }

        }
    }
} else {
    //echo "0 results";
}

echo "<br /><br /><br />";

$sqlTruncateTabelJumlahKataNegatif = "TRUNCATE tb_jumlah_kata_negatif";
$conn->query($sqlTruncateTabelJumlahKataNegatif);

$sqlSelectStemming = "SELECT * FROM tb_remove_duplikat WHERE kelas_remove_duplikat = 0";
$resultSelectStemming = $conn->query($sqlSelectStemming);

$hasil_perkalian_class_negatif = 0;

if ($resultSelectStemming->num_rows > 0) {
    //output data of each row
    while ($rowSelectStemming = $resultSelectStemming->fetch_assoc()) {

        $kataNegatif = 0;
        $sql = "SELECT * FROM tb_dokumen WHERE kelas_dokumen = -1 ORDER BY id_dokumen ASC";
        $result = $conn->query($sql);
        if ($result->num_rows > 0) {
            //output data of each row
            while ($row = $result->fetch_assoc()) {

                $kata = substr_count(strtolower($row["deskripsi_dokumen"]), $rowSelectStemming["deskripsi_remove_duplikat"]);
                //echo $row["deskripsi_dokumen"] . " " . $rowSelectStemming["deskripsi_remove_duplikat"];

                if ($kata == 1) {
                    $kataNegatif = $kataNegatif + 1;

                }
            }

            $sqlInsertJumlahKataNegatif = "INSERT INTO tb_jumlah_kata_negatif VALUES(NULL, '" . $rowSelectStemming["deskripsi_remove_duplikat"] . "','" . $kataNegatif . "') ";
            mysqli_query($conn, $sqlInsertJumlahKataNegatif);

            $sqlCountNegatif = "SELECT COUNT(id_dokumen) as count_negatif FROM tb_dokumen WHERE kelas_dokumen = -1";
            $resultCountNegatif = $conn->query($sqlCountNegatif);
            if ($resultCountNegatif->num_rows > 0) {
                while ($rowCountNegatif = $resultCountNegatif->fetch_assoc()) {
                    $CountNegatif[0] = $rowCountNegatif["count_negatif"];
                    $probabilitasNegatif = $CountNegatif[0];
                    $class_negatif = $kataNegatif / $CountNegatif[0];

                    if ($hasil_perkalian_class_negatif == 0) {
                        $hasil_perkalian_class_negatif = $class_negatif;
                    } else {
                        $hasil_perkalian_class_negatif = $hasil_perkalian_class_negatif * $class_negatif;
                    }


                    echo " (" . $kataNegatif . " / " . $CountNegatif[0] . ") " . " = " . $hasil_perkalian_class_negatif . " <br/> X ";

                }
            }
        }
    }
} else {
    //echo "0 results";
}

echo "<br /><br /><br />";

echo " " . $probabilitasNegatif . "/" . "(" . $probabilitasNegatif . " + " . $probabilitasPositif . ") = ";
echo " " . $probabilitasNegatif / ($probabilitasNegatif + $probabilitasPositif) . "<br/>";
echo " " . $probabilitasPositif . "/" . "(" . $probabilitasNegatif . " + " . $probabilitasPositif . ") = ";
echo " " . $probabilitasPositif / ($probabilitasNegatif + $probabilitasPositif) . "<br/>";

echo "<br/><br/>";
echo "3.a probabilitas posterior untuk positif<br/>";

echo " " . $hasil_perkalian_class_positif . " X " . $probabilitasPositif / ($probabilitasNegatif + $probabilitasPositif) . " / " . ($probabilitasNegatif + $probabilitasPositif) . " = ";
echo " " . ($hasil_perkalian_class_positif * ($probabilitasPositif / ($probabilitasNegatif + $probabilitasPositif))) / ($probabilitasNegatif + $probabilitasPositif);


echo "<br/><br/>";

echo "3.b probabilitas posterior untuk negatif<br/>";


echo " " . $hasil_perkalian_class_negatif . " X " . $probabilitasNegatif / ($probabilitasNegatif + $probabilitasPositif) . " / " . ($probabilitasNegatif + $probabilitasPositif) . " = ";
echo " " . ($hasil_perkalian_class_negatif * ($probabilitasNegatif / ($probabilitasNegatif + $probabilitasPositif))) / ($probabilitasNegatif + $probabilitasPositif);


echo "<br/><br/>";
echo "<br/><br/>";

?>

<?php //include("utility/header.php"); ?>


    <!-- ============================================================== -->
    <!-- Start right Content here -->
    <!-- ============================================================== -->
    <div class="content-page">
    <!-- Start content -->
    <div class="content">
    <div class="container">

    <!-- Row start -->
    <div class="row">
        <div class="col-md-12">
            <div class="card-box">

                <h4 class="header-title m-t-0 m-b-30">Klasifikasi Naive Bayes Classifier</h4>
                <table id="datatable" class="table table-striped table-bordered">
                    <thead>
                    <tr>

                        <th>Tweets</th>
                        <th>Positif</th>
                        <th>Negatif</th>
                        <th>Hasil</th>

                    </tr>
                    </thead>

                    <tbody>
                    <?php

                    $sqlSelectDokumenDua = "SELECT * FROM tb_dokumen WHERE kelas_dokumen = 0 ORDER BY id_dokumen DESC";
                    $resultSelectDokumenDua = $conn->query($sqlSelectDokumenDua);

                    if ($resultSelectDokumenDua->num_rows > 0) {
                        //output data of each row
                        while ($rowSelectDokumenDua = $resultSelectDokumenDua->fetch_assoc()) {

                            ?>
                            <tr>

                                <td>
                                    <?php echo $rowSelectDokumenDua ["deskripsi_dokumen"]; ?>
                                </td>
                                <td>
                                    <?php echo $positif = ($hasil_perkalian_class_positif * ($probabilitasPositif / ($probabilitasNegatif + $probabilitasPositif))) / ($probabilitasNegatif + $probabilitasPositif); ?>
                                </td>
                                <td>
                                    <?php echo $negatif = ($hasil_perkalian_class_negatif * ($probabilitasNegatif / ($probabilitasNegatif + $probabilitasPositif))) / ($probabilitasNegatif + $probabilitasPositif); ?>
                                </td>
                                <td>
                                    <?php
                                    if ($rowSelectDokumenDua ["kelas_dokumen"] == 0) {
                                        if (($positif <= $negatif) || ($negatif == 0)) {
                                            echo "Positif";
                                            //                                    echo $sqlUpdateHasil = "UPDATE tb_dokumen SET kelas_dokumen = 1 WHERE id_dokumen = " . $rowSelectDokumenDua ["id_dokumen"];
//                                    $conn->query($sqlUpdateHasil);

                                        } else if (($positif >= $negatif) || ($positif == 0)) {
                                            echo "Negatif";
                                            //                                    echo $sqlUpdateHasil = "UPDATE tb_dokumen SET kelas_dokumen = -1 WHERE id_dokumen = " . $rowSelectDokumenDua ["id_dokumen"];
//                                    $conn->query($sqlUpdateHasil);

                                        }

                                    } else {
                                        echo "tidak ada dokumen yang belum di beri label";

                                        echo "<br/><br/>";

                                    }
                                    ?>
                                </td>
                            </tr>


                            <?php
                        }
                    } else {
                        // echo "0 results";
                    }


                    //$conn->close();
                    ?>


                    </tbody>
                </table>
            </div>
        </div><!-- end col -->
    </div>
    <!-- end row -->

<?php include("utility/footer.php"); ?>