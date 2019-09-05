#include <iostream>

using namespace std;

int main() {
    int N;
    cin >> N;

    for (int i = 1; i <= 9; i++) {
        for (int j = 1; j <= 9; j++) {
            for (int k = 1; k <= 9; k++) {
                for (int l = 1; l <= 9; l++) {
                    if (N % i == 0 && N % j == 0 && N % k == 0 && N % l == 0) {
                        cout << i << j << k << l << " ";
                    }
                }
            }
        }s
    }

    cout << endl;

    return 0;
}
