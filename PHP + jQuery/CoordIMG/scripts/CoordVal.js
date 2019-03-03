/* 
 * Author: Isaac Lohnes.
 * Purpose: Functions for CoordVal project
 * Date Sept 2018
 */
"use strict";
var sNorSou;
var sEasWes;

function isValidLat(sLat) {
    //I have this feeling that some of my code goes on too long.
    //I suppose that will contiune to go away with time.
    //Anyway, here's isValidLat, it takes a string and sets sNorSou.
    "use strict";

    var sLatErrMsg = "";
    var bValidLat = true;
    var MINLAT = -90, MAXLAT = 90;


    var fLat = parseFloat(sLat);

    if (isNaN(fLat)) {
        sLatErrMsg = "Invalid Lat. Please use Number";
        bValidLat = false;
        sNorSou="Bad";
    } else if ((fLat <= MINLAT) || (fLat >= MAXLAT)) {
        sLatErrMsg = "Invalid Lat. Should be between -90 and +90";
        bValidLat = false;
        sNorSou="Bad";
    }
    
    
    if (fLat > 0 && fLat <= MAXLAT) {
        sNorSou="North";
    }
    
    if (fLat < 0 && fLat >= MINLAT) {
        sNorSou="South";
    }
    
    if (fLat == 0){
        sNorSou="Equator";
    }
    
    document.getElementById("laterr").innerHTML= sLatErrMsg;
    return bValidLat;

}

function isValidLong(sLong) {
    //Same as isValidLat(), except for Long 
    "use strict";

    var sLongErrMsg = "";
    var bValidLong = true;
    var MINLONG = -90, MAXLONG = 90;


    var fLong = parseFloat(sLong);

    if (isNaN(fLong)) {
        sLongErrMsg = "Invalid Long. Please use Number";
        bValidLong = false;
        sEasWes="World";
    } else if ((fLong <= MINLONG) || (fLong >= MAXLONG)) {
        sLongErrMsg = "Invalid Long. Should be between -90 and +90";
        bValidLat = false;
        sEasWes="World";
    }
    
    
    if (fLong > 0 && fLong <= MAXLONG) {
         sEasWes="East";
    }
    
    if (fLong < 0 && fLong >= MINLONG) {
        sEasWes="West";
    }
    
    if (fLong == 0){
        sEasWes="Prime-Meridian";
    }
    
    document.getElementById("longerr").innerHTML= sLongErrMsg;
    return bValidLong;

}


function valLatLong(sLat, sLong) {
    //Calls all other functions at onclick of validate
    "use strict";
    
    isValidLat(sLat);
    isValidLong(sLong);
    updDisplay(sNorSou, sEasWes);
    
}




function updDisplay(sNorSou, sEasWes){
    //I'm not 100% sure that the if statements with return 0
    //is the overall best approach, but it works and handles
    //all the testing I could think of.
    "use strict";
    
    if(sNorSou == "Equator" || sEasWes =="Prime-Meridian"){
        document.getElementById("currentWorld").src="img/World.jpg";
        return 0;
    }
    if(sNorSou == "Bad" || sEasWes =="World"){
        document.getElementById("currentWorld").src="img/BadWorld.jpg";
        return 0;
    }
    
    //This line below is a real zinger. If I had know js was this
    //useful I would have started using it a long time ago.
    document.getElementById("currentWorld").src="img/"+ sNorSou + sEasWes + ".jpg";
    
}    
    
    
    
    
    



