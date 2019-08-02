#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int n;
    cin >> n;
    int evenSum = 0;
    int oddSum = 0;
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        if (i % 2 == 0) {
            evenSum += num;
        } else {
            oddSum += num;
        }

    }

    if (evenSum == oddSum) {
        cout << "Yes, sum = " << evenSum << endl;
    } else {
        cout << "No, diff = " << abs(evenSum - oddSum) << endl;
    }
    return 0;
}
