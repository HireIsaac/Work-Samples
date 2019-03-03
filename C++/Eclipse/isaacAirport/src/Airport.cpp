/*
 * 	Airport.cpp
 *  Author: Isaac
 */


#include "Airport.h"
#include <iostream>


Airport::Airport(int dp, int dpp, int pgl, int pgt)
:PGL_(LQ_,pgl),PGT_(TQ_,pgt),dp_(LQ_, TQ_, dp, dpp)
{
	startT_ = T.time();
}

Airport::~Airport(){

}

void Airport::run(){
	int MAXRUNTIME = 1000;

	while(T.tic() < MAXRUNTIME + startT_){
		PGL_.nextPlane();
		PGT_.nextPlane();
		dp_.getNextPlane();
	}
	dp_.printStats();
}
