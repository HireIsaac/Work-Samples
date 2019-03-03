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
var INTERVAL = 1;//ms


function init() {
    "use strict";
    currentPhoto = 0;
    for (var i = 0; i < NUMPICS; i++) {
        pics[i] = new Image();
        pics[i].src = "images/employee" + (i + 1) + ".jpg";
    }

}
function changePhoto(photo) {
    "use strict";
    var imgURL = pics[photo].src;
    document.getElementById("currImg").src = imgURL;
    
    var imgName = imgURL.substr(imgURL.lastIndexOf('/') + 1);
    
    
    document.getElementById("imgTitle").innerHTML = imgName;
    
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
function prevPic() {
    "use strict";
    currentPhoto--;
    if (currentPhoto <= 0) {
        currentPhoto = pics.length - 1

    }
    changePhoto(currentPhoto);
}

function startShow() {
    "use strict";
    displayTimer = setInterval(nextPic, INTERVAL);
}

function stopShow() {
    "use strict";
    clearInterval(displayTimer);

}
