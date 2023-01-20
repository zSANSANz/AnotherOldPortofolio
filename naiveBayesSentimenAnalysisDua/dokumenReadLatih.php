<?php include("utility/header.php"); ?>

    <div class="wrapper">
    <div class="container">




    <div class="row">
        <div class="col-sm-12">
            <div class="card-box table-responsive">


                <h4 class="header-title m-t-0 m-b-30">Tabel Dokumen</h4>

                <table id="datatable" class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>deskripsi dokumen</th>
                        <th>kelas</th>

                    </tr>
                    </thead>

                    <tbody>
                    <?php

                    include "koneksi/koneksi.php";

                    $sql = "SELECT * FROM tb_dokumen WHERE kelas_dokumen != 0 ORDER BY id_dokumen DESC";
                    $result = $conn->query($sql);

                    if ($result->num_rows > 0) {
                        $i = 1;
                        //output data of each row
                        while ($row = $result->fetch_assoc()) {

                            ?>

                            <tr>
                                <td><?php echo $i ?></td>
                                <td><?php echo $row["deskripsi_dokumen"] ?></td>
                                <td><?php if ($row["kelas_dokumen"]==1) {
                                    echo "positif";
                                    } else {
                                        echo "negatif";
                                    }?></td>
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