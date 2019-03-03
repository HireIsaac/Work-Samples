#ifndef NODE_H
#define NODE_H

#include <cstdlib>
#include<iostream>

template<class T>
struct node {
	node* nextNode;
	T data;
};

#endif
