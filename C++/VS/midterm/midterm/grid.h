/*
 * grid.h
 *
 * A Happy little grid
 * Author: Isaac
 */

#ifndef GRID_H_
#define GRID_H_

#include <iostream>
#include <cstdlib>

using namespace std;

class grid {
public:
	grid(int n);
	void printGrid();	//Turns out, didn't even need this, just did it in constructor like a lazy bum hahaha


};


grid::grid(int n) {

	//Double for loop to make x and y the same
	for (int i = 0; i < n; i++) {
		cout << "|";	//make | first thing printed in each row
		for (int j = 0; j < n; j++) {

			//Left side checks axis going this way: \
			//Right side checks axis going this way: /
			if (i == j || i == n - j-1) {
				cout << " * |";
			}
			else {
				cout << " 0 |";
			}
		}
		cout << endl;
		for (int w = 0; w < n; w++) {
			cout << "____";		//Print seperators 
		}
		cout << endl;
	}

}

#endif
