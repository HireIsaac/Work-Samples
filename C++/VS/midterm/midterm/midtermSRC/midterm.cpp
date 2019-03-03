// midterm.cpp : This file contains the 'main' function. Program execution begins and ends there.
// Author: Isaac L


#include <iostream>
#include <cstdlib>
#include "SLList_midterm.h"
#include "grid.h"
using namespace std;


int main(int argc, char** argv) {
	List<int>s;
	s.pushHead(1);
	s.pushTail(2);
	s.pushTail(3);
	s.pushTail(4);
	s.pushTail(5);
	s.pushTail(6);
 
	cout << "pop 1: " << s.popHead() << endl;
	cout << "pop 2: " << s.popHead() << endl;
	cout << "pop 3: " << s.popHead() << endl;
	cout << "pop 4: " << s.popHead() << endl;
	cout << "pop 5: " << s.popHead() << endl;
	cout << "pop 6: " << s.popHead() << endl;


	cout << "\nReverse + Length:\n" << endl;

	s.pushHead(1);
	s.pushTail(2);
	s.pushTail(3);
	s.pushTail(4);
	s.pushTail(5);
	s.pushTail(6);


	cout << "length: " << s.length(s.head_) <<"\n"<<endl ;

	s.reverse();
	cout << "pop 1: " << s.popHead() << endl;
	cout << "pop 2: " << s.popHead() << endl;
	cout << "pop 3: " << s.popHead() << endl;
	cout << "pop 4: " << s.popHead() << endl;
	cout << "pop 5: " << s.popHead() << endl;
	cout << "pop 6: " << s.popHead() << endl;

	cout << "\nlength after popping: " << s.length(s.head_) << "\n" << endl;

	cout << "\nGrid below:\n " << endl;
	grid(10);

    
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
