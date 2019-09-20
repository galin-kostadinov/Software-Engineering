#include <iostream>
#include<string>

using namespace std;


int main() {

    int num1, num2;
    cin >> num1 >> num2;

    string symbol;

    bool realOperator = false;

    int result = 0;

    while (!realOperator) {
        cin >> symbol;

        if (symbol == "+") {
            result = num1 + num2;
            realOperator = true;
        } else if (symbol == "-") {
            result = num1 - num2;
            realOperator = true;
        } else if (symbol == "*") {
            result = num1 * num2;
            realOperator = true;
        } else if (symbol == "/") {
            if (num2 != 0) {
                result = num1 / num2;
                realOperator = true;
            } else {
                cout << "Error division by zero" << endl;
            }

        } else {
            cout << "try again" << endl;
        }
    }

    cout << result << endl;

    return 0;
}