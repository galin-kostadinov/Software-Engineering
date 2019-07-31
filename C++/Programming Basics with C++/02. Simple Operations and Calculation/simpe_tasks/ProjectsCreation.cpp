#include <iostream>

using namespace std;

int main() {
    string architect;
    int projectNum;

    cin >> architect >> projectNum;

    int hours = projectNum * 3;

    cout << "The architect " << architect << " will need " << hours
         << " hours to complete " << projectNum << " project/s." << endl;

    return 0;
}