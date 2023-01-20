<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
    <meta name="author" content="Coderthemes">

    <link rel="shortcut icon" href="assets/adminto-14/Admin/Horizontal/assets/images/favicon.ico">

    <title>Naive Bayes Classivier Analisis Sentimen Radikal Metode</title>

    <!-- DataTables -->
    <link href="assets/adminto-14/Admin/Horizontal/assets/plugins/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/adminto-14/Admin/Horizontal/assets/plugins/datatables/buttons.bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/adminto-14/Admin/Horizontal/assets/plugins/datatables/fixedHeader.bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/adminto-14/Admin/Horizontal/assets/plugins/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/adminto-14/Admin/Horizontal/assets/plugins/datatables/scroller.bootstrap.min.css" rel="stylesheet" type="text/css" />

    <link href="assets/adminto-14/Admin/Horizontal/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="assets/adminto-14/Admin/Horizontal/assets/css/core.css" rel="stylesheet" type="text/css" />
    <link href="assets/adminto-14/Admin/Horizontal/assets/css/components.css" rel="stylesheet" type="text/css" />
    <link href="assets/adminto-14/Admin/Horizontal/assets/css/icons.css" rel="stylesheet" type="text/css" />
    <link href="assets/adminto-14/Admin/Horizontal/assets/css/pages.css" rel="stylesheet" type="text/css" />
    <link href="assets/adminto-14/Admin/Horizontal/assets/css/menu.css" rel="stylesheet" type="text/css" />
    <link href="assets/adminto-14/Admin/Horizontal/assets/css/responsive.css" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shiv and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

    <script src="assets/adminto-14/Admin/Horizontal/assets/js/modernizr.min.js"></script>

</head>


<body>

<!-- Navigation Bar-->
<header id="topnav">
    <div class="topbar-main">
        <div class="container">

            <!-- LOGO -->
            <div class="topbar-left">
                <a href="index.php" class="logo"><span>Sentiment Analysis For Twitter<span> &nbsp; Naive Bayes Classifier</span></span></a>
            </div>
            <!-- End Logo container-->


            <div class="menu-extras">

                <ul class="nav navbar-nav navbar-right pull-right">



                    <li class="dropdown user-box">
                        <a href="" class="dropdown-toggle waves-effect waves-light profile " data-toggle="dropdown"
                           aria-expanded="true">
                            <img src="assets/adminto-14/Admin/Horizontal/assets/images/users/avatar-1.png"
                                 alt="user-img" class="img-circle user-img">
                            <div class="user-status away"><i class="zmdi zmdi-dot-circle"></i></div>
                        </a>

                        <ul class="dropdown-menu">
                            <li><a href="javascript:void(0)"><i class="ti-user m-r-5"></i> Profile</a></li>
                            <li><a href="javascript:void(0)"><i class="ti-settings m-r-5"></i> Settings</a></li>
                            <li><a href="javascript:void(0)"><i class="ti-lock m-r-5"></i> Lock screen</a></li>
                            <li><a href="javascript:void(0)"><i class="ti-power-off m-r-5"></i> Logout</a></li>
                        </ul>
                    </li>
                </ul>
                <div class="menu-item">
                    <!-- Mobile menu toggle-->
                    <a class="navbar-toggle">
                        <div class="lines">
                            <span></span>
                            <span></span>
                            <span></span>
                        </div>
                    </a>
                    <!-- End mobile menu toggle-->
                </div>
            </div>

        </div>
    </div>

    <div class="navbar-custom">
        <div class="container">
            <div id="navigation">
                <!-- Navigation Menu-->
                <ul class="navigation-menu">
                    <li class="has-submenu">
                        <a href="index.php"><i class="zmdi zmdi-view-dashboard"></i>
                            <span> Home </span> </a>
                    </li>
                    <li class="has-submenu">
                        <a href="#"><i class="zmdi zmdi-collection-text"></i><span> Upload </span> </a>
                        <ul class="submenu">
                            <li><a href="dokumenUpload.php">Upload Data Uji</a></li>
                            <li><a href="dokumenUploadLatih.php">Upload Data Latih</a></li>
                        </ul>
                    </li>

                    <li class="has-submenu">
                        <a href="#"><i class="zmdi zmdi-view-list"></i> <span> View Data </span> </a>
                        <ul class="submenu">
                            <li><a href="dokumenRead.php">Lihat Data Uji</a></li>
                            <li><a href="dokumenReadLatih.php">Lihat Data Latih</a></li>
                        </ul>
                    </li>

                    <li class="has-submenu">
                        <a href="#"><i class="zmdi zmdi-collection-item"></i> <span> Result </span> </a>
                        <ul class="submenu">
                            <li><a href="dokumenMining.php">Data Prossesing</a></li>
                            <li><a href="dataMining.php">Naive Bayes Classifier</a></li>
                            <li><a href="controller/dataMining.php">Hasil</a></li>
                        </ul>
                    </li>

                    <li class="has-submenu">
                        <a href="#"><i class="zmdi zmdi-chart"></i> <span> Charts </span> </a>
                        <ul class="submenu">
                            <li><a href="grafik.php">Batang</a></li>
                            <li><a href="grafikpie.php">Pie</a></li>
                        </ul>
                    </li>
                </ul>
                </li>

                </ul>
                <!-- End navigation menu  -->
            </div>
        </div>
    </div>
</header>
<!-- End Navigation Bar-->

        