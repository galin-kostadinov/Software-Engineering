#include <iostream>

using namespace std;

int main() {
    int timeFirst, timeSecond, timeThird;
    cin >> timeFirst >> timeSecond >> timeThird;

    int totalTime = timeFirst + timeSecond + timeThird;
    int min = totalTime / 60;
    int sec = totalTime % 60;

    if (sec < 10) {
        cout << min << ":0" << sec << endl;
    } else {
        cout << min << ":" << sec << endl;
    }

    return 0;
}