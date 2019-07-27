#include <iostream>
#include <string>

using namespace std;

int main() {
    double age;
    char gender;
    cin >> age >> gender;

    string output;
    if (age < 16) {
        if (gender == 'm') {
            output = "Master";
        } else {
            output = "Miss";
        }
    } else {
        if (gender == 'm') {
            output = "Mr.";
        } else {
            output = "Ms.";
        }
    }
    cout << output<<endl;

    return 0;
}
