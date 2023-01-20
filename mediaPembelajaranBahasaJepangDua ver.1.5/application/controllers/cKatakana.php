<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class cKatakana extends CI_Controller
{
    public function index() {
        $this->template->load('template', 'katakana.php');
    }
}
