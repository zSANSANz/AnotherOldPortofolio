
<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

/**
 * Created by PhpStorm.
 * User: nevermore
 * Date: 9/18/2016
 * Time: 1:50 PM
 */
class cLogin extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        $this->load->helper(array('url', 'form'));
        $this->load->library('session');
        $this->load->model('mLogin');
        $this->load->library('template');
    }

    public function index()
    {
        $this->template->load('template', 'soal/login');

    }

    public function cek_login()
    {
        $data = array('username' => $this->input->post('username', TRUE),
            'password' => md5($this->input->post('password', TRUE))
        );
        $this->load->model('mLogin'); // load model mPengguna
        $hasil = $this->mLogin->cek_user($data);
        if ($hasil->num_rows() == 1) {
            foreach ($hasil->result() as $sess) {
                $sess_data['logged_in'] = 'Sudah Loggin';
                $sess_data['username'] = $sess->username;
                $sess_data['password'] = $sess->password;
                $sess_data['hakakses'] = $sess->hakakses;
                $this->session->set_userdata($sess_data);
            }
            if ($this->session->userdata('hakakses') == 'admin') {
                redirect('cManipulasiSoal');
            } elseif ($this->session->userdata('hakakses') == 'siswa') {
                redirect('welcome');
            }
        } else {
            echo "<script>alert('Gagal login: Cek username, password!');history.go(-1);</script>";
        }
    }

    public function cek_siswa()
    {
        $data = array('username' => $this->input->post('username', TRUE),
            'password' => md5($this->input->post('password', TRUE))
        );
        $this->load->model('mLogin'); // load model mPengguna
        $hasil = $this->mLogin->cek_user($data);
        if ($hasil->num_rows() == 1) {
            foreach ($hasil->result() as $sess) {
                $sess_data['logged_in'] = 'Sudah Loggin';
                $sess_data['username'] = $sess->username;
                $sess_data['password'] = $sess->password;
                $sess_data['hakakses'] = $sess->hakakses;
                $this->session->set_userdata($sess_data);
            }
            if ($this->session->userdata('hakakses') == 'admin') {
                redirect('cManipulasiSoal');
            } elseif ($this->session->userdata('hakakses') == 'siswa') {
                redirect('welcome');
            }
        } else {
            echo "<script>alert('Gagal login: Cek username, password!');history.go(-1);</script>";
        }
    }

    function tambah(){
        $this->template->load('template','soal/daftar');

    }

    function tambah_act(){
        $data=array(
            'username' => $this->input->post('username'),
            'password' => $this->input->post('password'),
            'hakakses' => $this->input->post('hakakses')
        );
        $this->mLogin->mPenggunaTambahAct($data);
        redirect(base_url().'index.php/Welcome/index');
    }

    public function logout()
    {
        $this->session->unset_userdata('username');
        $this->session->unset_userdata('hakakses');
        session_destroy();
        redirect('welcome');
    }

}