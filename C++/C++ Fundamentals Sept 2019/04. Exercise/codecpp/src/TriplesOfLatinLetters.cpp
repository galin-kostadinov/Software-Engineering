#include <iostream>

using namespace std;


int main() {
    int n;
    cin >> n;

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            for (int k = 0; k < n; ++k) {
                cout << (char) ('a' + i) << (char) ('a' + j) << (char) ('a' + k) << endl;
            }
        }
    }

    return 0;
}