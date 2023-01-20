<?php

class cSoal extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        $this->load->database();
        $this->load->library('session');
        $this->load->helper(array('url', 'form'));
        $this->load->library('session');
        $this->load->model('mSoal');
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
                if ($point->point < 4) {
                    redirect('cSoal/errorTampilSiswa');
                }
            }
        }


        $data['data'] = $this->mSoal->mSoalLihat();
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
        $data['data'] = $this->mSoal->mSoalLihatSatu();
        $this->template->load('template', 'soal/materiSatuSoal', $data);
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

        $data['data'] = $this->mSoal->mSoalLihatDua();
        $this->template->load('template', 'soal/materiDuaSoal', $data);
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

        $data['data'] = $this->mSoal->mSoalLihatTiga();
        $this->template->load('template', 'soal/materiTigaSoal', $data);
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
        $data['data'] = $this->mSoal->mSoalLihatEmpat();
        $this->template->load('template', 'soal/materiEmpatSoal', $data);
    }

    public function hasil()
    {


        $data = array(
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

            'soalDuaSatu' => $this->input->post('soal21'),
            'soalDuaDua' => $this->input->post('soal22'),
            'soalDuaTiga' => $this->input->post('soal23'),
            'soalDuaEmpat' => $this->input->post('soal24'),
            'soalDuaLima' => $this->input->post('soal25'),
            'soalDuaEnam' => $this->input->post('soal26'),
            'soalDuaTuju' => $this->input->post('soal27'),
            'soalDuaDelapan' => $this->input->post('soal28'),
            'soalDuaSembilan' => $this->input->post('soal29'),
            'soalDuaSepuluh' => $this->input->post('soal30'),

            'soalTigaSatu' => $this->input->post('soal31'),
            'soalTigaDua' => $this->input->post('soal32'),
            'soalTigaTiga' => $this->input->post('soal33'),
            'soalTigaEmpat' => $this->input->post('soal34'),
            'soalTigaLima' => $this->input->post('soal35'),
            'soalTigaEnam' => $this->input->post('soal36'),
            'soalTigaTuju' => $this->input->post('soal37'),
            'soalTigaDelapan' => $this->input->post('soal38'),
            'soalTigaSembilan' => $this->input->post('soal39'),
            'soalTigaSepuluh' => $this->input->post('soal40'),

            'soalEmpatSatu' => $this->input->post('soal41'),
            'soalEmpatDua' => $this->input->post('soal42'),
            'soalEmpatTiga' => $this->input->post('soal43'),
            'soalEmpatEmpat' => $this->input->post('soal44'),
            'soalEmpatLima' => $this->input->post('soal45'),
            'soalEmpatEnam' => $this->input->post('soal46'),
            'soalEmpatTuju' => $this->input->post('soal47'),
            'soalEmpatDelapan' => $this->input->post('soal48'),
            'soalEmpatSembilan' => $this->input->post('soal49'),
            'soalEmpatSepuluh' => $this->input->post('soal50'),


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

            'jawabanSatuSatu' => $this->input->post('jawaban11'),
            'jawabanSatuDua' => $this->input->post('jawaban12'),
            'jawabanSatuTiga' => $this->input->post('jawaban13'),
            'jawabanSatuEmpat' => $this->input->post('jawaban14'),
            'jawabanSatuLima' => $this->input->post('jawaban15'),
            'jawabanSatuEnam' => $this->input->post('jawaban16'),
            'jawabanSatuTuju' => $this->input->post('jawaban17'),
            'jawabanSatuDelapan' => $this->input->post('jawaban18'),
            'jawabanSatuSembilan' => $this->input->post('jawaban19'),
            'jawabanSatuSepuluh' => $this->input->post('jawaban20'),

            'jawabanDuaSatu' => $this->input->post('jawaban21'),
            'jawabanDuaDua' => $this->input->post('jawaban22'),
            'jawabanDuaTiga' => $this->input->post('jawaban23'),
            'jawabanDuaEmpat' => $this->input->post('jawaban24'),
            'jawabanDuaLima' => $this->input->post('jawaban25'),
            'jawabanDuaEnam' => $this->input->post('jawaban26'),
            'jawabanDuaTuju' => $this->input->post('jawaban27'),
            'jawabanDuaDelapan' => $this->input->post('jawaban28'),
            'jawabanDuaSembilan' => $this->input->post('jawaban29'),
            'jawabanDuaSepuluh' => $this->input->post('jawaban30'),

            'jawabanTigaSatu' => $this->input->post('jawaban31'),
            'jawabanTigaDua' => $this->input->post('jawaban32'),
            'jawabanTigaTiga' => $this->input->post('jawaban33'),
            'jawabanTigaEmpat' => $this->input->post('jawaban34'),
            'jawabanTigaLima' => $this->input->post('jawaban35'),
            'jawabanTigaEnam' => $this->input->post('jawaban36'),
            'jawabanTigaTuju' => $this->input->post('jawaban37'),
            'jawabanTigaDelapan' => $this->input->post('jawaban38'),
            'jawabanTigaSembilan' => $this->input->post('jawaban39'),
            'jawabanTigaSepuluh' => $this->input->post('jawaban40'),

            'jawabanEmpatSatu' => $this->input->post('jawaban41'),
            'jawabanEmpatDua' => $this->input->post('jawaban42'),
            'jawabanEmpatTiga' => $this->input->post('jawaban43'),
            'jawabanEmpatEmpat' => $this->input->post('jawaban44'),
            'jawabanEmpatLima' => $this->input->post('jawaban45'),
            'jawabanEmpatEnam' => $this->input->post('jawaban46'),
            'jawabanEmpatTuju' => $this->input->post('jawaban47'),
            'jawabanEmpatDelapan' => $this->input->post('jawaban48'),
            'jawabanEmpatSembilan' => $this->input->post('jawaban49'),
            'jawabanEmpatSepuluh' => $this->input->post('jawaban50'),


            'nilai' => 0,
        );

        define('nilai', 'nilai');

        $data[nilai] = 0;

        if ($data['jawabanSatu'] == $data['soalSatu']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanDua'] == $data['soalDua']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanTiga'] == $data['soalTiga']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanEmpat'] == $data['soalEmpat']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanLima'] == $data['soalLima']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanEnam'] == $data['soalEnam']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanTuju'] == $data['soalTuju']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanDelapan'] == $data['soalDelapan']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanSembilan'] == $data['soalSembilan']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanSepuluh'] == $data['soalSepuluh']) {
            $data[nilai] = $data[nilai] + 2;
        }

        if ($data['jawabanSatuSatu'] == $data['soalSatuSatu']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanSatuDua'] == $data['soalSatuDua']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanSatuTiga'] == $data['soalSatuTiga']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanSatuEmpat'] == $data['soalSatuEmpat']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanSatuLima'] == $data['soalSatuLima']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanSatuEnam'] == $data['soalSatuEnam']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanSatuTuju'] == $data['soalSatuTuju']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanSatuDelapan'] == $data['soalSatuDelapan']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanSatuSembilan'] == $data['soalSatuSembilan']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanSatuSepuluh'] == $data['soalSatuSepuluh']) {
            $data[nilai] = $data[nilai] + 2;
        }

        if ($data['jawabanDuaSatu'] == $data['soalDuaSatu']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanDuaDua'] == $data['soalDuaDua']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanDuaTiga'] == $data['soalDuaTiga']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanDuaEmpat'] == $data['soalDuaEmpat']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanDuaLima'] == $data['soalDuaLima']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanDuaEnam'] == $data['soalDuaEnam']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanDuaTuju'] == $data['soalDuaTuju']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanDuaDelapan'] == $data['soalDuaDelapan']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanDuaSembilan'] == $data['soalDuaSembilan']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanDuaSepuluh'] == $data['soalDuaSepuluh']) {
            $data[nilai] = $data[nilai] + 2;
        }

        if ($data['jawabanTigaSatu'] == $data['soalTigaSatu']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanTigaDua'] == $data['soalTigaDua']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanTigaTiga'] == $data['soalTigaTiga']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanTigaEmpat'] == $data['soalTigaEmpat']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanTigaLima'] == $data['soalTigaLima']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanTigaEnam'] == $data['soalTigaEnam']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanTigaTuju'] == $data['soalTigaTuju']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanTigaDelapan'] == $data['soalTigaDelapan']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanTigaSembilan'] == $data['soalTigaSembilan']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanTigaSepuluh'] == $data['soalTigaSepuluh']) {
            $data[nilai] = $data[nilai] + 2;
        }

        if ($data['jawabanEmpatSatu'] == $data['soalEmpatSatu']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanEmpatDua'] == $data['soalEmpatDua']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanEmpatTiga'] == $data['soalEmpatTiga']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanEmpatEmpat'] == $data['soalEmpatEmpat']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanEmpatLima'] == $data['soalEmpatLima']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanEmpatEnam'] == $data['soalEmpatEnam']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanEmpatTuju'] == $data['soalEmpatTuju']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanEmpatDelapan'] == $data['soalEmpatDelapan']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanEmpatSembilan'] == $data['soalEmpatSembilan']) {
            $data[nilai] = $data[nilai] + 2;
        }
        if ($data['jawabanEmpatSepuluh'] == $data['soalEmpatSepuluh']) {
            $data[nilai] = $data[nilai] + 2;
        }


        $this->template->load('template', 'soal/hasilSoal', $data);


    }

    public function hasilSatu()
    {
        $data = array(
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