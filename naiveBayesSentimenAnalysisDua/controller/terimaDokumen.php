<?php

include "../koneksi/koneksi.php";

$dokumen = $_POST['dokumen'];
$class = $_POST['class'];

$sql = "INSERT INTO tb_dokumen(id_dokumen, deskripsi_dokumen, munafik, dukung, maju, jelek, kecewa, class) VALUES (NULL, '".$dokumen."', 0, 0, 0, 0, 0, ".$class.")";

//echo $sql;

if ($conn->query($sql) === TRUE) {
    header("Location:" . "../dokumenRead.php");
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();

?>