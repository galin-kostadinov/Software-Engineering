#include<iostream>

using namespace std;

int main() {
    double a, b, c;

    cin >> a >> b >> c;

    bool isTrue =
            a == 0 || b == 0 || c == 0
            || (a > 0 && b > 0 && c > 0)
            || (a < 0 && b < 0 && c > 0)
            || (a < 0 && b > 0 && c < 0)
            || (a > 0 && b < 0 && c < 0);

    if (isTrue) {
        cout << "+" << endl;
    } else {
        cout << "-" << endl;
    }

    return 0;
}
