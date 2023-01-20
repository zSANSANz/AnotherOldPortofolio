<?php if(!defined('BASEPATH')) exit('No direct script access allowed');


class kerusakan_gejala_model extends CI_Model {

    function __construct() {
        parent::__construct();
    }

    function get_all($limit, $uri) {

        $result = $this->db->get('kerusakan_gejala', $limit, $uri);
        if ($result->num_rows() > 0) {
            return $result->result_array();
        } else {
            return array();
        }
    }
    
    function get_one($id_kerusakan_gejala) {
        $this->db->where('id_kerusakan_gejala', $id_kerusakan_gejala);
        $result = $this->db->get('kerusakan_gejala');
        if ($result->num_rows() == 1) {
            return $result->row_array();
        } else {
            return array();
        }
    }

    function save() {
           $data = array(
        
            'id_kerusakan' => $this->input->post('id_kerusakan', TRUE),
           
            'id_gejala' => $this->input->post('id_gejala', TRUE),
           
            'density' => $this->input->post('density', TRUE),
           
           'datetime' => date('Y-m-d H:i:s'),
           
        );
        $this->db->insert('kerusakan_gejala', $data);
    }

    function update($id_kerusakan_gejala) {
        $data = array(
        'id_kerusakan_gejala' => $this->input->post('id_kerusakan_gejala',TRUE),
       'id_kerusakan' => $this->input->post('id_kerusakan', TRUE),
       
       'id_gejala' => $this->input->post('id_gejala', TRUE),
       
       'density' => $this->input->post('density', TRUE),
       
       'datetime' => date('Y-m-d H:i:s'),
       
        );
        $this->db->where('id_kerusakan_gejala', $id_kerusakan_gejala);
        $this->db->update('kerusakan_gejala', $data);
        /*'datetime' => date('Y-m-d H:i:s'),*/
    }

    function delete($id_kerusakan_gejala) {
        $this->db->where('id_kerusakan_gejala', $id_kerusakan_gejala);
        $this->db->delete('kerusakan_gejala'); 
       
    }

    //Update 07122013 SWI
    //untuk Array Dropdown
    function get_dropdown_array($value){
        $result = array();
        $array_keys_values = $this->db->query('select id_kerusakan_gejala, '.$value.' from kerusakan_gejala order by id_kerusakan_gejala asc');
        $result[0]="-- Pilih Urutan id_kerusakan_gejala --";
        foreach ($array_keys_values->result() as $row)
        {
            $result[$row->id_kerusakan_gejala]= $row->$value;
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
