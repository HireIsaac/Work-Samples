/*
 * Dispatch.h
 *
 *  Created on: Oct 12, 2018
 *      Author: nick
 */

#ifndef DISPATCH_H_
#define DISPATCH_H_

#include "Queue.h"
#include "Stat.h"
#include "Runway.h"

class Runway;

class Dispatch
{
public:
	Dispatch(Queue&, Queue&, int, int);
	virtual ~Dispatch();
	void getNextPlane();
	void printStats();
private:
	Queue& lq_;
	Queue& tq_;
	Stat t;
	Stat l;
	Runway ** rw;
	int numRun;
};

#endif /* DISPATCH_H_ */
