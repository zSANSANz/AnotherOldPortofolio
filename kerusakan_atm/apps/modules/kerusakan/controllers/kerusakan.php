<?php if(!defined('BASEPATH')) exit('No direct script access allowed');

class kerusakan extends MX_Controller {

    function __construct() {
        parent::__construct();
          
        //Load IgnitedDatatables Library
        $this->load->library(array('Datatables','Ion_auth/Ion_auth'));
        $this->load->model('kerusakan_model','kerusakandb',TRUE);
        $this->load->helper(array('form','url'));
        $this->session->set_userdata('lihat','kerusakan');
        if ( !$this->ion_auth->logged_in()): 
            redirect('auth/login', 'refresh');
        endif;
    }

    public function index() {
        $this->template->set_title('Kelola Kerusakan');
        $this->template->set_layout('default');
        $this->template->add_js('var baseurl="'.base_url().'kerusakan/";','embed');  
        $this->template->add_js('modules/kerusakan.js');
        $this->template->add_js('modules/crud.js');
        $this->template->add_js('plugins/interface/datatables.min.js');
        $this->template->add_js('modules/datatables-setup.min.js');
        
        $this->ckeditor();
        $this->template->load_view('contents/index',array(
                        'title'=>'Kelola Data kerusakan',
                        'subtitle'=>'Pengelolaan kerusakan',
                        'breadcrumb'=>array(
                            'kerusakan'),
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
        $this->datatables->select('id_kerusakan,kode,kerusakan,keterangan,penyebab,penanggulangan,datetime,isactive')
                        ->from('kerusakan');
        echo $this->datatables->generate();
    }

    public function get($id_kerusakan=null){
        if($id_kerusakan!==null){
            echo json_encode($this->kerusakandb->get_one($id_kerusakan));
        }
    }

    public function submit(){
        if ($this->input->post('ajax')){
          if ($this->input->post('id_kerusakan')){
            $this->kerusakandb->update($this->input->post('id_kerusakan'));
          }else{
            $this->kerusakandb->save();
          }

        }else{
          if ($this->input->post('submit')){
              if ($this->input->post('id_kerusakan')){
                $this->kerusakandb->update($this->input->post('id_kerusakan'));
              }else{
                $this->kerusakandb->save();
              }
          }
        }
    }

    public function delete(){
        if(isset($_POST['ajax'])){
            if(!empty($_POST['id'])){
                $this->kerusakandb->delete($this->input->post('id'));
                $this->session->set_flashdata('notif','Succeed, Data Has Deleted');
            }else {
                $this->session->set_flashdata('notif', 'Failed! No Data Deleted');
            }
        }
    }
}
