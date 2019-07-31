#include <iostream>

using namespace std;

int main() {
    int hour, min;
    cin >> hour >> min;

    min += hour * 60 + 15;

    hour = min / 60;
    min = min % 60;

    if (hour >= 24) {
        hour -= 24;
    }

    if (min < 10) {
        cout << hour << ":0" << min << endl;
    } else {
        cout << hour << ":" << min << endl;
    }

    return 0;
}