<?php

class cSoalAcak extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        $this->load->database();
        $this->load->library('session');
        $this->load->helper(array('url', 'form'));
        $this->load->library('session');
        $this->load->model('mSoalAcak');
        $this->load->library('template');
    }

    function index()
    {

        $username = $this->session->userdata('username');


        $dataSatu = $this->db->query("SELECT * FROM tb_login WHERE username ='" . $username . "'");

        if ($username == null) {
            redirect('cSoal/errorTampilSiswa');
        } else {
            foreach ($dataSatu->result() as $point) {
                if ($point->point < 0) {
                    redirect('cSoal/errorTampilSiswa');
                }
            }
        }

        $data['dataSoal'] = $this->mSoalAcak->mSoalAcakLihatEvaluasi();
        $data['dataJawaban'] = $this->mSoalAcak->mJawabanAcakLihatEvaluasi();
        $this->template->load('template', 'soal/evaluasi', $data);
    }

    function errorTampil()
    {
        $data['data'] = $this->mSoal->mSoalLihat();
        $this->template->load('template', 'soal/errorAdmin', $data);
    }

    function errorTampilSiswa()
    {
        $data['data'] = $this->mSoal->mSoalLihat();
        $this->template->load('template', 'soal/errorTampilSiswa', $data);
    }

    function indexSatu()
    {
        $username = $this->session->userdata('username');

        $dataSatu = $this->db->query("SELECT * FROM tb_login WHERE username ='" . $username . "'");
        if ($username == null) {
            redirect('cSoal/errorTampilSiswa');
        } else {

            foreach ($dataSatu->result() as $point) {
                if ($point->point < 0) {
                    redirect('cSoal/errorTampilSiswa');
                }
            }
        }

        $data['dataSoal'] = $this->mSoalAcak->mSoalAcakLihatSatu();
        $data['dataJawaban'] = $this->mSoalAcak->mJawabanAcakLihatSatu();
        $this->template->load('template', 'soal/materiSatuSoalAcak', $data);
    }

    function indexDua()
    {
        $username = $this->session->userdata('username');

        $dataSatu = $this->db->query("SELECT * FROM tb_login WHERE username ='" . $username . "'");
        if ($username == null) {
            redirect('cSoal/errorTampilSiswa');
        } else {

            foreach ($dataSatu->result() as $point) {
                if ($point->point < 1) {
                    redirect('cSoal/errorTampilSiswa');
                }
            }
        }

        $data['dataSoal'] = $this->mSoalAcak->mSoalAcakLihatDua();
        $data['dataJawaban'] = $this->mSoalAcak->mJawabanAcakLihatDua();
        $this->template->load('template', 'soal/materiDuaSoalAcak', $data);
    }

    function indexTiga()
    {

        $username = $this->session->userdata('username');


        $dataSatu = $this->db->query("SELECT * FROM tb_login WHERE username ='" . $username . "'");
        if ($username == null) {
            redirect('cSoal/errorTampilSiswa');
        } else {

            foreach ($dataSatu->result() as $point) {
                if ($point->point < 2) {
                    redirect('cSoal/errorTampilSiswa');
                }
            }
        }

        $data['dataSoal'] = $this->mSoalAcak->mSoalAcakLihatTiga();
        $data['dataJawaban'] = $this->mSoalAcak->mJawabanAcakLihatTiga();
        $this->template->load('template', 'soal/materiTigaSoalAcak', $data);
    }

    function indexEmpat()
    {

        $username = $this->session->userdata('username');


        $dataSatu = $this->db->query("SELECT * FROM tb_login WHERE username ='" . $username . "'");
        if ($username == null) {
            redirect('cSoal/errorTampilSiswa');
        } else {

            foreach ($dataSatu->result() as $point) {
                if ($point->point < 3) {
                    redirect('cSoal/errorTampilSiswa');
                }
            }
        }

        $data['dataSoal'] = $this->mSoalAcak->mSoalAcakLihatEmpat();
        $data['dataJawaban'] = $this->mSoalAcak->mJawabanAcakLihatEmpat();
        $this->template->load('template', 'soal/materiEmpatSoalAcak', $data);
    }

    public
    function hasilAcak()
    {

        $data = array(
            'username' => $this->session->userdata('username'),
            'materi' => $this->input->post('materi'),
            'soalSatu' => $this->input->post('soal1'),
            'soalDua' => $this->input->post('soal2'),
            'soalTiga' => $this->input->post('soal3'),
            'soalEmpat' => $this->input->post('soal4'),
            'soalLima' => $this->input->post('soal5'),
            'soalEnam' => $this->input->post('soal6'),
            'soalTuju' => $this->input->post('soal7'),
            'soalDelapan' => $this->input->post('soal8'),
            'soalSembilan' => $this->input->post('soal9'),
            'soalSepuluh' => $this->input->post('soal10'),

            'nilai' => 0,
        );

        $data['nilai'] = ($data['soalSatu'] +
                $data['soalDua'] +
                $data['soalTiga'] +
                $data['soalEmpat'] +
                $data['soalLima'] +
                $data['soalEnam'] +
                $data['soalTuju'] +
                $data['soalDelapan'] +
                $data['soalSembilan'] +
                $data['soalSepuluh']) * 10;

        if ($data['nilai'] >= 70) {
            $usernamePoint = $this->session->userdata('username');
            $dataPoint = array(
                'point' => $this->input->post('point'),
            );
            $this->mSoalAcak->mPenggunaUpdateAct($dataPoint, $usernamePoint);
        }

        $nilai = $data['nilai'];
        $username = $data['username'];
        $materi = $this->input->post('materi');

        $data = ['nilai' => $nilai, 'materi' => $materi, 'username' => $username,];

        $this->db->insert('tb_nilai', $data);

        $this->template->load('template', 'soal/hasilSoal', $data);
    }


    public
    function hasil()
    {

        $data = array(
            'username' => $this->session->userdata('username'),
            'soalSatu' => $this->input->post('soal1'),
            'soalDua' => $this->input->post('soal2'),
            'soalTiga' => $this->input->post('soal3'),
            'soalEmpat' => $this->input->post('soal4'),
            'soalLima' => $this->input->post('soal5'),
            'soalEnam' => $this->input->post('soal6'),
            'soalTuju' => $this->input->post('soal7'),
            'soalDelapan' => $this->input->post('soal8'),
            'soalSembilan' => $this->input->post('soal9'),
            'soalSepuluh' => $this->input->post('soal10'),

            'soalSatuSatu' => $this->input->post('soal11'),
            'soalSatuDua' => $this->input->post('soal12'),
            'soalSatuTiga' => $this->input->post('soal13'),
            'soalSatuEmpat' => $this->input->post('soal14'),
            'soalSatuLima' => $this->input->post('soal15'),
            'soalSatuEnam' => $this->input->post('soal16'),
            'soalSatuTuju' => $this->input->post('soal17'),
            'soalSatuDelapan' => $this->input->post('soal18'),
            'soalSatuSembilan' => $this->input->post('soal19'),
            'soalSatuSepuluh' => $this->input->post('soal20'),



            'nilai' => 0,
        );

        $data['nilai'] = (($data['soalSatu'] +
                $data['soalDua'] +
                $data['soalTiga'] +
                $data['soalEmpat'] +
                $data['soalLima'] +
                $data['soalEnam'] +
                $data['soalTuju'] +
                $data['soalDelapan'] +
                $data['soalSembilan'] +
                $data['soalSepuluh'] +
                $data['soalSatuSatu'] +
                $data['soalSatuDua'] +
                $data['soalSatuTiga'] +
                $data['soalSatuEmpat'] +
                $data['soalSatuLima'] +
                $data['soalSatuEnam'] +
                $data['soalSatuTuju'] +
                $data['soalSatuDelapan'] +
                $data['soalSatuSembilan'] +
                $data['soalSatuSepuluh']) * 5);

        $nilai = $data['nilai'];
        $username = $data['username'];
        $materi = $this->input->post('materi');

        $data = ['nilai' => $nilai, 'materi' => $materi, 'username' => $username,];

        $this->db->insert('tb_nilai', $data);


        $this->template->load('template', 'soal/hasilSoal', $data);

    }

    public
    function hasilSatu()
    {
        $data = array(
            'username' => $this->session->userdata('username'),
            'soalSatu' => $this->input->post('soal1'),
            'soalDua' => $this->input->post('soal2'),
            'soalTiga' => $this->input->post('soal3'),
            'soalEmpat' => $this->input->post('soal4'),
            'soalLima' => $this->input->post('soal5'),
            'soalEnam' => $this->input->post('soal6'),
            'soalTuju' => $this->input->post('soal7'),
            'soalDelapan' => $this->input->post('soal8'),
            'soalSembilan' => $this->input->post('soal9'),
            'soalSepuluh' => $this->input->post('soal10'),

            'jawabanSatu' => $this->input->post('jawaban1'),
            'jawabanDua' => $this->input->post('jawaban2'),
            'jawabanTiga' => $this->input->post('jawaban3'),
            'jawabanEmpat' => $this->input->post('jawaban4'),
            'jawabanLima' => $this->input->post('jawaban5'),
            'jawabanEnam' => $this->input->post('jawaban6'),
            'jawabanTuju' => $this->input->post('jawaban7'),
            'jawabanDelapan' => $this->input->post('jawaban8'),
            'jawabanSembilan' => $this->input->post('jawaban9'),
            'jawabanSepuluh' => $this->input->post('jawaban10'),


            'nilai' => 0,
        );

        define('nilai', 'nilai');

        $data[nilai] = 0;

        if ($data['jawabanSatu'] == $data['soalSatu']) {
            $data[nilai] = $data[nilai] + 10;
        }
        if ($data['jawabanDua'] == $data['soalDua']) {
            $data[nilai] = $data[nilai] + 10;
        }
        if ($data['jawabanTiga'] == $data['soalTiga']) {
            $data[nilai] = $data[nilai] + 10;
        }
        if ($data['jawabanEmpat'] == $data['soalEmpat']) {
            $data[nilai] = $data[nilai] + 10;
        }
        if ($data['jawabanLima'] == $data['soalLima']) {
            $data[nilai] = $data[nilai] + 10;
        }
        if ($data['jawabanEnam'] == $data['soalEnam']) {
            $data[nilai] = $data[nilai] + 10;
        }
        if ($data['jawabanTuju'] == $data['soalTuju']) {
            $data[nilai] = $data[nilai] + 10;
        }
        if ($data['jawabanDelapan'] == $data['soalDelapan']) {
            $data[nilai] = $data[nilai] + 10;
        }
        if ($data['jawabanSembilan'] == $data['soalSembilan']) {
            $data[nilai] = $data[nilai] + 10;
        }
        if ($data['jawabanSepuluh'] == $data['soalSepuluh']) {
            $data[nilai] = $data[nilai] + 10;
        }

        if ($data[nilai] >= 70) {
            $usernamePoint = $this->session->userdata('username');
            $dataPoint = array(
                'point' => $this->input->post('point'),
            );
            $this->mSoal->mPenggunaUpdateAct($dataPoint, $usernamePoint);
        }

        $this->template->load('template', 'soal/hasilSoal', $data);
    }
}

?>