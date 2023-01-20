<?php
class cManipulasiSoal extends CI_Controller{
    public function __construct() {

        parent::__construct();
        $this->load->library('session');
        if ($this->session->userdata('hakakses')=="") {
            redirect('cSoal/errorTampil');
        }
        $this->load->helper(array('url','form'));
        $this->load->model('mManipulasiSoal');
        $this->load->library('template');
    }

    function index(){
        $data['username'] = $this->session->userdata('username');
        $this->load->model('mManipulasiSoal');
        $data['data_soal']=$this->mManipulasiSoal->mManipulasiSoalLihat($data['username']);
        $this->template->load('template','soal/showSoal', $data);
    }

    function showSoal(){
        $data['data_soal']=$this->mManipulasiSoal->mManipulasiSoalLihatManipulasi();
        $this->template->load('template','soal/showSoalManipulasi', $data);
    }

    function showNilai(){
        $data['data_nilai']=$this->mManipulasiSoal->mNilai();
        $this->template->load('template','soal/showNilai', $data);
    }

    function showJawaban(){
        $data['data_soal']=$this->mManipulasiSoal->mManipulasiSoalLihatJawaban();
        $this->template->load('template','soal/showSoalJawaban', $data);
    }

    function tambah(){
        $this->template->load('template','soal/createSoal');
    }

    function tambahJawaban(){
        $data['soal'] = $this->mManipulasiSoal->mManipulasiSoalLihatManipulasi();
        $this->template->load('template','soal/createJawaban', $data);
    }

    function tambah_act(){
        $data=array(
            'soal' => $this->input->post('soal'),
            'id_materi' => $this->input->post('id_materi')
        );
        $this->mManipulasiSoal->mManipulasiSoalInsertAct($data);
        redirect(base_url().'index.php/cManipulasiSoal/showSoal');
    }

    function tambahJawaban_act(){
        $data=array(
            'id_soal' => $this->input->post('id_soal'),
            'jawaban' => $this->input->post('jawaban'),
            'benar' => $this->input->post('benar'),
        );
        $this->mManipulasiSoal->mManipulasiJawabanInsertAct($data);
        redirect(base_url().'index.php/cManipulasiSoal/showJawaban');
    }

    function edit($id_soal){
        $data=array(
            'id_soal'=>$id_soal
        );
        $data['data_edit']=$this->mManipulasiSoal->mManipulasiSoalEdit($data);
        $this->template->load('template','soal/editSoal', $data);
    }

    function edit_act(){
        $id_soal = $this->input->post('id_soal');
        $data=array(
            'soal' => $this->input->post('soal'),
            'id_materi' => $this->input->post('id_materi'),
        );
        $this->mManipulasiSoal->mManipulasiSoalUpdateAct($data,$id_soal);
        redirect(base_url().'index.php/cManipulasiSoal/showSoal');
    }

    function hapus($id_soal){
        $data=array(
            'id_soal' => $id_soal,
        );
        $this->mManipulasiSoal->mManipulasiSoalHapus($data);
        redirect(base_url().'index.php/cManipulasiSoal/showSoal');
    }

    function editJawaban($id_jawaban){
        $data=array(
            'id_jawaban'=>$id_jawaban
        );
        $data['data_edit']=$this->mManipulasiSoal->mManipulasiSoalJawabanEdit($data);
        $data['soal'] = $this->mManipulasiSoal->mManipulasiSoalLihatManipulasi();
        $this->template->load('template','soal/editjawaban', $data);
    }

    function editJawaban_act(){
        $id_jawaban = $this->input->post('id_jawaban');
        $data=array(
            'id_soal' => $this->input->post('id_soal'),
            'jawaban' => $this->input->post('jawaban'),
            'benar' => $this->input->post('benar'),
        );
        $this->mManipulasiSoal->mManipulasiSoalJawabanUpdateAct($data,$id_jawaban);
        redirect(base_url().'index.php/cManipulasiSoal/showjawaban');
    }

    function hapusJawaban($id_jawaban){
        $data=array(
            'id_jawaban' => $id_jawaban,
        );
        $this->mManipulasiSoal->mManipulasiSoalJawabanHapus($data);
        redirect(base_url().'index.php/cManipulasiSoal/showJawaban');
    }

}

?>