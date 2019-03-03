<?php


/**
 * Purpose: Holds functs to be used in cogs project
 * Date: Oct 2018
 * @author Isaac Lohnes
 */
class cogsProjects {



    private $data = array();
    private $header = array();
        

    public function convertHeader(){
        //big varchar values to just take all sorts of data into arr and combine / return it
        $dataTypes = array("VARCHAR(2000)","VARCHAR(2000)","VARCHAR(2000)","VARCHAR(2000)","VARCHAR(2000)","VARCHAR(2000)","VARCHAR(2000)");
        $map = array_combine($this->header[0], $dataTypes);
        return $map;
    }
    

    public function load($filename) {
        //load funtion. Pretty standard. Opens stuff 
        
        $boolTest = true;
        if (($handle = fopen($filename, 'r')) !== FALSE) {
            while (($row = fgetcsv($handle, 1000, ',')) !== FALSE) {
                if ($boolTest) {
                    $this->header[] = $row;
                    $boolTest = false;
                } else {
                    $this->data[] = $row;
                }
            }
            fclose($handle);
        }
    }

    public function setData($dataReturn) {
        //setter
        $this->data = $dataReturn;
    }    
    
    public function getData() {
        //getter
        return $this->data;
    }
    public function setHeader($header) {
        //setter
        $this->header = $header;
    }    
    
    public function getHeader() {
        //getter
        return $this->header[0];
    }
    
}
