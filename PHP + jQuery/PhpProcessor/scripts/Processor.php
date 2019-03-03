

<?php

/* 
 * Purpose: Process an order
 * Author: Isaac Lohnes
 * Date:  11/2018
 */

class Processor {

    private $date;
    private $email;
    private $fName;
    private $lName;
    
    
    //Seperate arrays for field population
    private $iArray = array();      //Items
    private $pArray = array("deluminator" => 150, "snitch" => 400, "cloak" => 99.99, "map" => 50, "stone" => 19.95, "wand" => 69.99);   //Prices
    private $proArray = array();    //Products
    private $qArray = array();      //Quantities
    
    function __construct() {
        //Constructor, gets from index and passes data to arrays
        //uses post. 
        $this->fName = (filter_input(INPUT_POST, "fname"));
        $this->lName = (filter_input(INPUT_POST, "lname"));
        $this->date = (filter_input(INPUT_POST, "odate"));
        $this->email = (filter_input(INPUT_POST, "useremail"));
        $this->proArray = (filter_input(INPUT_POST, "product", FILTER_SANITIZE_STRING, FILTER_REQUIRE_ARRAY));
        $this->qArray = (filter_input(INPUT_POST, "quantity", FILTER_SANITIZE_STRING, FILTER_REQUIRE_ARRAY));
    }
    
    
    public function display() {
        //Displays on second page.
        
        //init at 0.
        $total = 0;
        
        //Below is name/info outside of table.
        echo "<h4>Name: " . $this->fName . " " . $this->lName . "</h4>";
        echo "<h4>Email: " . $this->email . "</h4>";
        echo "<h4>Your purchases on " . $this->date . " : </h4><table>";
        echo "<tr><th>Product</th><th>Unit Price</th><th> Quantity</th><th>Total</th>";
        
        
        //Populate table
        foreach ($this->iArray as $k => $v) {
            echo "<tr><td>" . $k . "</td><td>" . "$" . $this->pArray[$k]. "</td><td>" . $v . "</td><td>" . "$" . $this->pArray[$k] * $v . "</td></tr>";
            
            $total += $this->pArray[$k] * $v;
        }

        //Calculate final after HST, which is calculated after first total.
        $HST = $total * 0.15;
        $final = $total + $HST;
        
        
        
        
        //Table population for prices
        echo "<tr><th>Item Total: </th><td colspan='2'></td><th>" . "$" . round($total, 2) . "</th></tr>";
        echo "<th>HST: </th><td colspan='2'></td><th>" . "$" . round($HST, 2) . "</th></tr>";
        echo "<th>Grand Total: </th><td colspan='2'></td><th>" . "$" . round($final, 2) . "</th></tr></table>";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public function getOrder() {
        //Getter for populating arraies with data from php
        
        //Standard temp to hold data.
        $temp = array_keys($this->pArray);
        
        //
        foreach($this->proArray as $p) {
            $i = 0;
            while($temp[$i] != $p) {
                $i++;
            }
            $this->iArray[$p] = $this->qArray[$i];
        }
        
        
        
        
        //gets rid of null data.
        foreach($this->iArray as $key => $value) {
            if($value == 0) {
                unset($this->iArray[$key]);
                
            }
        }
    }
    
}






















