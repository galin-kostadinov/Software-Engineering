#include<iostream>
#include <string>

using namespace std;

int main() {
    int sum = 0;
    while (sum < 10000) {
        string command;
        getline(cin, command);
        if (command == "Going home") {
            getline(cin, command);
            sum += stoi(command);
            break;
        }
        sum += stoi(command);
    }
    if (sum >= 10000) {
        cout << "Goal reached! Good job!" << endl;
    } else {
        cout << 10000 - sum << " more steps to reach goal." << endl;
    }
    return 0;
}