/*
 * 	Dispatch.cpp
 *  Author: Isaac
 */
#include <iostream>
#include "Plane.h"
#include "Dispatch.h"
#include "Stat.h"
#include "Queue.h"



using namespace std;

Dispatch::Dispatch(Queue& l, Queue& t, int cleartime, int runw) :
		lq_ { l }, tq_ { t } {
	numRun = runw;
	rw = new Runway *[numRun];
	for (int i = 0; i <= numRun; i++) {
		rw[i] = new Runway(*this, cleartime);
	}
}

Dispatch::~Dispatch() {

}

void Dispatch::getNextPlane() {
	Plane * lh = lq_.inspect();
	Plane * th = tq_.inspect();
	Runway * rww;
	bool chk = false;
	int a;

	for (a = 0; a < numRun; a++) {
		if (rw[a]->getReady()) {
			rww = rw[a];
			chk = true;
		}
	}
	if (chk) {
		if (lh == nullptr && th != nullptr) {
			Plane * tp = tq_.dequeue();
			t.tally(tp->waitTime());
			rww->setReady(false);
			delete (tp);
		} else if (lh != nullptr && th == nullptr) {
			Plane * lp = lq_.dequeue();
			l.tally(lp->waitTime());
			rww->setReady(false);
			delete (lp);
		} else if (lh != nullptr && th != nullptr) {
			if (lh->waitTime() >= th->waitTime()) {
				Plane * lp = lq_.dequeue();
				l.tally(lp->waitTime());
				rww->setReady(false);
				delete (lp);
			} else {
				Plane * tp = tq_.dequeue();
					t.tally(tp->waitTime());
					rww->setReady(false);
					delete tp;

			}
		}
	}
	for (int a = 0; a <= numRun; a++) {
		if (!rw[a]->getReady()) {
			rw[a]->getNextPlane();
		}
	}
}

void Dispatch::printStats() {
	cout << "This is the average of take off " << t.average() << endl;
	cout << "This is the average of land " << l.average() << endl;
}

