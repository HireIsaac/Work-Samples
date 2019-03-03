/*
 * Circle.h
 *
 *  Created on: Dec 6, 2018
 *      Author: Isaac Lohnes
 */

#ifndef CIRCLE_H_
#define CIRCLE_H_

#include "Shape.h"
#include "Point.h"


class Circle: public Shape {

public:
   Circle(double x, double y, double newradius);
   double getRadius();
   void setRadius(double newradius);
   void draw();

private:
   double radius;
};




#endif /* CIRCLE_H_ */
