<!-- 
 Purpose: Second page to display order
 Author: I Lohnes 
 Date: 11/2018
 -->

<?php
include 'scripts/Processor.php';
$checkoutCart = new Processor();
$checkoutCart->getOrder();

?>
<html>
    <head>
        <title>Your Shopping Cart</title>
        <link rel="stylesheet" type="text/css" href="css/styles.css" />
    </head>
    <body>
        <h1>Your Cart:</h1>
        <?php
        $checkoutCart->display();
        
        ?>
        
        <a href="index.php">Return to order page</a>
    </body>
</html>