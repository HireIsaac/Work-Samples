/*
 * PlaneGen.h
 *
 *  Created on: Sep 27, 2018
 *      Author: nick
 */

#ifndef PLANEGEN_H_
#define PLANEGEN_H_

#include "Queue.h"
#include "Plane.h"
#include "Delay.h"

class PlaneGen {
public:
	PlaneGen(Queue &, int);
	virtual ~PlaneGen();
	void nextPlane();
private:
	Queue& Q_;
	Delay d_;
	int nextArrival_;
	Timer myWatch_;
};

#endif /* PLANEGEN_H_ */
