<?php
class mJam extends CI_Controller{
	function __construct(){
		parent::__construct();
		$this->load->database();
	}

	function mJamLihat(){
		$lihat = $this->db->get('jam');
		return $lihat->result();
 	}

	function mJamTambahAct() {
		$id_jam = $this->input->post('id_jam');
		$range_jam = $this->input->post('range_jam');
		$shift = $this->input->post('shift');

			$data = array (
				'id_jam'=> $id_jam,
				'range_jam'=> $range_jam,
				'shift'=> $shift,
			);
			
		$this->db->insert('jam', $data);
		$tambah = $this->db->get('jam');
		return $tambah->result();
	}

	function mJamEdit($data){
		$this->db->where($data);
		$edit = $this->db->get('jam');
		return $edit->result();
	}

	function mJamUpdateAct($data,$id_jam){
		$this->db->where('id_jam', $id_jam);
		$this->db->update('jam',$data);
	}
	
	function mJamHapus($data){
		$this->db->delete('jam',$data);
	}
	
}
 
?>