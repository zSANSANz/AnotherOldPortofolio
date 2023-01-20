<?php

include "koneksi/koneksi.php";

session_start();

if(!isset($_SESSION['login_user'])){
    header("location:login.php");
}

include("utility/header.php");

?>
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

                            <h1> CARA PENGGUNAAN </h1>

                            <p class="text-muted">1. SIAPKAN DATA YANG AKAN DIUPLOAD DENGAN FORMAT .TXT</p>

                            <p class="text-muted"> 2. TEKAN MENU UPLOAD DATA, KEMUDIAN PILIH DATA  (.TXT) YANG AKAN DIMASUKAN</p>

                            <p class="text-muted">3. KEMUDIAN  PADA  PEMROSESAN AWAL, PILIH TOMBOL UNTUK MASING-MASING FUNGSI (TOKENIZE, STOPWORD REMOVAL      DAN STEMMING)</p>

                            <p class="text-muted">4. SETELAH DILAKUKAN PEMROSESAN AWAL KEMUDIAN DILAKUKAN PROSES KLASIFIKASI DENGAN MENGGUNAKAN TOMBOL NAIVE BAYES CLASSIFIER, MAKA AKAN TERLIHAT HASIL UNTUK NILAI DARI DOKUMEN TERSEBUT, APAKAH TERMASUK KEDALAM KATEGORI POSITIF ATAU NEGATIF (DIPILIH BERDASARKAN NILAI TERBESAR)</p>

                            <p class="text-muted">5. TAMPILAN GRAFIK BERDASARKAN NILAI AKURASI DLL</p>
                        </div>
                    </div>

                </div>
                <!-- End of Row -->




            
<?php include("utility/footer.php"); ?>