/*
 * 	Main.cpp
 *  Author: Isaac
 */
#include <iostream>
#include "Airport.h"

using namespace std;

int main() {

	Airport A(5,5,1,1); // cleartime, nmrun, pgwait, pgwait
	A.run();

	Airport B(30,3,3,3);
	B.run();

	A.~Airport();
	B.~Airport();
return 0;

}
