<?php

//fun little code block to just bloop out errors:
error_reporting(-1); // display all faires
ini_set('display_errors', 1);  // ensure that faires will be seen
ini_set('display_startup_errors', 1); // display faires that didn't born

/*
 * Purpose: Middleman for DB and php pages
 * Author: Isaac Lohnes
 * Date: DEC 2018
 */

include 'DBProcessing.php';

class workWithShoppingCart {

    
    private $firstName;
    private $lastName;
    private $email;
    private $password;
    private $userName;
    private $userArr;
    private $totalProducts;
    private $prices;
    private $products; 
    private $quantity;
    private $itemsArray;
    const MAX = 4;          //eventually this should just be product count from DB.
    
    public function __construct() {
        //takes everything from page, and sets working with values to it.
        $this->userName = (filter_input(INPUT_POST, "username"));
        $this->password = (filter_input(INPUT_POST, "password"));
        $this->firstName = (filter_input(INPUT_POST, "firstName"));
        $this->lastName = (filter_input(INPUT_POST, "lastName"));
        $this->email = (filter_input(INPUT_POST, "email"));
        $this->quantity = (filter_input(INPUT_POST, "quantity"));
        $this->products = (filter_input(INPUT_POST, "product"));
    }

    public function login() {
        //login function, makes new dbpro, checks if users
        //are in DB, and changes back to index if user is not
        //verified
        $dbPro = new DBProcessing();
        $this->userArr = $dbPro->verifyUser($this->userName, $this->password);
        if ($this->userArr) {
            return true;
        } else {
            //below is nifty way to change location as script in php.
            //combine ALL the languages
            echo "<script> location.href='../index.php'; </script>";
            return false;
        }
    }

    public function userInfo() {
        //Removes PW from displaying, then displays everthing in userArr
        unset($this->userArr['password']);
        foreach ($this->userArr as $key => $value) {
            echo '<p>' . $key . ' ' . $value . '</p>';
        }
    }

    public function getUserName() {
        //getter for username
        return $this->userName;
    }

    public function getPassword() {
        //getter for PW
        return $this->password;
    }

    private function setProductName(){
        //setter, creates new dbprocessing
        $dbPro = new DBProcessing();
        $this->totalProducts = $dbPro->productInfo(1,1); 
    }
    
        private function setProductPrice(){
        //setter, creates new dbprocessing
        $dbPro = new DBProcessing();
        $this->prices = $dbPro->productInfo(2,2); 
    }

    public function createUser() {
        //function to insert new user into sql 
        $dbPro = new DBProcessing();
        if (!$dbPro->verifyCreateUser($this->userName)) {
            //if username verified, insert new user info into table on DB
            $dbPro->insertUser($this->userName, $this->password, $this->firstName, $this->lastName, $this->email);
            echo "<script> location.href='../index.php'; </script>";
        } else {
            //something here for user not able to be created, maybe
            //an alert or something, not really sure if I should
            //just redo a function here or just alert
        }
    }

    public function createProductTable() {
        //function to populate table with products
        
        //set locally
        $this->setProductName();
        $this->setProductPrice();
        
        foreach(array_combine($this->totalProducts, $this->prices) as $key=>$value){
            
            //fancy echo stuff to populate table rows
            echo '<tr><td><label><input type="checkbox" name="product[]" value="'. $key .'">' .$key. '</td><td>'.$value.'</td>';
            echo '<td><input type="number" name="quantity[]" min="0" max="10" value="0"></td></tr>';
        }
    }
   
    public function getProductInfo() {
        //displays product info, uses self::max
        
        for ($i = 0; $i < self::MAX; $i++) {
            $iter = 0;
            while ($this->totalProducts[$iter] != $this->products[$i]) {
                $iter++;
            }
            $this->itemsArray[$this->products[$i]] = $this->quantity[$iter];
        }
        foreach ($this->itemsArray as $key => $value) {
            if ($value == 0) {
                unset($this->itemsArray[$key]);
            }
        }
    }
    
    private function productTotal(){
        //display total here
    }
}
