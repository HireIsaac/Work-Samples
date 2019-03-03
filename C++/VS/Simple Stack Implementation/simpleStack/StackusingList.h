#ifndef STACKUSINGLIST_H
#define STACKUSINGLIST_H


#include <cstdlib>
#include<iostream>
#include "node.h"

using namespace std;
template<class T>
class StackusingList
{
public:


	StackusingList()
	{
		//Constructor
		top = nullptr;
		count = 0;
	}



	void push(T element)
	{
		//Push function, checks if top is null and makes new top if so.

		node<T> *newTop = new node<T>;
		newTop->data = element;
		if (top == nullptr)
			newTop->nextNode = nullptr;
		else
			newTop->nextNode = top;

		top = newTop;
		count++;

	}

	T pop()
		/*There is some sort of funky behavior here. */
	{
		if (top == nullptr)
			throw "Nothing to pop";
		else
		{

			T old = top->data;
			top = top->nextNode;
			count--;
			T  temp = old;
			return temp;

		}
	}


	void print()
	{
		//I know you didn't ask for this, but I figured this would be better then doing it all in main.
		node<T> *temp;
		temp = top;
		while (temp != nullptr)
		{
			cout << temp->data << ",";
			temp = temp->nextNode;
		}
	}

	operator bool() {
		//bool to return based on stack being full or not
		if (top == NULL)
			return false;
		else
			return true;
	}


private:
	node<T> *top;
	int count;
};

#endif