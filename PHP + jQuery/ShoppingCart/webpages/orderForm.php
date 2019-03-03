
<!--
Purpose: Order page
Author: Isaac Lohnes
Date: DEC 2018
-->

<?php
include '../scripts/workWithShoppingCart.php';
$form = new workWithShoppingCart();
if ($form->login()):
    ?>
    <html>
        <head>
            <title>Order</title>
            <link rel="stylesheet" type="text/css" href="../css/styles.css" />
        </head>
        <body>
            <form action="results.php" method="POST" name="orderform" id="orderform">
                <fieldset name="userfieldset" id="userfieldset">
                    <legend>User Information</legend>
<!--                    display user info from server-->
                    <?php $form->userInfo() ?>
                </fieldset>
                <fieldset name="orderfieldset" id="orderfieldset">
                    <legend>Order Information</legend>
                    <p>
                    <table>
                        <tr>
                            
                            <th>Product</th>
                            <th>Price</th>
                            <th>Quantity</th>   
                            
                        </tr>
<!--                        below is rows populating from DB-->
                        <?php $form->createProductTable() ?>
                    </table>
                    </p>
                </fieldset>
                <p>
                    <input type="submit" value="Process Order" name="procesr" id="processOrder">
                    <input type="reset" value="Clear Your Order" name="reset" id="resetform">
                </p>
            </form>
        </body>
    </html>
    <?php
 endif; 