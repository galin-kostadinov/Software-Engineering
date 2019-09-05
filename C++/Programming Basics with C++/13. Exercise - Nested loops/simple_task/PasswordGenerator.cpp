#include <iostream>
#include <cmath>

using namespace std;

int main() {
    int n, l;
    cin >> n >> l;
    char letter = 'a' + l;

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {

            for (char k = 'a'; k < letter; k++) {
                for (char m = 'a'; m < letter; m++) {
                    for (int o = max(i, j) + 1; o <= n; o++) {
                        cout << i << j << k << m << o << " ";

                    }
                }
            }
        }
    }

    return 0;
}
