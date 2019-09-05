#include<iostream>
#include <string>

using namespace std;

int main() {

    string destination;
    int tripPrice = 0;
    int sum = 0;

    for (getline(cin, destination); destination != "End"; getline(cin, destination)) {
        string input;
        getline(cin, input);
        tripPrice = stoi(input);

        while (tripPrice > sum) {
            getline(cin, input);
            sum += stoi(input);
        }

        cout << "Going to " << destination << "!" << endl;

        sum = 0;
    }

    return 0;
}