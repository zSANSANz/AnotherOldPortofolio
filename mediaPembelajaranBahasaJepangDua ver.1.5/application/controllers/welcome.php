<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Welcome extends CI_Controller {
	public function __construct()
	{
		parent::__construct();
		$this->load->helper(array('url', 'form'));
		$this->load->library('session');
		$this->load->model('mLogin');
		$this->load->library('template');
	}

	/**
	 * Index Page for this controller.
	 *
	 * Maps to the following URL
	 * 		http://example.com/index.php/welcome
	 *	- or -  
	 * 		http://example.com/index.php/welcome/index
	 *	- or -
	 * Since this controller is set as the default controller in 
	 * config/routes.php, it's displayed at http://example.com/
	 *
	 * So any other public methods not prefixed with an underscore will
	 * map to /index.php/welcome/<method_name>
	 * @see http://codeigniter.com/user_guide/general/urls.html
	 */
	
	public function index()
	{
		$this->template->load('template','welcome_message');
	}

	public function beranda()
	{
		$this->template->load('template','beranda');
	}

	public function simulasi()
	{
		$this->template->load('template','simulasiEksekusi');
	}

	public function evaluasi()
	{
		$this->template->load('template','evaluasi');
	}

	public function bantuan()
	{
		$this->template->load('template','bantuan');
	}

}

/* End of file welcome.php */
/* Location: ./application/controllers/welcome.php */