<?php
class cJam extends CI_Controller{
	function __construct(){
		parent::__construct();
		$this->load->helper(array('url','form'));
		$this->load->model('mJam');
		$this->load->library('template');
	}

	function index(){
		$data['data_jam']=$this->mJam->mJamLihat();
		$this->template->load('template','jam/index', $data);
	}

	function tambah(){
		$this->template->load('template','jam/vJamTambah');
	}

	function tambah_act(){
		$data=array(
			'id_jam' => $this->input->post('id_jam'),
			'range_jam'=>$this->input->post('range_jam'),
			'shift'=>$this->input->post('shift'),
			);
		$this->mJam->mJamTambahAct($data);	
		redirect(base_url().'index.php/cJam/index');
	}

	function edit($id_jam){
		$data=array(
			'id_jam'=>$id_jam
			);
		$data['data_edit']=$this->mJam->mJamEdit($data);
		$this->template->load('template','jam/vJamEdit', $data);
	}

	function update_act(){
		$id_jam = $this->input->post('id_jam');
		$data=array(			
			'range_jam'=>$this->input->post('range_jam'),
			'shift'=>$this->input->post('shift'),
			);
		$this->mJam->mJamUpdateAct($data,$id_jam);
		redirect(base_url().'index.php/cJam/index');
	}

	function hapus($id_jam){
		$data=array(
			'id_jam' => $id_jam
			);
		$this->mJam->mJamHapus($data);
		redirect(base_url().'index.php/cJam/index');
	}

}
 
?>