#include <iostream>

using namespace std;

int main() {
    double usd;
    cin >> usd;
    double bgn = 1.79549 * usd;

    cout.setf(ios::fixed);
    cout.precision(2);

    cout << bgn << endl;

    return 0;
}