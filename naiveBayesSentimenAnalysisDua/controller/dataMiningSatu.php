<?php

include "koneksi/koneksi.php";

$sqlHasil = "TRUNCATE table tb_dokumen_hasil";
$conn->query($sqlHasil);

