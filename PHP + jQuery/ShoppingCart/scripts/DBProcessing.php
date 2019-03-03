<?php



/**
 * Database processing PHP
 * Processing for working with DB for shopping cart
 * @author Isaac Lohnes
 */
class DBProcessing {
    private $connection;
    private $result;
           
    public function __construct() {
        //on construction, uses setConnection function with user info to connect to DB
        $this -> setConnection("localhost","w0409360","zvidttM2g9eOXEWF","w0409360");
    }
        
    public function disconnect(){
        //Kills connection, closes.
        $this -> connection -> kill($this -> connection -> thread_id);
        $this -> connection -> close();
    }
   
    public function setConnection($host,$user,$pass,$db){
        //Connects with mysqli.
        $this -> connection = new mysqli($host, $user, $pass, $db);

        if ($this -> connection ->connect_error) {
                printf("Connection failed: %s\n", $this -> connection ->connect_error);
                
        } else {
        }
    }
    
    
    

    public function insertUser($username, $password, $firstname, $lastname, $email) {
        //function to insert new users to DB
        
        //SQL statement to execute and return based on pass.
        $sql = "INSERT INTO Shopper VALUES ( '$username' , '$password' , '$firstname' , '$lastname', '$email' );";
        
        //error handling below
        if ($this->executeQuery($sql)) {
            return true;
        } else {
            return false;
        }
    }

    public function verifyCreateUser($username) {
        //Function to call when new user is attempted to be created, and 
        //and checks if the statement run has any rows, so duplicate users
        //cannot be created
        $sql = "SELECT * FROM Shopper WHERE username='$username';";
        $result = $this->executeQuery($sql);
        
        
        $verify = mysqli_num_rows($result);
        if ($verify == 0) {
            return true;
        } else {
            return false;
        }
    }

    public function verifyUser($username, $password) {
        //funct to get userInfo
        
        $sql = "SELECT * FROM Shopper WHERE username='$username' AND password='$password';";
        $result = $this -> executeQuery($sql);
        
        $count = mysqli_num_rows($result);
        $userInfo = $result->fetch_array(MYSQLI_ASSOC);
        
        //return is user info is available
        if ($count == 1) {
            return $userInfo;
        } else {
            return false;
        }
    }
    
    public function productInfo($first, $last){
        //function to get product info
        $productInfo = array();
        $sql = "SELECT * FROM Product;";
        $result = $this -> executeQuery($sql);
        
        while ($row = $result->fetch_array(MYSQLI_ASSOC)) {
            
            $split = array_slice($row, $first, $last);
            foreach($split as $value){
                 array_push($productInfo, $value);
            }
       }
        return $productInfo;
    }


    private function executeQuery($sql) {
        //Simple query running function, for error handling.
        
        $result = $this -> connection ->query($sql);
        if (!$result) {
            throw Exception($this -> connection -> error);
        }
        return $result;
    }
      
    
}
