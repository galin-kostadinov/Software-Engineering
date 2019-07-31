#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    int counter = 0;
    int minNumber = INT_MAX;
    while (counter < n) {
        int number;
        cin >> number;
        if (number < minNumber) {
            minNumber = number;
        }
        counter++;
    }
    cout << minNumber << endl;
    return 0;
}