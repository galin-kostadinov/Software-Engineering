#include <iostream>
#include <string>

using namespace std;

int main() {
    string type;
    int rows;
    int columns;
    cin >> type >> rows >> columns;

    double price = 0;
    if (type == "Premiere") {
        price = 12.0;
    } else if (type == "Normal") {
        price = 7.50;
    } else if (type == "Discount") {
        price = 5.0;
    }

    cout.setf(ios:: fixed);
    cout.precision(2);
    cout<< price*rows*columns<<endl;

    return 0;
}