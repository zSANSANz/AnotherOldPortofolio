<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class cBabEmpat extends CI_Controller {

	public function __construct()
	{
		parent::__construct();
		$this->load->helper(array('url','form'));
		$this->load->model('mMateri');
		$this->load->library('template');
	}
	
	public function babEmpat()
	{
		$this->template->load('template','babEmpat/index.php');
	}

	public function babEmpatTujuan()
	{
		$this->template->load('template','babEmpat/tujuan.php');
	}
	
	public function babEmpatMateri()
	{
		$data['data_materi'] = $this->mMateri->mMateriLihatEmpat();
		$this->template->load('template','babEmpat/materi.php', $data);
	}

	public function babEmpatRangkuman()
	{
		$this->template->load('template','babEmpat/rangkuman.php');
	}

	public function babEmpatEvaluasi()
	{
		$this->template->load('template','babEmpat/evaluasi.php');
	}


}

/* End of file welcome.php */
/* Location: ./application/controllers/welcome.php */
