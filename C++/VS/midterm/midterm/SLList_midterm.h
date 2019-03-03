/*
 * List.h
 *
 * A singly linked list...
 *
 *  Created on: 2016-01-15
 *  Modified:   2019-01-30
 *      Author: piotr
 */

#ifndef LIST_H_
#define LIST_H_

#include <stdexcept>
#include <iostream>


template < class T>
class Node {
public:
	Node(T v, Node * p = 0) :val_(v), next_(p) {}
	virtual ~Node() {};
	T val_;
	Node * next_;
};

template <class T>
class List {
public:
	List() :head_(nullptr), tail_(nullptr) {}
	List(const List&) = delete;
	List & operator= (const List&) = delete;
	virtual ~List();
	void pushHead(T);
	void pushTail(T);
	T popHead() ;
	T popTail();
	bool empty() const { return head_ == nullptr; }
	void print() const;

	// Not implemented ...
	void insertAfter(T, T) {};
	void insertBefore(T, T) {};
	void del(T) {};
	// ...
	void reverse();
	long length(Node<T> * head_);
	// ... waiting for somebody to do it ;)

	class Iterator {
	public:
		Iterator() :p_(nullptr) {};
		bool operator== (Iterator s) { return s.p_==p_; }
		bool operator!= (Iterator s) { return s.p_!=p_; }
		const Iterator & operator++() { p_=p_->next_; return *this;}
		Iterator operator++(int) {
			Iterator tmp(*this);
			p_=p_->next_;
			return tmp;
		}
		T& operator* () { return p_->val_ ; }
		friend class List<T>;
	private:
		Node<T> * p_;
		Iterator(Node<T> * x) :p_(x) {};
	};
	Iterator begin() { return Iterator(head_); }
	Iterator end()   { return Iterator(); }
	Node<T> * head_;

private:
	
	Node<T> * tail_;
};


template <class T>
List<T>::~List() {
	for(Node<T> * p=head_; p; p=p->next_) {
		delete p;
	}
}

template <class T>
void List<T>::pushHead(T v)
{
	if ( head_ )
		head_=new Node<T>(v, head_);
	else
		tail_=head_=new Node<T>(v);
}

template <class T>
void List<T>::pushTail(T v)
{
	if ( head_ )
		tail_=tail_->next_=new Node<T>(v);
	else
		tail_=head_=new Node<T>(v);

}


template <class T>
void List<T>::print() const
{
	if (head_)
		for(Node<T> * p=head_; p; p=p->next_)
			std::cout << p->val_ << " ";

	std::cout << std::endl;

}

template <class T>
T List<T>::popHead() 
{
	Node<T> * p(head_);

	if (p==nullptr) throw (std::runtime_error("Empty list."));

	T v(head_->val_);

	if ( (head_=head_->next_) == nullptr )
			tail_=nullptr;

	delete p;
	return v;
}


template <class T>
T List<T>::popTail()
{
	T v;
	Node<T> * p(head_);

	if (p == nullptr) throw (std::runtime_error ("Empty list"));

	if (head_==tail_) {
		v=p->val_;
		delete p;
		head_=tail_=nullptr;
	}
	else {
		while (p->next_ != tail_)
				p=p->next_;

		v=p->next_->val_;
		delete p->next_;
		tail_=p;
		tail_->next_=nullptr;
	}

	return v;

}





/*Fun begins here:*/

template <class T>
void List<T>::reverse() {
	{
		// Initialize 
		Node<T> *current_ = head_;
		Node<T> *prev_ = NULL, *next_ = NULL;


		while (current_ != NULL)
		{
			// Store next & reverse
			next_ = current_->next_;
			current_->next_ = prev_;

			// Move pointers one position. 
			prev_ = current_;
			current_ = next_;
		}
		head_ = prev_;
	}

}

template <class T>
long List<T>::length(Node<T> * head_) {
	if (head_ == nullptr)
		return 0;

	// length is 1 +length of remaining list 
	return 1 + length(head_->next_);
}








#endif /* LIST_H_ */
