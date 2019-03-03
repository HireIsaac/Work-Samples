#ifndef PRINTER_H_
#define PRINTER_H_

#include <iostream>
#include <string>
#include <fstream>
#include <map>
#include <set>
#include <iomanip>
#include <limits>
#include <stack>


using namespace std;

class Printer{

public:

	Printer(const string&);
	virtual ~Printer();
	void readData(istream& in);
	void printDistance();
	void printPath();
	void path();
	void run();

private:

	string fileName;
	set <string> _cities;
	map <string, map<string, double> > _distance;
	map <string, map<string, string> > _predecessor;
	double infini = numeric_limits<double>::infinity();
};

#endif