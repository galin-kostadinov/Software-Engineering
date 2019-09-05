#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;

    double inputNum = 0.0;
    double OddSum = 0;
    double OddMin = 0;
    double OddMax = 0;
    double EvenSum = 0;
    double EvenMin = 0;
    double EvenMax = 0;

    if (n >= 1) {
        cin >> inputNum;
        OddSum = inputNum;
        OddMin = inputNum;
        OddMax = inputNum;
    }

    if (n >= 2) {
        cin >> inputNum;
        EvenSum = inputNum;
        EvenMin = inputNum;
        EvenMax = inputNum;
    }

    if (n >= 3) {
        for (int i = 1; i <= n - 2; i++) {
            cin >> inputNum;
            if (!(i % 2 == 0)) {
                OddSum = OddSum + inputNum;

                if (OddMin > inputNum) {
                    OddMin = inputNum;
                }

                if (OddMax < inputNum) {
                    OddMax = inputNum;
                }
            } else {
                EvenSum = EvenSum + inputNum;

                if (EvenMin > inputNum) {
                    EvenMin = inputNum;
                }

                if (EvenMax < inputNum) {
                    EvenMax = inputNum;
                }
            }
        }
    }

    cout.setf(ios::fixed);
    cout.precision(2);

    cout << "OddSum=" << OddSum << "," << endl;

    if (n >= 1) {
        cout << "OddMin=" << OddMin << "," << endl;
        cout << "OddMax=" << OddMax << "," << endl;
    } else {
        cout << "OddMin=No" << "," << endl;
        cout << "OddMax=No" << "," << endl;
    }

    cout << "EvenSum=" << EvenSum << "," << endl;

    if (n >= 2) {
        cout << "EvenMin=" << EvenMin << "," << endl;
        cout << "EvenMax=" << EvenMax << endl;
    } else {
        cout << "EvenMin=No" << "," << endl;
        cout << "EvenMax=No" << endl;
    }

    return 0;
}
