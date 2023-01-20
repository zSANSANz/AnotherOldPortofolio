<?php

include "../koneksi/koneksi.php";

$sql = "SELECT * FROM tb_dokumen ORDER BY id_dokumen ASC";
$result = $conn->query($sql);


if ($result->num_rows > 0) {
    //output data of each row
    while ($row = $result->fetch_assoc()) {

        $munafik = substr_count(strtolower($row["deskripsi_dokumen"]), "munafik");
        $dukung = substr_count(strtolower($row["deskripsi_dokumen"]), "dukung");
        $maju = substr_count(strtolower($row["deskripsi_dokumen"]), "maju");
        $jelek = substr_count(strtolower($row["deskripsi_dokumen"]), "jelek");
        $kecewa = substr_count(strtolower($row["deskripsi_dokumen"]), "kecewa");

        $sqlUpdateMunafik = "UPDATE tb_dokumen SET munafik=".$munafik." WHERE id_dokumen=".$row['id_dokumen'];
        //echo $sqlUpdateMunafik;
        mysqli_query($conn, $sqlUpdateMunafik);

        $sqlUpdateDukung = "UPDATE tb_dokumen SET dukung=".$dukung." WHERE id_dokumen=".$row['id_dokumen'];
        //echo $sqlUpdateMunafik;
        mysqli_query($conn, $sqlUpdateDukung);

        $sqlUpdateMaju = "UPDATE tb_dokumen SET maju=".$maju." WHERE id_dokumen=".$row['id_dokumen'];
        //echo $sqlUpdateMunafik;
        mysqli_query($conn, $sqlUpdateMaju);

        $sqlUpdateJelek = "UPDATE tb_dokumen SET jelek=".$jelek." WHERE id_dokumen=".$row['id_dokumen'];
        //echo $sqlUpdateMunafik;
        mysqli_query($conn, $sqlUpdateJelek);

        $sqlUpdateKecewa = "UPDATE tb_dokumen SET kecewa=".$kecewa." WHERE id_dokumen=".$row['id_dokumen'];
        //echo $sqlUpdateMunafik;
        mysqli_query($conn, $sqlUpdateKecewa);

        header("Location:" . "../dokumenReadMining.php");
        
    }
}
else {
    echo "0 results";
}

$conn->close();