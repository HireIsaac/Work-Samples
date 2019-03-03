<?php
include '../scripts/workWithShoppingCart.php';
$form = new workWithShoppingCart();

//Below is a weird thing Nick showed me. I don't really like it at all, but it basically will load
//the entire page in an if loop based on conditions. 
if ((!$form->createUser() && filter_input(INPUT_SERVER, 'REQUEST_METHOD') == 'POST') || filter_input(INPUT_SERVER, 'REQUEST_METHOD') != 'POST'):
    ?>
    <!--
    Purpose: Create new user
    Author: Isaac Lohnes
    Date: DEC 2018
    -->
    <html>
        <head>
            <link rel="stylesheet" type="text/css" href="../css/styles.css" />
            <title>New User</title>
        </head>
        
        <body>
            
            
            
            
            <form method="POST" name="orderForm" id="orderform">
                <p>
                    <label for="username" class="label">Username</label>
                    <input type="text" placeholder="Enter Username" name="username"  required>
                </p>
                <p>
                    <label for="password" class="label">Password</label>
                    <input type="text" placeholder="Enter a Password" name="password"  required>
                </p>
                <p>
                    <label for="firstName" class="label">First Name</label>
                    <input type="text" placeholder="Enter First Name" name="firstName"required>
                </p>
                <p>
                    <label for="lastName" class="label">Last Name</label>
                    <input type="text" placeholder="Enter Last Name" name="lastName" required>
                </p>
                <p>
                    <label for="email" class="label">Email</label>
                    <input type="text" placeholder="Enter Email" name="email"  required>
                </p>
                
                <button type="submit" value="Create New User" name="create" >Create User</button>
                
                <input type="reset" value="Clear" name="reset" id="resetform">
                
                <input type="button" value="Return To Log In" onclick="window.location.href='../index.php'" />
                <!--Above just changes entire window location onclick.-->
            </form>
            
        </body>
    </html>
    
<?php
//End of loop here, so it will call form again if conditions not met.
else:
    $form->createUser()
    ?>
<?php endif;
