<?php

class mManipulasiSoal extends CI_Controller
{
    function __construct() {
        parent::__construct();
        $this->load->database();
    }

    function mManipulasiSoalLihat($tb_soalname) {
        if ($tb_soalname == "admin") {
            $this->db->select('*');
            $this->db->from('tb_soal_acak');
            $this->db->join('tb_jawaban_acak', 'tb_soal_acak.id_soal = tb_jawaban_acak.id_soal');
            $lihat = $this->db->get();
        }
        else {
            $this->db->select('*');
            $this->db->from('tb_soal_acak', 'tb_jawaban_acak');
            $this->db->where('tb_soal.tb_soalname', $tb_soalname);
            $lihat = $this->db->get();
        }

        return $lihat->result();
    }

    function mManipulasiSoalLihatManipulasi() {
        $this->db->select('*');
        $this->db->from('tb_soal_acak');
        $lihat = $this->db->get();

        return $lihat->result();
    }

    function mNilai() {
        $this->db->select('*');
        $this->db->from('tb_nilai');
        $lihat = $this->db->get();

        return $lihat->result();
    }

    function mManipulasiSoalLihatJawaban() {

        $this->db->select('*');
        $this->db->from('tb_jawaban_acak');
        $lihat = $this->db->get();

        return $lihat->result();
    }


    function mManipulasiSoalInsertAct() {
        $soal = $this->input->post('soal');
        $id_materi = $this->input->post('id_materi');

        $data = ['soal' => $soal, 'id_materi' => $id_materi,];

        $this->db->insert('tb_soal_acak', $data);
        $tambah = $this->db->get('tb_soal_acak');

        return $tambah->result();
    }

    function mManipulasiJawabanInsertAct() {
        $id_soal = $this->input->post('id_soal');
        $jawaban = $this->input->post('jawaban');
        $benar = $this->input->post('benar');

        $data = ['id_soal' => $id_soal, 'jawaban' => $jawaban, 'benar' => $benar,];

        $this->db->insert('tb_jawaban_acak', $data);
        $tambah = $this->db->get('tb_jawaban_acak');

        return $tambah->result();
    }

    function mManipulasiSoalEdit($data) {
        $this->db->where($data);
        $edit = $this->db->get('tb_soal_acak');

        return $edit->result();
    }

    function mManipulasiSoalJawabanEdit($data) {
        $this->db->where($data);
        $edit = $this->db->get('tb_jawaban_acak');

        return $edit->result();
    }

    function mManipulasiSoalJawabanUpdateAct($data, $id_jawaban) {
        $this->db->where('id_jawaban', $id_jawaban);

        $jawaban = $this->input->post('jawaban');
        $benar = $this->input->post('benar');

        $data = [
            'jawaban' => $jawaban,
            'benar' => $benar,
        ];
        $this->db->update('tb_jawaban_acak', $data);
    }

    function mManipulasiSoalUpdateAct($data, $id_soal) {

        $soal = $this->input->post('soal');
        $id_materi = $this->input->post('id_materi');

        $data = [
            'soal' => $soal,
            'id_materi' => $id_materi,
        ];

        $this->db->where('id_soal', $id_soal);
        $this->db->update('tb_soal_acak', $data);
    }

    function mManipulasiSoalHapus($data) {
        $this->db->delete('tb_soal_acak', $data);
    }

    function mManipulasiSoalJawabanHapus($data) {
        $this->db->delete('tb_jawaban_acak', $data);
    }

    
}

?>