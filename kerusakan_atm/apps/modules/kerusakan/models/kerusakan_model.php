<?php if(!defined('BASEPATH')) exit('No direct script access allowed');


class kerusakan_model extends CI_Model {

    function __construct() {
        parent::__construct();
    }

    function get_all($limit, $uri) {

        $result = $this->db->get('kerusakan', $limit, $uri);
        if ($result->num_rows() > 0) {
            return $result->result_array();
        } else {
            return array();
        }
    }
    
    function get_one($id_kerusakan) {
        $this->db->where('id_kerusakan', $id_kerusakan);
        $result = $this->db->get('kerusakan');
        if ($result->num_rows() == 1) {
            return $result->row_array();
        } else {
            return array();
        }
    }

    function save() {
           $data = array(
        
            'kode' => $this->input->post('kode', TRUE),
           
            'kerusakan' => $this->input->post('kerusakan', TRUE),
           
            'keterangan' => $this->input->post('keterangan', TRUE),
           
            'penyebab' => $this->input->post('penyebab', TRUE),
           
            'penanggulangan' => $this->input->post('penanggulangan', TRUE),
            'isactive' => $this->input->post('aktif', TRUE),
            'isadmin' => $this->input->post('isadmin', TRUE),
           
            'datetime' => date('Y-m-d H:i:s'),
           
        );
        $this->db->insert('kerusakan', $data);
    }

    function update($id_kerusakan) {
        $data = array(
        'id_kerusakan' => $this->input->post('id_kerusakan',TRUE),
       'kode' => $this->input->post('kode', TRUE),
       
       'kerusakan' => $this->input->post('kerusakan', TRUE),
       
       'keterangan' => $this->input->post('keterangan', TRUE),
       
       'penyebab' => $this->input->post('penyebab', TRUE),
       
       'penanggulangan' => $this->input->post('penanggulangan', TRUE),
        'isactive' => $this->input->post('aktif', TRUE),
        'isadmin' => $this->input->post('isadmin', TRUE),
           
       'datetime' => date('Y-m-d H:i:s'),
        );
        $this->db->where('id_kerusakan', $id_kerusakan);
        $this->db->update('kerusakan', $data);
        /*'datetime' => date('Y-m-d H:i:s'),*/
    }

    function delete($id_kerusakan) {
        $this->db->where('id_kerusakan', $id_kerusakan);
        $this->db->delete('kerusakan'); 
       
    }

    //Update 07122013 SWI
    //untuk Array Dropdown
    function get_dropdown_array($value){
        $result = array();
        $array_keys_values = $this->db->query('select id_kerusakan, '.$value.' from kerusakan order by id_kerusakan asc');
        $result[0]="-- Pilih Urutan id_kerusakan --";
        foreach ($array_keys_values->result() as $row)
        {
            $result[$row->id_kerusakan]= $row->$value;
        }
        return $result;
    }

    //Update 30122014 SWI
    //untuk Array Dropdown dari database yang lain
    function get_drop_array($db,$key,$value){
        $result = array();
        $array_keys_values = $this->db->query('select '.$key.','.$value.' from '.$db.' order by '.$key.' asc');
        $result[0]="-- Pilih ".$value." --";
        foreach ($array_keys_values->result() as $row)
        {
            $result[$row->$key]= $row->$value;
        }
        return $result;
    }
    
}
?>
