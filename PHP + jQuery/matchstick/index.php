<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Matchsticks</title>
    <link rel="icon" href="img/matchstick.gif" type="image/gif">
    <link rel="stylesheet" href="css/styles.css" />
    <script type="text/javascript" src="js/script.js"></script>
    <!--
        Purpose: HTML for matchstick game
        Author: Isaac Lohnes
        Date: Oct 2018
    -->
</head>

<body>
    <div id="control">


        <h1>Current player: </h1>
        <p id="player" class="player1">Player 1</p>
        <p id="errorOut"></p>
        <br />
        <button onclick="clearPlay()">clear</button>
        <button onclick="play()">play</button>
    </div>


    <div id="photoContainer">
        <div id="row1">
            <img src="img/matchstick.gif" class="match unused" alt="matchstick" onclick="imgOnClick(this)"/>
        </div>

        <div id="row2">
            <img src="img/matchstick.gif" class="match unused" alt="matchstick" onclick="imgOnClick(this)" />
            <img src="img/matchstick.gif" class="match unused" alt="matchstick" onclick="imgOnClick(this)" />
            <img src="img/matchstick.gif" class="match unused" alt="matchstick" onclick="imgOnClick(this)" />
        </div>

        <div id="row3">
            <img src="img/matchstick.gif" class="match unused" alt="matchstick" onclick="imgOnClick(this)" />
            <img src="img/matchstick.gif" class="match unused" alt="matchstick" onclick="imgOnClick(this)" />
            <img src="img/matchstick.gif" class="match unused" alt="matchstick" onclick="imgOnClick(this)" />
            <img src="img/matchstick.gif" class="match unused" alt="matchstick" onclick="imgOnClick(this)" />
            <img src="img/matchstick.gif" class="match unused" alt="matchstick" onclick="imgOnClick(this)" />
        </div>
        
        <div id="row4">
            <img src="img/matchstick.gif" class="match unused" alt="matchstick" onclick="imgOnClick(this)" />
            <img src="img/matchstick.gif" class="match unused" alt="matchstick" onclick="imgOnClick(this)" />
            <img src="img/matchstick.gif" class="match unused" alt="matchstick" onclick="imgOnClick(this)" />
            <img src="img/matchstick.gif" class="match unused" alt="matchstick" onclick="imgOnClick(this)" />
            <img src="img/matchstick.gif" class="match unused" alt="matchstick" onclick="imgOnClick(this)" />
            <img src="img/matchstick.gif" class="match unused" alt="matchstick" onclick="imgOnClick(this)" />
            <img src="img/matchstick.gif" class="match unused" alt="matchstick" onclick="imgOnClick(this)" />
        </div>
    </div>
</body>
</html>