/*
 * Plane.h
 *
 *  Created on: Sep 13, 2018
 *      Author: piotr
 */

#ifndef QUEUE_H_
#define QUEUE_H_

class Plane;

class Queue final{
public:
	Queue();
	Queue(const Queue&) = delete;
	Queue(Queue&&)= delete;
	Queue& operator=(const Queue&) = delete;
	Queue& operator=(Queue&&) = delete;
	virtual ~Queue();

	bool enqueue(Plane *);
	Plane * dequeue();
	Plane * inspect()const;
	bool isEmpty()const { return cnt_ == 0; }
	bool isFull()const { return cnt_ == MAXSIZE_;}

	bool operator<< (Plane * p) {
		return enqueue(p);
	}

private:
	static const int MAXSIZE_ = 15;
	Plane * q_[MAXSIZE_];
	int head_;
	int tail_;
	int cnt_;
};

#endif /* QUEUE_H_ */
