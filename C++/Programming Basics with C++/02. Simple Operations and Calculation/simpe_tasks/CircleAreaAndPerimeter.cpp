#include <iostream>

using namespace std;

int main() {
    double r;
    cin >> r;

    double area = r * r * 3.1415926535897932384626433832795;
    double perimeter = 2 * r * 3.1415926535897932384626433832795;

//    cout.setf(ios::fixed);
//    cout.precision(2);

    cout << area << endl << perimeter << endl;

    return 0;
}