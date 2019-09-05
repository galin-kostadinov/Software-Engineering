#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int main() {
    string input;
    getline(cin, input);
    int maxCaughtFishes = stoi(input);
    string fishName;
    getline(cin, fishName);
    getline(cin, input);
    double fishWeight = stod(input);
    int caughtFishes = 1;
    int caughtFishesTree = 1;

    double profit = 0;

    cout.setf(ios::fixed);
    cout.precision(2);

    while (fishName != "Stop" && caughtFishes <= maxCaughtFishes) {
        double sum = 0;

        for (int i = 0; i < fishName.length(); i++) {
            sum = sum + (double) fishName[i];
        }

        if (caughtFishesTree < 3) {
            profit = profit - sum / fishWeight;
        } else {
            profit = profit + sum / fishWeight;
            caughtFishesTree = 0;
        }

        if (caughtFishes < maxCaughtFishes) {
            getline(cin, fishName);

            if (fishName != "Stop") {
                getline(cin, input);
                fishWeight = stod(input);
                ++caughtFishes;
                ++caughtFishesTree;
            } else {
                break;
            }
        } else {
            break;
        }
    }

    if (caughtFishes == maxCaughtFishes) {
        cout << "Lyubo fulfilled the quota!" << endl;
    }

    if (profit >= 0) {
        cout << "Lyubo's profit from " << caughtFishes << " fishes is " << profit << " leva." << endl;
    } else {
        cout << "Lyubo lost " << abs(profit) << " leva today." << endl;
    }

    return 0;
}
