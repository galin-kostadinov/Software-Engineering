#include<iostream>

using namespace std;

int main() {
    int sum = 0;
    int sum1 = 0;
    string winner;
    string name;
    getline(cin, name);

    while (name != "STOP") {
        for (int i = 0; i < name.length(); i++) {
            sum += name[i];
        }

        if (sum > sum1) {
            winner = name;
            sum1 = sum;
        }

        sum = 0;
        getline(cin, name);
    }

    cout << "Winner is " << winner << " - " << sum1 << "!" << endl;

    return 0;
}