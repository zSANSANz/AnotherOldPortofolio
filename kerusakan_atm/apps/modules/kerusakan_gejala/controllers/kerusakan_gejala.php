<?php if(!defined('BASEPATH')) exit('No direct script access allowed');

class kerusakan_gejala extends MX_Controller {

    function __construct() {
        parent::__construct();
          
        //Load IgnitedDatatables Library
        $this->load->library(array('Datatables','Ion_auth/Ion_auth'));
        $this->load->model('kerusakan_gejala_model','kerusakan_gejaladb',TRUE);
        $this->load->helper(array('form','url'));
        $this->session->set_userdata('lihat','kerusakan_gejala');
        if ( !$this->ion_auth->logged_in()): 
            redirect('auth/login', 'refresh');
        endif;
    }

    public function index() {
        $this->template->set_title('Kelola kerusakan_gejala');
        $this->template->set_layout('default');
        $this->template->add_js('var baseurl="'.base_url().'kerusakan_gejala/";','embed');  
        $this->template->add_js('modules/kerusakan_gejala.js');
        $this->template->add_js('modules/crud.min.js');
        $this->template->add_js('plugins/interface/datatables.min.js');
        $this->template->add_js('modules/datatables-setup.min.js');
        
        $this->ckeditor();
        $this->template->load_view('contents/index',array(
                        'title'=>'Kelola Data kerusakan_gejala',
                        'subtitle'=>'Pengelolaan kerusakan_gejala',
                        'breadcrumb'=>array(
                            'kerusakan_gejala'),
                        ));
        
    }
     
    public function ckeditor(){
        session_start();
            $_SESSION['KCFINDER']=array();
            $_SESSION['kcfinder'] = FALSE;
            $_SESSION['KCFINDER']['disabled'] = false;
            $_SESSION['KCFINDER']['uploadURL'] = "../uploads";
            // $this->template->load_view('ckeditor/admin');

    }
    //<!-- Start Primary Key -->
    

    public function getdatatables(){
        $this->datatables->select('id_peny_gejala,id_kerusakan,id_gejala,density,datetime,')
                        ->from('kerusakan_gejala');
        echo $this->datatables->generate();
    }

   

    public function get($id_peny_gejala=null){
        if($id_peny_gejala!==null){
            echo json_encode($this->kerusakan_gejaladb->get_one($id_peny_gejala));
        }
    }

    public function submit(){
        if ($this->input->post('ajax')){
          if ($this->input->post('id_peny_gejala')){
            $this->kerusakan_gejaladb->update($this->input->post('id_peny_gejala'));
          }else{
            $this->kerusakan_gejaladb->save();
          }

        }else{
          if ($this->input->post('submit')){
              if ($this->input->post('id_peny_gejala')){
                $this->kerusakan_gejaladb->update($this->input->post('id_peny_gejala'));
              }else{
                $this->kerusakan_gejaladb->save();
              }
          }
        }
    }

    
    public function delete(){
        if(isset($_POST['ajax'])){
            if(!empty($_POST['id'])){
                $this->kerusakan_gejaladb->delete($this->input->post('id'));
                $this->session->set_flashdata('notif','Succeed, Data Has Deleted');
            }else {
                $this->session->set_flashdata('notif', 'Failed! No Data Deleted');
            }
        }
    }
    

}
