
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="css/styles.css"/>
        <title>User Login</title>
    </head>
    <body>
        <form action="webpages/orderForm.php" method="POST" name="logInForm" 
            <fieldset id="fieldSet">
                <legend>Log In:</legend>
                <p>
                    <label for="usernname" class="label">Username</label>
                    <input type="text" placeholder="Enter Username" name="username"  required>
                </p>

                <p>
                    <label for="password" class="label">Password</label>
                    <input type="text" placeholder="Enter Password" name="password"  required>
                </p>
                <button type="submit" value="Log In" name="login" id="Login">Login</button>
                <input type="button" value="Create User" onclick="window.location.href='webpages/newUser.php'" />
            </fieldset>
        </form>
    </body>
</html>

