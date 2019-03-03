/*
 * Airport.h
 *
 *  Created on: Oct 12, 2018
 *      Author: nick
 */

#ifndef AIRPORT_H_
#define AIRPORT_H_

#include "Delay.h"
#include "Dispatch.h"
#include "PlaneGen.h"
#include "Queue.h"
#include "Timer.h"

class Airport{
public:
	Airport(int,int,int,int);
	virtual ~ Airport();
	void run();
private:
	Queue TQ_;
	Queue LQ_;
	PlaneGen PGL_;
	PlaneGen PGT_;
	Timer T;
	Dispatch dp_;
	int startT_;
};




#endif /* AIRPORT_H_ */
