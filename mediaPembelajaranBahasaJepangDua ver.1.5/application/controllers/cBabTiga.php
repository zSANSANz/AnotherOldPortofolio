<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class cBabTiga extends CI_Controller {

	public function __construct()
	{
		parent::__construct();
		$this->load->helper(array('url','form'));
		$this->load->model('mMateri');
		$this->load->library('template');
	}
	
	public function babTiga()
	{
		$this->template->load('template','babTiga/index.php');
	}

	public function babTigaTujuan()
	{
		$this->template->load('template','babTiga/tujuan.php');
	}
	
	public function babTigaMateri()
	{
		$data['data_materi'] = $this->mMateri->mMateriLihatTiga();
		$this->template->load('template','babTiga/materi.php', $data);
	}

	public function babTigaRangkuman()
	{
		$this->template->load('template','babTiga/rangkuman.php');
	}

	public function babTigaEvaluasi()
	{
		$this->template->load('template','babTiga/evaluasi.php');
	}


}

/* End of file welcome.php */
/* Location: ./application/controllers/welcome.php */