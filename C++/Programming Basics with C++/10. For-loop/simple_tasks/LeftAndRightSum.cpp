#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int n;
    cin >> n;
    int leftSum = 0;
    int rightSum = 0;
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        leftSum += num;
    }
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        rightSum += num;
    }
    if (leftSum == rightSum) {
        cout << "Yes, sum = " << leftSum << endl;
    } else {
        cout << "No, diff = " << abs(leftSum - rightSum) << endl;
    }
    return 0;
}
