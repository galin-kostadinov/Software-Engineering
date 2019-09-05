#include <iostream>
#include <string>

using namespace std;

int main() {
    int n;
    cin >> n;
    string nToString = to_string(n);
    int length = nToString.size();

    for (int row = 0; row < length; row++) {
        int number = nToString[length - 1 - row] - '0';

        if (number == 0) {
            cout << ("ZERO") << endl;
            continue;
        }

        char symbolToRepeat = (char) (number + 33);

        for (int i = 0; i < number; i++) {
            cout << symbolToRepeat;
        }
        cout << endl;
    }

    return 0;
}
