<?php

class mSoalAcak extends CI_Controller
{
    function __construct()
    {
        parent::__construct();
        $this->load->database();
    }

    function mSoalAcakLihatEvaluasi()
    {
        $data = $this->db->query("SELECT * FROM tb_soal_acak ORDER BY RAND() LIMIT 20");
        $this->db->query("TRUNCATE tb_soal_hasil_acak");

        foreach ($data->result() as $acak) {

            $soal = $acak->soal;
            $idGambar = $acak->id_gambar;
            $idMateri = $acak->id_materi;
            $idSoalAsal = $acak->id_soal;

            $this->db->query("INSERT INTO tb_soal_hasil_acak(id_soal, soal, id_gambar, id_materi, id_soal_asal) VALUES(NULL, '$soal', '$idGambar', '$idMateri', '$idSoalAsal')");

        }

        $lihat = $this->db->query("SELECT * FROM tb_soal_hasil_acak");

        return $lihat->result();
    }

    function mJawabanAcakLihatEvaluasi()
    {
        $lihat = $this->db->query("SELECT * FROM tb_jawaban_acak, tb_soal_hasil_acak 
                                    WHERE
                                        tb_soal_hasil_acak.id_soal_asal = tb_jawaban_acak.id_soal
                                    ORDER BY 
                                        RAND()
                                       ");
        return $lihat->result();
    }

    function mSoalAcakLihatSatu()
    {
        $data = $this->db->query("SELECT * FROM tb_soal_acak WHERE id_materi=1 ORDER BY RAND() LIMIT 10");
        $this->db->query("TRUNCATE tb_soal_hasil_acak");

        foreach ($data->result() as $acak) {

            $soal = $acak->soal;
            $idGambar = $acak->id_gambar;
            $idMateri = $acak->id_materi;
            $idSoalAsal = $acak->id_soal;

            $this->db->query("INSERT INTO tb_soal_hasil_acak(id_soal, soal, id_gambar, id_materi, id_soal_asal) VALUES(NULL, '$soal', '$idGambar', '$idMateri', '$idSoalAsal')");

        }

        $lihat = $this->db->query("SELECT * FROM tb_soal_hasil_acak WHERE id_materi=1");

        return $lihat->result();
    }

    function mJawabanAcakLihatSatu()
    {
        $lihat = $this->db->query("SELECT * FROM tb_jawaban_acak, tb_soal_hasil_acak 
                                    WHERE
                                        tb_soal_hasil_acak.id_materi=1 
                                    AND
                                        tb_soal_hasil_acak.id_soal_asal = tb_jawaban_acak.id_soal
                                    ORDER BY 
                                        RAND()
                                       ");
        return $lihat->result();
    }

    function mSoalAcakLihatDua()
    {
        $data = $this->db->query("SELECT * FROM tb_soal_acak WHERE id_materi=2 ORDER BY RAND() LIMIT 10");
        $this->db->query("TRUNCATE tb_soal_hasil_acak");

        foreach ($data->result() as $acak) {

            $soal = $acak->soal;
            $idGambar = $acak->id_gambar;
            $idMateri = $acak->id_materi;
            $idSoalAsal = $acak->id_soal;

            $this->db->query("INSERT INTO tb_soal_hasil_acak(id_soal, soal, id_gambar, id_materi, id_soal_asal) VALUES(NULL, '$soal', '$idGambar', '$idMateri', '$idSoalAsal')");

        }

        $lihat = $this->db->query("SELECT * FROM tb_soal_hasil_acak WHERE id_materi=2");

        return $lihat->result();
    }

    function mJawabanAcakLihatDua()
    {
        $lihat = $this->db->query("SELECT * FROM tb_jawaban_acak, tb_soal_hasil_acak 
                                    WHERE
                                        tb_soal_hasil_acak.id_materi=2 
                                    AND
                                        tb_soal_hasil_acak.id_soal_asal = tb_jawaban_acak.id_soal
                                    ORDER BY 
                                        RAND()
                                       ");
        return $lihat->result();
    }

    function mSoalAcakLihatTiga()
    {
        $data = $this->db->query("SELECT * FROM tb_soal_acak WHERE id_materi=3 ORDER BY RAND() LIMIT 10");
        $this->db->query("TRUNCATE tb_soal_hasil_acak");

        foreach ($data->result() as $acak) {

            $soal = $acak->soal;
            $idGambar = $acak->id_gambar;
            $idMateri = $acak->id_materi;
            $idSoalAsal = $acak->id_soal;

            $this->db->query("INSERT INTO tb_soal_hasil_acak(id_soal, soal, id_gambar, id_materi, id_soal_asal) VALUES(NULL, '$soal', '$idGambar', '$idMateri', '$idSoalAsal')");

        }

        $lihat = $this->db->query("SELECT * FROM tb_soal_hasil_acak WHERE id_materi=3");

        return $lihat->result();
    }

    function mJawabanAcakLihatTiga()
    {
        $lihat = $this->db->query("SELECT * FROM tb_jawaban_acak, tb_soal_hasil_acak 
                                    WHERE
                                        tb_soal_hasil_acak.id_materi=3 
                                    AND
                                        tb_soal_hasil_acak.id_soal_asal = tb_jawaban_acak.id_soal
                                    ORDER BY 
                                        RAND()
                                       ");
        return $lihat->result();
    }

    function mSoalAcakLihatEmpat()
    {
        $data = $this->db->query("SELECT * FROM tb_soal_acak WHERE id_materi=4 ORDER BY RAND() LIMIT 10");
        $this->db->query("TRUNCATE tb_soal_hasil_acak");

        foreach ($data->result() as $acak) {

            $soal = $acak->soal;
            $idGambar = $acak->id_gambar;
            $idMateri = $acak->id_materi;
            $idSoalAsal = $acak->id_soal;

            $this->db->query("INSERT INTO tb_soal_hasil_acak(id_soal, soal, id_gambar, id_materi, id_soal_asal) VALUES(NULL, '$soal', '$idGambar', '$idMateri', '$idSoalAsal')");

        }

        $lihat = $this->db->query("SELECT * FROM tb_soal_hasil_acak WHERE id_materi=4");

        return $lihat->result();
    }

    function mJawabanAcakLihatEmpat()
    {
        $lihat = $this->db->query("SELECT * FROM tb_jawaban_acak, tb_soal_hasil_acak 
                                    WHERE
                                        tb_soal_hasil_acak.id_materi=4 
                                    AND
                                        tb_soal_hasil_acak.id_soal_asal = tb_jawaban_acak.id_soal
                                    ORDER BY 
                                        RAND()
                                       ");
        return $lihat->result();
    }

    function mPenggunaUpdateAct($dataPoint, $usernamePoint){
        $point = $this->input->post('point');
        $this->db->where('username', $usernamePoint);

        $dataPoint = array (
            'point'=> $point,
        );

        $this->db->update('tb_login',$dataPoint);
    }

    function mNilaiInsertAct() {
        $nilai = $this->input->post('nilai');
        $username = $this->input->post('username');
        $materi = $this->input->post('materi');

        $data = ['nilai' => $nilai, 'materi' => $materi, 'username' => $username,];

        $this->db->insert('tb_soal_acaka', $data);
        $tambah = $this->db->get('tb_soal_acak');

        return $tambah->result();
    }


}

?>