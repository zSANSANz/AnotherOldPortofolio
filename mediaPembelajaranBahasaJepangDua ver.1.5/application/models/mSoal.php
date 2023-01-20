<?php

class mSoal extends CI_Controller
{
    function __construct()
    {
        parent::__construct();
        $this->load->database();
    }

    function mSoalLihat()
    {
        $lihat = $this->db->query("SELECT * FROM tb_soal ORDER BY RAND() LIMIT 50");
        return $lihat->result();
    }

    function mSoalLihatSatu()
    {
        $lihat = $this->db->query("SELECT * FROM tb_soal WHERE tipe_soal='materi satu' ORDER BY RAND() LIMIT 10");
        return $lihat->result();
    }

    function mSoalLihatDua()
    {
        $lihat = $this->db->query("SELECT * FROM tb_soal WHERE tipe_soal='materi dua' ORDER BY RAND() LIMIT 10");
        return $lihat->result();
    }

    function mSoalLihatTiga()
    {
        $lihat = $this->db->query("SELECT * FROM tb_soal WHERE tipe_soal='materi tiga' ORDER BY RAND() LIMIT 10");
        return $lihat->result();
    }

    function mSoalLihatEmpat()
    {
        $lihat = $this->db->query("SELECT * FROM tb_soal WHERE tipe_soal='materi empat'  ORDER BY RAND() LIMIT 10");
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

    
}
?>