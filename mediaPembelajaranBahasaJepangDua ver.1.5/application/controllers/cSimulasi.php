<?php
class cSimulasi extends CI_Controller{
    function __construct(){
        parent::__construct();
        $this->load->helper(array('url','form'));
        $this->load->library('template');
    }

    public function eksekusi(){
        $data = array(
            'command' => $this->input->post('command'),
            'terminal' => $this->input->post('terminal'),
            'hasil' => 'hasil',
            'mixed' => 'mixed',
        );

        if ($data['command']=="ls") {
            $data['hasil'] = "tampilkan list";
        } else if ($data['command']=="vi/etc/") {
            $data['hasil'] = "emboh yooo";
        } else if ($data['command']=="sudo -i") {
            $data['hasil'] = "masuk sebagai super-user";
        } else if ($data['command']=="apt-get update") {
            $data['hasil'] = "update sistem server.";
        } else if ($data['command']=="apt-get install bind9") {
            $data['hasil'] = "menginstal DNS server.";
        } else {
            $data['hasil'] = "command tidak ditemukan, silahkan coba lagi";
        }


        $this->template->load('template','simulasiEksekusi',$data);
    }


}

?>