<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class cHiragana extends CI_Controller
{
    public function index() {
        $this->template->load('template', 'hiragana.php');
    }
}