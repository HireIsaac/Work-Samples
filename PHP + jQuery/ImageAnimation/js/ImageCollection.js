/* 
 Author: Isaac Lohnes
 Purpose: JS functions for index
 Date: Sept 2018
 */
"use strict";
var currentPhoto;
var pics = [];
var NUMPICS = 9;
var displayTimer;
var INTERVAL = 240;//ms


function init() {
    "use strict";
    currentPhoto = 0;
    for (var i = 0; i < NUMPICS; i++) {
        pics[i] = new Image();
        pics[i].src = "images/Capture" + (i + 1) + ".PNG";
    }
    document.getElementById("stop").disabled = true;

}
function changePhoto(photo) {
    "use strict";
    var imgURL = pics[photo].src;
    document.getElementById("currImg").src = imgURL;
    
    var imgName = imgURL.substr(imgURL.lastIndexOf('/') + 1);
    
    console.log( "\nimgName : " + imgName);
}
function nextPic() {
    "use strict";
    currentPhoto++;
    if (currentPhoto >= pics.length) {
        currentPhoto = 0;
    }
    changePhoto(currentPhoto);
}

function startShow() {
    "use strict";
    displayTimer = setInterval(nextPic, INTERVAL);
    document.getElementById("start").disabled = true;
    document.getElementById("stop").disabled = false;
}

function stopShow() {
    "use strict";
    clearInterval(displayTimer);
    document.getElementById("stop").disabled = true;
    document.getElementById("start").disabled = false;

}

function setActive(obj) {
    var myButtonClasses = obj.classList;
    if (myButtonClasses.contains("activeButton")){
        myButtonClasses.remove("activeButton")
    }else {
        myButtonClasses.add("activeButton")
    }
    
}
