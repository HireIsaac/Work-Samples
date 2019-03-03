/*
 * Tree.h - a binary tree; i.e. BST
 *
 *  Created on: 2016-02-10
 *      Author: piotr
 */

#ifndef TREE_H_
#define TREE_H_

#include <iostream>
#include <vector>
#include <queue>
#include <cmath>

template <class T>
class Tree {
public:
	Tree();
	Tree(T, Tree* =nullptr, Tree* =nullptr);
	Tree(const Tree&) = delete;
	Tree& operator= (const Tree&) = delete;
	virtual ~Tree();
	bool insert(T);
	bool find(T);
	void del(T);	// This will be hard!
	void inorder();
	void inorder(std::vector<T>&);
	void porder();
	void porder(std::vector<T>&);
	void balance(const std::vector<T>& A, int first, int last);
	void rebalance();
	void breathFirst();
	long height();
	void print();
private:
	class Node {
	public:
		Node(T v, Node * l=nullptr, Node * r=nullptr)
		:value_(v), left_(l), right_(r) {}
		T value_;
		Node * left_;
		Node * right_;
	};

	Node * root_;
	void inorder(Node *);
	void inorder(Node *, std::vector<T>&);
	void porder(Node *);
	void porder(Node *, std::vector<T>&);
	void delSubTree(Node *&);
	void delNode(Node *&);

};

template <class T>
Tree<T>::Tree()
: root_(nullptr)
{}

template <class T>
Tree<T>::Tree(T v, Tree * lst, Tree * rst)
{
	Node * l(lst?lst->root_:nullptr);
	Node * r(rst?rst->root_:nullptr);
	root_=new Node(v, l, r);
}

template <class T>
Tree<T>::~Tree()
{
	delSubTree(root_);
}


/* Another insert() proposed below...

template <class T>
bool Tree<T>::insert(T v)
{
	Node * * p(&root_);

	while (*p) {
		if ( (*p)->value_ == v ) return false;
		if ( (*p)->value_ > v )
			p = &((*p)->left_);
		else
			p = &((*p)->right_);
	}
	*p = new Node<T>(v);

	return true;
}
*/

/* Is this easier to follow? Let me know... */
template <class T>
bool Tree<T>::insert(T v)
{
	Node * p{root_};

	if (root_==nullptr) root_ = new Node(v);

	while (p) {
		if ( p->value_ == v ) return false;
		if ( p->value_ > v )
			if (p->left_)
				p=p->left_;
			else
				p->left_=new Node(v), p=nullptr;
		else
			if (p->right_)
				p=p->right_;
			else
				p->right_=new Node(v), p=nullptr;
	}

	return true;
}

template <class T>
bool Tree<T>::find(T v)
{
	Node * p{root_};

	while (p) {
		if (p->value_ == v)
			return true;
		if (p->value_  > v)
			p=p->left_;
		else
			p=p->right_;
	}
	return false;
}

template <class T>
void Tree<T>::inorder()
{
	inorder(root_);
}

template <class T>
void Tree<T>::inorder(std::vector<T>& arr)
{
	inorder(root_, arr);
}






template <class T>
void Tree<T>::porder()
{
	porder(root_);
}

template <class T>
void Tree<T>::porder(std::vector<T>& arr)
{
	porder(root_, arr);
}






template <class T>
void Tree<T>::breathFirst()
{
	Node * p{nullptr};
	std::queue<Node *> Q{};

	Q.push(root_);
	while (! Q.empty()) {
		p=Q.front(), Q.pop();
		if (p) {
			Q.push(p->left_);
			Q.push(p->right_);
			std::cout << p->value_ << std::endl;
		}
	}
}

template <class T>
long Tree<T>::height() {
	Node * p{nullptr};
	std::queue<Node *> Q{};
	long h{0};
	int nodes{0};
	int empty{0};

	if (! root_ ) return -1;  

	Q.push(root_);
	while (! Q.empty()) {
		p=Q.front(), Q.pop();
		if (p) {
			Q.push(p->left_);
			Q.push(p->right_);
			}
		else {
			empty++;
			Q.push(nullptr);
			Q.push(nullptr);
		}
		nodes++;

		if (nodes == pow(2,h)) {
			if (empty==nodes) break;
			h++, empty=nodes=0;
		}
	}
	return h-1;  
}

// Print tree
template <class T>
void Tree<T>::print()   // An ugly one... 
{
	Node * p{nullptr};
	std::queue<Node *> Q{};

	const long H{height()+1};

	if ( H > 10) {
		std::cout << "The height of this tree " << H <<"."<< std::endl;
		std::cout << "Printing refused. (You may try to re-balance it first)." << std::endl;
		return;
	}

	int line{0};
	int nodes{0};

	if (! root_ ) return;

	Q.push(root_);
	while (! Q.empty()) {
		p=Q.front(), Q.pop();

		if (p) {
			Q.push(p->left_);
			Q.push(p->right_);
			std::cout << " " << p->value_;
		}
		else {
			Q.push(nullptr);
			Q.push(nullptr);
			std::cout << " -" ;
		}

		nodes++;

		if (nodes == pow(2,line)) {
			std::cout << std::endl;
			line++, nodes=0;
			if (line==H) return;
		}


	}
}

// Private:

template <class T>
void Tree<T>::inorder(Node * p)
{
	if (!p) return;

	inorder(p->left_);
	std::cout << p->value_ << std::endl;
	inorder(p->right_);

}

template <class T>
void Tree<T>::inorder(Node * p, std::vector<T> & arr )
{
	if (!p) return;

	inorder(p->left_, arr);
	arr.push_back( p->value_);
	inorder(p->right_, arr);

}




template <class T>
void Tree<T>::porder(Node * p)
{
	if (!p) return;

	porder(p->left_);
	porder(p->right_);
	
	std::cout << p->value_ << std::endl;
	

}

template <class T>
void Tree<T>::porder(Node * p, std::vector<T> & arr)
{
	if (!p) return;

	porder(p->left_, arr);
	porder(p->right_, arr);
	
	arr.push_back(p->value_);
	

}








template <class T>
void Tree<T>::balance(const std::vector<T>& A, int first, int last)
{
	int mid{(first+last)/2};

	if (first <= last ) {
		insert(A[mid]);
	    balance(A, first, mid-1);
	    balance(A, mid+1, last);
	}
}

template <class T>
void Tree<T>::rebalance()
{
	if (! root_ ) return;
	std::vector <T> aux{};

	inorder(aux);
	delSubTree(root_);
	balance(aux, 0, aux.size()-1 );
}

template <class T>
void Tree<T>::delSubTree(Node*& p)
{
	if (!p) return;

	delSubTree(p->left_);
	delSubTree(p->right_);
	// std::cout << "Deleting "<< p->value_ << std::endl;
	delete p;
	p=nullptr;

}


// "Lightly" tested:
template<class T>
void Tree<T>::delNode(Node*& n) {

	if (! n ) return;

	Node *tmp{n};

	if (! n->right_)
		n=n->left_;
	else if (! n->left_)
		n=n->right_;
	else {
		tmp=n->left_;
		while ( tmp->right_)
			tmp=tmp->right_;
		tmp->right_ = n->right_;
		tmp=n;
		n=n->left_;
	}
	delete tmp;
}



template<class T>
void Tree<T>::del(T v)  {

	Node * p{root_};
	Node * parent{nullptr};

	while (p) {
		if (p->value_ == v)
			break;
		parent=p;
		if (p->value_  > v)
			p=p->left_;
		else
			p=p->right_;
	}
	
	if (!p) return;

	if (p == root_)
		delNode(root_);  // root_, and NOT p !
	else
		if (p == parent->left_)
			delNode(parent->left_);
		else
			if (p == parent->right_)
				delNode(parent->right_);

}



// A stand-alone balance procedure:

template <class T>
Tree<T> * balance(std::vector<T> A, int first, int last)
{
	int mid{(first+last)/2};

	if (last - first > 1)
		return new Tree<T>(A[mid], balance(A, first, mid-1), balance(A, mid+1, last) );
	if (last - first == 1)
		return new Tree<T>(A[first], 0, new Tree<T>(A[last]));
	if ( last -first == 0)
		return new Tree<T>(A[first]);


	return 0;
}


#endif /* TREE_H_ */


