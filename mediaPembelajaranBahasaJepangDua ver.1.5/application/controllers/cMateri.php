<?php

class cMateri extends CI_Controller {
    public function __construct() {
        parent::__construct();
        $this->load->library('session');
        if ($this->session->userdata('hakakses')=="") {
            redirect('cSoal/errorTampil');
        }
        $this->load->helper(array('url','form'));
        $this->load->model('mMateri');
        $this->load->library('template');
    }

    function index() {
        $data['username'] = $this->session->userdata('username');
        $this->load->model('mMateri');
        $data['data_materi'] = $this->mMateri->mMateriLihat($data['username']);
        $this->template->load('template','materi/showMateri', $data);
    }

    function editMateri($id_materi) {
        $data=array (
            'id_materi'=>$id_materi
        );
        $data['data_edit']=$this->mMateri->mMateriEdit($data);
        $this->template->load('template','materi/editMateri', $data);
    }

    function tambah() {
        $this->template->load('template', 'materi/createMateri');
    }

    function tambahMateri_act() {
        $data=array(
            'id_materi' => null,
            'materi' => $this->input->post('materi'),
            'no_materi' => $this->input->post('no_materi'),
        );
        $this->mMateri->mMateriInsertAct($data);
        redirect(base_url().'index.php/cMateri');
    }

    function edit_act() {
        $id_materi = $this->input->post('id_materi');
        $data=array(
            'materi' => $this->input->post('materi'),
            'id_materi' => $this->input->post('id_materi'),
        );
        $this->mMateri->mMateriUpdateAct($data, $id_materi);
        redirect(base_url().'index.php/cMateri/editMateri');
    }
}

/* End of file welcome.php */
/* Location: ./application/controllers/welcome.php */