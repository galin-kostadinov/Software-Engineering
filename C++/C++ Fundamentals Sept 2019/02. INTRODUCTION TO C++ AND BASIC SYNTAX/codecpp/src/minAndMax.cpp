#include<iostream>

using namespace std;

int main() {
    int n;
    cin >> n;

    int min = INT_MAX;
    int max = INT_MIN;

    for (int i = 0; i < n; ++i) {
        int num;
        cin >> num;

        if (num > max) {
            max = num;
        }

        if (num < min) {
            min = num;
        }
    }

    cout << min << " " << max << endl;

    return 0;
}

