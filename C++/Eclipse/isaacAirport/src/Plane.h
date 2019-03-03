/*
 * Plane.h
 *
 *  Created on: Sep 27, 2018
 *      Author: nick
 */

#ifndef PLANE_H_
#define PLANE_H_

#include "Timer.h"

class Plane {
public:
	Plane();
	virtual ~Plane();
	int getSerial();
	int waitTime();
	int arrivalTime();
private:
	static int source_;
	int serial_;
	Timer breitling_;

	int startTime_;
};

#endif /* PLANE_H_ */
