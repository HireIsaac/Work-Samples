// simpleStack.cpp : This file contains the 'main' function. Program execution begins and ends there.
//


#include <cstdlib>
#include<iostream>
#include "StackusingList.h"
#include "node.h"
using namespace std;


int main(int argc, char** argv) {
	StackusingList<int>s;


	cout << "\n\nPushing to stack:\n" << endl;
	s.push(1);
	s.push(2);
	s.push(3);
	s.push(4);
	s.push(5);
	s.push(6);

	cout << "Stack:\n" << endl;
	s.print();

	
	cout << "Running pop, printing, then pushing what was popped: "  << "\n"<< endl;
	
	int temp = s.pop();
	s.print();
	cout << "\n\nAfter pushing back: \n" << endl;
	s.push(temp);
	s.print();

	cout << "\n\nTesting bool op, stack has content message expected:\n" << endl;

	if (s.operator bool()) {
		cout << "Stack has content" << endl;
	}
	else {
		cout << "Stack is empty" << endl;
	}

	return 0;
}