#include <iostream>

using namespace std;

int main() {
    int a, b, c, d;
    cin >> a >> b >> c >> d;

    for (int firstRowFirstNum = a; firstRowFirstNum <= b; firstRowFirstNum++) {
        for (int firstRowSecondNum = a; firstRowSecondNum <= b; firstRowSecondNum++) {
            for (int secondRowFirstNum = c; secondRowFirstNum <= d; secondRowFirstNum++) {
                for (int secondRowSecondNum = c; secondRowSecondNum <= d; secondRowSecondNum++) {
                    if ((firstRowFirstNum + secondRowSecondNum) == (firstRowSecondNum + secondRowFirstNum) &&
                        firstRowFirstNum != firstRowSecondNum && secondRowFirstNum != secondRowSecondNum) {
                        cout << firstRowFirstNum << firstRowSecondNum << endl;
                        cout << secondRowFirstNum << secondRowSecondNum << endl;
                        cout << endl;
                    }
                }
            }
        }
    }

    return 0;
}
