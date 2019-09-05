#include<iostream>

using namespace std;

int main() {
    int n;
    cin >> n;

    int number = 1;

    for (int i = 0; i <= n; i += 2) {
        cout << number << endl;
        number *= 4;
    }

    return 0;
}