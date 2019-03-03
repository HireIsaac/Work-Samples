/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    init();
    $("#start").click(function () {
        startShow();
    });
    
    $("#next").click(function () {
        nextPic();
    });
    $("#prev").click(function () {
        prevPic();
    });
    
    
    
    
});


function startShow() {
    "use strict";
    displayTimer = setInterval(nextPic, INTERVAL);
}

function stopShow() {
    "use strict";
    clearInterval(displayTimer);

}


