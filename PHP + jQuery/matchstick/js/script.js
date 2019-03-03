/**
 * Purpose: JS for matchstick game
 * Author: Isaac Lohnes
 * Date: Oct 2018
 */


var numMatches = 16;
//Used to check win conditions. 


function clearErr() {
    "use strict";
    //Non required function, simply removes padding on error msg,
    //as after removing innerhtml padding will still exist.
    var err = document.getElementById("errorOut");
    if (err.innerHTML === "") {
        err.style.padding = "0px";
    } else {
        err.style.padding = "10px";
    }
}

function clearPlay() {
    "use strict";
    //Selects all selected matches, and switches them back to unused. Also clears error message
    var elements = document.querySelectorAll(".selected");

    for (var i = 0; i < elements.length; i++) {
        elements[i].classList.toggle("selected");
        elements[i].classList.toggle("unused");
    }
    document.getElementById("errorOut").innerHTML = "";
    clearErr();
}


function imgOnClick(match) {
    "use strict"; 
    //Super simple, toggles classes for selection at start of turn.
    match.classList.toggle("selected");
    match.classList.toggle("unused");
}

function isValidPlay() {
    "use strict"; 
    //takes all selected elements, and makes sure there is more then one, and makes sure they have the same parent ID,
    //which is how I check that they are on the same row, as each div containing the imgs has a unique ID.
    var elements = document.getElementsByClassName("selected");
    var elementsArr = [];

    if (elements === undefined || elements.length == 0) {
        document.getElementById("errorOut").innerHTML = "Please select a match.";
        return false;
    }
    
    for (var i = 0; i < elements.length; ++i) {

        elementsArr.push(elements[i].parentElement.id);

        if (elementsArr[i] !== elementsArr[0]) {
            document.getElementById("errorOut").innerHTML = "Invalid play, please select matches on same row.";
            return false;
        } 

    }
}



function play() {
    "use strict"; 
    //Checks if play is valid, if it is, it toggles selected to used, and turns off onclick.
    //Then it checks the win condition, and if it is met, resets. After valid play is checked,
    //it toggles the active player.
    
    if (isValidPlay() === false) {
        clearErr();
        return;
    }
    if (isValidPlay() !== false) {
        
        var elements = document.querySelectorAll(".selected");
        document.getElementById("errorOut").innerHTML = "";
        for (var i = 0; i < elements.length; i++) {
            elements[i].classList.toggle("selected");
            elements[i].classList.toggle("used");
            elements[i].onclick = false;
        }
        
    }
    if (winCondition()) {
        var currentplayer = document.getElementById("player");
        window.alert(currentplayer.innerHTML + " has won!");
        reset();
    }
    togglePlayer();
    clearErr();
    
}

function reset() {
    "use strict"; 
    //Reloads to be called after game is complete.
    location.reload();
}


function togglePlayer() {
    "use strict";
    //Toggles player currently active.
    var currentplayer = document.getElementById("player");
    currentplayer.classList.toggle("player1");
    currentplayer.classList.toggle("player2");

    if (currentplayer.classList.contains("player1")) {
        currentplayer.innerHTML = "Player 1";
        document.body.style.backgroundColor = "lightblue";
    } else {
        currentplayer.innerHTML = "Player 2";
        document.body.style.backgroundColor = "lightgreen";
    }
}


function winCondition() {
    "use strict"; 
    //checks if game is over.
    var elements = document.querySelectorAll(".used");
    if (elements.length == numMatches) {
        return true;
    } else {
        return false;
    }

}








