<?php
/**
 * Created by PhpStorm.
 * User: cvgs
 * Date: 11/28/2016
 * Time: 1:03 PM
 */

class mMateri extends CI_Controller
{
    function __construct() {
        parent::__construct();
        $this->load->database();
    }

    function mMateriLihat() {
        $this->db->select('*');
        $this->db->from('tb_materi');
        $lihat = $this->db->get();
        return $lihat->result();
    }

    function mMateriLihatSatu() {
        $this->db->select('*');
        $this->db->from('tb_materi');
        $this->db->where('no_materi','1');
        $lihat = $this->db->get();
        return $lihat->result();
    }

    function mMateriLihatDua() {
        $this->db->select('*');
        $this->db->from('tb_materi');
        $this->db->where('no_materi','2');
        $lihat = $this->db->get();
        return $lihat->result();
    }

    function mMateriLihatTiga() {
        $this->db->select('*');
        $this->db->from('tb_materi');
        $this->db->where('no_materi','3');
        $lihat = $this->db->get();
        return $lihat->result();
    }

    function mMateriLihatEmpat() {
        $this->db->select('*');
        $this->db->from('tb_materi');
        $this->db->where('no_materi','4');
        $lihat = $this->db->get();
        return $lihat->result();
    }

    function mMateriLihatLima() {
        $this->db->select('*');
        $this->db->from('tb_materi');
        $this->db->where('no_materi','5');
        $lihat = $this->db->get();
        return $lihat->result();
    }

    function mMateriLihatEnam() {
        $this->db->select('*');
        $this->db->from('tb_materi');
        $this->db->where('no_materi','6');
        $lihat = $this->db->get();
        return $lihat->result();
    }

    function mMateriLihatManipulasi() {
        $this->db->select('*');
        $this->db->from('tb_materi');
        $lihat = $this->db->get();

        return $lihat->result();
    }

    function mMateriInsertAct() {
        $materi = $this->input->post('materi');
        $id_materi = $this->input->post('id_materi');
        $no_materi = $this->input->post('no_materi');

        $data = [
                 'id_materi' => $id_materi,
                 'materi' => $materi,
                 'no_materi' => $no_materi,
        ];

        $this->db->insert('tb_materi', $data);
        $tambah = $this->db->get('tb_materi');

        return $tambah->result();
    }

    function mMateriEdit($data) {
        $this->db->where($data);
        $edit = $this->db->get('tb_materi');

        return $edit->result();
    }

    function mMateriUpdateAct($data, $id_materi) {
        $this->db->where('id_materi', $id_materi);

        $materi = $this->input->post('materi');

        $data = [
            'materi' => $materi,

        ];
        $this->db->where('id_materi', $id_materi);
        $this->db->update('tb_materi', $data);

    }

    function mMateriHapus($data) {
        $this->db->delete('tb_materi');
    }
}