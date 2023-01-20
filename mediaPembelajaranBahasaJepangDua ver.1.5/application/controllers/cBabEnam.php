<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class cBabEnam extends CI_Controller {
	public function __construct()
	{
		parent::__construct();
		$this->load->helper(array('url','form'));
		$this->load->model('mMateri');
		$this->load->library('template');
	}
	
	public function babEnam()
	{
		$this->template->load('template','babEnam/index.php');
	}

	public function babEnamTujuan()
	{
		$this->template->load('template','babEnam/tujuan.php');
	}
	
	public function babEnamMateri()
	{
		$data['data_materi'] = $this->mMateri->mMateriLihatEnam();
		$this->template->load('template','babEnam/materi.php', $data);
	}

	public function babEnamRangkuman()
	{
		$this->template->load('template','babEnam/rangkuman.php');
	}

	public function babEnamEvaluasi()
	{
		$this->template->load('template','babEnam/evaluasi.php');
	}


}

/* End of file welcome.php */
/* Location: ./application/controllers/welcome.php */
