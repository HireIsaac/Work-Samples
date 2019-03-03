
/*
	Purpose: Functions for NSCC form processor
	Author: Isaac Lohnes
	Date: Oct 13 / 2018

*/




//I use an error counter. I use this because I use a class selection to check user error for the carpool bit,
//and if I used an error value then it would reset itself every time the class iterated through a filled collumn.
//The only reason this is even important is because I want the red error bit to show in the specific part where
//the error is, instead of just filling the whole row.
var error = 0;
var errorString = '';
var carError = 0;

$( function() {
	//datepicker
	"use strict";
    $( "#datepicker" ).datepicker();
  } );




$(document).ready(function () {
	"use strict";
    $("#parkingRules").click(function () {
        $("#parkingParagraph").slideToggle();
    });


	 $("#submit").click(function () {
		"use strict";
		//Run all functions, check if car loop has an error, and launch office section if it passes all checks
		validFirstName();
		validLastName();
		validDate();
		validNum();
		validPass();
		rulesRead();
		if (carError !== 0){
			errorString += '\nPlease fill in car information related to pass type picked';
		}
		if ( error !== 0) {
			window.alert("Please fix highlighted errors: \n" + errorString);
		} else {
			$('#officeUse, #officeSubmit').css("display","block");
		}
		error = 0;
		errorString = '';
		carError = 0;
		
	});

	 $("#clearForm, #clearOffice").click(function () {
		//Setup for clear buttons
		"use strict";
		 $(this).closest('form').find("input[type=text], textarea").val("");
		 $("input").removeClass("errorClass");
	 });


});




function validLastName() {
//Checks if last name has content.
	"use strict";
	if($('#lastName').val() == ''){
			$('#lastName').addClass( "errorClass" );
			$('#lastName').removeClass( "notErrorClass ");
			error += 1;
			errorString += '\nLast Name cannot be null';
		} else {
			$('#lastName').removeClass( "errorClass" );
			$('#lastName').addClass( "notErrorClass ");
			
		}
}


function validFirstName() {
//Checks if first name has content.
	"use strict";
	if($('#firstName').val() == ''){
			$('#firstName').addClass( "errorClass" );
			$('#firstName').removeClass( "notErrorClass ");
			error += 1;
			errorString += '\nFirst Name cannot be null';
		} else {
			$('#firstName').removeClass( "errorClass" );
			$('#firstName').addClass( "notErrorClass ");
			
		}
}

function validDate(){
//Checks if date is in future or empty
	"use strict";
		var selectedDate = $('#datepicker').datepicker('getDate');
		var now = new Date();
		now.setHours(0,0,0,0);
		if (selectedDate < now) {
			$( "#datepicker" ).addClass( "notErrorClass" );
			$( "#datepicker" ).removeClass( "errorClass" );
			
		} else {

			$( "#datepicker" ).addClass( "errorClass" );
			$( "#datepicker" ).removeClass( "notErrorClass" );
			error += 1;
			errorString += '\nDate cannot be in future';
			
		}


		if($( "#datepicker" ).val() == ''){
			$( "#datepicker" ).addClass( "errorClass" );
			$( "#datepicker" ).removeClass( "notErrorClass ");
			error += 1;
			errorString += '\nDate cannot be null';
		} else {
			$( "#datepicker" ).removeClass( "errorClass" );
			$( "#datepicker" ).addClass( "notErrorClass ");

			
		}
}

function validNum(){
//checks if student ID is == 7
	"use strict";
	if($('#studentID').val().length !== 7) {
		$('#studentID').addClass( "errorClass");
		$('#studentID').removeClass( "notErrorClass");
		error += 1;
		errorString += '\nID must be 7 numbers';
	} else {
		$('#studentID').addClass( "notErrorClass");
		$('#studentID').removeClass( "errorClass");
	
	}
}

function validPass(){
//Checks if at least first car is filled out for single car pass, and if two cars are filled out for car pool
	"use strict";
	if($('#singleCar').is(':checked')) {  
		$('.car1').each(function(){
			var element = $(this);
			if(element.val() == ''){
				error += 1;
				//car error is so that I don't get spammed with errors by appending to the error string inside my each loop
				carError += 1;
				element.addClass( "errorClass");
				element.removeClass( "notErrorClass");
				$('.car2unique').removeClass( "errorClass");
			} else {
				element.addClass( "notErrorClass");
				element.removeClass( "errorClass");
				$('.car2unique').removeClass( "errorClass");
				
			}
		});
	}

	else{

		$('.car2').each(function(){
			var element = $(this);
			if(element.val() == ''){
				error += 1;
				carError += 1;
				element.addClass( "errorClass");
				element.removeClass( "notErrorClass");
			} else {
				element.addClass( "notErrorClass");
				element.removeClass( "errorClass");
				
			}
		});
	}



}

function rulesRead() {
//checks if user checked read rules box
	"use strict";
	if($('#readRules').is(':checked')) {
	} else {
		error += 1;
		errorString += '\nPlease read rules and regulations';
	}
}