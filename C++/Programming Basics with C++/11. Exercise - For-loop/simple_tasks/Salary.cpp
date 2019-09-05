#include <iostream>

using namespace std;

int main() {
    string input;
    getline(cin, input);
    int n = stoi(input);
    getline(cin, input);
    int salary = stoi(input);

    for (int i = 1; i <= n; i++) {
        string domain;
        getline(cin, domain);

        if (domain == "Facebook") {
            salary = salary - 150;
        } else if (domain == "Instagram") {
            salary = salary - 100;
        } else if (domain == "Reddit") {
            salary = salary - 50;
        }

        if (salary <= 0) {
            break;
        }
    }

    if (salary <= 0) {
        cout << "You have lost your salary." << endl;
    } else {
        cout << salary << endl;
    }

    return 0;
}
