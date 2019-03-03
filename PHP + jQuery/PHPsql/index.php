<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <form enctype="multipart/form-data" action="scripts/workWithCogsPrjs.php" method="post">
            <input type="hidden" name="MAX_FILE_SIZE" value="400000">
            <input type="file" name="fileToProcess" accept=".csv">
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
