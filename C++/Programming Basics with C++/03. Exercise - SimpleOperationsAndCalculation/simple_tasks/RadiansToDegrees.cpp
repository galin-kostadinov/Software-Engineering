#include <iostream>
#include <cmath>

using namespace std;

int main() {

    double rad;
    cin >> rad;
    double deg = rad * 180 / 3.1415926535;

    cout << round(deg) << endl;
    return 0;
}