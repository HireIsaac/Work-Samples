/*
 * 	PlaneGen.cpp
 *  Author: Isaac
 */
#include <iostream>
#include "PlaneGen.h"

using namespace std;

PlaneGen::PlaneGen(Queue& x, int m)
:Q_{x}, d_{m}, nextArrival_{myWatch_.time() + d_.getDelay()}
{
}

PlaneGen::~PlaneGen() {
	// TODO Auto-generated destructor stub
}

void PlaneGen::nextPlane(){

	if(nextArrival_ <= myWatch_.time()){
		nextArrival_ = myWatch_.time() + d_.getDelay();
		if(Q_.isFull()){
			cout << "The queue is full. Redirecting the plane." << endl;
		}else{
			Q_.enqueue(new Plane);
		}
	}
}

