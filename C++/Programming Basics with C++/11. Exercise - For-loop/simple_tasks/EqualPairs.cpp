#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int n;DivideWithoutRemainder.cpp
    cin >> n;

    int sum1 = 0;
    int sum2 = 0;
    int maxDiff = 0;
    int maxDiff2 = 0;

    for (int i = 1; i <= n; i++) {
        if (!(i % 2 == 0)) {
            int num1, num2;
            cin >> num1 >> num2;
            sum1 = num1 + num2;
        } else if (i % 2 == 0) {
            int num1, num2;
            cin >> num1 >> num2;
            sum2 = num1 + num2;
        }

        if (i > 1) {
            maxDiff = sum1 - sum2;
            if (abs(maxDiff) > abs(maxDiff2)) {
                maxDiff2 = maxDiff;
            }
        }
    }

    if (maxDiff2 == 0) {
        cout << "Yes, value=" << sum1 << endl;
    } else {
        cout << "No, maxDiff=" << abs(maxDiff2) << endl;
    }

    return 0;
}
