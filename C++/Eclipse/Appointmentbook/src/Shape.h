/*
 * Shape.h
 *
 *  Created on: 2012-12-09
 *      Author: piotr
 */

#ifndef SHAPE_H_
#define SHAPE_H_

#include "Point.h"

class Shape {

public:
	Shape(){};
	virtual ~Shape(){};
	virtual double area() = 0;
	virtual bool isExternal(const Point&) = 0;
	// The above is to verify whether or not the argument Point
	// lies outside the shape
};

#endif /* SHAPE_H_ */
