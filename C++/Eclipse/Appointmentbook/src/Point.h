/*
 * Point.h
 *
 *  Created on: 2012-12-09
 *      Author: piotr
 */

#ifndef POINT_H_
#define POINT_H_

class Point {

public:
	Point(double x = 0.0, double y = 0.0) : x_(x), y_(y) {};
	virtual ~Point(){};
	double x() const { return x_; }
	double y() const { return y_; }
private:
		double x_;
		double y_;
};

#endif /* POINT_H_ */
