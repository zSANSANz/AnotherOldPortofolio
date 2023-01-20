<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class cBabSatu extends CI_Controller {
	public function __construct() {
		parent::__construct();
		$this->load->helper(array('url','form'));
		$this->load->model('mMateri');
		$this->load->library('template');
	}

	public function babSatu()
	{

		$this->template->load('template','babSatu/index.php');
	}

	public function babSatuTujuan()
	{
		$this->template->load('template','babSatu/tujuan.php');
	}
	
	public function babSatuMateri()
	{
		$data['data_materi'] = $this->mMateri->mMateriLihatSatu();
		$this->template->load('template','babSatu/materi.php', $data);
	}

	public function babSatuMateriDua()
	{
		$this->template->load('template','babSatu/materiDua.php');
	}

	public function babSatuMateriTiga()
	{
		$this->template->load('template','babSatu/materiTiga.php');
	}

	public function babSatuMateriEmpat()
	{
		$this->template->load('template','babSatu/materiEmpat.php');
	}

	public function babSatuMateriLima()
	{
		$this->template->load('template','babSatu/materiLima.php');
	}

	public function babSatuRangkuman()
	{
		$this->template->load('template','babSatu/rangkuman.php');
	}

	public function babSatuEvaluasi()
	{
		$this->template->load('template','babSatu/evaluasi.php');
	}
}
