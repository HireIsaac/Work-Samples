/*
 * Runway.h
 *
 *  Created on: Oct 11, 2018
 *      Author: nick
 */

#ifndef RUNWAY_H_
#define RUNWAY_H_

#include "Dispatch.h"
#include "Delay.h"
#include "Timer.h"
class Dispatch;

class Runway{
public:
	Runway(Dispatch &, int);
	virtual ~Runway();
	void getNextPlane();
	bool getReady(){return Ready;};
	void setReady(bool a){nextClear_ = T.time() + d_.getDelay();Ready = a;};
private:
	Dispatch& dis_;
	Delay d_;
	bool Ready = true;
	int nextClear_;
	Timer T;
};



#endif /* RUNWAY_H_ */
