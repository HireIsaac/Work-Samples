/*
 * 	Plane.cpp
 *  Author: Isaac
 */

#include <iostream>
#include "Plane.h"

using namespace std;

int Plane::source_ = 1000;

Plane::Plane()
:serial_{source_++}, startTime_{breitling_.time()}
{
}

Plane::~Plane() {
	// TODO Auto-generated destructor stub
}

int Plane::getSerial(){
	return serial_;
}
int Plane::waitTime(){
	return breitling_.time() - startTime_;
}
int Plane::arrivalTime(){
	return startTime_;
}

