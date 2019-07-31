#include <iostream>
#include <cmath>

using namespace std;

int main() {
    double income, averageGrade, minSalary;
    cin >> income >> averageGrade >> minSalary;

    int socialScholarship = floor(0.35 * minSalary);
    int excellentScholarship = floor(25 * averageGrade);

    if (averageGrade > 4.5 && averageGrade < 5.5 && income < minSalary) {
        if (income < minSalary) {
            cout << "You get a Social scholarship " << socialScholarship << " BGN" << endl;
        }

    } else if (averageGrade >= 5.5) {
        if (income < minSalary && socialScholarship > excellentScholarship) {
            cout << "You get a Social scholarship " << socialScholarship << " BGN" << endl;
        } else {
            cout << "You get a scholarship for excellent results "
                 << excellentScholarship << " BGN" << endl;
        }
    } else {
        cout << "You cannot get a scholarship!" << endl;
    }

    return 0;
}