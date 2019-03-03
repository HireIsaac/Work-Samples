<?php 

/* 
 * Purpose: Call cogsProjects functions
 * Date: Oct 2018
 * Author: Isaac Lohnes
 */

    $target = 'external/cogsprojects.csv';
 
    $indexCall = new cogsProjects($target);
    $indexCall->sortFunct(2);
    //uncomment below to change datasort
    // $indexCall->datasort(1);
    $indexCall->display($indexCall->getData());
    
