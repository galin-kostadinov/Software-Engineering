#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int n;
    cin >> n;

    int sum = 0;
    int maxNum = 0;

    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        sum += num;

        if (maxNum < num) {
            maxNum = num;
        }
    }
    if (sum - maxNum == maxNum) {
        cout << "Yes" << endl;
        cout << "Sum = " << maxNum << endl;
    } else {
        cout << "No" << endl;
        cout << "Diff = " << abs(sum - 2 * maxNum) << endl;
    }

    return 0;
}
