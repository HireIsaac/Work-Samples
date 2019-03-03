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
        <script src="js/ImageCollection.js"></script>
    </head>
    <body onload="init();">
        <p>
            <button id="start" onclick="startShow()">Start </button>
            <button id="stop" onclick="stopShow()">Stop </button>
            <button id="next" onclick="nextPic()">Next Picture </button>
            <button id="prev" onclick="prevPic()">Previous Picture </button>
        </p>
        <figure>
            <img id="currImg" src="images/employee1.jpg"/>
            <figcaption id="imgTitle">images/employee1.jpg</figcaption>
        </figure>
 
    </body>
</html>