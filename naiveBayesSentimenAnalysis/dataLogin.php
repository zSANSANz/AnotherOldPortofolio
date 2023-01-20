<?php
/**
 * Created by PhpStorm.
 * User: heroes-4
 * Date: 1/1/2017
 * Time: 2:46 PM
 */

include "koneksi/koneksi.php";

session_start();

$myusername = mysqli_real_escape_string($conn, $_POST['username']);
$mypassword = mysqli_real_escape_string($conn, $_POST['password']);

$sql = "SELECT username FROM tb_user WHERE username = '$myusername' and password = '$mypassword'";
$result = $conn->query($sql);
if ($result->num_rows > 0) {
//output data of each row


    $_SESSION['login_user'] = $myusername;
    header("location: index.php");

} else {

    ?>



    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
        <meta name="author" content="Coderthemes">

        <!-- App Favicon -->
        <link rel="shortcut icon" href="assets/adminto-14/Admin/Light/assets/images/favicon.ico">

        <!-- App title -->
        <title>Naive Bayes Classivier - Login</title>

        <!-- App CSS -->
        <link href="assets/adminto-14/Admin/Light/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="assets/adminto-14/Admin/Light/assets/css/core.css" rel="stylesheet" type="text/css" />
        <link href="assets/adminto-14/Admin/Light/assets/css/components.css" rel="stylesheet" type="text/css" />
        <link href="assets/adminto-14/Admin/Light/assets/css/icons.css" rel="stylesheet" type="text/css" />
        <link href="assets/adminto-14/Admin/Light/assets/css/pages.css" rel="stylesheet" type="text/css" />
        <link href="assets/adminto-14/Admin/Light/assets/css/menu.css" rel="stylesheet" type="text/css" />
        <link href="assets/adminto-14/Admin/Light/assets/css/responsive.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shiv and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->

        <script src="assets/adminto-14/Admin/Light/assets/js/modernizr.min.js"></script>

    </head>
    <body>

    <div class="account-pages"></div>
    <div class="clearfix"></div>
    <div class="wrapper-page">
        <div class="ex-page-content text-center">
            <div class="text-error">ERROR</div>
            <h3 class="text-uppercase font-600">Invalid Login</h3>
            <p class="text-muted">
                Username atau Password yang anda Masukkan Salah
            </p>
            <br>
            <a class="btn btn-success waves-effect waves-light" href="login.php">Kembali</a>

        </div>
    </div>
    <!-- End wrapper page -->

    <script>
        var resizefunc = [];
    </script>

    <!-- jQuery  -->
    <script src="assets/adminto-14/Admin/Light/assets/js/jquery.min.js"></script>
    <script src="assets/adminto-14/Admin/Light/assets/js/bootstrap.min.js"></script>
    <script src="assets/adminto-14/Admin/Light/assets/js/detect.js"></script>
    <script src="assets/adminto-14/Admin/Light/assets/js/fastclick.js"></script>
    <script src="assets/adminto-14/Admin/Light/assets/js/jquery.slimscroll.js"></script>
    <script src="assets/adminto-14/Admin/Light/assets/js/jquery.blockUI.js"></script>
    <script src="assets/adminto-14/Admin/Light/assets/js/waves.js"></script>
    <script src="assets/adminto-14/Admin/Light/assets/js/wow.min.js"></script>
    <script src="assets/adminto-14/Admin/Light/assets/js/jquery.nicescroll.js"></script>
    <script src="assets/adminto-14/Admin/Light/assets/js/jquery.scrollTo.min.js"></script>

    <!-- App js -->
    <script src="assets/adminto-14/Admin/Light/assets/js/jquery.core.js"></script>
    <script src="assets/adminto-14/Admin/Light/assets/js/jquery.app.js"></script>

    </body>
    </html>












<?php

}


?>

