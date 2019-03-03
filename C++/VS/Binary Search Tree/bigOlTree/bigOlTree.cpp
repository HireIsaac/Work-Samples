// bigOlTree.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include "pch.h"
#include <iostream>
#include "BST.h"
using namespace std;

int main()
{
	Tree<int> pine;
	int val{ 0 };

	for (int i = 0; i < 6; i++) {
		cout << "an int pls: ";
		cin >> val;
		pine.insert(val);
		

		
		
	}

	pine.print();
	pine.breathFirst();
	cout << "inO:" << endl;
	pine.inorder();
	cout << "pO:" << endl;
	pine.porder();

	return 0;
}

