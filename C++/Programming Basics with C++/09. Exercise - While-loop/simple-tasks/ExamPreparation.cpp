#include<iostream>
#include <string>

using namespace std;

int main() {
    int failureCountLimit;
    cin >> failureCountLimit;
    cin.ignore();

    int problemsCount = 0;
    double totalGradeSum = 0;
    double failureCounter = 0;

    string taskName;
    while (true) {
        string currentTask;
        getline(cin, currentTask);
        if (currentTask == "Enough") {
            break;
        }
        taskName = currentTask;
        string gradeLikeText;
        getline(cin, gradeLikeText);
        int grade = stoi(gradeLikeText);

        if (grade <= 4) {
            failureCounter++;
        }
        if (failureCounter == failureCountLimit) {

            break;
        }
        problemsCount++;
        totalGradeSum += grade;
    }

    if (failureCounter != failureCountLimit) {
        cout.setf(ios::fixed);
        cout.precision(2);

        cout << "Average score: " << totalGradeSum / problemsCount << endl;
        cout << "Number of problems: " << problemsCount << endl;
        cout << "Last problem: " << taskName << endl;
    } else {
        cout << "You need a break, " << failureCounter << " poor grades." << endl;
    }
    return 0;
}