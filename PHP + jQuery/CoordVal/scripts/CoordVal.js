/* 
 * Author: Isaac Lohnes.
 * Purpose: Functions for CoordVal project
 * Date Sept 2018
 */
"use strict";


function isValidLat(sLat) {
    "use strict";

    var sLatErrMsg = " ";
    var bValidLat = true;
    var MINLAT = -90, MAXLAT = 90;


    var fLat = parseFloat(sLat);

    if (isNaN(fLat)) {
        sLatErrMsg = "Invalid Lat. Please use Number";
        bValidLat = false;
    } else if ((fLat < MINLAT) || (fLat > MAXLAT)) {
        sLatErrMsg = "Invalid Lat. Should be between -90 and +90";
        bValidLat = false;
    }
    
    document.getElementById("laterr").innerHTML(sLatErrMsg);
    return bValidLat;

}




function valLatLong(sLat, sLong) {
    "use strict";

//    var fLat, fLong;
    var sOutput = "";

//    fLat = parseFloat(sLat);


//    if (isNaN(fLat)) {
//        sOutput = "The lattitude is not a valid number ";
//
//
//    } else {
//        sOutput = "The lattitude is a valid number ";
//
//    }

    fLong = parseFloat(sLong);
    if (isNaN(fLong)) {
        sOutput += "\nand the longitude is not a valid number.";
        console.log(sOutput);
    } else {
        sOutput += "\nand the longitude is a valid number.";
        console.log(sOutput);
    }

    window.alert(sOutput);


}


