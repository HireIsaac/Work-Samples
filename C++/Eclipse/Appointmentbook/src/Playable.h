/*
 * Playable.h
 *
 *  Created on: Dec 6, 2018
 *      Author: Isaac Lohnes
 */

#ifndef PLAYABLE_H_
#define PLAYABLE_H_


class Playable {

public:
	Playable(){};
	virtual ~Playable(){};
	virtual void setUp(Playable *);
	virtual void playIt(int = 1);
	virtual void play();
	virtual void stop();
};




#endif /* PLAYABLE_H_ */
