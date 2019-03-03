
#include "Printer.h"


Printer::Printer(const string & str):fileName{str} {
	ifstream France(fileName.c_str(), ios::in);

	if (!France) {
		cout << "File not found" << endl; 
	}

	readData(France);
	run();
}




Printer::~Printer() {
	//Destructor
}



void Printer::readData(istream& input) {
	string start, end;
	double distance;

	while (input >> start >> end >> distance) {
		_cities.insert(start);
		_cities.insert(end);
		_distance[start][end] = distance;
		_predecessor[start][end] = start;
	}

	for (auto& c : _cities) {
		for (auto& a : _cities) {
			if (_distance[c][a] == 0) {
				_distance[c][a] = infini;
			}
		}
	}

	for (auto& c : _cities) {
		_distance[c][c] = 0;
	}

}








void Printer::run() {

	double _newDistance;
	set<string>::const_iterator _cinter, _cstart, _cend;

	//Psudocode converted into actual code below:

	for (auto& _cinter : _cities) {
		for (auto& _cstart : _cities) {
			for (auto& _cend : _cities) {
				if (_distance[_cstart][_cinter] * _distance[_cinter][_cend] != 0 && _cinter != _cend) {
					_newDistance = _distance[_cstart][_cinter] + _distance[_cinter][_cend];
					if ((_newDistance < _distance[_cstart][_cend]) || (_distance[_cstart][_cinter] == 0)) {
						_distance[_cstart][_cend] = _newDistance;
						_predecessor[_cstart][_cend] = _predecessor[_cinter][_cend];

					}
				}
			}
		}
	}


	printDistance();
	printPath();
}


void Printer::printPath() {

	/*I had to get help with the numbers for setw, but it works now! same function as printDistance
	
	*/


	cout << "\n\n\nPath table" << endl;


	cout << setw(12) << " ";
	for (auto y : _cities) {
		cout << setw(6) << y.substr(0, 5);
	}
	cout << endl;


	for (auto x : _cities) {
		cout << setw(12) << left << x;
		for (auto y : _cities) {
			cout << setw(6) << right << _predecessor[x][y].substr(0, 5);
		}
		cout << endl;
	}

}


void Printer::printDistance() {
	cout << "\n\n\nDistance table" << endl;

	cout << setw(12) << "";
	for (auto y : _cities) {
		cout << setw(6) << y.substr(0, 5);
	}
	cout << endl;

	for (auto x : _cities) {
		cout << setw(12) << left << x;
		for (auto y : _cities) {
			cout << setw(6) << right << _distance[x][y];
		}
		cout << "\n" << endl;
	}

}







void Printer::path() {

	stack<string> path;
	string  a, b, x, y;


	cout << "Pick start location ";
	cin >> a;
	cout << "Pick end location ";
	cin >> b;
	cout << "Calculating path for: " << a << " - " << b << endl;
	cout << "Result: " << endl;


	path.push(x = b);

	while ((x = _predecessor[a][x]) != a) {
		path.push(x);
	}

	while (!path.empty()) {
		y = path.top();
		cout << "Distance for: "<< x << " - " << y << " "<< _distance[x][y] << endl;
		x = y;
		path.pop();

	}



	cout << "\n\n Total Distance for  " << _distance[a][b] << endl;

}