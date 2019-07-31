#include <iostream>

using namespace std;

int main() {
    string figureType;
    cin >> figureType;

    cout.setf(iostream::fixed);
    cout.precision(3);

    if (figureType == "square") {
        double a;
        cin >> a;
        cout << a * a << endl;
    } else if (figureType == "rectangle") {
        double a, b;
        cin >> a >> b;
        cout << a * b << endl;
    } else if (figureType == "circle") {
        double a;
        cin >> a;
        cout << 3.141592653589 * a * a << endl;;
    } else if (figureType == "triangle") {
        double a, b;
        cin >> a >> b;
        cout << a * b / 2 << endl;
    }

    return 0;
}