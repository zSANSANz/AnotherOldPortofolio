<?php include("utility/header.php"); ?>


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


                <h4 class="header-title m-t-0 m-b-30">Tabel Dokumen</h4>

                <table id="datatable" class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>No</th>
                        <th>TWEETS</th>
                        <th>Hasil</th>

                    </tr>
                    </thead>

                    <tbody>
                    <?php

                    include "koneksi/koneksi.php";

                    $sql = "SELECT * FROM tb_hasil ORDER BY id_hasil DESC";
                    $result = $conn->query($sql);

                    if ($result->num_rows > 0) {
                        $i = 1;
                        //output data of each row
                        while ($row = $result->fetch_assoc()) {

                            ?>

                            <tr>
                                <td><?php echo $i ?></td>
                                <td><?php echo $row["deskripsi_hasil"] ?></td>
                                <td><?php echo $row["hasil"] ?></td>
                            </tr>

                            <?php
                            $i++;
                        }
                    } else {
                        echo "0 results";
                    }

                    $conn->close();

                    ?>


                    </tbody>
                </table>
            </div>
        </div><!-- end col -->
    </div>
    <!-- end row -->



<?php include("utility/footer.php"); ?>