/*
 * Plane.h
 *
 *  Created on: Sep 13, 2018
 *      Author: piotr
 */

#include <iostream>
#include "Queue.h"

using namespace std;

Queue::Queue()
: head_{0}, tail_{0}, cnt_{0}
{}

Queue::~Queue() {
}

bool Queue::enqueue(Plane * p)
{
	if(isFull()) return false;

	cnt_++;
	q_[tail_++] = p;
	tail_%=MAXSIZE_;

	return true;
}

Plane * Queue::dequeue()
{
	if (isEmpty()) return nullptr;

	Plane * firstPlane(q_[head_++]);

	cnt_--;
	head_%=MAXSIZE_;

	return firstPlane;
}


Plane * Queue::inspect() const
{
	if (isEmpty()) return nullptr;

	return q_[head_];
}

