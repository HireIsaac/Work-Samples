<!DOCTYPE html>
<!--
Purpose: Lat/Long Validator
Author: Isaac Lohnes
Date:	 Sept 2018
-->

<html>
    <head>
        <meta charset="UTF-8">
        <title>Latitude and Longitude Validator</title>
        <link rel="stylesheet" href ="css/CoordVal.css" />
        <script type="text/javascript" src="scripts/CoordVal.js"></script>



    </head>

    <body>
        <form action="#" method="get" id="CoordForm" name="CoordForm">
            <fieldset>
                <h3>Enter your Co-ordinates:</h3>
                <label for="lat" class="left"> Latitude: </label>
                <input type="text" id="lat" name="lat">
                <label id="laterr"></label>
                <br>
                <label for="long" class="left"> Longitude: </label>
                <input type="text" id="long" name="long" >
                <label id="longerr"></label>
                <br>
                <label for="val" class="left"> &nbsp; </label>
                <input type="button" id="val" value="Validate" onclick="valLatLong(lat.value,long.value)" >
                <label id="results">Click to Validate </label>
            </fieldset>
        </form>
    </body>
</html>