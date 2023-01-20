<?php

class mLogin extends CI_Controller
{
    function __construct()
    {
        parent::__construct();
        $this->load->database();
    }

    public function cek_user($data)
    {
        $query = $this->db->get_where('tb_login', $data);
        return $query;
    }

    function mPenggunaTambahAct() {
        $username = $this->input->post('username');
        $password = md5($this->input->post('password'));
        $hakakses = $this->input->post('hakakses');

        $data = array (
            'username'=> $username,
            'password'=> $password,
            'hakakses'=> $hakakses,
        );

        $this->db->insert('tb_login', $data);
        $tambah = $this->db->get('tb_login');
        return $tambah->result();
    }

    

}