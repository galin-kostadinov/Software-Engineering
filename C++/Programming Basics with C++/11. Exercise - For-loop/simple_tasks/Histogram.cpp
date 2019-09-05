#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;

    int counterP1 = 0;
    int counterP2 = 0;
    int counterP3 = 0;
    int counterP4 = 0;
    int counterP5 = 0;

    for (int i = 1; i <= n; i++) {
        int inputNum;
        cin >> inputNum;
        if (inputNum < 200) {
            ++counterP1;
        } else if (inputNum < 400) {
            ++counterP2;
        } else if (inputNum < 600) {
            ++counterP3;
        } else if (inputNum < 800) {
            ++counterP4;
        } else if (inputNum >= 800) {
            ++counterP5;
        }
    }

    cout.setf(ios::fixed);
    cout.precision(2);

    cout << 100.0 * counterP1 / n << '%' << endl;
    cout << 100.0 * counterP2 / n << '%' << endl;
    cout << 100.0 * counterP3 / n << '%' << endl;
    cout << 100.0 * counterP4 / n << '%' << endl;
    cout << 100.0 * counterP5 / n << '%' << endl;

    return 0;
}
