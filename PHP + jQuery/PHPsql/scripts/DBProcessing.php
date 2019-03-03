<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Database processing PHP
 *
 * @author Isaac Lohnes
 */
class DBProcessing {
    private $connection;
    private $result;
           
    public function __construct() {
        //on construction, uses setConnection function with user info to connect to DB
        $this -> setConnection(//removed for github);
    }
   
    
    
    
    
    public function createTable($table,$mapFields){
        $drop ="drop table if exists ".$table;
        $this ->queryAndCheck($drop);
        //check if table exists, and check it using internal queryAndCheck() function
        
        $create = "CREATE TABLE ".$table." (";
        //String for SQL statement
        
        end($mapFields);
        $lastKey = key($mapFields);
        //get last key
        
        foreach($mapFields as $fieldName => $dataType){
            //iterate through for table creation string
            $create .= $fieldName . " " . $dataType;
            if($fieldName != $lastKey){
                $create .= ",";
            }
        }
        
        $create .= "); ";
        $this ->queryAndCheck($create);
        //close create SQL, and check it
    }
    
    
    
    public function disconnect(){
        //Kills connection, closes.
        $this -> connection -> kill($this -> connection -> thread_id);
        $this -> connection -> close();
    }
    
    
    
    
    public function displayTable($table, $arrayFields, $orderBy=null){
        //function to display table on webpage
        $sql = $this -> setQuery($table,$arrayFields,$orderBy);
        $this -> queryAndCheck($sql);
        $i =0;
        //init strings
        
        echo "<table border='1'><tr><th></th>";
        //echo table with first header empty
        
        foreach($arrayFields as $val){
            echo "<th>".$val."</th>";
        }
        //fill table headers
        
        echo"</tr>";
        //close header row
        
        while($row = $this -> result -> fetch_array(MYSQLI_ASSOC)){
            echo "<tr><td>".$i.": </td>";
            //tr with numbers as first column
            
            foreach($row as $val){
                echo "<td>".$val."<td>";
            }
            echo "</tr>";
            $i++;
            //iterate through populating data, close row, then increase table
            //row counter for first column
            
        }
        echo "</table>";
        //close table
        
    }
    
    
    public function insertIntoTable($table,$arrayData){
        //function to insert data into table, is passed target table
        //and data to insert
        
        $sql = "INSERT INTO ".$table." VALUES (";
        //create sql string
        
        end($arrayData);
        $lastElementKey = key($arrayData);
        //last key
        
        foreach($arrayData as $key => $val){
            $newString = addslashes($val);
            $sql .= "\"".$newString."\"";
            if($key != $lastElementKey){
                $sql .=", ";
            }
        }
        $sql .= ");";
        $this ->queryAndCheck($sql);
        //close string, and query it.
    }
    
    
    
    
    public function setConnection($host,$user,$pass,$db){
        //Connects with mysqli.
        $this -> connection = new mysqli($host, $user, $pass, $db);

        
        if ($this -> connection ->connect_error) {
                printf("Connection failed: %s\n", $this -> connection ->connect_error);
                
        } else {
                printf("Host info: %s\n", $this -> connection->host_info);
        }
    }
    
    
    
    
    
    
    public function setQuery($table, $arrayFields, $orderBy=null){
        //Function to create Queries 
        
        $sql = "SELECT ";
        //initial string for statement
        
        end($arrayFields);
        $lastElementKey = key($arrayFields);
        //get last key
        
        foreach($arrayFields as $key => $val){
            //iterate through data in key val format
            if($key===$lastElementKey){
                $sql .=$val;
            }else{
                $sql .= $val.", ";
                //comma seperate values if not at end
            }
        }
        
        $sql .= " FROM ". $table;
        //append to SQL string
        
        if($orderBy != null){
            $sql .= " ORDER BY ".$orderBy;
            //append SQL string to if orderBy not null
        }
        
        $sql .=";";
        //SQL statement is done here.
        
        return $sql;
    }
    
    
    
    
    
    public function queryAndCheck($sql){
        //function to check when to disconnect by comparing result to query
        // of variable given.
        $this -> result = $this -> connection -> query($sql);
        if(!$this -> result){
            $this -> disconnect();
            throw new Exception("Query failure");
        }
    }
    
    
    
    
    
}
