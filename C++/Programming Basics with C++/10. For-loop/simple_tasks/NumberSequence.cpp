#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;

    int num;
    cin >> num;

    int min;
    int max;
    min = num;
    max = num;

    for (int i = 0; i < n - 1; i++) {
        cin >> num;

        if (num < min) {
            min = num;
        }

        if (num > max) {
            max = num;
        }
    }

    cout << "Max number: " << max << endl;
    cout << "Min number: " << min << endl;

    return 0;
}
