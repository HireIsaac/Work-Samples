/*
 * sortTimer.cpp
 *
 *  Created on: Feb 18, 2018
 *      Author: piotr
 *
 * The sortTimer function returns the number of second (fractions of)
 * a given sort (or similar) function needed to process an array of integers.
 * It also prints in microseconds (usec) the value returned.
 */

#include <stdio.h>
#include <time.h>

double sortTimer(int* a, int size, void (*f)(int*, int)) {

	int Start, Stop;
	Start=clock();
	f(a,size);
	Stop=clock();
	printf("\nComputed in: %d usec.", Stop - Start);
	return (double)(Stop - Start)/CLOCKS_PER_SEC;

}
