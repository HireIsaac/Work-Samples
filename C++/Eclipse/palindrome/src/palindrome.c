/*
 ============================================================================
 Name        : palindrome.c
 Author      : Isaac Lohnes
 Version     :
 Copyright   : Your copyright notice
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <assert.h>

double bisect(double a, double b, double (*f)(double)){
	double s=(a+b)/2;
	double margin = 0.000001;
	//declaring s and margin above, margin is simply how close to 0 you wish to get.


	assert (f(a) * f(b) < 0);
	s=(a+b)/2;

	if (f(s)* f(b) <0){
		a = s;
	}
	else{
		b = s;
	}
	//Above simply runs the function once, it wouldn't work without this.


		while (f(s) > margin || f(s) < -margin){
			assert (f(a) * f(b) < 0);
			s=(a+b)/2;


				if (f(s)* f(b) <0){
					a = s;
				}
				else{
					b = s;
				}

				//While loop swaps a or b with s, depending on which satisfies condition
				// f(s) * f (a or b) < 0.
		}
		return s;

}




int main() {
	setbuf(stdout, NULL);
	printf("\ncos(x)=0 for x=%10.8f",bisect(0.0,3.0,cos));
	//above simply prints bisect function for 0,3,cos.

	char *word_actual;
	int i;
	int len;
	word_actual = malloc(sizeof(char) * 255);
	//declaring variables for palindrome check


	printf("\n\nEnter word for palindrome check ");
	scanf("%[^\n]s", word_actual);
	printf("\n");

	len = strlen(word_actual);

	//Below is for loop for palindrome check, just a simple if else.
	for(i = 0; i < len/2; i++){
	    if(tolower(word_actual[i]) != tolower(word_actual[len - 1 - i])){
	        printf(word_actual);
	        printf(" is not a palindrome.\n");
	        break;
	    }
	    else{
	    	printf(word_actual);
	    	printf(" is a palindrome.\n");
	    	break;

	    }
	}
	}




