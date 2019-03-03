/*
 * 	Runway.cpp
 *  Author: Isaac
 */


#include <iostream>
#include "Runway.h"

using namespace std;

Runway::Runway(Dispatch& l, int t)
: dis_{l}, d_{t}, nextClear_{T.time()}
{}

Runway::~Runway(){

}

void Runway::getNextPlane(){
	if(nextClear_ <= T.time()){
		Ready = true;
	}
}
