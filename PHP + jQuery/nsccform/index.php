
<!--
	Purpose: NSCC form processor
	Author: Isaac Lohnes
	Date: Oct 13 / 2018
-->


<!doctype html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Parking pass</title>

    <!--CDNs:-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
<link href="https://code.jquery.com/ui/1.12.1/themes/blitzer/jquery-ui.css" rel="stylesheet">


    <!--Internal links:-->
    <link rel="stylesheet" type="text/css" href="css/styles.css">
    <script src="js/scripts.js"></script>

</head>
<body>

    <form autocomplete="off">
        <div class="container">
            <div class="row">
                <div class="col-12" id="nsccLogo">
                    <img alt="NSCC Logo" src="img/nscclogo.png" />
                </div>

                <div class="col-12 text-center" id="parkingPassApplication">
                    <h2>PARKING PASS APPLICATION</h2>
                    <hr />
                </div>

                <div class="col-12">
                    <p class="sectionheader">Date: <input type="text" id="datepicker"></p>
                </div>

                <div class="col-12" id="contactInformation">
                    <p class="sectionheader">Contact Information</p>
                    <div class="row row-eq-height text-center">
                        <div class="col-4 greyBackground boxLayout">
                            <p>Last Name</p>
                        </div>
                        <div class="col-4 greyBackground boxLayout">
                            <p>First Name</p>
                        </div>
                        <div class="col-4 greyBackground boxLayout">
                            <p>Student / Employee #</p>
                        </div>
                        <div class="col-4 boxLayout">
                            <input type="text" id="lastName">
                        </div>
                        <div class="col-4 boxLayout">
                            <input type="text" id="firstName">
                        </div>
                        <div class="col-4 boxLayout">
                            <input type="text" id="studentID">
                        </div>
                    </div>
                </div>

				<div class="col-12">
					<p class="sectionheader">Type of Pass:</p>
					<input type="radio" id ="singleCar" name="pass" value="single" checked="checked"> Single<br>
					<input type="radio" id="carPool" name="pass" value="carpool"> Car Pool
				
				</div>




                <div class="col-12" id="vehicleInformation">
                    <p class="sectionheader">Vehicle Information - Permits are transferrable so please provide additional vehicle details</p>
                    <div class="row row-eq-height text-center">
                        <div class="col-1 greyBackground boxLayout">
                            <p>#</p>
                        </div>
                        <div class="col-3 greyBackground boxLayout">
                            <p>Make</p>
                        </div>
                        <div class="col-3 greyBackground boxLayout">
                            <p>Model</p>
                        </div>
                        <div class="col-3 greyBackground boxLayout">
                            <p>Licence Plate #</p>
                        </div>
                        <div class="col-2 greyBackground boxLayout">
                            <p>Color</p>
                        </div>
                        <div class="col-1 boxLayout">
                            <p>1</p>
                        </div>
                        <div class="col-3 boxLayout">
                            <input type="text" class="make car1 car2">
                        </div>
                        <div class="col-3 boxLayout">
                            <input type="text" class="model car1 car2">
                        </div>
                        <div class="col-3 boxLayout">
                            <input type="text" class="licence car1 car2">
                        </div>
                        <div class="col-2 boxLayout">
                            <input type="text" class="color car1 car2">
                        </div>
                        <div class="col-1 boxLayout">
                            <p>2</p>
                        </div>
                        <div class="col-3 boxLayout">
                            <input type="text" class="make car2 car2unique">
                        </div>
                        <div class="col-3 boxLayout">
                            <input type="text" class="model car2 car2unique">
                        </div>
                        <div class="col-3 boxLayout">
                            <input type="text" class="licence car2 car2unique">
                        </div>
                        <div class="col-2 boxLayout">
                            <input type="text" class="color car2 car2unique">
                        </div>
                        <div class="col-1 boxLayout">
                            <p>3</p>
                        </div>
                        <div class="col-3 boxLayout">
                            <input type="text" class="make">
                        </div>
                        <div class="col-3 boxLayout">
                            <input type="text" class="model">
                        </div>
                        <div class="col-3 boxLayout">
                            <input type="text" class="licence">
                        </div>
                        <div class="col-2 boxLayout">
                            <input type="text" class="color">
                        </div>
                        <div class="col-1 boxLayout">
                            <p>4</p>
                        </div>
                        <div class="col-3 boxLayout">
                            <input type="text" class="make">
                        </div>
                        <div class="col-3 boxLayout">
                            <input type="text" class="model">
                        </div>
                        <div class="col-3 boxLayout">
                            <input type="text" class="licence">
                        </div>
                        <div class="col-2 boxLayout">
                            <input type="text" class="color">
                        </div>
                    </div>
                </div>

                <div class="col-12" id="parkingRegulations">



                    <h3 id="parkingRules" class="text-center">Parking Regulations</h3>
                    <div id="parkingParagraph">
                        <h5 class="text-center">NOTE: A parking pass does not guarantee a parking space will always be available.</h5>
                        <ol>
                            <li>
                                All vehicles parked on campus must display a permit. The permit must
                                be in clear view from outside the windshield. Vehicles without permit displayed, will be ticketed without
                                warning and/or towed away at the owner&#39;s expense.
                            </li>
                            <li>
                                Vehicles must be parked in authorized, marked spaces only. No centre land or driveway
                                parking is permitted due to fire/evacuation regulations.
                            </li>
                            <li>
                                Parking in reserved spaces is not permitted without College approval.
                            </li>
                            <li>
                                Motorcycles must be parked in an area designated for such use.
                            </li>
                            <li>
                                This permit is transferrable to other vehicles owned by the permit holder. Please notify
                                campus security of the vehicle information.
                            </li>
                            <li>
                                NSCC is not liable for any property loss/damage, vandalism or theft arising from the use
                                of parking on its premises.
                            </li>
                            <li>
                                During fire drills, and other emergency evacuations there will be no movement of vehicles
                                under any circumstances.
                            </li>
                            <li>
                                NSCC reserves the right to revoke any parking permits at any time.
                            </li>
                        </ol>
                    </div>
                </div>

                <div class="col-12 text-center" id="readRulesContainer">
                    <input type="checkbox" id="readRules">
                    <p>I have read, and agree to the <span>Parking Regulations</span> stated above</p>

                </div>

				<div class="col-12 " id="formSubmit">
					<div class="row">
						<div class="col-5 filler">
						</div>
						<div class="col-1 button">
							<button type='button' id="submit">Submit</button>
						</div>
						<div class="col-1 button">
							<button type='button' id="clearForm">Clear</button>
						</div>
						<div class="col-5 filler">
						</div>
					</div>				
				</div>


                <div class="col-12" id="officeUse">
                    <p class="sectionheader">For Office Use Only:</p>

                    <label class="title">Processor:</label>
					<select name="processor" id="pro">
						<option selected="selected">Jamie</option>
						<option>Bonny</option>
						<option>Other</option>
					</select>



                    <div class="row text-center">
                        <div class="col-3 greyBackground boxLayout">
                            <p>Parking Pass Number</p>
                        </div>

                        <div class="col-3 greyBackground boxLayout">
                            <p>Receipt</p>
                        </div>
                        <div class="col-3 greyBackground boxLayout">
                            <p>Date Issued</p>
                        </div>
                        <div class="col-3 greyBackground boxLayout">
                            <p>Amount Paid</p>
                        </div>
                        <div class="col-3 boxLayout">
                            <input />
                        </div>
                        <div class="col-3 boxLayout">
                            <input />
                        </div>
                        <div class="col-3 boxLayout">
                            <input />
                        </div>
                        <div class="col-3 boxLayout">
                            <input />
                        </div>
                    </div>
                </div>

				<div class="col-12 " id="officeSubmit">
					<div class="row">
						<div class="col-5 filler">
						</div>
						<div class="col-1 button">
							<button type='button' id="process">Process</button>
						</div>
						<div class="col-1 button">
							<button type='button' id="clearOffice">Clear</button>
						</div>
						<div class="col-5 filler">
						</div>
					</div>				
				</div>



            </div>


           

        </div>

    </form>
</body>
</html> 