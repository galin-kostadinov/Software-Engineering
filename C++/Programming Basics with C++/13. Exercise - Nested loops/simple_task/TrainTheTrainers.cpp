#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int main() {
    string input;
    getline(cin, input);
    int countJury = stoi(input);
    double sumMultiEvaluations = 0;
    double averageEvaluationByPresentation = 0;
    double averageEvaluationByPresentations = 0;

    int counterPresentation = 0;
    string presentationName;
    getline(cin, presentationName);
    cout.setf(ios::fixed);
    cout.precision(2);

    while (presentationName != "Finish") {
        double sumSingleEvaluations = 0;

        for (int i = 0; i < countJury; i++) {
            getline(cin, input);
            double num = stod(input);
            sumSingleEvaluations += num;
        }

        averageEvaluationByPresentation = sumSingleEvaluations / countJury;
        sumMultiEvaluations += averageEvaluationByPresentation;

        cout << presentationName << " - " << averageEvaluationByPresentation << "." << endl;
        ++counterPresentation;
        getline(cin, presentationName);
    }

    averageEvaluationByPresentations = sumMultiEvaluations / counterPresentation;
    cout << "Student's final assessment is " << averageEvaluationByPresentations << "." << endl;

    return 0;
}
