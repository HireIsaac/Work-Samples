/*
 * maintest.cpp
 *
 *  Created on: Dec 6, 2018
 *      Author: Isaac Lohnes
 */






#include "Shape.h"
#include "Circle.h"

#include <iostream>
#include <string>
#include <fstream>
#include <unistd.h>

using namespace std;

int main() {
//	Piotr. I don't know why, but I simply cannot even remember
// 	basic programming right now. My mind is totally turned off.
//	this is going to be the worst exam I ever have done, but
// 	thank god I did well on everything else, because I expect to
//	fail this. I have not slept for a day and this is the worst.

//	I've tried a couple different things but something seems to be always breaking so I just get frusturated.




// 	below would be playIt:
//	for(int i = 0; i < playTimes; i++){
    string line;
    ifstream out("Book.txt");
    while(getline(out, line)) {
        cout << line << endl;
        usleep(1000);
    }
    out.close();
}
