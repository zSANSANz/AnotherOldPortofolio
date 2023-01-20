<?php include("utility/header.php"); ?>


    <!-- ============================================================== -->
    <!-- Start right Content here -->
    <!-- ============================================================== -->
    <div class="content-page">
        <!-- Start content -->
        <div class="content">
            <div class="container">


                <div class="row">

                <div class="row">
                    <div class="col-lg-4">
                        <div class="card-box">
                            <div class="dropdown pull-right">
                                <a href="#" class="dropdown-toggle card-drop" data-toggle="dropdown"
                                   aria-expanded="false">
                                    <i class="zmdi zmdi-more-vert"></i>
                                </a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                            </div>


                            <div class="widget-chart text-center">
                                <div id="morris-donut-example" style="height: 245px;"></div>
                                <ul class="list-inline chart-detail-list m-b-0">
                                    <li>
                                        <h5 style="color: #ff8acc;"><i class="fa fa-circle m-r-5"></i>Positif</h5>
                                    </li>
                                    <li>
                                        <h5 style="color: #5b69bc;"><i class="fa fa-circle m-r-5"></i>Negatif</h5>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div><!-- end col -->

                    <div class="col-lg-4">
                        <div class="card-box">
                            <div class="dropdown pull-right">
                                <a href="#" class="dropdown-toggle card-drop" data-toggle="dropdown"
                                   aria-expanded="false">
                                    <i class="zmdi zmdi-more-vert"></i>
                                </a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                            </div>
                            <div id="morris-bar-example" style="height: 280px;"></div>
                        </div>
                    </div><!-- end col -->

                    <div class="col-lg-4">
                        <div class="card-box">
                            <div class="dropdown pull-right">
                                <a href="#" class="dropdown-toggle card-drop" data-toggle="dropdown"
                                   aria-expanded="false">
                                    <i class="zmdi zmdi-more-vert"></i>
                                </a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                            </div>
                            <h4 class="header-title m-t-0">Total Revenue</h4>
                            <div id="morris-line-example" style="height: 280px;"></div>
                        </div>
                    </div><!-- end col -->

                </div>
                <!-- end row -->


                    </div><!-- end col -->

                </div> <!-- container -->

            </div> <!-- content -->


        </div>


        <script>
            var resizefunc = [];
        </script>

        <!-- jQuery  -->
        <script src="assets/adminto-14/Admin/Light/assets/js/jquery.min.js"></script>
        <script src="assets/adminto-14/Admin/Light/assets/js/bootstrap.min.js"></script>
        <script src="assets/adminto-14/Admin/Light/assets/js/detect.js"></script>
        <script src="assets/adminto-14/Admin/Light/assets/js/fastclick.js"></script>
        <script src="assets/adminto-14/Admin/Light/assets/js/jquery.blockUI.js"></script>
        <script src="assets/adminto-14/Admin/Light/assets/js/waves.js"></script>
        <script src="assets/adminto-14/Admin/Light/assets/js/jquery.nicescroll.js"></script>
        <script src="assets/adminto-14/Admin/Light/assets/js/jquery.slimscroll.js"></script>
        <script src="assets/adminto-14/Admin/Light/assets/js/jquery.scrollTo.min.js"></script>

        <!-- KNOB JS -->
        <!--[if IE]>
        <script type="text/javascript" src="assets/adminto-14/Admin/Light/assets/plugins/jquery-knob/excanvas.js"></script>
        <![endif]-->
        <script src="assets/adminto-14/Admin/Light/assets/plugins/jquery-knob/jquery.knob.js"></script>

        <!--Morris Chart-->
        <script src="assets/adminto-14/Admin/Light/assets/plugins/morris/morris.min.js"></script>
        <script src="assets/adminto-14/Admin/Light/assets/plugins/raphael/raphael-min.js"></script>

        <!-- Dashboard init -->
        <script src="assets/adminto-14/Admin/Light/assets/pages/jquery.dashboard.js"></script>

        <!-- App js -->
        <script src="assets/adminto-14/Admin/Light/assets/js/jquery.core.js"></script>
        <script src="assets/adminto-14/Admin/Light/assets/js/jquery.app.js"></script>

<?php include("utility/footer.php"); ?>