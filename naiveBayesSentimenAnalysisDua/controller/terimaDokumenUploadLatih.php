<?php
$uploadedfile=$_FILES['uploadedfile']['name'];
$target_path="upload/";
$target_path=$target_path . basename( $_FILES['uploadedfile']['name'] );
if (move_uploaded_file($_FILES['uploadedfile']['tmp_name'],$target_path))
{
    $myfile = fopen("upload/".basename($_FILES['uploadedfile']['name']), "r") or die("Unable to open file!");
    //echo fread($myfile,filesize("upload/".basename($_FILES['uploadedfile']['name'])));
    //echo $_POST["kelas"];

    include "../koneksi/koneksi.php";

    $class = $_POST['class'];

//    $dokumen = $_POST['dokumen'];
//    $class = $_POST['class'];

    $sql = "INSERT INTO tb_dokumen(id_dokumen, deskripsi_dokumen, kelas_dokumen) VALUES (NULL, '".fread($myfile,filesize("upload/".basename($_FILES['uploadedfile']['name'])))."', ".$class.")";

    echo $sql;

    if ($conn->query($sql) === TRUE) {
        header("Location:" . "../dokumenReadLatih.php");
    } else {
        echo "Error: " . $sql . "<br>" . $conn->error;
    }

    $conn->close();

    fclose($myfile);
}
else
{
    echo("File Tidak Dapat di Upload, Silahkan Coba Lagi!");
}
?>





