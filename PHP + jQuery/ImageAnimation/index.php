<!DOCTYPE html>
<!--
Author: Isaac L
Purpose: Playing with arrays
Date: Sept 2018
-->
<html>
    <head>
        <title>Slideshow</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link type="text/css" rel="stylesheet" href="css/style.css"/>
        <script src="js/ImageCollection.js"></script>
        
    </head>
    <body onload="init();">
        <p>
            <button id="start" onclick="startShow()" 
                    onmouseover="setActive(this)"
                    onmouseout="setActive(this)"
                    >Start animation </button>
            
            <button id="stop" onclick="stopShow()" 
                    onmouseover="setActive(this)"
                    onmouseout="setActive(this)">
                Stop animation</button>

        </p>
        <figure>
            <img id="currImg" src="images/Capture1.PNG"/>

        </figure>
 
    </body>
</html> 