#include <iostream>
#include <string>

using namespace std;

int main() {
    string name;
    cin >> name;

    double totalSum = 0;
    int counter = 1;
    double currentGrade;

    while (counter <= 12) {
        double currentGrade;
        cin >> currentGrade;

        if (currentGrade >= 4) {
            totalSum += currentGrade;
            counter++;
        }
    }

    cout.setf(ios::fixed);
    cout.precision(2);

    cout << name << " graduated. Average grade: " << totalSum / 12 << endl;

    return 0;
}