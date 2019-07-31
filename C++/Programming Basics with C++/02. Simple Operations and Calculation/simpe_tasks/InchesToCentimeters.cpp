#include <iostream>

using namespace std;

int main() {
    double numberInch;
    cin >> numberInch;
    double numberCentimeters = numberInch * 2.54;

//    cout.setf(ios::fixed);
//    cout.precision(1);

    cout << numberCentimeters << endl;

    return 0;
}