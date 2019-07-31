#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    int counter = 0;
    int maxNumber = INT_MIN;
    while (counter < n) {
        int number;
        cin >> number;
        if (number > maxNumber) {
            maxNumber = number;
        }
        counter++;
    }
    cout << maxNumber << endl;
    return 0;
}