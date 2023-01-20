<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class cBabDua extends CI_Controller {

    public function __construct()
    {
        parent::__construct();
		$this->load->helper(array('url','form'));
		$this->load->model('mMateri');
		$this->load->library('template');
    }

	public function babDua()
	{
		$this->template->load('template','babDua/index.php');
	}

	public function babDuaTujuan()
	{
		$this->template->load('template','babDua/tujuan.php');
	}
	
	public function babDuaMateri()
	{
        $data['data_materi'] = $this->mMateri->mMateriLihatDua();
        $this->template->load('template','babDua/materi.php', $data);
	}

	public function babDuaRangkuman()
	{
		$this->template->load('template','babDua/rangkuman.php');
	}

	public function babDuaEvaluasi()
	{
		$this->template->load('template','babDua/evaluasi.php');
	}


}

/* End of file welcome.php */
/* Location: ./application/controllers/welcome.php */