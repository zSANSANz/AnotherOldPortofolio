<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class cBabLima extends CI_Controller {
	public function __construct()
	{
		parent::__construct();
		$this->load->helper(array('url','form'));
		$this->load->model('mMateri');
		$this->load->library('template');
	}
	
	public function babLima()
	{
		$this->template->load('template','babLima/index.php');
	}

	public function babLimaTujuan()
	{
		$this->template->load('template','babLima/tujuan.php');
	}
	
	public function babLimaMateri()
	{
		$data['data_materi'] = $this->mMateri->mMateriLihatLima();
		$this->template->load('template','babLima/materi.php', $data);
	}

	public function babLimaRangkuman()
	{
		$this->template->load('template','babLima/rangkuman.php');
	}

	public function babLimaEvaluasi()
	{
		$this->template->load('template','babLima/evaluasi.php');
	}


}

/* End of file welcome.php */
/* Location: ./application/controllers/welcome.php */
