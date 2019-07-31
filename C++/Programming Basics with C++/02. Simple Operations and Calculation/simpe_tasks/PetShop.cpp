#include <iostream>

using namespace std;

int main() {
    int dogsNum;
    int otherPetsNum;

    cin >> dogsNum >> otherPetsNum;

    double result = dogsNum * 2.5 + otherPetsNum * 4;

    cout.setf(ios::fixed);
    cout.precision(2);

    cout << result << " lv." << endl;

    return 0;
}