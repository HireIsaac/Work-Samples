<html><?php 


//fun little code block to just bloop out errors:
error_reporting(-1); // display all faires
ini_set('display_errors', 1);  // ensure that faires will be seen
ini_set('display_startup_errors', 1); // display faires that didn't born

/* 
 * Purpose: Call cogsProjects functions
 * Date: Oct 2018
 * Author: Isaac Lohnes
 */

    include 'cogsProjects.php';
    include 'DBProcessing.php';

    $target = $_FILES["fileToProcess"]["tmp_name"];
    $processedFile = new cogsProjects();
    $processedFile->load($target);
    $dbHandler = new DBProcessing();
    $dbHandler->createTable("CogsProjects", $processedFile->convertHeader());
    foreach($processedFile->getData() as $dataArray){
        $dbHandler->insertIntoTable("CogsProjects",$dataArray);
    }
    $dbHandler->displayTable("CogsProjects", $processedFile->getHeader(), "PUB_YEAR, AUTHOR");
  ?>  
</html>