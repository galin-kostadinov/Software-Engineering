#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;

    int counterP2 = 0;
    int counterP3 = 0;
    int counterP4 = 0;


    for (int i = 1; i <= n; i++) {
        int inputNum;
        cin >> inputNum;
        if (inputNum % 2 == 0) {
            ++counterP2;
        }
        if (inputNum % 3 == 0) {
            ++counterP3;
        }

        if (inputNum % 4 == 0) {
            ++counterP4;
        }

    }

    cout.setf(ios::fixed);
    cout.precision(2);

    cout << 100.0 * counterP2 / n << '%' << endl;
    cout << 100.0 * counterP3 / n << '%' << endl;
    cout << 100.0 * counterP4 / n << '%' << endl;

    return 0;
}
