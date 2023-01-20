<?php
/**
 * Created by PhpStorm.
 * User: heroes-4
 * Date: 1/1/2017
 * Time: 4:27 PM
 */
include "koneksi/koneksi.php";


for ($i = 1; $i <= 29000; $i++) {

    $sql = "INSERT INTO tb_stopword(id_stopword, deskripsi_stopword) VALUES (NULL, '')";

    $conn->query($sql);

}