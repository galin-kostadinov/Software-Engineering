#include <iostream>
#include <string>

using namespace std;

int main() {

    int num1, num2;
    char symbol;
    cin >> num1 >> num2 >> symbol;

    cout.setf(ios::fixed);
    cout.precision(2);


    if (symbol == '+') {
        int result = num1 + num2;
        if (result % 2 == 0) {
            cout << num1 << " + " << num2 << " = " << result << " - " << "even" << endl;
        } else {
            cout << num1 << " + " << num2 << " = " << result << " - " << "odd" << endl;
        }
    } else if (symbol == '-') {
        int result = num1 - num2;
        if (result % 2 == 0) {
            cout << num1 << " - " << num2 << " = " << result << " - " << "even" << endl;
        } else {
            cout << num1 << " - " << num2 << " = " << result << " - " << "odd" << endl;
        }
    } else if (symbol == '*') {
        int result = num1 * num2;
        if (result % 2 == 0) {
            cout << num1 << " * " << num2 << " = " << result << " - " << "even" << endl;
        } else {
            cout << num1 << " * " << num2 << " = " << result << " - " << "odd" << endl;
        }
    } else if (symbol == '/') {
        if (num2 == 0) {
            cout << "Cannot divide " << num1 << " by zero" << endl;
        } else {
            cout << num1 << " / " << num2 << " = " << 1.0*num1 / num2 << endl;
        }
    } else if (symbol == '%') {
        if (num2 == 0) {
            cout << "Cannot divide " << num1 << " by zero" << endl;
        } else {
            cout << num1 << " % " << num2 << " = " << num1 % num2 << endl;
        }
    }

    return 0;
}