<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
    <meta name="author" content="Coderthemes">

    <link rel="shortcut icon" href="assets/adminto-14/Admin/Light/assets/images/favicon.ico">

    <title>Adminto - Responsive Admin Dashboard Template</title>

    <!--Morris Chart CSS -->
    <link rel="stylesheet" href="assets/adminto-14/Admin/Light/assets/plugins/morris/morris.css">

    <!-- App css -->
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

<body class="fixed-left">

<!-- Begin page -->
<div id="wrapper">

    <!-- Top Bar Start -->
    <div class="topbar">

        <!-- LOGO -->
        <div class="topbar-left">
            <a href="index.html" class="logo"><span>NBC<span></span></span><i class="zmdi zmdi-layers"></i></a>
        </div>

        <!-- Button mobile view to collapse sidebar menu -->
        <div class="navbar navbar-default" role="navigation">
            <div class="container">

                <!-- Page title -->
                <ul class="nav navbar-nav navbar-left">
                    <li>
                        <button class="button-menu-mobile open-left">
                            <i class="zmdi zmdi-menu"></i>
                        </button>
                    </li>

                </ul>


            </div><!-- end container -->
        </div><!-- end navbar -->
    </div>
    <!-- Top Bar End -->


    <!-- ========== Left Sidebar Start ========== -->
    <div class="left side-menu">
        <div class="sidebar-inner slimscrollleft">

            <!-- User -->
            <div class="user-box">
                <div class="user-img">
                    <img src="assets/adminto-14/Admin/Light/assets/images/users/avatar-1.png" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive">
                    <div class="user-status offline"><i class="zmdi zmdi-dot-circle"></i></div>
                </div>
                <h5><a href="#">Twitter</a> </h5>

            </div>
            <!-- End User -->

            <!--- Sidemenu -->
            <div id="sidebar-menu">
                <ul>

                    <li>
                        <a href="index.php" class="waves-effect"><i class="zmdi zmdi-view-dashboard"></i> <span> Cara Penggunaan </span> </a>
                    </li>

                    <li>
                        <a href="dokumenUpload.php" class="waves-effect"><i class="zmdi zmdi-format-underlined"></i> <span> Upload Data </span> <span class="label label-warning pull-right">U</span></a>
                    </li>

                    <li class="has_sub">
                        <a href="dokumenRead.php" class="waves-effect"><i class="zmdi zmdi-invert-colors"></i> <span> Lihat Data </span> </a>

                    </li>

                    <li class="has_sub">
                        <a href="dokumenMining.php" class="waves-effect"><i class="zmdi zmdi-collection-text"></i><span> Pemrosesan Data </span><span class="menu-arrow"></span> </a>

                    </li>

                    <li class="has_sub">
                        <a href="dataMining.php" class="waves-effect"><i class="zmdi zmdi-view-list"></i> <span> Naive Bayes Classifier </span> </a>

                    </li>

                    <li class="has_sub">
                        <a href="dokumenHasil.php" class="waves-effect"><i class="glyphicon glyphicon-eye-open"></i> <span> Data Hasil </span> </a>

                    </li>

                    <li class="has_sub">
                        <a href="grafik.php" class="waves-effect"><i class="zmdi zmdi-chart"></i><span> Grafik </span> </a>

                    </li>

                    <li class="has_sub">
                        <a href="logout.php" class="waves-effect"><i class="zmdi zmdi-power"></i><span> Log Out </span> </a>

                    </li>


                </ul>
                <div class="clearfix"></div>
            </div>
            <!-- Sidebar -->
            <div class="clearfix"></div>

        </div>

    </div>
    <!-- Left Sidebar End -->



        