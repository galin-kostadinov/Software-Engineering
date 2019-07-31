#include <iostream>
#include <string>

using namespace std;

int main() {
    double num;
    string unitIn, unitOut;
    cin >> num >> unitIn >> unitOut;

    if (unitIn=="mm") {
        num/=1000;
    }else if (unitIn=="cm") {
        num/=100;
    }

    if (unitOut=="mm") {
        num*=1000;
    }else if (unitOut=="cm") {
        num*=100;
    }

    cout.setf(iostream::fixed);
    cout.precision(3);
    cout << num << endl;

    return 0;
}