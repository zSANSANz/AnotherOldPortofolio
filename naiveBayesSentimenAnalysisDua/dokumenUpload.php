<?php include("utility/header.php"); ?>

<div class="wrapper">
    <div class="container">
        <!-- Page-Title -->

        <div class="row">


            <div class="col-lg-6">
                <div class="card-box">


                    <h4 class="header-title m-t-0 m-b-30">From Upload Dokumen</h4>

                    <form class="form-horizontal" enctype="multipart/form-data" method="POST"
                          action="controller/terimaDokumenUpload.php">
                        <div class="form-group">
                            <label for="dokumen" class="col-sm-2 control-label">Dokumen
                                *</label>
                            <div class="col-sm-7">
                                <input type="file" required name="uploadedfile"
                                       class="form-control" id="uploadedfile">

                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-8">
                                <button type="submit" class="btn btn-primary waves-effect waves-light">
                                    Simpan
                                </button>
                                <button type="reset"
                                        class="btn btn-default waves-effect waves-light m-l-5">
                                    Refresh
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div><!-- end col -->
        </div>
        <!-- end row -->


        <?php include("utility/footer.php"); ?>
