<?php


/**
 * Purpose: Holds functs to be used in cogs project
 * Date: Oct 2018
 * @author Isaac Lohnes
 */
class cogsProjects {


    function __construct($filename) {
        //constructor
        $this->data = array();
        $this->header = array();
        $this->load($filename);   
    }
    
    private function compareAuth($x,$y){
        //function to sort by author (alphabetic) 
        return ($x[0] < $y[0])? -1 : 1;
    }
    
    private function compareYear($x,$y){
        //function to sort by year (low to high)
        return ($x[2] < $y[2])? -1 : 1;
    }
    
    public function sortFunct($compare) {
        //decides which usort to use, author, or year.
        switch ($compare) {
            case 1:
                usort($this->data, array("cogsProjects","compareAuth"));
                break;
            case 2:
                usort($this->data, array("cogsProjects","compareYear"));
                break;
        
        }
    }
     
    public function display($arrayIn) {
        //Sets title, makes table, fills table with data values
        echo '<title>PHP project</title>';
        echo "<table>";
        for($i = 0; $i < sizeof($arrayIn); $i++){
            echo "<tr>";
            
            foreach($this->header[$i] as $head){
                echo "<th>". $head ."</th>";
            } 
            echo "</tr>";
          
            echo "<tr>";
            foreach($arrayIn[$i] as $value){
                echo "<td>". $value ."</td>";
            }
            echo "</tr>";
        }
        echo "</table>";
    }
    
    public function getData() {
        //getter
        return $this->data;
    }

    private function load($filename) {
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
}
